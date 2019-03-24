package com.hokumus.course.management.ui.muhasebe;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hokumus.course.management.model.ogrenci.Ogrenci;
import com.hokumus.course.management.model.ogrenci.OgrenciGrup;
import com.hokumus.course.management.util.DatabaseBaseService;
import com.hokumus.course.management.util.IDatabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class BorcSorgulamaUi extends JPanel {
	private JTextField txtName;
	private JTextField txtLastName;

	private JLabel label;
	private JLabel label_1;
	private JLabel lblMoney;

	private JButton btnSorgula;

	public BorcSorgulamaUi() {
		initialize();
	}

	private void initialize() {
		setBounds(0, 0, 450, 500);
		setLayout(null);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(141, 54, 155, 20);
		add(txtName);

		label = new JLabel("Ad\u0131 : ");
		label.setBounds(69, 57, 51, 14);
		add(label);

		label_1 = new JLabel("Soyad\u0131 : ");
		label_1.setBounds(69, 120, 57, 14);
		add(label_1);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(141, 117, 155, 20);
		add(txtLastName);

		btnSorgula = new JButton("Sorgula");
		btnSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BorcSorgulama_Arction_Performed(arg0);
			}
		});
		btnSorgula.setBounds(141, 209, 89, 23);
		add(btnSorgula);

		lblMoney = new JLabel("Bor\u00E7 : ");
		lblMoney.setBounds(69, 304, 241, 39);
		add(lblMoney);

	}

	protected void BorcSorgulama_Arction_Performed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DatabaseBaseService<Ogrenci> dao = new DatabaseBaseService<Ogrenci>();
		DatabaseBaseService<OgrenciGrup> daoGrup = new DatabaseBaseService<OgrenciGrup>();
		Ogrenci ogrenci = new Ogrenci();
		ogrenci.setAd(txtName.getText());
		ogrenci.setSoyad(txtLastName.getText());
		try {
			Ogrenci temp = dao.kullaniciBulDiger(ogrenci);
			if (temp != null) {
				OgrenciGrup grup = new OgrenciGrup();
				grup.setOgrenci(temp);
				List<OgrenciGrup> tempGrup = daoGrup.tumKayitlariGetir(grup);
				for (OgrenciGrup i : tempGrup) {
					if (i.getOgrenci() != null) {
						if (i.getOgrenci().getAd().equals(ogrenci.getAd()) && 
								i.getOgrenci().getSoyad().equals(ogrenci.getSoyad())) {
							lblMoney.setText(lblMoney.getText() + " " + i.getUcret());
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(BorcSorgulamaUi.this, "Öðrenci Bulunamadý!!!");
			e.printStackTrace();
		}
	}

}
