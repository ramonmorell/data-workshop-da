/**
 * 
 */
package com.dataworkshop.dataworkshopda.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ramon
 *
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "TBL_ANALYSES")
public class Analysis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String name;
	private String description;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private AnalysisCategory category;

}
