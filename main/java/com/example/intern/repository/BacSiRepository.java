package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intern.model.BacSi;

public interface BacSiRepository extends JpaRepository<BacSi, Long> {
	//query
	List<BacSi> findByKhoaId(Long id);
}
