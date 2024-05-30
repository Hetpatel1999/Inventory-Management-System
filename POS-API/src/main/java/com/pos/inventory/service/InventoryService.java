package com.pos.inventory.service;

import java.util.List;
import java.util.Optional;

import com.pos.inventory.entity.Inventory;

public interface InventoryService {

	public List<Inventory> getAllInventories();

	public Optional<Inventory> getInventoryById(String inventoryId);

	public Inventory saveInventory(Inventory inventory);

	public void deleteInventory(String inventoryId);
}
