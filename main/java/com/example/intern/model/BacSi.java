package com.example.intern.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dm_bacsi")
public class BacSi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank
	private String ten;
	
	@NotBlank
	private String chuyenkhoa;
	
	private String trinhdo;
	
	private String mota;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "khoaid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Khoa khoa;
	
	//constructor and getter setter
	
	public BacSi() {
		// TODO Auto-generated constructor stub
	}

	public BacSi(Long id, String ten, String chuyenkhoa, String trinhdo, String mota, Khoa khoa) {
		super();
		this.id = id;
		this.ten = ten;
		this.chuyenkhoa = chuyenkhoa;
		this.trinhdo = trinhdo;
		this.mota = mota;
		this.khoa = khoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getChuyenkhoa() {
		return chuyenkhoa;
	}

	public void setChuyenkhoa(String chuyenkhoa) {
		this.chuyenkhoa = chuyenkhoa;
	}

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Khoa getKhoa() {
		return khoa;
	}

	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}
	
	
	
	
}
