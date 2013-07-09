package com.TroyEmpire.HebeServer.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="Restaurant")
public class Restaurant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "managerName", unique = true, nullable = false)
	private String managerName;
	
	@Column(name = "notes", unique = true, nullable = true)
	private String notes;
	
	@Column(name = "phoneNumber", unique = true, nullable = false)
	private String phoneNumber;
	
	@Column(name = "desciption", nullable = true)
	private String description;
	
	@Column(name = "address", nullable = true)
	private String address;
	
	@Column(name = "campusId", nullable = false)
	private int campusId;
	
	
	
}
