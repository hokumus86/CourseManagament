package com.hokumus.course.management.ui.muhasebe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.hokumus.course.management.dao.muhasebe.GiderDao;
import com.hokumus.course.management.model.muhasebe.Gider;
import com.hokumus.course.management.util.IDatabase;

public class AylikGiderUi extends JPanel {
	private JLabel lblMoney;
	private JButton btnGetir;

	public AylikGiderUi() {
		initialize();
	}

	private void initialize() {
		setBounds(0, 0, 450, 500);
		setLayout(null);

		lblMoney = new JLabel("D\u00F6nem Aylik Gider : ");
		lblMoney.setBounds(75, 180, 210, 33);
		add(lblMoney);

		btnGetir = new JButton("Sorgula");
		btnGetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AylikGiderSorgulama_Action_Performed(arg0);
			}
		});
		btnGetir.setBounds(187, 104, 89, 23);
		add(btnGetir);

	}

	public void AylikGiderSorgulama_Action_Performed(ActionEvent arg0) {
		IDatabase<Gider> dao = new GiderDao();
		try {
			List<Gider> gider = dao.tumKayitlariGetir(new Gider());
			GregorianCalendar gcalendar = new GregorianCalendar();
			int month = gcalendar.get(Calendar.MONTH);
			Calendar cal = Calendar.getInstance();
			List<Gider> tmp = new ArrayList<Gider>();
			for (Gider liste : gider) {
				cal.setTime(liste.getTarih());
				if (month ==  cal.get(Calendar.MONTH)) {
					tmp.add(liste);
				}
			}
			double toplam = 0;
			for (Gider i : tmp) {
				if (i.getDigerGiderler() != null) {
					toplam = i.getDigerGiderler().getDogalGazFatura() != null
							? toplam += i.getDigerGiderler().getDogalGazFatura().doubleValue()
							: toplam;
					toplam = i.getDigerGiderler().getElektrikFatura() != null
							? toplam += i.getDigerGiderler().getElektrikFatura().doubleValue()
							: toplam;
					toplam = i.getDigerGiderler().getInternetFatura() != null
							? toplam += i.getDigerGiderler().getInternetFatura().doubleValue()
							: toplam;
					toplam = i.getDigerGiderler().getSuFatura() != null
							? toplam += i.getDigerGiderler().getSuFatura().doubleValue()
							: toplam;
					toplam = i.getDigerGiderler().getVergiOdeme() != null
							? toplam += i.getDigerGiderler().getVergiOdeme().doubleValue()
							: toplam;
					toplam = i.getMiktar() != null ? toplam += i.getMiktar().doubleValue() : toplam;
				}
				if (i.getOgretmen() != null)
					toplam = i.getOgretmen().getUcret() != null ? toplam += i.getOgretmen().getUcret().doubleValue()
							: toplam;
				if (i.getPersonel() != null)
					toplam = i.getPersonel().getUcret() != null ? toplam += i.getPersonel().getUcret().doubleValue()
							: toplam;
			}

			lblMoney.setText(lblMoney.getText() + " " + toplam);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(AylikGiderUi.this, "Veritabaný iþlemlerinde hata oluþtu!!!");
			e.printStackTrace();
		}
	}
}
