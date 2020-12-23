/**
 * 
 */
package com.dataworkshop.dataworkshopda.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.dataworkshop.dataworkshopda.entity.RawData;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * @author ramon
 *
 */
@ApplicationScoped
public class RawDataRepository implements PanacheRepository<RawData> {
	
	public List<RawData> findByName(String name) {
		return list("name LIKE ?1", '%' + name + '%');
	}

}
