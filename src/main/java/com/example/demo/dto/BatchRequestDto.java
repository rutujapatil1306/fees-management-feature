package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.BatchStatus;

public class BatchRequestDto {

	private Integer bID;
	private String batchName;
	private LocalDate startDate;
	private String mode;
	private String timing;
	private Integer fees;
	private String description;
	private BatchStatus status;

	private List<InstallmentDto> installments;

	public BatchStatus getStatus() {
		return status;
	}

	public void setStatus(BatchStatus status) {
		this.status = status;
	}

	public Integer getbID() {
		return bID;
	}

	public void setbID(Integer bID) {
		this.bID = bID;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<InstallmentDto> getInstallments() {
		return installments;
	}

	public void setInstallments(List<InstallmentDto> installments) {
		this.installments = installments;
	}

}
