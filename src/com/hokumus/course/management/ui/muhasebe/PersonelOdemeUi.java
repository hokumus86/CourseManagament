package com.hokumus.course.management.ui.muhasebe;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hokumus.course.management.dao.muhasebe.GiderDao;
import com.hokumus.course.management.model.ik.Ogretmen;
import com.hokumus.course.management.model.ik.Personel;
import com.hokumus.course.management.model.muhasebe.Gider;
import com.hokumus.course.management.util.CourseUtils;
import com.hokumus.course.management.util.DatabaseBaseService;
import com.hokumus.course.management.util.IDatabase;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PersonelOdemeUi extends JPanel{
	
	private JTextField rxrName;
	private JTextField txtLastName;

	private JLabel label;
	private JLabel label_1;

	private JButton btnPay;
	private JButton btnCancel;
	
	public PersonelOdemeUi() {
		initialize();
	}
	
	private void initialize() {
		setBounds(0, 0, 450, 500);
		setLayout(null);

		label = new JLabel("Ad\u0131 : ");
		label.setBounds(83, 80, 51, 14);
		add(label);

		rxrName = new JTextField();
		rxrName.setColumns(10);
		rxrName.setBounds(155, 77, 155, 20);
		add(rxrName);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(155, 140, 155, 20);
		add(txtLastName);

		label_1 = new JLabel("Soyad\u0131 : ");
		label_1.setBounds(83, 143, 57, 14);
		add(label_1);

		btnPay = new JButton("\u00D6deme Yap");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonelOdeme_Action_Performed(arg0);
			}
		});
		btnPay.setBounds(83, 236, 119, 23);
		add(btnPay);

		btnCancel = new JButton("Iptal");
		btnCancel.setBounds(218, 236, 119, 23);
		add(btnCancel);
	}

	protected void PersonelOdeme_Action_Performed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Personel temp = new Personel();
		DatabaseBaseService<Personel> daoOgretmen = new DatabaseBaseService<Personel>();
		DatabaseBaseService<Gider> daoGider = new GiderDao();
		temp.setAd(rxrName.getText());
		temp.setSoyad(txtLastName.getText());
		try {
			Personel personel = daoOgretmen.kullaniciBulDiger(temp);
			if(personel != null) {
				Gider gider = new Gider();
				gider.setPersonel(personel);
				gider.setTarih(new Date());
				gider.setEklemeTarihi(new Date());
				gider.setEkleyen(CourseUtils.userName);
				daoGider.kaydet(gider);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(PersonelOdemeUi.this, "Persoel Bulunamadý");
		}
	}
}
