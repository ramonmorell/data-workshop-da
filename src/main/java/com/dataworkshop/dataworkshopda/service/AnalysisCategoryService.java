/**
 * 
 */
package com.dataworkshop.dataworkshopda.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.dataworkshop.dataworkshopda.entity.AnalysisCategory;

/**
 * @author ramon
 *
 */
@ApplicationScoped
public interface AnalysisCategoryService {
	
	public List<AnalysisCategory> listCategories();
	
	public AnalysisCategory getCategory(long id);
	
	public AnalysisCategory setCategory(AnalysisCategory analysisCategory);
	
	public AnalysisCategory updateCategory(AnalysisCategory analysisCategory);
	
	public boolean deleteCategory(long id);
	
	public List<AnalysisCategory> searchCategories(String name);
	
}
