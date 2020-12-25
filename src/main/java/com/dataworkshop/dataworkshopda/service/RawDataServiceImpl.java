/**
 * 
 */
package com.dataworkshop.dataworkshopda.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.dataworkshop.dataworkshopda.entity.RawData;
import com.dataworkshop.dataworkshopda.entity.Status;
import com.dataworkshop.dataworkshopda.repository.RawDataRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ramon
 *
 */
@ApplicationScoped
@Slf4j
public class RawDataServiceImpl implements RawDataService {

	@Inject
	RawDataRepository dataRepository;

	@Override
	public List<RawData> listData() {
		log.info("RawDataServiceImpl >> listData()");
		return dataRepository.listAll();
	}

	@Override
	public RawData getData(long id) {
		log.info("RawDataServiceImpl >> getData() >> input: id={}", id);
		Optional<RawData> res = dataRepository.findByIdOptional(id);
		res.orElseThrow(()-> new NotFoundException(String.format("Id=%s not found in DDBB", id)));
		return res.get();
	}

	@Override
	@Transactional
	public RawData setData(RawData rawData) {
		log.info("RawDataServiceImpl >> setData() >> input: {}", rawData);
		rawData.setDate(LocalDateTime.now());
		rawData.setState(Status.STATUS_ACTIVE);
		dataRepository.persist(rawData);
		return rawData;
	}

	@Override
	@Transactional
	public RawData updateData(RawData rawData) {
		log.info("RawDataServiceImpl >> updateData() >> input: {}", rawData);
		RawData rawDataDataBase = dataRepository.findById(rawData.getId());
		if (rawDataDataBase == null) {
			throw new NotFoundException(String.format("Id=%s not found in DDBB", rawData.getId()));
		} else {
			rawDataDataBase.setName(rawData.getName());
			rawDataDataBase.setDescription(rawData.getDescription());
			dataRepository.persist(rawDataDataBase);
		}
		return rawDataDataBase;
	}

	@Override
	@Transactional
	public boolean deleteData(long id) {
		log.info("RawDataServiceImpl >> deleteData() >> input: id={}", id);
		Boolean dataDeleted = dataRepository.deleteById(id);
		if (!dataDeleted) {
			throw new NotFoundException(String.format("Id=%s not found in DDBB", id));
		}
		return dataDeleted;
	}

	@Override
	public List<RawData> searchData(String name) {
		log.info("RawDataServiceImpl >> searchData() >> input: name={}", name);
		return dataRepository.findByName(name);
	}

}
