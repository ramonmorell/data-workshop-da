/**
 * 
 */
package com.dataworkshop.dataworkshopda.repository;

import javax.enterprise.context.ApplicationScoped;

import com.dataworkshop.dataworkshopda.entity.Analysis;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * @author ramon
 *
 */
@ApplicationScoped
public class AnalysisRepository implements PanacheRepository<Analysis> {

}
