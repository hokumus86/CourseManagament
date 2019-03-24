package com.hokumus.course.management.ui.ik;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hokumus.course.management.dao.ik.PersonelDAO;
import com.hokumus.course.management.model.ik.Personel;
import com.hokumus.course.management.ui.kullanici.UserAdd;


public class PersonelAdd extends JFrame {
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtEmail;
	private JTextField txtMobilePhone;
	private JTextArea txtareaAddress;
	private JTextField txtSalary;
	private JTextField txtStartDate;

	public PersonelAdd() {
		initialize();
	}

	private void initialize() {

		setTitle("Personel Ekleme");
		setBounds(100, 100, 503, 395);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblAd = new JLabel("Ad\u0131: ");
		lblAd.setBounds(40, 30, 46, 14);
		getContentPane().add(lblAd);

		JLabel lblSoyad = new JLabel("Soyad\u0131:");
		lblSoyad.setBounds(40, 55, 46, 14);
		getContentPane().add(lblSoyad);

		JLabel lblCepTel = new JLabel("Cep Tel:");
		lblCepTel.setBounds(40, 155, 46, 14);
		getContentPane().add(lblCepTel);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(40, 180, 46, 14);
		getContentPane().add(lblEmail);

		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(40, 93, 46, 14);
		getContentPane().add(lblAdres);

		txtName = new JTextField();
		txtName.setBounds(135, 27, 200, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(135, 52, 200, 20);
		getContentPane().add(txtSurname);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(135, 181, 200, 20);
		getContentPane().add(txtEmail);

		txtMobilePhone = new JTextField();
		txtMobilePhone.setColumns(10);
		txtMobilePhone.setBounds(135, 155, 200, 20);
		getContentPane().add(txtMobilePhone);


		txtareaAddress = new JTextArea();
		txtareaAddress.setBounds(135, 93, 200, 39);
		getContentPane().add(txtareaAddress);


		JButton btnSave = new JButton("Kaydet");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApplicationAdd_Action_Performed(e);
			}
		});
		btnSave.setBounds(246, 302, 89, 23);
		getContentPane().add(btnSave);
		
		JLabel lblcreti = new JLabel("\u00DCcreti: ");
		lblcreti.setBounds(40, 216, 46, 14);
		getContentPane().add(lblcreti);
		
		txtSalary = new JTextField();
		txtSalary.setBounds(135, 212, 200, 20);
		getContentPane().add(txtSalary);
		txtSalary.setColumns(10);
		
		JLabel lblBalamaTarihi = new JLabel("Ba\u015Flama Tarihi:");
		lblBalamaTarihi.setBounds(40, 250, 89, 14);
		getContentPane().add(lblBalamaTarihi);
		
		txtStartDate = new JTextField();
		txtStartDate.setBounds(135, 247, 200, 20);
		getContentPane().add(txtStartDate);
		txtStartDate.setColumns(10);
		
		JLabel lblDdmmyyyy = new JLabel("dd/mm/yyyy");
		lblDdmmyyyy.setBounds(40, 275, 70, 14);
		getContentPane().add(lblDdmmyyyy);
		
		JButton btnExit = new JButton("Kapat");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExit_Action_Performed(e);
			}
		});
		btnExit.setBounds(74, 302, 89, 23);
		getContentPane().add(btnExit);

	}

	protected void btnExit_Action_Performed(ActionEvent e) {
		// TODO Auto-generated method stub
		PersonelAdd.this.dispose();
		
	}

	protected void btnApplicationAdd_Action_Performed(ActionEvent e) {

		PersonelDAO dao = new PersonelDAO();
		Personel usr = new Personel();
		usr.setAd(txtName.getText());
		usr.setSoyad(txtSurname.getText());
		usr.setTel(txtMobilePhone.getText());
		usr.setMail(txtEmail.getText());
		usr.setAdres(txtareaAddress.getText());
		usr.setUcret(new BigDecimal(txtSalary.getText()));

        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        try {
			usr.setBaslamaTarihi(df.parse(txtStartDate.getText()));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

		try {
			dao.kaydet(usr);
			JOptionPane.showMessageDialog(PersonelAdd.this, "Kayýt Baþarýlý...");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(PersonelAdd.this, "Kayýt Baþarýsýz oldu...!!!");
			e1.printStackTrace();
		}

	}
}
