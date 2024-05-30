package com.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pos.company.entity.Company;
import com.pos.company.entity.User;
import com.pos.company.repository.CompanyRepository;
import com.pos.company.repository.UserRepository;
import com.pos.inventory.entity.Inventory;
import com.pos.inventory.product.entity.Product;
import com.pos.inventory.product.repositoty.ProductRepository;
import com.pos.inventory.repository.InventoryRepository;

@SpringBootApplication
public class PosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApiApplication.class, args);
	}

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private InventoryRepository inventoryRepository;

	public void run(String... args) throws Exception {
		// Sample companies
		Company company1 = new Company();
		company1.setTenantId("1");
		company1.setName("Company A");
		company1.setEmail("companya@example.com");
		company1 = companyRepository.save(company1);

		Company company2 = new Company();
		company2.setTenantId("2");
		company2.setName("Company B");
		company2.setEmail("companyb@example.com");
		company2 = companyRepository.save(company2);

		// Sample users
		User user1 = new User();
		user1.setTenantId("1");
		user1.setCompany(company1);
		user1.setUsername("user1");
		user1.setPasswordHash("password1");
		user1.setEmail("user1@example.com");
		user1.setRole("ADMIN");
		userRepository.save(user1);

		User user2 = new User();
		user2.setTenantId("2");
		user2.setCompany(company2);
		user2.setUsername("user2");
		user2.setPasswordHash("password2");
		user2.setEmail("user2@example.com");
		user2.setRole("USER");
		userRepository.save(user2);

		// Sample products
		Product product1 = new Product();
		product1.setTenantId("1");
		product1.setCompany(company1);
		product1.setName("Product A");
		product1.setDescription("Description of Product A");
		product1.setPrice(100.00);
		product1 = productRepository.save(product1);

		Product product2 = new Product();
		product2.setTenantId("2");
		product2.setCompany(company2);
		product2.setName("Product B");
		product2.setDescription("Description of Product B");
		product2.setPrice(200.00);
		product2 = productRepository.save(product2);

		// Sample inventories
		Inventory inventory1 = new Inventory();
		inventory1.setTenantId("1");
		inventory1.setProduct(product1);
		inventory1.setCompany(company1);
		inventory1.setQuantity(50);
		inventoryRepository.save(inventory1);

		Inventory inventory2 = new Inventory();
		inventory2.setTenantId("2");
		inventory2.setProduct(product2);
		inventory2.setCompany(company2);
		inventory2.setQuantity(30);
		inventoryRepository.save(inventory2);
	}
}
