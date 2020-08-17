package com.example.intern.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intern.model.BacSi;
import com.example.intern.model.Khoa;
import com.example.intern.service.IBacSiService;
import com.example.intern.service.IKhoaService;

@CrossOrigin 
@RestController
@RequestMapping("/api/v1")
public class BacSiController {
	
	@Autowired 
	private IBacSiService bacsiService;
	
	@Autowired
	private IKhoaService khoaService;
	
	@GetMapping("/bacsi")
	public List<BacSi> getAll(){
		return bacsiService.getAll();
	}
	
	@GetMapping("/bacsi/{id}")
	public BacSi getOneById(@PathVariable("id") Long id) {
		return bacsiService.getOneById(id);
	}
	
	@GetMapping("/bacsi/khoa/{khoaid}")
	public List<BacSi> findByKhoaId(@PathVariable("khoaid") Long khoaid){
		return bacsiService.findByKhoaId(khoaid);
	}
	
	@PostMapping("/bacsi/khoa/{khoaid}")
	public BacSi createBacSi(@PathVariable("khoaid") Long khoaid,
			@Valid @RequestBody BacSi bacsiRequest) {
		Khoa khoa = khoaService.getOneById(khoaid);
		bacsiRequest.setKhoa(khoa);
		
		return bacsiService.save(bacsiRequest);
	}
	
	@PutMapping("/bacsi/{bacsiid}/khoa/{khoaid}")
	public BacSi updateBacSi(@PathVariable("bacsiid") Long bacsiid,
			@PathVariable("khoaid") Long khoaid,
			@Valid @RequestBody BacSi bacsiRequest) {
		Khoa khoa = khoaService.getOneById(khoaid);
		BacSi bacsi = bacsiService.getOneById(bacsiid);
		
		bacsi.setTen(bacsiRequest.getTen());
		bacsi.setChuyenkhoa(bacsiRequest.getChuyenkhoa());
		bacsi.setTrinhdo(bacsiRequest.getTrinhdo());
		bacsi.setMota(bacsiRequest.getMota());
		bacsi.setKhoa(khoa);
		
		return bacsiService.save(bacsi);
	}
	
	@DeleteMapping("/bacsi/{id}")
	public void deleteBacSi(@PathVariable("id") Long id) {
		bacsiService.delete(id);
	}
	
}



























