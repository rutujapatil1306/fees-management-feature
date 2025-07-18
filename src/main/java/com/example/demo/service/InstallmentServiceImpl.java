package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.InstallmentRequestDto;
import com.example.demo.entity.Batch;
import com.example.demo.entity.Installment;
import com.example.demo.entity.InstallmentType;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.InstallmentRepository;

@Service
public class InstallmentServiceImpl implements InstallmentService {

	@Autowired
	InstallmentRepository installmentRepository;
	
	@Autowired
	BatchRepository batchRepository;
	
	
	@Override
	public List<Installment> saveInstallments(InstallmentRequestDto dto) {
	 
	    Batch batch = batchRepository.findById(dto.getBatchId())
	        .orElseThrow(() -> new RuntimeException("Batch not found with ID: " + dto.getBatchId()));

	  
	    List<Installment> installmentList = dto.getInstallments().stream().map(installmentDto -> {
	        Installment installment = new Installment();
	        installment.setType(InstallmentType.valueOf(installmentDto.getType()));
	        installment.setAmount(installmentDto.getAmount());
	        installment.setDueDate(installmentDto.getDueDate());
	        installment.setInstallmentNumber(installmentDto.getInstallmentNumber());
	        installment.setBatch(batch);
	        return installment;
	    }).collect(Collectors.toList());

	  
	    return installmentRepository.saveAll(installmentList);
	}

}
