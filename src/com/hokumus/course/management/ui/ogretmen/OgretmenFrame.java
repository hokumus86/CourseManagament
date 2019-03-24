package com.hokumus.course.management.ui.ogretmen;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.management.dao.ik.OgretmenDAO;
import com.hokumus.course.management.model.ogrenci.OgrenciGrup;
import com.hokumus.course.management.model.ogretmen.YoklamaBilgileri;
import com.hokumus.course.management.model.yonetim.Grup;
import com.hokumus.course.management.model.yonetim.Kurs;

public class OgretmenFrame extends JFrame {
	private JTable table;
	public String[][] data;
	public String[][] data2;
	public String[] columns = new String[] { "id", "adi", "baslamatarihi", "fiyat" };
	public String[] columns2 = new String[] { "id", "adi", "kurs", "ogretmen", "ogrenciSayisi", "salon", "balamaTarihi",
			"bitisTarihi" };
	private JTable table2;
	public List<Kurs> kurslist;
	private JTable table3;
	private JTable table4;
	private JTextField textGrup;
	private JTextField textKonu;
	private JTextField textAciklama;

	public static List<YoklamaBilgileri> YoklamaBilgileriList;

	public OgretmenFrame() {

		initialize();

	}

	public void initialize() {

		OgretmenDAO ogrtdao = new OgretmenDAO();

		try {
			YoklamaBilgileriList = ogrtdao.tumKayitlariGetir(new YoklamaBilgileri());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		
		Calendar c = Calendar.getInstance();

		getContentPane().setLayout(null);
		setBounds(100, 100, 581, 764);

//
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 25, 545, 65);
		getContentPane().add(scrollPane1);
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 120, 545, 65);
		getContentPane().add(scrollPane2);
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(331, 315, 188, 401);
		getContentPane().add(scrollPane3);
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.setBounds(10, 221, 545, 65);
		getContentPane().add(scrollPane4);
//	
		textGrup = new JTextField();
		textGrup.setBounds(84, 313, 219, 20);
		getContentPane().add(textGrup);
		textGrup.setColumns(10);
		textKonu = new JTextField();
		textKonu.setBounds(84, 359, 219, 20);
		getContentPane().add(textKonu);
		textKonu.setColumns(10);
		textAciklama = new JTextField();
		textAciklama.setBounds(84, 589, 219, 61);
		getContentPane().add(textAciklama);
		textAciklama.setColumns(10);
//

//	
		JPanel panel = new JPanel();
		panel.setBounds(518, 315, 37, 401);
		getContentPane().add(panel);
		JCheckBox checkBox = new JCheckBox("");
		panel.add(checkBox);
		JCheckBox checkBox_1 = new JCheckBox("");
		panel.add(checkBox_1);
		JCheckBox checkBox_2 = new JCheckBox("");
		panel.add(checkBox_2);
		JCheckBox checkBox_3 = new JCheckBox("");
		panel.add(checkBox_3);
		JCheckBox checkBox_4 = new JCheckBox("");
		panel.add(checkBox_4);
		JCheckBox checkBox_5 = new JCheckBox("");
		panel.add(checkBox_5);
		JCheckBox checkBox_6 = new JCheckBox("");
		panel.add(checkBox_6);
		JCheckBox checkBox_7 = new JCheckBox("");
		panel.add(checkBox_7);
		JCheckBox checkBox_8 = new JCheckBox("");
		panel.add(checkBox_8);
		JCheckBox checkBox_9 = new JCheckBox("");
		panel.add(checkBox_9);
		JCheckBox checkBox_10 = new JCheckBox("");
		panel.add(checkBox_10);
		JCheckBox checkBox_11 = new JCheckBox("");
		panel.add(checkBox_11);
		JCheckBox checkBox_12 = new JCheckBox("");
		panel.add(checkBox_12);
		JCheckBox checkBox_13 = new JCheckBox("");
		JCheckBox checkBox_14 = new JCheckBox("");
		panel.add(checkBox_14);
//		

		JLabel lblNewLabel = new JLabel("ogrenci:");
		lblNewLabel.setBounds(331, 297, 46, 14);
		getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("yoklama:");
		lblNewLabel_1.setBounds(504, 297, 51, 14);
		getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("kurslar:");
		lblNewLabel_2.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("gruplar:");
		lblNewLabel_3.setBounds(10, 105, 46, 14);
		getContentPane().add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("yoklamabilgileri:");
		lblNewLabel_4.setBounds(10, 206, 171, 14);
		getContentPane().add(lblNewLabel_4);
		JLabel lblNewLabel_5 = new JLabel("grup:");
		lblNewLabel_5.setBounds(10, 316, 46, 14);
		getContentPane().add(lblNewLabel_5);
		JLabel lblNewLabel_6 = new JLabel("konu:");
		lblNewLabel_6.setBounds(10, 362, 46, 14);
		getContentPane().add(lblNewLabel_6);
		JLabel lblDerstarihi = new JLabel("dersTarihi:");
		lblDerstarihi.setBounds(10, 408, 76, 14);
		getContentPane().add(lblDerstarihi);
		Label label_1 = new Label("aciklama:");
		label_1.setBounds(10, 589, 62, 22);
		getContentPane().add(label_1);
		JLabel lblYoklamatarihi = new JLabel("YoklamaTarihi:");
		lblYoklamatarihi.setBounds(10, 483, 102, 14);
		getContentPane().add(lblYoklamatarihi);
		JLabel lblDersTarih = new JLabel();
		lblDersTarih.setBounds(126, 408, 177, 14);
		getContentPane().add(lblDersTarih);
		lblDersTarih.setText(c.getTime() + "");
		JButton btnDersTarSol = new JButton("<");
		btnDersTarSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				c.add(c.DATE, 1);
				lblDersTarih.setText(c.getTime() + "");
			}
		});
		btnDersTarSol.setBounds(201, 433, 46, 23);
		getContentPane().add(btnDersTarSol);
		JButton btnDersTarSag = new JButton(">");
		btnDersTarSag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.add(c.DATE, -1);
				lblDersTarih.setText(c.getTime() + "");
			}
		});
		btnDersTarSag.setBounds(257, 433, 46, 23);
		getContentPane().add(btnDersTarSag);

		JLabel lblYokTarih = new JLabel();
		lblYokTarih.setBounds(126, 483, 177, 14);
		getContentPane().add(lblYokTarih);
		lblYokTarih.setText(c.getTime() + "");
		JButton btnYokTarSol = new JButton("<");
		btnYokTarSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.add(c.DATE, -1);
				lblYokTarih.setText(c.getTime() + "");
			}
		});
		btnYokTarSol.setBounds(201, 510, 46, 23);
		getContentPane().add(btnYokTarSol);
		JButton btnYokTarSag = new JButton(">");
		btnYokTarSag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.add(c.DATE, 1);
				lblYokTarih.setText(c.getTime() + "");
			}
		});
		btnYokTarSag.setBounds(257, 510, 46, 23);
		getContentPane().add(btnYokTarSag);

		JButton BtnYokGuncelle = new JButton("Guncelle");
		BtnYokGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu().setDersTarihi(c.getTime());
					YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu().setYoklamaTarihi(c.getTime());
					YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu()
							.setYoklamaAciklama(textAciklama.getText());
					YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu()
							.setIslenenKonu(textKonu.getText());

					for (int i = 0; i < YoklamaBilgileriList.get(table4.getSelectedRow()).getGrup()
							.getOgrenciSayisi(); i++) {

						if ((((JCheckBox) (panel.getComponent(i))).isSelected())) {

							YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu()
									.getYoklamalar()[i] = true;
						} else {
							YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu()
									.getYoklamalar()[i] = false;
						}

					}
					ogrtdao.guncelle(YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		BtnYokGuncelle.setBounds(212, 661, 89, 23);
		getContentPane().add(BtnYokGuncelle);

//ogretmen girisi yapilinca acilan kurslar data ile table alinir orn: java kursu c# kursu
		table = new JTable();
		scrollPane1.setViewportView(table);
		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		table3 = new JTable();
		scrollPane3.setViewportView(table3);
		table4 = new JTable();
		scrollPane4.setViewportView(table4);

		JButton BtnYokKaydet = new JButton("YeniKayit");
		BtnYokKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				YoklamaBilgileri yeniyb = new YoklamaBilgileri();
				yeniyb.setYoklamaFormu(YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu());

				try {

					YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu().setDersTarihi(c.getTime());
					YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu().setYoklamaTarihi(c.getTime());
					YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu()
							.setYoklamaAciklama(textAciklama.getText());
					YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu()
							.setIslenenKonu(textKonu.getText());

					for (int i = 0; i < YoklamaBilgileriList.get(table4.getSelectedRow()).getGrup()
							.getOgrenciSayisi(); i++) {

						if ((((JCheckBox) (panel.getComponent(i))).isSelected())) {

							YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu()
									.getYoklamalar()[i] = true;
						} else {
							YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu()
									.getYoklamalar()[i] = false;
						}

					}
					ogrtdao.kaydet(YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu().getYoklamaBilgileri());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		BtnYokKaydet.setBounds(214, 693, 89, 23);
		getContentPane().add(BtnYokKaydet);
		try {
			kurslist = ogrtdao.tumKayitlariGetir(new Kurs());

			if (kurslist.size() > 0) {
				data = new String[kurslist.size()][5];
				for (int i = 0; i < kurslist.size(); i++) {
					data[i][0] = kurslist.get(i).getId() + "";
					data[i][1] = kurslist.get(i).getAdi();
					data[i][2] = kurslist.get(i).getEklemeTarihi() + "";
					data[i][3] = kurslist.get(i).getFiyat() + "";
					data[i][4] = kurslist.get(i).grup.getId() + "";

				}
				DefaultTableModel dtm = new DefaultTableModel(data, columns);
				table.setModel(dtm);
			} else {
				JOptionPane.showMessageDialog(OgretmenFrame.this, "kurs bulunamadi");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
// table e tiklama ile secilen kursa ait gruplar data2 ile table2 ye alinir. orn: java kursunun sabah ve aksam gruplari
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					List<Grup> gruplist = ogrtdao.tumKayitlariGetir(kurslist.get(table.getSelectedRow()).grup);
					if (gruplist.size() > 0) {
						data2 = new String[gruplist.size()][8];
						for (int i = 0; i < gruplist.size(); i++) {
							// JOptionPane.showMessageDialog(OgretmenFrame.this,gruplist.get(i).getId()+"
							// size: "+gruplist.size());
							data2[i][0] = gruplist.get(i).getId() + "";
							data2[i][1] = gruplist.get(i).getAdi();
							data2[i][2] = gruplist.get(i).getKurs().getAdi();
							// data2[i][3]=gruplist.get(i).getOgretmen().getAd();
							data2[i][3] = null;
							data2[i][4] = gruplist.get(i).getOgrenciSayisi() + "";
							// data2[i][5]=gruplist.get(i).getSalon().getAdi()+"";
							data2[i][5] = null;
							data2[i][6] = gruplist.get(i).getBaslamaTarihi() + "";
							data2[i][7] = gruplist.get(i).getBitisTarihi() + "";

						}
						DefaultTableModel dtm2 = new DefaultTableModel(data2, columns2);
						table2.setModel(dtm2);
					} else {
						JOptionPane.showMessageDialog(OgretmenFrame.this, "grup bulunamadi");
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			}
		});

// table2 de secilen bir grubun ogrencileri data3 ile table3 e yoklama bilgileri ise data4 ile table4 e alinir orn: java kursu aksam grubunun ogrencileri ve aksam grubunun cesitli tarihlerdeki yoklamabilgileri
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {

					String[][] data4 = new String[YoklamaBilgileriList.size()][5];
					String[] column4 = new String[] { "id", "derstarihi", "yoklamatarihi", "grup", "kurs" };
					for (int k = 0; k < YoklamaBilgileriList.size(); k++) {

						if (YoklamaBilgileriList.get(k).getGrup().getId() == table2.getModel()
								.getValueAt(table2.getSelectedRow(), 0)) {

							data4[k][0] = YoklamaBilgileriList.get(k).getId() + "";
							data4[k][1] = YoklamaBilgileriList.get(k).getYoklamaFormu().getDersTarihi() + "";
							data4[k][2] = YoklamaBilgileriList.get(k).getYoklamaFormu().getYoklamaTarihi() + "";
							data4[k][3] = YoklamaBilgileriList.get(k).getGrup().getId() + "";
							data4[k][4] = YoklamaBilgileriList.get(k).getKurs().getAdi();
						}

					}
					DefaultTableModel dtm4 = new DefaultTableModel(data4, column4);
					table4.setModel(dtm4);

//					
					List<OgrenciGrup> OgrenciGrupList = ogrtdao.tumKayitlariGetir(new OgrenciGrup());
					for (int i = 0; i < OgrenciGrupList.size(); i++) {

						if (OgrenciGrupList.get(i).getGrup().getId() == table2.getModel()
								.getValueAt(table2.getSelectedRow(), 0)) {

							String[][] data3 = new String[OgrenciGrupList.get(i).getGrup().getOgrenciSayisi()][3];
							String[] column3 = new String[] { "ogrenciId", "ogrenciAdi", "yoklama" };

							for (int j = 0; j < OgrenciGrupList.get(i).getGrup().getOgrenciSayisi(); j++) {

								data3[j][0] = OgrenciGrupList.get(i).getOgrenci().getId() + "";
								data3[j][1] = OgrenciGrupList.get(i).getOgrenci().getAd();

							}
							DefaultTableModel dtm3 = new DefaultTableModel(data3, column3);
							table3.setModel(dtm3);
							break;
						}

					}

//				

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			}
		});

//	table4 den secilen bir yoklamabilgilerine ait yoklamaformunun bilgileri frame aktarýlýr

		table4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					// List<YoklamaBilgileri> YoklamaBilgileriList = ogrtdao.tumKayitlariGetir(new
					// YoklamaBilgileri());
					textGrup.setText(YoklamaBilgileriList.get(table4.getSelectedRow()).getGrup().getAdi());
					textKonu.setText(
							YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu().getIslenenKonu());
					textAciklama.setText(
							YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu().getYoklamaAciklama());
					lblDersTarih.setText(
							YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu().getDersTarihi() + "");
					lblYokTarih.setText(
							YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu().getYoklamaTarihi()
									+ "");

					for (int i = 0; i < YoklamaBilgileriList.get(table4.getSelectedRow()).getGrup()
							.getOgrenciSayisi(); i++) {

						if (YoklamaBilgileriList.get(table4.getSelectedRow()).getYoklamaFormu()
								.getYoklamalar()[i] == true) {
							((JCheckBox) (panel.getComponent(i))).setSelected(true);
						} else {
							((JCheckBox) (panel.getComponent(i))).setSelected(false);
						}

					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}
}
