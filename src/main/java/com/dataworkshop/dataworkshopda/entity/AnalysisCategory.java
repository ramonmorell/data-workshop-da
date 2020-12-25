/**
 * 
 */
package com.dataworkshop.dataworkshopda.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TBL_ANALYSIS_CATEGORIES")
public class AnalysisCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String name;
	private String desciption;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private AnalysisCategory parentCategory;
	@OneToMany(mappedBy = "category")
	private List<Analysis> analyses;

}
