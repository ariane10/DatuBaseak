package Proiektua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BezeroBerriaSartu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroBerriaSartu frame = new BezeroBerriaSartu();
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
	public BezeroBerriaSartu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(60, 71, 61, 16);
		contentPane.add(lblIzena);
		
		JLabel lblAbizena = new JLabel("Abizena:");
		lblAbizena.setBounds(60, 113, 61, 16);
		contentPane.add(lblAbizena);
		
		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setBounds(60, 151, 61, 16);
		contentPane.add(lblHelbidea);
		
		textField = new JTextField();
		textField.setBounds(133, 66, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 108, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(133, 146, 241, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQL db = new MySQL();
				db.bezeroBerriaSartu(pasahitza, textField.getText(), textField_1.getText(), textField_2.getText(), kreditua);
			}
		});
		btnGorde.setBounds(257, 210, 117, 29);
		contentPane.add(btnGorde);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministratzailearenAukerak aukerak = new AdministratzailearenAukerak();
				aukerak.setVisible(true);
			}
		});
		btnAtzera.setBounds(60, 210, 117, 29);
		contentPane.add(btnAtzera);
		
		JLabel lblBezeroBerriarenDatuak = new JLabel("Bezero berriaren datuak sartu:");
		lblBezeroBerriarenDatuak.setBounds(60, 24, 314, 16);
		contentPane.add(lblBezeroBerriarenDatuak);
	}

}
