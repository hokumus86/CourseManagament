package com.hokumus.course.management.ui.muhasebe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hokumus.course.management.dao.muhasebe.GelirDao;
import com.hokumus.course.management.dao.muhasebe.OgrenciOdemeDao;
import com.hokumus.course.management.model.muhasebe.Gelir;
import com.hokumus.course.management.model.ogrenci.Ogrenci;
import com.hokumus.course.management.model.ogrenci.OgrenciGrup;
import com.hokumus.course.management.model.ogrenci.OgrenciOdeme;
import com.hokumus.course.management.util.CourseUtils;
import com.hokumus.course.management.util.DatabaseBaseService;
import javax.swing.JTextArea;

public class OgrenciOdemeUi extends JPanel {
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtMoney;

	private JLabel lblNewLabel;
	private JLabel lblSoyad;
	private JLabel lblcret;
	private JLabel lblMoney;

	private JButton txtPay;
	private JButton btnIptal;
	private JTextArea textArea;
	private JLabel label;

	public OgrenciOdemeUi() {
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		setBounds(0, 0, 450, 500);
		setLayout(null);

		lblNewLabel = new JLabel("Ad\u0131 : ");
		lblNewLabel.setBounds(44, 58, 51, 14);
		add(lblNewLabel);

		txtName = new JTextField();
		txtName.setBounds(116, 55, 155, 20);
		add(txtName);
		txtName.setColumns(10);

		lblSoyad = new JLabel("Soyad\u0131 : ");
		lblSoyad.setBounds(44, 121, 57, 14);
		add(lblSoyad);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(116, 118, 155, 20);
		add(txtLastName);

		lblcret = new JLabel("\u00DCcret : ");
		lblcret.setBounds(44, 185, 51, 14);
		add(lblcret);

		txtMoney = new JTextField();
		txtMoney.setColumns(10);
		txtMoney.setBounds(116, 182, 155, 20);
		add(txtMoney);

		txtPay = new JButton("\u00D6deme Yap");
		txtPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OgrenciOdeme_Action_Performed(arg0);
			}
		});
		txtPay.setBounds(44, 416, 114, 23);
		add(txtPay);

		btnIptal = new JButton("Iptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnIptal.setBounds(201, 416, 114, 23);
		add(btnIptal);

		lblMoney = new JLabel("Kalan Bor\u00E7 : ");
		lblMoney.setBounds(44, 450, 241, 39);
		add(lblMoney);
		
		textArea = new JTextArea();
		textArea.setBounds(116, 251, 155, 94);
		add(textArea);
		
		label = new JLabel("A\u00E7\u0131klama : ");
		label.setBounds(44, 251, 51, 14);
		add(label);

	}

	protected void OgrenciOdeme_Action_Performed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DatabaseBaseService<Ogrenci> dao = new DatabaseBaseService<Ogrenci>();
		DatabaseBaseService<OgrenciGrup> daoGrup = new DatabaseBaseService<OgrenciGrup>();
		DatabaseBaseService<Gelir> daoGelir = new GelirDao();
		DatabaseBaseService<OgrenciOdeme> daoOdeme = new OgrenciOdemeDao();

		Ogrenci ogrenci = new Ogrenci();
		ogrenci.setAd(txtName.getText());
		ogrenci.setSoyad(txtLastName.getText());

		try {
			Ogrenci temp = dao.kullaniciBulDiger(ogrenci);
			if (temp != null) {
				OgrenciOdeme ogrenciOdeme = new OgrenciOdeme();
				ogrenciOdeme.setOgrenci(temp);
				ogrenciOdeme.setOdemeTarihi(new Date());
				OgrenciGrup grup = new OgrenciGrup();
				grup.setOgrenci(temp);
				List<OgrenciGrup> tempGrup = daoGrup.tumKayitlariGetir(grup);
				for (OgrenciGrup i : tempGrup) {
					if (i.getOgrenci() != null) {
						BigDecimal sonuc = new BigDecimal(
								i.getUcret().doubleValue() - Double.valueOf(txtMoney.getText()));
						i.setUcret(sonuc);
						i.setGuncellemeTarihi(new Date());
						i.setEkleyen(CourseUtils.userName);
						daoGrup.guncelle(i);
						if (ogrenciOdeme.getOdemeMiktari() == null)
							ogrenciOdeme.setOdemeMiktari(new BigDecimal(0));
						ogrenciOdeme.setOdemeMiktari(
								new BigDecimal(ogrenciOdeme.getOdemeMiktari().doubleValue() + Double.valueOf(txtMoney.getText())));
						ogrenciOdeme.setEklemeTarihi(new Date());
						ogrenciOdeme.setEkleyen(CourseUtils.userName);
						ogrenciOdeme.setAciklama(textArea.getText());
						daoOdeme.kaydet(ogrenciOdeme);
						Gelir gelir = new Gelir();
						gelir.setOgrenciOdeme(ogrenciOdeme);
						gelir.setTarih(new Date());
						gelir.setEklemeTarihi(new Date());
						gelir.setEkleyen(CourseUtils.userName);
						daoGelir.kaydet(gelir);
						lblMoney.setText(lblMoney.getText() + " " + i.getUcret());
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(OgrenciOdemeUi.this, "Öðrenci Bulunamadý!!!");
			e.printStackTrace();
		}
	}
}
