package com.hokumus.course.management.ui.ik;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.hokumus.course.management.dao.ik.InsanKaynaklariDAO;
import com.hokumus.course.management.model.ik.Basvuru;
import com.hokumus.course.management.model.kullanici.CinsiyetEnum;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;
import javax.swing.JLabel;


public class ApplicationsList extends JFrame {
	private JTable table;
	private JScrollPane scrollPane;
	private Panel panel;
	private JLabel lblDoumYeri;
	private JTextField txtDogumYeri;
	private JTextField txtCepTel;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblMedeniDurum;
	private JTextField txtMedeniDurum;

	public ApplicationsList() throws Exception {

		initialize();
	}

	private void initialize() throws Exception {
		setTitle("Baþvurular");
		setBounds(100, 100, 1029, 485);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 573, 369);
		getContentPane().add(scrollPane);
		
		
		InsanKaynaklariDAO dao = new InsanKaynaklariDAO();
		String[][] data = null;
		String[] columnNames= {"id","Adý","Soyadý", "Cinsiyet", "Doðum Tarihi","Uzmanlýk Alaný"};
		try {
			List<Basvuru> liste = dao.kayitAra(new Basvuru());
			data = new String[liste.size()][6];
			for (int i = 0; i < liste.size(); i++) {
				data[i][0]= ""+ liste.get(i).getId();
				data[i][1]= liste.get(i).getName();
				data[i][2]= liste.get(i).getSurname();
				data[i][3]= String.valueOf(liste.get(i).getCinsiyet());
				data[i][4]= String.valueOf(liste.get(i).getDogumTarihi());
				data[i][5]= liste.get(i).getUzmanlikAlani();
				
				
				/*
				data[i][5]= liste.get(i).getDogumYeri();
				data[i][6]= String.valueOf(liste.get(i).getCeptel());
				data[i][7]= liste.get(i).getEmail();
				data[i][8]= liste.get(i).getMedeniDurum();
				data[i][9]= liste.get(i).getAdres();
				data[i][10]= String.valueOf(liste.get(i).getEgitimDuzeyi());
				
				data[i][12]= String.valueOf(liste.get(i).getTecrubeYili());
				data[i][13]= liste.get(i).getReferans1();
				data[i][14]= liste.get(i).getReferans2();
				data[i][15]= liste.get(i).getReferans3();*/
				
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(data,columnNames);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					tableRowIndex_Mouse_clicked(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		 panel = new Panel();
		panel.setBounds(606, 41, 397, 369);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblDoumYeri = new JLabel("Do\u011Fum Yeri: ");
		lblDoumYeri.setBounds(10, 11, 104, 14);
		panel.add(lblDoumYeri);
		
		txtDogumYeri = new JTextField();
		txtDogumYeri.setBounds(143, 8, 210, 20);
		panel.add(txtDogumYeri);
		txtDogumYeri.setColumns(10);
		
		JLabel lblCepTel = new JLabel("Cep tel:");
		lblCepTel.setBounds(10, 47, 85, 14);
		panel.add(lblCepTel);
		
		txtCepTel = new JTextField();
		txtCepTel.setBounds(143, 44, 210, 20);
		panel.add(txtCepTel);
		txtCepTel.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 83, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(143, 75, 210, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblMedeniDurum = new JLabel("Medeni Durum:");
		lblMedeniDurum.setBounds(10, 120, 85, 14);
		panel.add(lblMedeniDurum);
		
		txtMedeniDurum = new JTextField();
		txtMedeniDurum.setBounds(143, 117, 210, 20);
		panel.add(txtMedeniDurum);
		txtMedeniDurum.setColumns(10);
		panel.setVisible(false);
		
		
		
	}

	protected void tableRowIndex_Mouse_clicked(MouseEvent e) throws Exception {
		
		//txtDogumYeri.setText("");
		
		panel.setVisible(true); 
		
		InsanKaynaklariDAO dao = new InsanKaynaklariDAO();
		String[][] data = null;
		try {
			List<Basvuru> liste = dao.kayitAra(new Basvuru());
			for (int i = 0; i < liste.size(); i++) {
				
				txtDogumYeri.setText(liste.get(i).getDogumYeri() );
				txtCepTel.setText(""+liste.get(i).getCeptel());
				txtEmail.setText(liste.get(i).getEmail());
				txtMedeniDurum.setText(liste.get(i).getMedeniDurum());
				
				
				/*
				data[i][9]= liste.get(i).getAdres();
				data[i][10]= String.valueOf(liste.get(i).getEgitimDuzeyi());
				
				data[i][12]= String.valueOf(liste.get(i).getTecrubeYili());
				data[i][13]= liste.get(i).getReferans1();
				data[i][14]= liste.get(i).getReferans2();
				data[i][15]= liste.get(i).getReferans3();*/
				
				

			}
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		
		
	}
}
