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
		
		JMenuItem mn�tmrencideme = new JMenuItem("\u00D6\u011Frenci \u00D6deme");
		mn�tmrencideme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel ooUi = new OgrenciOdemeUi();
				getContentPane().add(ooUi);
				ooUi.updateUI();
				ooUi.setVisible(true);
			}
		});
		mnGelir.add(mn�tmrencideme);
		
		JMenuItem mn�tmBorSorgulama = new JMenuItem("Bor\u00E7 Sorgulama");
		mn�tmBorSorgulama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel bsUi = new BorcSorgulamaUi();
				getContentPane().add(bsUi);
				bsUi.updateUI();
				bsUi.setVisible(true);
			}
		});
		mnGelir.add(mn�tmBorSorgulama);
		
		JMenuItem mn�tmEnvanter_1 = new JMenuItem("Envanter");
		mn�tmEnvanter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel gelirEnvanter = new GelirEnvanterUi();
				getContentPane().add(gelirEnvanter);
				gelirEnvanter.updateUI();
				gelirEnvanter.setVisible(true);
			}
		});
		mnGelir.add(mn�tmEnvanter_1);
		
		JMenu mnGider = new JMenu("Gider");
		menuBar.add(mnGider);
		
		JMenuItem mn�tmretmendeme = new JMenuItem("\u00D6\u011Fretmen \u00D6deme");
		mn�tmretmendeme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel ogretmenOdeme = new OgretmenOdemeUi();
				getContentPane().add(ogretmenOdeme);
				ogretmenOdeme.updateUI();
				ogretmenOdeme.setVisible(true);
			}
		});
		mnGider.add(mn�tmretmendeme);
		
		JMenuItem mn�tmPersoneldeme = new JMenuItem("Personel \u00D6deme");
		mn�tmPersoneldeme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel personelOdeme = new PersonelOdemeUi();
				getContentPane().add(personelOdeme);
				personelOdeme.updateUI();
				personelOdeme.setVisible(true);
			}
		});
		mnGider.add(mn�tmPersoneldeme);
		
		JMenuItem mn�tmEnvanter = new JMenuItem("Envanter");
		mn�tmEnvanter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel giderEnvanter = new GiderEnvanterUi();
				getContentPane().add(giderEnvanter);
				giderEnvanter.updateUI();
				giderEnvanter.setVisible(true);
			}
		});
		mnGider.add(mn�tmEnvanter);
		
		JMenu mnDierGiderler = new JMenu("Di\u011Fer Giderler");
		mnGider.add(mnDierGiderler);
		
		JMenuItem mn�tmElektrikFatura = new JMenuItem("Elektrik Fatura");
		mn�tmElektrikFatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel elektrikFatura = new ElektirikFatOdemeUi();
				getContentPane().add(elektrikFatura);
				elektrikFatura.updateUI();
				elektrikFatura.setVisible(true);
			}
		});
		mnDierGiderler.add(mn�tmElektrikFatura);
		
		JMenuItem mn�tmSuFatura = new JMenuItem("Su Fatura");
		mn�tmSuFatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel suFatura = new SuFatOdemeUi();
				getContentPane().add(suFatura);
				suFatura.updateUI();
				suFatura.setVisible(true);
			}
		});
		mnDierGiderler.add(mn�tmSuFatura);
		
		JMenuItem mn�tmDoalgazFatura = new JMenuItem("Do\u011Falgaz Fatura");
		mn�tmDoalgazFatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel dogalgazFatura = new DogalgazFatOdemeUi();
				getContentPane().add(dogalgazFatura);
				dogalgazFatura.updateUI();
				dogalgazFatura.setVisible(true);
			}
		});
		mnDierGiderler.add(mn�tmDoalgazFatura);
		
		JMenuItem mn�tmInternetFatura = new JMenuItem("\u0130nternet Fatura");
		mn�tmInternetFatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel internetFatura = new InternetFatOdemeUi();
				getContentPane().add(internetFatura);
				internetFatura.updateUI();
				internetFatura.setVisible(true);
			}
		});
		mnDierGiderler.add(mn�tmInternetFatura);
		
		JMenuItem mn�tmVergideme = new JMenuItem("Vergi \u00D6deme");
		mn�tmVergideme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel vergiOdeme = new VergiOdemeUi();
				getContentPane().add(vergiOdeme);
				vergiOdeme.updateUI();
				vergiOdeme.setVisible(true);
			}
		});
		mnDierGiderler.add(mn�tmVergideme);
		
		JMenu mnzet = new JMenu("\u00D6zet");
		menuBar.add(mnzet);
		
		JMenu mnAylkzet = new JMenu("Ayl\u0131k \u00D6zet");
		mnzet.add(mnAylkzet);
		
		JMenuItem mn�tmAylkGelir = new JMenuItem("Ayl\u0131k Gelir");
		mn�tmAylkGelir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel aylikGelir = new AylikGelirUi();
				getContentPane().add(aylikGelir);
				aylikGelir.updateUI();
				aylikGelir.setVisible(true);
			}
		});
		mnAylkzet.add(mn�tmAylkGelir);
		
		JMenuItem mn�tmAylkGider = new JMenuItem("Ayl\u0131k Gider");
		mn�tmAylkGider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel aylikGider = new AylikGiderUi();
				getContentPane().add(aylikGider);
				aylikGider.updateUI();
				aylikGider.setVisible(true);
			}
		});
		mnAylkzet.add(mn�tmAylkGider);
		
		JMenuItem mn�tmAylkKarzarar = new JMenuItem("Ayl\u0131k Kar/Zarar");
		mn�tmAylkKarzarar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel aylikKarZarar = new AylikKarZararUi();
				getContentPane().add(aylikKarZarar);
				aylikKarZarar.updateUI();
				aylikKarZarar.setVisible(true);
			}
		});
		mnAylkzet.add(mn�tmAylkKarzarar);
		
		JMenu mnYllkzet = new JMenu("Y\u0131ll\u0131k \u00D6zet");
		mnzet.add(mnYllkzet);
		
		JMenuItem mn�tmYllkGelir = new JMenuItem("Y\u0131ll\u0131k Gelir");
		mn�tmYllkGelir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel yillikGelir = new YillikGelirUi();
				getContentPane().add(yillikGelir);
				yillikGelir.updateUI();
				yillikGelir.setVisible(true);
			}
		});
		mnYllkzet.add(mn�tmYllkGelir);
		
		JMenuItem mn�tmYllkGider = new JMenuItem("Y\u0131ll\u0131k Gider");
		mn�tmYllkGider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel yillikGider = new YillikZararUi();
				getContentPane().add(yillikGider);
				yillikGider.updateUI();
				yillikGider.setVisible(true);
			}
		});
		mnYllkzet.add(mn�tmYllkGider);
		
		JMenuItem mn�tmYllkKarzarar = new JMenuItem("Y\u0131ll\u0131k Kar/Zarar");
		mn�tmYllkKarzarar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				JPanel yillikKarZarar = new YillikKarZararUi();
				getContentPane().add(yillikKarZarar);
				yillikKarZarar.updateUI();
				yillikKarZarar.setVisible(true);
			}
		});
		mnYllkzet.add(mn�tmYllkKarzarar);
		getContentPane().setLayout(null);
	}
}
