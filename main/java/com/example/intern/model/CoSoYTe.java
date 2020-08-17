package com.example.intern.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="dm_cosoyte")
public class CoSoYTe {
	
	@Id
	private Long id;
	
	@NotBlank
	private String ten;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tinhid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Tinh tinh;
	

	// constructor and getter setter 
	public CoSoYTe() {
		
	}

	public CoSoYTe(Long id, String ten, Tinh tinh) {
		super();
		this.id = id;
		this.ten = ten;
		this.tinh = tinh;
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
	
	public Tinh getTinh() {
		return tinh;
	}

	public void setTinh(Tinh tinh) {
		this.tinh = tinh;
	}
}
