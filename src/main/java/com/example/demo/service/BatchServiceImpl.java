package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BatchRequestDto;
import com.example.demo.dto.BatchWithInstallmentsResponseDTO;
import com.example.demo.entity.Batch;
import com.example.demo.entity.Installment;
import com.example.demo.entity.InstallmentType;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstallmentRepository;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	BatchRepository batchRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	InstallmentRepository installmentRepository;
	
	@Override
	public Batch save(Batch batch) {
		Batch savedBatch = batchRepository.save(batch);
		return savedBatch;
	}
	
	@Override
	public BatchWithInstallmentsResponseDTO saveBatchWithInstallments(BatchRequestDto dto) {
	    Batch batch = new Batch();
	    batch.setbID(dto.getbID());
	    batch.setBatchName(dto.getBatchName());
	    batch.setStartDate(dto.getStartDate());
	    batch.setMode(dto.getMode());
	    batch.setTiming(dto.getTiming());
	    batch.setFees(dto.getFees());
	    batch.setDescription(dto.getDescription());
	    batch.setStatus(dto.getStatus());

	    // Save the batch
	    Batch savedBatch = batchRepository.save(batch);

	    // Map and save installments
	    List<Installment> installmentList = dto.getInstallments().stream().map(i -> {
	        Installment inst = new Installment();
	        inst.setId(i.getId());
	        inst.setType(InstallmentType.valueOf(i.getType()));
	        inst.setAmount(i.getAmount());
	        inst.setDueDate(i.getDueDate());
	        inst.setInstallmentNumber(i.getInstallmentNumber());
	        inst.setBatch(savedBatch);
	        return inst;
	    }).collect(Collectors.toList());

	    List<Installment> savedInstallments = installmentRepository.saveAll(installmentList);

	    // Return the response
	    return new BatchWithInstallmentsResponseDTO(savedBatch, savedInstallments);
	}




}
