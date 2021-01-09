/**
 * 
 */
package com.dataworkshop.dataworkshopda.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import com.dataworkshop.dataworkshopda.dto.AnalysisCategoryDto;
import com.dataworkshop.dataworkshopda.entity.AnalysisCategory;
import com.dataworkshop.dataworkshopda.mapper.AnalysisCategoryMapper;
import com.dataworkshop.dataworkshopda.service.AnalysisCategoryService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ramon
 *
 */
@ApplicationScoped
@Slf4j
public class AnalysisCategoryResourceImpl implements AnalysisCategoryResource {

	@Inject
	AnalysisCategoryService analysisCategoryService;

	@Override
	public Response listCategories() {
		log.info("AnalysisCategoryResourceImpl >> listCategories()");
		List<AnalysisCategoryDto> res = new ArrayList<AnalysisCategoryDto>();
		try {
			res = analysisCategoryService.listCategories().stream().map(category -> AnalysisCategoryMapper.toDto(category)).collect(Collectors.toList());
			log.info("AnalysisCategoryResourceImpl >> listCategories() >> {}", res);
		} catch (Exception e) {
			log.error("AnalysisCategoryResourceImpl >> listCategories() : " + e.getMessage());
		}
		return Response.ok(res).status(200).build();
	}

	@Override
	public Response getCategory(long id) {
		log.info("AnalysisCategoryResourceImpl >> getCategory() >> data input: id={}", id);
		AnalysisCategory res = new AnalysisCategory();
		try {
			res = analysisCategoryService.getCategory(id);
			log.info("AnalysisCategoryResourceImpl >> getCategory() >> {}", res);
		} catch (NotFoundException e) {
			log.error("AnalysisCategoryResourceImpl >> getCategory() : " + e.getMessage());
			return Response.serverError().status(409).build();
		} catch (Exception e) {
			log.error("AnalysisCategoryResourceImpl >> getCategory() : " + e.getMessage());
			return Response.serverError().status(500).build();
		}
		return Response.ok(res).status(200).build();
	}

	@Override
	public Response setCategory(AnalysisCategoryDto category) {
		log.info("AnalysisCategoryResourceImpl >> setCategory() >> data input: {}", category);
		AnalysisCategory res = new AnalysisCategory();
		try {
			AnalysisCategory categoryEntity = AnalysisCategoryMapper.toEntity(category);
			AnalysisCategory parentCategory = analysisCategoryService.getCategory(category.getParentCategoryId());
			categoryEntity.setParentCategory(parentCategory);
			res = analysisCategoryService.setCategory(categoryEntity);
			log.info("AnalysisCategoryResourceImpl >> setCategory() >> {}", res);
		} catch (PersistenceException e) {
			log.error("AnalysisCategoryResourceImpl >> setCategory() : " + e.getMessage());
			return Response.serverError().status(409).build();
		} catch (Exception e) {
			log.error("AnalysisCategoryResourceImpl >> setCategory() : " + e.getMessage());
			return Response.serverError().status(500).build();
		}
		return Response.ok(res).status(200).build();
	}

	@Override
	public Response updateCategory(AnalysisCategoryDto category) {
		log.info("AnalysisCategoryResourceImpl >> updateCategory() >> data input: {}", category);
		AnalysisCategory res = new AnalysisCategory();
		try {
			AnalysisCategory categoryEntity = AnalysisCategoryMapper.toEntity(category);
			AnalysisCategory parentCategory = analysisCategoryService.getCategory(category.getId());
			categoryEntity.setParentCategory(parentCategory);
			res = analysisCategoryService.updateCategory(categoryEntity);
			log.info("AnalysisCategoryResourceImpl >> updateCategory() >> {}", res);
		} catch (NotFoundException e) {
			log.error("AnalysisCategoryResourceImpl >> updateCategory() : " + e.getMessage());
			return Response.serverError().status(409).build();
		} catch (Exception e) {
			log.error("AnalysisCategoryResourceImpl >> updateCategory() : " + e.getMessage());
			return Response.serverError().status(500).build();
		}
		return Response.ok(res).status(200).build();
	}

	@Override
	public Response deleteCategory(long id) {
		log.info("AnalysisCategoryResourceImpl >> deleteCategory() >> data input: id={}", id);
		boolean res = false;
		try {
			res = analysisCategoryService.deleteCategory(id);
			log.info("AnalysisCategoryResourceImpl >> deleteCategory() >> {}", res);
		} catch (NotFoundException e) {
			log.error("AnalysisCategoryResourceImpl >> deleteCategory() : " + e.getMessage());
			return Response.serverError().status(409).build();
		} catch (Exception e) {
			log.error("AnalysisCategoryResourceImpl >> deleteCategory() : " + e.getMessage());
			return Response.serverError().status(500).build();
		}
		return Response.ok(res).status(200).build();
	}

	@Override
	public Response searchCategories(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
