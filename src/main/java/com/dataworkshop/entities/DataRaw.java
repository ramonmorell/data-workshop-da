/**
 * 
 */
package com.dataworkshop.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ramon
 *
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "TBL_RAW_DATA")
public class DataRaw {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private long userId;
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	private Byte[] data;
	private Date date;
	@Enumerated(EnumType.STRING)
	private Status state;
	
	public DataRaw(String name, String description, Byte[] data, Date date, Status state) {
		super();
		this.name = name;
		this.description = description;
		this.data = data;
		this.date = date;
		this.state = state;
	}
	
}
