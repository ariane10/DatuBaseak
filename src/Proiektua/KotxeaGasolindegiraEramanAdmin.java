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

public class KotxeaGasolindegiraEramanAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KotxeaGasolindegiraEramanAdmin frame = new KotxeaGasolindegiraEramanAdmin();
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
	public KotxeaGasolindegiraEramanAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZeinKotxeEraman = new JLabel("Zein kotxe eraman nahi duzu gasolindegira?");
		lblZeinKotxeEraman.setBounds(83, 55, 289, 16);
		contentPane.add(lblZeinKotxeEraman);
		
		JLabel lblsartuKotxearenMatrikula = new JLabel("(Sartu kotxearen matrikula)");
		lblsartuKotxearenMatrikula.setBounds(136, 83, 177, 16);
		contentPane.add(lblsartuKotxearenMatrikula);
		
		textField = new JTextField();
		textField.setBounds(156, 111, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGasolindegira = new JButton("Gorde");
		btnGasolindegira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQL db = MySQL.getMySQL();
				db.kotxeaGasolindegiraEraman(textField.getText());
			}
		});
		btnGasolindegira.setBounds(255, 190, 117, 29);
		contentPane.add(btnGasolindegira);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministratzailearenAukerak administratzailearenAukerak = new AdministratzailearenAukerak();
				administratzailearenAukerak.setVisible(true);
			}
		});
		btnAtzera.setBounds(83, 190, 117, 29);
		contentPane.add(btnAtzera);
	}
}
