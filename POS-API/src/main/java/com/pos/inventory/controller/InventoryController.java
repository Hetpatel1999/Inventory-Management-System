package com.pos.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pos.base.controller.ABaseController;
import com.pos.base.dto.ResponseDTO;
import com.pos.inventory.entity.Inventory;
import com.pos.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController extends ABaseController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping
	public List<Inventory> getAllInventories() {
		return inventoryService.getAllInventories();
	}

	@GetMapping("/{id}")
	public ResponseDTO<Inventory> getInventoryById(@PathVariable String id) {
		Optional<Inventory> inventory = inventoryService.getInventoryById(id);
		return generateResponse(inventory.get(), HttpStatus.OK);
	}

	@PostMapping
	public Inventory createInventory(@RequestBody Inventory inventory) {
		return inventoryService.saveInventory(inventory);
	}

	@PutMapping("/{id}")
	public ResponseDTO<Inventory> updateInventory(@PathVariable String id, @RequestBody Inventory inventoryDetails) {
		Optional<Inventory> inventory = inventoryService.getInventoryById(id);
		if (inventory.isPresent()) {
			Inventory updatedInventory = inventory.get();
			updatedInventory.setQuantity(inventoryDetails.getQuantity());
			return generateResponse(inventoryService.saveInventory(updatedInventory), HttpStatus.OK);
		} else {
			return generateResponse(null, HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteInventory(@PathVariable String id) {
		inventoryService.deleteInventory(id);
	}

	@Override
	public Class<?> getControllerClass() {
		return this.getClass();
	}
}
