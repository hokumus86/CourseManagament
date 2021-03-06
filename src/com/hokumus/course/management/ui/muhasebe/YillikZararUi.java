package com.hokumus.course.management.ui.muhasebe;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.hokumus.course.management.dao.muhasebe.GiderDao;
import com.hokumus.course.management.model.muhasebe.Gider;
import com.hokumus.course.management.util.IDatabase;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;

public class YillikZararUi extends JPanel {
	private JLabel lblMoney;
	private JButton btnGetir;

	public YillikZararUi() {
		initialize();
	}

	private void initialize() {
		setBounds(0, 0, 450, 500);
		setLayout(null);

		lblMoney = new JLabel("D\u00F6nem Y�ll�k Zarar : ");
		lblMoney.setBounds(75, 180, 210, 33);
		add(lblMoney);

		btnGetir = new JButton("Sorgula");
		btnGetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YillikZarar_Action_Performed(arg0);
			}
		});
		btnGetir.setBounds(187, 104, 89, 23);
		add(btnGetir);

	}

	protected void YillikZarar_Action_Performed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		IDatabase<Gider> dao = new GiderDao();
		try {
			List<Gider> gider = dao.tumKayitlariGetir(new Gider());
			GregorianCalendar gcalendar = new GregorianCalendar();
			int month = gcalendar.get(Calendar.YEAR);
			Calendar cal = Calendar.getInstance();
			List<Gider> tmp = new ArrayList<Gider>();
			for (Gider liste : gider) {
				cal.setTime(liste.getTarih());
				if (month == cal.get(Calendar.YEAR)) {
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
			JOptionPane.showMessageDialog(YillikZararUi.this, "Veritaban� i�lemlerinde hata olu�tu!!!");
			e.printStackTrace();
		}
	}
}
