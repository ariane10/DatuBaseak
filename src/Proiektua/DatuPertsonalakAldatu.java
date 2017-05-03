package Proiektua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Proiektua.MySQL;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DatuPertsonalakAldatu extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatuPertsonalakAldatu frame = new DatuPertsonalakAldatu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DatuPertsonalakAldatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 95, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 133, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 171, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(111, 62, 78, 16);
		contentPane.add(lblPasahitza);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(111, 100, 78, 16);
		contentPane.add(lblIzena);
		
		JLabel lblAbizena = new JLabel("Abizena:");
		lblAbizena.setBounds(111, 138, 78, 16);
		contentPane.add(lblAbizena);
		
		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setBounds(111, 176, 78, 16);
		contentPane.add(lblHelbidea);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQL db = new MySQL();
				db.datuPertsonalakAldatu(kodea, passwordField.getText(), textField_3.getText(), textField_1.getText(), textField_2.getText());
			}
		});
		btnGorde.setBounds(222, 221, 95, 29);
		contentPane.add(btnGorde);
		
		JButton btnNewButton = new JButton("Atzera");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BezeroarenAukerak bezeroarenAukerak = new BezeroarenAukerak();
				bezeroarenAukerak.setVisible(true);
			}
		});
		btnNewButton.setBounds(111, 221, 99, 29);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 57, 130, 26);
		contentPane.add(passwordField);
	}

}
