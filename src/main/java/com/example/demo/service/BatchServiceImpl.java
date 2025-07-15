package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Batch;
import com.example.demo.repository.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	BatchRepository batchRepository;
	
	@Override
	public Batch save(Batch batch) {
		Batch savedBatch = batchRepository.save(batch);
		return savedBatch;
	}

}
