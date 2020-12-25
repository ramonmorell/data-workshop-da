/**
 * 
 */
package com.dataworkshop.dataworkshopda.dto;

import lombok.Data;

/**
 * @author ramon
 *
 */
@Data
public class AnalysisCategoryDto {
	private long id;
	private String name;
	private String desciption;
	private long parentCategoryId;
}
