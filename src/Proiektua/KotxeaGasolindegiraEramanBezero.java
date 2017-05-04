package Proiektua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KotxeaGasolindegiraEramanBezero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KotxeaGasolindegiraEramanBezero frame = new KotxeaGasolindegiraEramanBezero();
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
	public KotxeaGasolindegiraEramanBezero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(242, 62, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSartuKotxearenMatrikula = new JLabel("Sartu kotxearen matrikula:");
		lblSartuKotxearenMatrikula.setBounds(52, 67, 178, 16);
		contentPane.add(lblSartuKotxearenMatrikula);
		
		JLabel lblZenbatKarburanteGehitu = new JLabel("Zenbat karburante gehitu nahi duzu?");
		lblZenbatKarburanteGehitu.setBounds(52, 119, 237, 16);
		contentPane.add(lblZenbatKarburanteGehitu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60"}));
		comboBox.setBounds(301, 115, 71, 27);
		contentPane.add(comboBox);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQL db = MySQL.getMySQL();
				db.bezeroakKotxeaGasolindegiraEraman(kodea, textField.getText(), Integer.parseInt(comboBox.getName()));
			}
		});
		btnGorde.setBounds(255, 201, 117, 29);
		contentPane.add(btnGorde);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BezeroarenAukerak bezeroarenAukerak = new BezeroarenAukerak();
				bezeroarenAukerak.setVisible(true);
			}
		});
		btnAtzera.setBounds(52, 201, 117, 29);
		contentPane.add(btnAtzera);
	}
}
