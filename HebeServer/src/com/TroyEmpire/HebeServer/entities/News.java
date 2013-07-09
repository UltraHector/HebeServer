 package com.TroyEmpire.HebeServer.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.TroyEmpire.HebeServer.constants.NewsType;

import lombok.Data;


@Data 
@Entity
@Table(name="News")
public class News implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "publishDate")
	private Date publishDate;
	
	@Column(name = "newsType")
	private NewsType newsType;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content", length = 10000)
	private String content;
}
