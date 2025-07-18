package com.example.demo.dto;

import java.util.List;

public class InstallmentRequestDto {

	  private Integer batchId;
	    private List<InstallmentDto> installments;
	    
		public Integer getBatchId() {
			return batchId;
		}
		public void setBatchId(Integer batchId) {
			this.batchId = batchId;
		}
		public List<InstallmentDto> getInstallments() {
			return installments;
		}
		public void setInstallments(List<InstallmentDto> installments) {
			this.installments = installments;
		}
	    
	    
}
