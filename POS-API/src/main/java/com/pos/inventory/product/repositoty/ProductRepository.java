package com.pos.inventory.product.repositoty;

import org.springframework.stereotype.Repository;

import com.pos.base.repository.GenericRepository;
import com.pos.inventory.product.entity.Product;

@Repository
public interface ProductRepository extends GenericRepository<Product, String> {

}
