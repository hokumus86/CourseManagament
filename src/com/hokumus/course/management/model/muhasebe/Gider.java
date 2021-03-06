package com.hokumus.course.management.model.muhasebe;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.management.model.base.BaseEntity;
import com.hokumus.course.management.model.demirbas.Envanter;
import com.hokumus.course.management.model.ik.Ogretmen;
import com.hokumus.course.management.model.ik.Personel;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "expense")
public class Gider extends BaseEntity{

    private Long id;
    private String konu;
    private BigDecimal miktar;
    private Date tarih;
    private Ogretmen ogretmen;
    private Personel personel;
    private Envanter envanter;
    private DigerGiderler digerGiderler;
    
    @Embedded
    public DigerGiderler getDigerGiderler() {
		return digerGiderler;
	}

	public void setDigerGiderler(DigerGiderler digerGiderler) {
		this.digerGiderler = digerGiderler;
	}

	@Id
    @SequenceGenerator(name = "seq_expense", allocationSize = 1, sequenceName = "seq_expense")
    @GeneratedValue(generator = "seq_expense", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "subject", length = 100)
    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    @Column(name = "quantity", precision = 14, scale = 2)
    public BigDecimal getMiktar() {
        return miktar;
    }

    public void setMiktar(BigDecimal miktar) {
        this.miktar = miktar;
    }

    @Column(name = "date")
    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    public Ogretmen getOgretmen() {
        return ogretmen;
    }

    public void setOgretmen(Ogretmen ogretmen) {
        this.ogretmen = ogretmen;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    public Envanter getEnvanter() {
        return envanter;
    }

    public void setEnvanter(Envanter envanter) {
        this.envanter = envanter;
    }

    @Override
    public String toString() {
        return   "Gider Id = " +id+" Personel id = "+personel+ " Envanter id = "+envanter+ " Ogretmen id = "+ogretmen;
    }
 

}

