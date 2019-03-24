package com.hokumus.course.management.ui.muhasebe;

import java.math.BigDecimal;
import java.util.Date;

import com.hokumus.course.management.model.ik.Ogretmen;
import com.hokumus.course.management.model.ik.Personel;
import com.hokumus.course.management.model.ogrenci.Ogrenci;
import com.hokumus.course.management.model.ogrenci.OgrenciGrup;
import com.hokumus.course.management.model.ogrenci.OgrenciOdeme;
import com.hokumus.course.management.util.DatabaseBaseService;

public class TestRunner {
	public static void main(String[] args) {
		new MainMuhasebeUi().setVisible(true);
		
		
		
		Ogrenci ogrenci = new Ogrenci();
		ogrenci.setAd("Mustafa");
		ogrenci.setSoyad("Senyurt");
		ogrenci.setKayitTarihi(new Date());
		
		
		OgrenciGrup grup = new OgrenciGrup();
		grup.setUcret(new BigDecimal(2500));
		
		
		OgrenciOdeme odeme = new OgrenciOdeme();
		
		
		Ogretmen ogretmen = new Ogretmen();
		ogretmen.setAd("Huseyin");
		ogretmen.setSoyad("Okumus");
		ogretmen.setUcret(new BigDecimal(1500));
		
		
		Personel personel = new Personel();
		personel.setAd("Ahmet");
		personel.setSoyad("Yagdiran");
		personel.setUcret(new BigDecimal(1000));
		
		DatabaseBaseService<Ogrenci> daoOgrenci = new DatabaseBaseService<Ogrenci>();
		DatabaseBaseService<OgrenciGrup> daoGrup = new DatabaseBaseService<>();
		DatabaseBaseService<OgrenciOdeme> daoOdeme = new DatabaseBaseService<>();
		DatabaseBaseService<Ogretmen> daoOgretmen = new DatabaseBaseService<>();
		DatabaseBaseService<Personel> daoPersonel = new DatabaseBaseService<>();
		
		
		try {
			daoOgrenci.kaydet(ogrenci);
			daoOgretmen.kaydet(ogretmen);
			daoPersonel.kaydet(personel);
			grup.setOgrenci(daoOgrenci.kullaniciBulDiger(ogrenci));
			daoGrup.kaydet(grup);
			odeme.setOgrenci(daoOgrenci.kullaniciBulDiger(ogrenci));
			daoOdeme.kaydet(odeme);
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			new MainMuhasebeUi().setVisible(true);
		}
		
	}
}
