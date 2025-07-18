package com.example.demo.service;

import com.example.demo.dto.BatchRequestDto;
import com.example.demo.dto.BatchWithInstallmentsResponseDTO;
import com.example.demo.entity.Batch;

public interface BatchService {

	Batch save(Batch batch);

	BatchWithInstallmentsResponseDTO saveBatchWithInstallments(BatchRequestDto dto);

}
