package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {

}
