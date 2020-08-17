package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intern.model.Khoa;

public interface KhoaRepository extends JpaRepository<Khoa, Long> {
	//query
	List<Khoa> findByCosoyteId(Long cosoyteid);
}
