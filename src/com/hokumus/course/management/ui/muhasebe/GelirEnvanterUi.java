package com.hokumus.course.management.ui.muhasebe;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GelirEnvanterUi extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	
	public GelirEnvanterUi() {
		initialize();
	}

	private void initialize() {
		setBounds(0, 0, 450, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(63, 66, 75, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(179, 63, 156, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("New label");
		label.setBounds(63, 116, 75, 14);
		add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(179, 113, 156, 20);
		add(textField_1);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(63, 168, 75, 14);
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(179, 165, 156, 20);
		add(textField_2);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(63, 223, 75, 14);
		add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(179, 220, 156, 20);
		add(textField_3);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(63, 272, 75, 14);
		add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(179, 269, 156, 20);
		add(textField_4);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(63, 325, 75, 14);
		add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(179, 322, 156, 20);
		add(textField_5);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(63, 374, 75, 14);
		add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(179, 371, 156, 20);
		add(textField_6);
		
		
		
		
	}
}
