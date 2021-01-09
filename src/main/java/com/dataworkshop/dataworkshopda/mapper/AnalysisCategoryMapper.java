/**
 * 
 */
package com.dataworkshop.dataworkshopda.mapper;

import com.dataworkshop.dataworkshopda.dto.AnalysisCategoryDto;
import com.dataworkshop.dataworkshopda.entity.AnalysisCategory;

/**
 * @author ramon
 *
 */
public class AnalysisCategoryMapper {
	public static AnalysisCategoryDto toDto(AnalysisCategory analysisCategoryEntity) {
		AnalysisCategoryDto res = new AnalysisCategoryDto();
		res.setId(analysisCategoryEntity.getId());
		res.setName(analysisCategoryEntity.getName());
		res.setDesciption(analysisCategoryEntity.getDesciption());
		AnalysisCategory parentCategory = analysisCategoryEntity.getParentCategory();
		if(parentCategory != null) {
			res.setParentCategoryId(parentCategory.getId());
		}
		return res;
	}
	
	
	public static AnalysisCategory toEntity(AnalysisCategoryDto analysisCategoryEntity) {
		AnalysisCategory res = new AnalysisCategory();
		res.setId(analysisCategoryEntity.getId());
		res.setName(analysisCategoryEntity.getName());
		res.setDesciption(analysisCategoryEntity.getDesciption());
		Long parentCategoryiD = analysisCategoryEntity.getParentCategoryId();
		if(parentCategoryiD != null) {
			AnalysisCategory parentCategory = new AnalysisCategory();
			parentCategory.setId(parentCategoryiD);
			res.setParentCategory(parentCategory);
		}
		return res;
	}

}
