package com.hokumus.course.management.ui.muhasebe;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hokumus.course.management.dao.muhasebe.GiderDao;
import com.hokumus.course.management.model.muhasebe.DigerGiderler;
import com.hokumus.course.management.model.muhasebe.Gider;
import com.hokumus.course.management.util.CourseUtils;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.awt.event.ActionEvent;

public class VergiOdemeUi extends JPanel{
	private JLabel lblFat;
	private JButton btnAdd;
	private JTextField txtMoney;

	public VergiOdemeUi() {
		initialize();
	}

	private void initialize() {
		setBounds(0, 0, 450, 500);
		setLayout(null);

		lblFat = new JLabel("Vergi Miktarý : ");
		lblFat.setBounds(65, 123, 102, 23);
		add(lblFat);

		btnAdd = new JButton("Ekle");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VergiOdeme_Action_Performed(arg0);
			}
		});
		btnAdd.setBounds(155, 187, 89, 23);
		add(btnAdd);
		
		txtMoney = new JTextField();
		txtMoney.setBounds(185, 124, 125, 20);
		add(txtMoney);
		txtMoney.setColumns(10);

	}

	protected void VergiOdeme_Action_Performed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		GiderDao dao = new GiderDao();
		Gider gider = new Gider();
		DigerGiderler dGider = new DigerGiderler();
		dGider.setVergiOdeme(new BigDecimal(txtMoney.getText()));
		gider.setDigerGiderler(dGider);
		gider.setTarih(new Date());
		gider.setEklemeTarihi(new Date());
		gider.setEkleyen(CourseUtils.userName);
		try {
			dao.kaydet(gider);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(VergiOdemeUi.this, "Ýþlem Baþarýsýz Oldu");
		}
	}
}
