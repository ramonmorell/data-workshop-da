package com.dataworkshop.dataworkshopda.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.dataworkshop.dataworkshopda.entity.Analysis;

@ApplicationScoped
public interface AnalysisService {
	
	public List<Analysis> listAnalyses();
	
	public Analysis getAnalysis(long id);
	
	public Analysis setAnalysis(Analysis analysis);
	
	public Analysis updateAnalysis(Analysis analysis);
	
	public boolean deleteAnalysis(long id);
	
	public List<Analysis> searchAnalyses(String name);
	
}
