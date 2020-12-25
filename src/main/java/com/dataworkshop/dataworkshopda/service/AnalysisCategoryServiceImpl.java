/**
 * 
 */
package com.dataworkshop.dataworkshopda.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.dataworkshop.dataworkshopda.entity.AnalysisCategory;
import com.dataworkshop.dataworkshopda.repository.AnalysisCategoryRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ramon
 *
 */
@ApplicationScoped
@Slf4j
public class AnalysisCategoryServiceImpl implements AnalysisCategoryService {
	
	@Inject
	AnalysisCategoryRepository analysisCategoryRepository;

	@Override
	public List<AnalysisCategory> listCategories() {
		log.info("AnalysisCategoryServiceImpl >> listCategories()");
		return analysisCategoryRepository.listAll();
	}

	@Override
	public AnalysisCategory getCategory(long id) {
		log.info("AnalysisCategoryServiceImpl >> getCategory() >> data input: id={}", id);
		return analysisCategoryRepository.findById(id);
	}

	@Override
	@Transactional
	public AnalysisCategory setCategory(AnalysisCategory analysisCategory) {
		log.info("AnalysisCategoryServiceImpl >> setCategory() >> input: {}", analysisCategory);
		analysisCategoryRepository.persist(analysisCategory);
		return analysisCategory;
	}

	@Override
	@Transactional
	public AnalysisCategory updateCategory(AnalysisCategory analysisCategory) {
		log.info("AnalysisCategoryServiceImpl >> updateCategory() >> input: {}", analysisCategory);
		AnalysisCategory analysisCategoryDataBase = analysisCategoryRepository.findById(analysisCategory.getId());
		if(analysisCategoryDataBase == null) {
			throw new NotFoundException(String.format("Id=%s not found in DDBB", analysisCategory.getId()));
		} else {
			analysisCategoryDataBase.setName(analysisCategory.getName());
			analysisCategoryDataBase.setDesciption(analysisCategory.getDesciption());
			analysisCategoryDataBase.setParentCategory(analysisCategory.getParentCategory());
			analysisCategoryRepository.persist(analysisCategoryDataBase);
		}
		return analysisCategoryDataBase;
	}

	@Override
	@Transactional
	public boolean deleteCategory(long id) {
		log.info("AnalysisCategoryServiceImpl >> deleteCategory() >> data input: id={}", id);
		boolean dataDeleted = analysisCategoryRepository.deleteById(id);
		if(!dataDeleted) {
			throw new NotFoundException(String.format("Id=%s not found in DDBB", id));
		}
		return dataDeleted;
	}

	@Override
	public List<AnalysisCategory> searchCategories(String name) {
		log.info("AnalysisCategoryServiceImpl >> searchCategories() >> data input: name={}", name);
		// TODO Auto-generated method stub
		return null;
	}

}
