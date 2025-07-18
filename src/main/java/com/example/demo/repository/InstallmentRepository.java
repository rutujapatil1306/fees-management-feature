package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Installment;

public interface InstallmentRepository extends JpaRepository<Installment, Integer> {

}
