package com.pos.inventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.inventory.entity.Inventory;
import com.pos.inventory.repository.InventoryRepository;
import com.pos.inventory.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public List<Inventory> getAllInventories() {
		return inventoryRepository.findAll();
	}

	@Override
	public Optional<Inventory> getInventoryById(String inventoryId) {
		return inventoryRepository.findById(inventoryId);
	}

	@Override
	public Inventory saveInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@Override
	public void deleteInventory(String inventoryId) {
		inventoryRepository.deleteById(inventoryId);
	}
}
