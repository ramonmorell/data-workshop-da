/**
 * 
 */
package com.dataworkshop.dataworkshopda.repository;

import javax.enterprise.context.ApplicationScoped;

import com.dataworkshop.dataworkshopda.entity.AnalysisCategory;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * @author ramon
 *
 */
@ApplicationScoped
public class AnalysisCategoryRepository implements PanacheRepository<AnalysisCategory> {

}
