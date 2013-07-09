package com.TroyEmpire.HebeServer.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Building")
public class Building implements Serializable{
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
	@Column(name = "latitude")
	private double latitude;
	@Column(name = "longitude")
	private double longitude;
	@Column(name = "description")
	private String description;
	@Column(name = "pathDotId")
	private int pathDotId;
	
	@Column(name = "miniLatitude")
	private double miniLatitude;
	@Column(name = "maxLatitude")
	private double maxLatitude;
	@Column(name = "miniLongitude")
	private double miniLongitude;
	@Column(name = "maxLongitude")
	private double maxLongitude;

	
}
