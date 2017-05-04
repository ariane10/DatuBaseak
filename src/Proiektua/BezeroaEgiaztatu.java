package Proiektua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class BezeroaEgiaztatu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroaEgiaztatu frame = new BezeroaEgiaztatu();
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
	public BezeroaEgiaztatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(90, 124, 76, 16);
		contentPane.add(lblPasahitza);
		
		JLabel lblKodea = new JLabel("Kodea:");
		lblKodea.setBounds(90, 81, 61, 16);
		contentPane.add(lblKodea);
		
		textField = new JTextField();
		textField.setBounds(197, 76, 139, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAtera = new JButton("Atera");
		btnAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnAtera.setBounds(90, 203, 117, 29);
		contentPane.add(btnAtera);
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//TODO
				//if bezeroa Datu basean badago 
				BezeroarenAukerak bezeroarenAukerak = new BezeroarenAukerak();
				bezeroarenAukerak.setVisible(true);
				//else
				//JOptionPane.showMessageDialog(null, "Kodea edo pasahitza okerrak");
			}
		});
		btnSartu.setBounds(219, 203, 117, 29);
		contentPane.add(btnSartu);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 119, 139, 21);
		contentPane.add(passwordField);
	}
}
