/**
 * 
 */
package com.dataworkshop.dataworkshopda.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.dataworkshop.dataworkshopda.entity.RawData;

/**
 * @author ramon
 *
 */
@ApplicationScoped
public interface RawDataService {
	
	public List<RawData> listData();
	
	public RawData getData(long id);
	
	public RawData setData(RawData rawData);
	
	public RawData updateData(RawData rawData);
	
	public boolean deleteData(long id);
	
	public List<RawData> searchData(String name);

}
