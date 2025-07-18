package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Batch;
import com.example.demo.entity.Installment;

public class BatchWithInstallmentsResponseDTO {
	
	
	    private Batch batch;
	    private List<Installment> installments;

	    public BatchWithInstallmentsResponseDTO(Batch batch, List<Installment> installments) {
	        this.batch = batch;
	        this.installments = installments;
	    }

		public Batch getBatch() {
			return batch;
		}

		public void setBatch(Batch batch) {
			this.batch = batch;
		}

		public List<Installment> getInstallments() {
			return installments;
		}

		public void setInstallments(List<Installment> installments) {
			this.installments = installments;
		}

	}



