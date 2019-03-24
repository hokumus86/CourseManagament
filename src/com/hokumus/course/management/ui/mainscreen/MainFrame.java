package com.hokumus.course.management.ui.mainscreen;

import javax.swing.JFrame;

import com.hokumus.course.management.model.kullanici.Role;
import com.hokumus.course.management.ui.ik.ApplicationForm;
import com.hokumus.course.management.ui.ik.ApplicationsList;
import com.hokumus.course.management.ui.ik.PersonelAdd;
import com.hokumus.course.management.ui.kullanici.EnterUser;
import com.hokumus.course.management.ui.kullanici.UserAdd;
import com.hokumus.course.management.ui.muhasebe.AylikGelirUi;
import com.hokumus.course.management.ui.muhasebe.AylikGiderUi;
import com.hokumus.course.management.ui.muhasebe.AylikKarZararUi;
import com.hokumus.course.management.ui.muhasebe.BorcSorgulamaUi;
import com.hokumus.course.management.ui.muhasebe.DogalgazFatOdemeUi;
import com.hokumus.course.management.ui.muhasebe.ElektirikFatOdemeUi;
import com.hokumus.course.management.ui.muhasebe.GelirEnvanterUi;
import com.hokumus.course.management.ui.muhasebe.GiderEnvanterUi;
import com.hokumus.course.management.ui.muhasebe.InternetFatOdemeUi;
import com.hokumus.course.management.ui.muhasebe.MainMuhasebeUi;
import com.hokumus.course.management.ui.muhasebe.OgrenciOdemeUi;
import com.hokumus.course.management.ui.muhasebe.OgretmenOdemeUi;
import com.hokumus.course.management.ui.muhasebe.PersonelOdemeUi;
import com.hokumus.course.management.ui.muhasebe.SuFatOdemeUi;
import com.hokumus.course.management.ui.muhasebe.VergiOdemeUi;
import com.hokumus.course.management.ui.muhasebe.YillikGelirUi;
import com.hokumus.course.management.ui.muhasebe.YillikKarZararUi;
import com.hokumus.course.management.ui.muhasebe.YillikZararUi;
import com.hokumus.course.management.ui.ogretmen.OgretmenFrame;
import com.hokumus.course.management.ui.yonetim.KursAcma;
import com.hokumus.course.management.ui.yonetim.KursListesi;
import com.hokumus.course.management.ui.yonetim.ProductivityFrame;
import com.hokumus.course.management.ui.yonetim.SalonAcma;
import com.hokumus.course.management.util.CourseUtils;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private EnterUser user;

	public MainFrame(EnterUser user) {
		this.user = user; // Para metre almayýp giriþ ekranýný ana ekran açýlýrken kapatýp
		// daha sonra ana ekrandan istendiðinde yeni istance yaratýlabilir.
		intialize();
		if (CourseUtils.userRole == Role.ADMIN)
			intialize();
		else if(CourseUtils.userRole == Role.STUDENT)
			intialize_Student();
	}

	private void intialize() {
		setTitle("Dersane Projesi Ana Ekran");
		setBounds(100, 100, 650, 700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnDosya = new JMenu("Dosya");
		menuBar.add(mnDosya);

		JMenuItem mnItemStdList = new JMenuItem("\u00D6\u011Frenci Listesi");
		mnDosya.add(mnItemStdList);

		JMenuItem mnItemThrList = new JMenuItem("\u00D6\u011Fretmen Listesi");
		mnItemThrList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgretmenFrame of = new OgretmenFrame();
				of.setVisible(true);
			}
		});
		mnDosya.add(mnItemThrList);

		JMenuItem mnItemCrsList = new JMenuItem("Kurs Listesi");
		mnItemCrsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KursListesi().setVisible(true);
			}
		});
		mnDosya.add(mnItemCrsList);

		JMenu mnSettings = new JMenu("\u0130\u015Flem");
		menuBar.add(mnSettings);

		JMenuItem mnItemStdAdd = new JMenuItem("\u00D6\u011Frenci Ekleme");
		mnSettings.add(mnItemStdAdd);

		JMenuItem mnItemCourseAdd = new JMenuItem("Kurs A\u00E7ma");
		mnItemCourseAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KursAcma().setVisible(true);
			}
		});
		mnSettings.add(mnItemCourseAdd);

		JMenuItem mnItemThrAdd = new JMenuItem("\u00D6\u011Fretmen Ekleme");
		mnSettings.add(mnItemThrAdd);
		
		JMenuItem mnItemUserAdd = new JMenuItem("Kullan\u0131c\u0131 Ekleme");
		mnItemUserAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnItemUserAdd_Action_Performed(e);
			}
		});
		mnSettings.add(mnItemUserAdd);
		JMenuItem mntmSalonAma = new JMenuItem("Salon A\u00E7ma");
		mntmSalonAma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SalonAcma().setVisible(true);
			}
		});
		mnSettings.add(mntmSalonAma);
		
		JMenu mnGelir = new JMenu("Gelir");
		menuBar.add(mnGelir);
		
		JMenuItem mnýtmrencideme = new JMenuItem("\u00D6\u011Frenci \u00D6deme");
		mnýtmrencideme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel ooUi = new OgrenciOdemeUi();
				getContentPane().add(ooUi);
				ooUi.updateUI();
				ooUi.setVisible(true);
			}
		});
		mnGelir.add(mnýtmrencideme);
		
		JMenuItem mnýtmBorSorgulama = new JMenuItem("Bor\u00E7 Sorgulama");
		mnýtmBorSorgulama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel bsUi = new BorcSorgulamaUi();
				getContentPane().add(bsUi);
				bsUi.updateUI();
				bsUi.setVisible(true);
			}
		});
		mnGelir.add(mnýtmBorSorgulama);
		
		JMenuItem mnýtmEnvanter_1 = new JMenuItem("Envanter");
		mnýtmEnvanter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel gelirEnvanter = new GelirEnvanterUi();
				getContentPane().add(gelirEnvanter);
				gelirEnvanter.updateUI();
				gelirEnvanter.setVisible(true);
			}
		});
		mnGelir.add(mnýtmEnvanter_1);
		
		JMenu mnGider = new JMenu("Gider");
		menuBar.add(mnGider);
		
		JMenuItem mnýtmretmendeme = new JMenuItem("\u00D6\u011Fretmen \u00D6deme");
		mnýtmretmendeme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel ogretmenOdeme = new OgretmenOdemeUi();
				getContentPane().add(ogretmenOdeme);
				ogretmenOdeme.updateUI();
				ogretmenOdeme.setVisible(true);
			}
		});
		mnGider.add(mnýtmretmendeme);
		
		JMenuItem mnýtmPersoneldeme = new JMenuItem("Personel \u00D6deme");
		mnýtmPersoneldeme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel personelOdeme = new PersonelOdemeUi();
				getContentPane().add(personelOdeme);
				personelOdeme.updateUI();
				personelOdeme.setVisible(true);
			}
		});
		mnGider.add(mnýtmPersoneldeme);
		
		JMenuItem mnýtmEnvanter = new JMenuItem("Envanter");
		mnýtmEnvanter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel giderEnvanter = new GiderEnvanterUi();
				getContentPane().add(giderEnvanter);
				giderEnvanter.updateUI();
				giderEnvanter.setVisible(true);
			}
		});
		mnGider.add(mnýtmEnvanter);
		
		JMenu mnDierGiderler = new JMenu("Di\u011Fer Giderler");
		mnGider.add(mnDierGiderler);
		
		JMenuItem mnýtmElektrikFatura = new JMenuItem("Elektrik Fatura");
		mnýtmElektrikFatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel elektrikFatura = new ElektirikFatOdemeUi();
				getContentPane().add(elektrikFatura);
				elektrikFatura.updateUI();
				elektrikFatura.setVisible(true);
			}
		});
		mnDierGiderler.add(mnýtmElektrikFatura);
		
		JMenuItem mnýtmSuFatura = new JMenuItem("Su Fatura");
		mnýtmSuFatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel suFatura = new SuFatOdemeUi();
				getContentPane().add(suFatura);
				suFatura.updateUI();
				suFatura.setVisible(true);
			}
		});
		mnDierGiderler.add(mnýtmSuFatura);
		
		JMenuItem mnýtmDoalgazFatura = new JMenuItem("Do\u011Falgaz Fatura");
		mnýtmDoalgazFatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel dogalgazFatura = new DogalgazFatOdemeUi();
				getContentPane().add(dogalgazFatura);
				dogalgazFatura.updateUI();
				dogalgazFatura.setVisible(true);
			}
		});
		mnDierGiderler.add(mnýtmDoalgazFatura);
		
		JMenuItem mnýtmInternetFatura = new JMenuItem("\u0130nternet Fatura");
		mnýtmInternetFatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel internetFatura = new InternetFatOdemeUi();
				getContentPane().add(internetFatura);
				internetFatura.updateUI();
				internetFatura.setVisible(true);
			}
		});
		mnDierGiderler.add(mnýtmInternetFatura);
		
		JMenuItem mnýtmVergideme = new JMenuItem("Vergi \u00D6deme");
		mnýtmVergideme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel vergiOdeme = new VergiOdemeUi();
				getContentPane().add(vergiOdeme);
				vergiOdeme.updateUI();
				vergiOdeme.setVisible(true);
			}
		});
		mnDierGiderler.add(mnýtmVergideme);
		
		JMenu mnzet = new JMenu("\u00D6zet");
		menuBar.add(mnzet);
		
		JMenu mnAylkzet = new JMenu("Ayl\u0131k \u00D6zet");
		mnzet.add(mnAylkzet);
		
		JMenuItem mnýtmAylkGelir = new JMenuItem("Ayl\u0131k Gelir");
		mnýtmAylkGelir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel aylikGelir = new AylikGelirUi();
				getContentPane().add(aylikGelir);
				aylikGelir.updateUI();
				aylikGelir.setVisible(true);
			}
		});
		mnAylkzet.add(mnýtmAylkGelir);
		
		JMenuItem mnýtmAylkGider = new JMenuItem("Ayl\u0131k Gider");
		mnýtmAylkGider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel aylikGider = new AylikGiderUi();
				getContentPane().add(aylikGider);
				aylikGider.updateUI();
				aylikGider.setVisible(true);
			}
		});
		mnAylkzet.add(mnýtmAylkGider);
		
		JMenuItem mnýtmAylkKarzarar = new JMenuItem("Ayl\u0131k Kar/Zarar");
		mnýtmAylkKarzarar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel aylikKarZarar = new AylikKarZararUi();
				getContentPane().add(aylikKarZarar);
				aylikKarZarar.updateUI();
				aylikKarZarar.setVisible(true);
			}
		});
		mnAylkzet.add(mnýtmAylkKarzarar);
		
		JMenu mnYllkzet = new JMenu("Y\u0131ll\u0131k \u00D6zet");
		mnzet.add(mnYllkzet);
		
		JMenuItem mnýtmYllkGelir = new JMenuItem("Y\u0131ll\u0131k Gelir");
		mnýtmYllkGelir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel yillikGelir = new YillikGelirUi();
				getContentPane().add(yillikGelir);
				yillikGelir.updateUI();
				yillikGelir.setVisible(true);
			}
		});
		mnYllkzet.add(mnýtmYllkGelir);
		
		JMenuItem mnýtmYllkGider = new JMenuItem("Y\u0131ll\u0131k Gider");
		mnýtmYllkGider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel yillikGider = new YillikZararUi();
				getContentPane().add(yillikGider);
				yillikGider.updateUI();
				yillikGider.setVisible(true);
			}
		});
		mnYllkzet.add(mnýtmYllkGider);
		
		JMenuItem mnýtmYllkKarzarar = new JMenuItem("Y\u0131ll\u0131k Kar/Zarar");
		mnýtmYllkKarzarar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel yillikKarZarar = new YillikKarZararUi();
				getContentPane().add(yillikKarZarar);
				yillikKarZarar.updateUI();
				yillikKarZarar.setVisible(true);
			}
		});
		mnYllkzet.add(mnýtmYllkKarzarar);
		JMenu mnInsanKaynaklar = new JMenu("\u0130nsan Kaynaklar\u0131");
		menuBar.add(mnInsanKaynaklar);
		
		JMenuItem mnItemApplicationForm = new JMenuItem("Ba\u015Fvuru Formu");
		mnItemApplicationForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnItemApplicationForm_Action_Performed(e);
			}
		});
		mnInsanKaynaklar.add(mnItemApplicationForm);
		
		JMenuItem mnItemBasvuruListesi = new JMenuItem("Ba\u015Fvuru Listesi");
		mnItemBasvuruListesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mnItemBasvuruListesi_Action_Performed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		mnInsanKaynaklar.add(mnItemBasvuruListesi);
		
		JMenuItem mnItemPersonelEkle = new JMenuItem("Personel Ekle");
		mnItemPersonelEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnItemPersonelEkle_Action_Performed(e);
			}
		});
		mnInsanKaynaklar.add(mnItemPersonelEkle);
		JMenuItem mnItemProductivity = new JMenuItem("Kurslarýn Verimliliði");
		mnItemProductivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnItemProductivity_Action_Performed(e);
			}
		});
		mnSettings.add(mnItemProductivity);
	}
	
	protected void mnItemProductivity_Action_Performed(ActionEvent e) {
		ProductivityFrame temp = new ProductivityFrame();
		temp.setVisible(true);
	}
	
	protected void mnItemBasvuruListesi_Action_Performed(ActionEvent e) throws Exception {
		ApplicationsList al = new ApplicationsList();
		al.setVisible(true);
		
	}

	protected void mnItemPersonelEkle_Action_Performed(ActionEvent e) {
		PersonelAdd pa = new  PersonelAdd();
		pa.setVisible(true);
		
	}

	protected void mnItemApplicationForm_Action_Performed(ActionEvent e) {
		ApplicationForm apf = new ApplicationForm();
		apf.setVisible(true);
		
	}

	protected void mnItemUserAdd_Action_Performed(ActionEvent e) {
		UserAdd temp = new UserAdd();
		temp.setVisible(true);
		
	}

	private void intialize_Student() {
		setTitle("Dersane Projesi Ana Ekran");
		setBounds(100, 100, 650, 700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnDosya = new JMenu("Dosya");
		menuBar.add(mnDosya);

		JMenuItem mnItemStdList = new JMenuItem("\u00D6\u011Frenci Listesi");
		mnDosya.add(mnItemStdList);

		JMenuItem mnItemThrList = new JMenuItem("\u00D6\u011Fretmen Listesi");
		mnDosya.add(mnItemThrList);

		JMenuItem mnItemCrsList = new JMenuItem("Kurs Listesi");
		mnDosya.add(mnItemCrsList);

		JMenu mnSettings = new JMenu("\u0130\u015Flem");
		menuBar.add(mnSettings);


		
	}
}
