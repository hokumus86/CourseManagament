package com.hokumus.course.management.model.ik;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.management.model.base.BaseEntity;
import com.hokumus.course.management.model.kullanici.CinsiyetEnum;
import com.hokumus.course.management.ui.ik.EgitimDuzeyiEnum;

@Entity
@Table(name="basvuru")
public class Basvuru extends BaseEntity implements Serializable{
	

	
	private Long id;
	private String name;
	private String surname;
	private CinsiyetEnum cinsiyet;
	private Date dogumTarihi;
	private String dogumYeri;
	private int ceptel;
	private String email;
	private String medeniDurum;
	private String adres;
	private EgitimDuzeyiEnum egitimDuzeyi;
	private String uzmanlikAlani;
	private int tecrubeYili;
	private String referans1;
	private String referans2;
	private String referans3;
	// private byte[] foto;
	 

	@Id
	@SequenceGenerator(name="seq_basvuru",allocationSize=1,initialValue=1,sequenceName="seq_basvuru")
	@GeneratedValue(generator="seq_basvuru",strategy=GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="name",length=100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="surname",length=100)
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column(name="sex",length=10)
	public CinsiyetEnum getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(CinsiyetEnum cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	
	@Column(name="birthdate",length=10)
	public Date getDogumTarihi() {
		return dogumTarihi;
	}
	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	
	@Column(name="birthplace",length=100)
	public String getDogumYeri() {
		return dogumYeri;
	}
	public void setDogumYeri(String dogumYeri) {
		this.dogumYeri = dogumYeri;
	}
	
	@Column(name="mobilephone",length=100)
	public int getCeptel() {
		return ceptel;
	}
	public void setCeptel(int ceptel) {
		this.ceptel = ceptel;
	}
	
	@Column(name="email",length=100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="maritalstatus",length=100)
	public String getMedeniDurum() {
		return medeniDurum;
	}
	public void setMedeniDurum(String medeniDurum) {
		this.medeniDurum = medeniDurum;
	}
	
	@Column(name="address",length=100)
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}

	@Column(name="educationallevel",length=100)
	public EgitimDuzeyiEnum getEgitimDuzeyi() {
		return egitimDuzeyi;
	}
	public void setEgitimDuzeyi(EgitimDuzeyiEnum egitimDuzeyi) {
		this.egitimDuzeyi = egitimDuzeyi;
	}

	@Column(name="profession",length=100)
	public String getUzmanlikAlani() {
		return uzmanlikAlani;
	}
	public void setUzmanlikAlani(String uzmanlikAlani) {
		this.uzmanlikAlani = uzmanlikAlani;
	}
	

	@Column(name="experience",length=3)
	public int getTecrubeYili() {
		return tecrubeYili;
	}
	public void setTecrubeYili(int tecrubeYili) {
		this.tecrubeYili = tecrubeYili;
	}
	

	@Column(name="reference1",length=1000)
	public String getReferans1() {
		return referans1;
	}
	public void setReferans1(String referans1) {
		this.referans1 = referans1;
	}

	@Column(name="reference2",length=1000)
	public String getReferans2() {
		return referans2;
	}
	public void setReferans2(String referans2) {
		this.referans2 = referans2;
	}

	@Column(name="reference3",length=1000)
	public String getReferans3() {
		return referans3;
	}
	public void setReferans3(String referans3) {
		this.referans3 = referans3;
	}
	/*
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	*/
	
	
	
	

}
