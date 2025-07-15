package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Batch {

	@Id
	private int bID;
	  private String batchName;
	    private LocalDate startDate;
	    private LocalDate endDate;
	    private String mode;  // "Online" or "Offline"
	    private String timing;
	    private String trainerName;

	    @ManyToOne
	    @JoinColumn(name = "course_id")
	    private Course course;

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

		public LocalDate getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
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

		public String getTrainerName() {
			return trainerName;
		}

		public void setTrainerName(String trainerName) {
			this.trainerName = trainerName;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		@Override
		public String toString() {
			return "Batch [bID=" + bID + ", batchName=" + batchName + ", startDate=" + startDate + ", endDate="
					+ endDate + ", mode=" + mode + ", timing=" + timing + ", trainerName=" + trainerName + ", course="
					+ course + "]";
		}

		public Batch(int bID, String batchName, LocalDate startDate, LocalDate endDate, String mode, String timing,
				String trainerName, Course course) {
			super();
			this.bID = bID;
			this.batchName = batchName;
			this.startDate = startDate;
			this.endDate = endDate;
			this.mode = mode;
			this.timing = timing;
			this.trainerName = trainerName;
			this.course = course;
		}

		public Batch() {
	
		}
   
}
