package com.pos.inventory.repository;

import org.springframework.stereotype.Repository;

import com.pos.base.repository.GenericRepository;
import com.pos.inventory.entity.Inventory;

@Repository
public interface InventoryRepository extends GenericRepository<Inventory, String> {

}
