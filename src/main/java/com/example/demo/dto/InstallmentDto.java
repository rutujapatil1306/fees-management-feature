package com.example.demo.dto;

import java.time.LocalDate;

public class InstallmentDto {

	 private Integer id;
	    private String type;
	    private Integer installmentNumber;
	    private Double amount;
	    private LocalDate dueDate;
	    
	    
	    
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Integer getInstallmentNumber() {
			return installmentNumber;
		}
		public void setInstallmentNumber(Integer installmentNumber) {
			this.installmentNumber = installmentNumber;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public LocalDate getDueDate() {
			return dueDate;
		}
		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}
		
	    
	    
}
