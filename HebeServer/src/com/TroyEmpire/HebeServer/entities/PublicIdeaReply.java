package com.TroyEmpire.HebeServer.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;




@Data
@Entity
@Table(name = "PublicIdeaReply")
public class PublicIdeaReply implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "publicIdeaId", nullable = false)
	private int publicIdeaId;
	
	@Column(name = "replyDate")
	private Date replyDate;
	
	@Column(name = "content")
	private String content;

}
