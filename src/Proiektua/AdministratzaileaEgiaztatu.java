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

public class AdministratzaileaEgiaztatu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratzaileaEgiaztatu frame = new AdministratzaileaEgiaztatu();
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
	public AdministratzaileaEgiaztatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministratzailearenPasahitzaSartu = new JLabel("Administratzailearen pasahitza sartu:");
		lblAdministratzailearenPasahitzaSartu.setBounds(105, 74, 261, 16);
		contentPane.add(lblAdministratzailearenPasahitzaSartu);
		
		textField = new JTextField();
		textField.setBounds(169, 110, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministratzailearenAukerak administratzailearenAukerak = new AdministratzailearenAukerak();
				administratzailearenAukerak.setVisible(true);
			}
		});
		btnSartu.setBounds(249, 195, 117, 29);
		contentPane.add(btnSartu);
		
		JButton btnAtera = new JButton("Atera");
		btnAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnAtera.setBounds(93, 195, 117, 29);
		contentPane.add(btnAtera);
	}

}
