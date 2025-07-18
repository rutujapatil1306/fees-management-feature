package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.InstallmentRequestDto;
import com.example.demo.entity.Installment;

public interface InstallmentService {

	List<Installment> saveInstallments(InstallmentRequestDto dto);

}
