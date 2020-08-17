package com.example.intern.service;

import java.util.List;

import com.example.intern.model.Khoa;

public interface IKhoaService {
	
	List<Khoa> getAll();
	Khoa getOneById(Long id);
	List<Khoa> findByCosoyteId(Long cosoyteid);
	Khoa save(Khoa khoa);
	void delete(Long id);
}
