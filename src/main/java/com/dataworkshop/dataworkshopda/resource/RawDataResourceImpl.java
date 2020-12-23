/**
 * 
 */
package com.dataworkshop.dataworkshopda.resource;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import com.dataworkshop.dataworkshopda.entity.RawData;
import com.dataworkshop.dataworkshopda.service.RawDataService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ramon
 *
 */
@ApplicationScoped
@Slf4j
public class RawDataResourceImpl implements RawDataResource {

	@Inject
	RawDataService dataService;

	@Override
	public Response listData() {
		log.info("RawDataResourceImpl >> listData()");
		List<RawData> res = new ArrayList<RawData>();
		try {
			res = dataService.listData();
			log.info("RawDataResourceImpl >> listData() >> {}", res);
		} catch (Exception e) {
			log.error("RawDataResourceImpl >> listData() : " + e.getMessage());
		}
		return Response.ok(res).status(200).build();
	}

	@Override
	public Response getData(long id) {
		log.info("RawDataResourceImpl >> getData() >> data input: id={}", id);
		RawData res = new RawData();
		try {
			res = dataService.getData(id);
			log.info("RawDataResourceImpl >> getData() >> {}", res);
		} catch (NotFoundException e) {
			log.error("RawDataResourceImpl >> getData() : " + e.getMessage());
			return Response.serverError().status(409).build();
		} catch (Exception e) {
			log.error("RawDataResourceImpl >> getData() : " + e.getMessage());
			return Response.serverError().status(500).build();
		}
		return Response.ok(res).status(200).build();
	}

	@Override
	public Response setData(RawData rawData) {
		log.info("RawDataResourceImpl >> setData() >> data input: {}", rawData);
		RawData res = new RawData();
		try {
			res = dataService.setData(rawData);
			log.info("RawDataResourceImpl >> setData() >> {}", res);
		} catch (PersistenceException e) {
			log.error("RawDataResourceImpl >> setData() : " + e.getMessage());
			return Response.serverError().status(409).build();
		} catch (Exception e) {
			log.error("RawDataResourceImpl >> setData() : " + e.getMessage());
			return Response.serverError().status(500).build();
		}
		return Response.ok(res).status(200).build();
	}

	@Override
	public Response updateData(RawData rawData) {
		log.info("RawDataResourceImpl >> updateData() >> data input: {}", rawData);
		RawData res = new RawData();
		try {
			res = dataService.updateData(rawData);
			log.info("RawDataResourceImpl >> updateData() >> {}", res);
		} catch (NotFoundException e) {
			log.error("RawDataResourceImpl >> updateData() : " + e.getMessage());
			return Response.serverError().status(409).build();
		} catch (Exception e) {
			log.error("RawDataResourceImpl >> updateData() : " + e.getMessage());
			return Response.serverError().status(500).build();
		}
		return Response.ok(res).status(200).build();
	}

	@Override
	public Response deleteData(long id) {
		log.info("RawDataResourceImpl >> deleteData() >> data input: id={}", id);
		boolean res = false;
		try {
			res = dataService.deleteData(id);
			log.info("RawDataResourceImpl >> deleteData() >> {}", res);
		} catch (NotFoundException e) {
			log.error("RawDataResourceImpl >> deleteData() : " + e.getMessage());
			return Response.serverError().status(409).build();
		} catch (Exception e) {
			log.error("RawDataResourceImpl >> deleteData() : " + e.getMessage());
			return Response.serverError().status(500).build();
		}
		return Response.ok(res).status(200).build();
	}

	@Override
	public Response searchData(String name) {
		log.info("RawDataResourceImpl >> searchData() >> data input: name={}", name);
		List<RawData> res = new ArrayList<RawData>();
		try {
			res = dataService.searchData(name);
			log.info("RawDataResourceImpl >> searchData() >> {}", res);
		} catch (Exception e) {
			log.error("RawDataResourceImpl >> searchData() : " + e.getMessage());
		}
		return Response.ok(res).status(200).build();
	}

}
