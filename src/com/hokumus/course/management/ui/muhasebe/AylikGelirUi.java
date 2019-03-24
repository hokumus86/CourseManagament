package com.hokumus.course.management.ui.muhasebe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.hokumus.course.management.dao.muhasebe.GelirDao;
import com.hokumus.course.management.model.muhasebe.Gelir;
import com.hokumus.course.management.util.IDatabase;

public class AylikGelirUi extends JPanel {
	private JLabel lblMoney;
	private JButton btnGetir;

	public AylikGelirUi() {
		initialize();
	}

	private void initialize() {
		setBounds(0, 0, 450, 500);
		setLayout(null);

		lblMoney = new JLabel("D\u00F6nem Aylik Gelir : ");
		lblMoney.setBounds(75, 180, 210, 33);
		add(lblMoney);

		btnGetir = new JButton("Sorgula");
		btnGetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AylikGelirSorgulama_Action_Performed(arg0);
			}
		});
		btnGetir.setBounds(187, 104, 89, 23);
		add(btnGetir);

	}

	public void AylikGelirSorgulama_Action_Performed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		IDatabase<Gelir> dao = new GelirDao();
		try {
			List<Gelir> gelir = dao.kayitAra(new Gelir());
			GregorianCalendar gcalendar = new GregorianCalendar();
			int month = gcalendar.get(Calendar.MONTH);
			Calendar cal = Calendar.getInstance();
			List<Gelir> tmp =new ArrayList<Gelir>();
			for(Gelir liste : gelir) {
				cal.setTime(liste.getTarih());
				if(month == cal.get(Calendar.MONTH)) {
					tmp.add(liste);
				}
			}
			double toplam = 0;
			for(Gelir i : tmp) {
				toplam = i.getMiktar() != null ? toplam += i.getMiktar().doubleValue() : toplam;
				if (i.getOgrenciOdeme() != null)
					toplam = i.getOgrenciOdeme().getOdemeMiktari() != null
							? toplam += i.getOgrenciOdeme().getOdemeMiktari().doubleValue()
							: toplam;
			}
			lblMoney.setText(lblMoney.getText() + " " + toplam);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(AylikGelirUi.this, "Veritabaný iþlemlerinde hata oluþtu!!!");
			e.printStackTrace();
		}
	}
	
}
