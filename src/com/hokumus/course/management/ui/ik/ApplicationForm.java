package com.hokumus.course.management.ui.ik;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hokumus.course.management.dao.ik.InsanKaynaklariDAO;
import com.hokumus.course.management.model.ik.Basvuru;
import com.hokumus.course.management.model.kullanici.CinsiyetEnum;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class ApplicationForm extends JFrame {

	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtBirthDate;
	private JTextField txtEmail;
	private JTextField txtMobilePhone;
	private JTextField txtBirthPlace;
	private JComboBox cmbSex;
	private JComboBox cmbEducationalStatus;
	private JTextField txtProfession;
	private JTextField txtExperience;
	private JTextField txtReference1;
	private JTextField txtReference2;
	private JTextField txtReference3;
	private JRadioButton rdbtnEvli;
	private JRadioButton rdbtnBekar;
	private JTextArea txtareaAddress;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public ApplicationForm() {
		
		
		initialize();

	}

	private void initialize() {

		setTitle("Ba\u015Fvuru Formu");
		setBounds(100, 100, 503, 552);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblAd = new JLabel("Ad\u0131: ");
		lblAd.setBounds(40, 30, 46, 14);
		getContentPane().add(lblAd);

		JLabel lblSoyad = new JLabel("Soyad\u0131:");
		lblSoyad.setBounds(40, 55, 46, 14);
		getContentPane().add(lblSoyad);

		JLabel lblCinsiyet = new JLabel("Cinsiyet");
		lblCinsiyet.setBounds(40, 80, 46, 14);
		getContentPane().add(lblCinsiyet);

		JLabel lblDoumTarihi = new JLabel("Do\u011Fum Tarihi:");
		lblDoumTarihi.setBounds(40, 105, 85, 14);
		getContentPane().add(lblDoumTarihi);

		JLabel lblDoumYeri = new JLabel("Do\u011Fum Yeri: ");
		lblDoumYeri.setBounds(40, 130, 85, 14);
		getContentPane().add(lblDoumYeri);

		JLabel lblCepTel = new JLabel("Cep Tel:");
		lblCepTel.setBounds(40, 155, 46, 14);
		getContentPane().add(lblCepTel);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(40, 180, 46, 14);
		getContentPane().add(lblEmail);

		JLabel lblMedeniDurum = new JLabel("Medeni Durum:");
		lblMedeniDurum.setBounds(40, 205, 85, 14);
		getContentPane().add(lblMedeniDurum);

		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(40, 229, 46, 14);
		getContentPane().add(lblAdres);

		JLabel lblEitimDzeyi = new JLabel("E\u011Fitim D\u00FCzeyi:");
		lblEitimDzeyi.setBounds(40, 284, 85, 14);
		getContentPane().add(lblEitimDzeyi);

		JLabel lblUzmanlkAlan = new JLabel("Uzmanl\u0131k Alan\u0131:");
		lblUzmanlkAlan.setBounds(40, 309, 85, 14);
		getContentPane().add(lblUzmanlkAlan);

		JLabel lblTecrbeYl = new JLabel("Tecr\u00FCbe Y\u0131l\u0131:");
		lblTecrbeYl.setBounds(40, 334, 85, 14);
		getContentPane().add(lblTecrbeYl);

		JLabel lblReferans = new JLabel("Referans 1:");
		lblReferans.setBounds(40, 359, 85, 14);
		getContentPane().add(lblReferans);

		JLabel lblReferans_1 = new JLabel("Referans 2:");
		lblReferans_1.setBounds(40, 384, 85, 14);
		getContentPane().add(lblReferans_1);

		JLabel lblReferans_2 = new JLabel("Referans 3:");
		lblReferans_2.setBounds(40, 409, 85, 14);
		getContentPane().add(lblReferans_2);

		txtName = new JTextField();
		txtName.setBounds(135, 27, 200, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(135, 52, 200, 20);
		getContentPane().add(txtSurname);

		txtBirthDate = new JTextField();
		txtBirthDate.setColumns(10);
		txtBirthDate.setBounds(135, 104, 200, 20);
		getContentPane().add(txtBirthDate);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(135, 181, 200, 20);
		getContentPane().add(txtEmail);

		txtMobilePhone = new JTextField();
		txtMobilePhone.setColumns(10);
		txtMobilePhone.setBounds(135, 155, 200, 20);
		getContentPane().add(txtMobilePhone);

		txtBirthPlace = new JTextField();
		txtBirthPlace.setColumns(10);
		txtBirthPlace.setBounds(135, 129, 200, 20);
		getContentPane().add(txtBirthPlace);

		DefaultComboBoxModel model = new DefaultComboBoxModel(CinsiyetEnum.values());
		cmbSex = new JComboBox<>(model);
		cmbSex.setBounds(135, 77, 200, 20);
		getContentPane().add(cmbSex);

		rdbtnEvli = new JRadioButton("Evli");
		rdbtnEvli.setSelected(true);
		buttonGroup.add(rdbtnEvli);
		rdbtnEvli.setBounds(133, 204, 62, 23);
		getContentPane().add(rdbtnEvli);

		rdbtnBekar = new JRadioButton("Bekar");
		buttonGroup.add(rdbtnBekar);
		rdbtnBekar.setBounds(197, 204, 85, 23);
		getContentPane().add(rdbtnBekar);

		 txtareaAddress = new JTextArea();
		txtareaAddress.setBounds(135, 229, 200, 39);
		getContentPane().add(txtareaAddress);

		DefaultComboBoxModel model1 = new DefaultComboBoxModel(EgitimDuzeyiEnum.values());
		cmbEducationalStatus = new JComboBox<>(model1);
		cmbEducationalStatus.setBounds(136, 281, 199, 20);
		getContentPane().add(cmbEducationalStatus);

		txtProfession = new JTextField();
		txtProfession.setBounds(135, 306, 200, 20);
		getContentPane().add(txtProfession);
		txtProfession.setColumns(10);

		txtExperience = new JTextField();
		txtExperience.setBounds(135, 331, 200, 20);
		getContentPane().add(txtExperience);
		txtExperience.setColumns(10);

		txtReference1 = new JTextField();
		txtReference1.setBounds(135, 356, 200, 20);
		getContentPane().add(txtReference1);
		txtReference1.setColumns(10);

		txtReference2 = new JTextField();
		txtReference2.setBounds(135, 381, 200, 20);
		getContentPane().add(txtReference2);
		txtReference2.setColumns(10);

		txtReference3 = new JTextField();
		txtReference3.setBounds(135, 406, 200, 20);
		getContentPane().add(txtReference3);
		txtReference3.setColumns(10);

		JButton btnSave = new JButton("Kaydet");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApplicationAdd_Action_Performed(e);
			}
		});
		btnSave.setBounds(193, 453, 89, 23);
		getContentPane().add(btnSave);
		
		
		JLabel lblDdmmyyyy = new JLabel("dd/mm/yyyy");
		lblDdmmyyyy.setBounds(350, 105, 75, 14);
		getContentPane().add(lblDdmmyyyy);

	}

	protected void btnApplicationAdd_Action_Performed(ActionEvent e) {
		
		InsanKaynaklariDAO dao = new InsanKaynaklariDAO();
		Basvuru usr = new Basvuru();
		usr.setName(txtName.getText());
		usr.setSurname(txtSurname.getText());
		usr.setCinsiyet((CinsiyetEnum) cmbSex.getSelectedItem());
		
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/mm/yyyy");
		Date invoiceDate = null;
		try {
			invoiceDate = formatDate.parse(txtBirthDate.getText());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
		usr.setDogumTarihi(invoiceDate);
		
		usr.setDogumYeri(txtBirthPlace.getText());
		usr.setCeptel(Integer.parseInt(txtMobilePhone.getText()));
		usr.setEmail(txtEmail.getText());
		usr.setMedeniDurum(rdbtnMedeniDurum_Action_Performed(buttonGroup));
		usr.setAdres(txtareaAddress.getText());
		usr.setEgitimDuzeyi((EgitimDuzeyiEnum) cmbEducationalStatus.getSelectedItem());
		usr.setUzmanlikAlani(txtProfession.getText());
		usr.setTecrubeYili(Integer.parseInt(txtExperience.getText()));
		usr.setReferans1(txtReference1.getText());
		usr.setReferans2(txtReference2.getText());
		usr.setReferans3(txtReference3.getText());
		
		try {
			dao.kaydet(usr);
			JOptionPane.showMessageDialog(ApplicationForm.this, "Kayýt Baþarýlý...");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(ApplicationForm.this, "Kayýt Baþarýsýz oldu...!!!");
			e1.printStackTrace();
		}
		
	}

	protected String  rdbtnMedeniDurum_Action_Performed(ButtonGroup buttonGroup2) {
		// TODO Auto-generated method stub
		
		Enumeration<AbstractButton> bg =  buttonGroup.getElements();
		while (bg.hasMoreElements()) {
			JRadioButton jrd = (JRadioButton) bg.nextElement();
			if (jrd.isSelected()) {
				return jrd.getText();
			}
			
		}
		return null;

	}

}
