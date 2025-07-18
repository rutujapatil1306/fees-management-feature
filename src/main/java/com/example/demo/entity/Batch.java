package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Batch {

	@Id
	private int bID;
	private String batchName;
	private LocalDate startDate;
    private String mode;  // "Online" or "Offline"
    private String timing;
    private Integer fees;
    private String description;
    
    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Enrollment> enrollments;
    
    
    public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
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
	
	    
		public int getbID() {
			return bID;
		}
		public void setbID(int bID) {
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
	    
	    
	   

}