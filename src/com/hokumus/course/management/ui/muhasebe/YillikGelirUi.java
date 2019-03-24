package com.hokumus.course.management.ui.muhasebe;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.hokumus.course.management.dao.muhasebe.GelirDao;
import com.hokumus.course.management.model.muhasebe.Gelir;
import com.hokumus.course.management.util.IDatabase;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;

public class YillikGelirUi extends JPanel {
	private JLabel lblMoney;
	private JButton btnGetir;

	public YillikGelirUi() {
		initialize();
	}

	private void initialize() {
		setBounds(0, 0, 450, 500);
		setLayout(null);

		lblMoney = new JLabel("D\u00F6nem Yillik Gelir : ");
		lblMoney.setBounds(75, 180, 210, 33);
		add(lblMoney);

		btnGetir = new JButton("Sorgula");
		btnGetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YillikGelir_Action_Performed(arg0);
			}
		});
		btnGetir.setBounds(187, 104, 89, 23);
		add(btnGetir);

	}

	protected void YillikGelir_Action_Performed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		IDatabase<Gelir> dao = new GelirDao();
		try {
			List<Gelir> gelir = dao.kayitAra(new Gelir());
			GregorianCalendar gcalendar = new GregorianCalendar();
			int month = gcalendar.get(Calendar.YEAR);
			Calendar cal = Calendar.getInstance();
			List<Gelir> tmp = new ArrayList<Gelir>();
			for (Gelir liste : gelir) {
				cal.setTime(liste.getTarih());
				if (month == cal.get(Calendar.YEAR)) {
					tmp.add(liste);
				}
			}
			double toplam = 0;
			for (Gelir i : tmp) {
				toplam = i.getMiktar() != null ? toplam += i.getMiktar().doubleValue() : toplam;
				if (i.getOgrenciOdeme() != null)
					toplam = i.getOgrenciOdeme().getOdemeMiktari() != null
							? toplam += i.getOgrenciOdeme().getOdemeMiktari().doubleValue()
							: toplam;
			}
			lblMoney.setText(lblMoney.getText() + " " + toplam);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(YillikGelirUi.this, "Veritabaný iþlemlerinde hata oluþtu!!!");
			e.printStackTrace();
		}
	}

}
