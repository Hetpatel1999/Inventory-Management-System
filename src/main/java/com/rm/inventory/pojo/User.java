package com.rm.inventory.pojo;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "rm_user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "USER_ID")
	private String id;
	
	@Column(name = "USER_NAME")
	private String name;
	
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "USER_ROLE")
	private String role;

}
