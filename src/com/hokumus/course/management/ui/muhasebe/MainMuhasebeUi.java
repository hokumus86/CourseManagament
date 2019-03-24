package com.hokumus.course.management.ui.muhasebe;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;

public class MainMuhasebeUi extends JFrame{
	
	
	public MainMuhasebeUi() {
		initialize();
	}

	private void initialize() {
		setTitle("Dersane Projesi Muhasebe");
		setBounds(100, 100, 450, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
		getContentPane().setLayout(null);
	}
}
