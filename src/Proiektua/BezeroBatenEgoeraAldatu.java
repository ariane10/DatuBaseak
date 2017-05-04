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

public class BezeroBatenEgoeraAldatu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroBatenEgoeraAldatu frame = new BezeroBatenEgoeraAldatu();
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
	public BezeroBatenEgoeraAldatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZeinBezerorenEgoera = new JLabel("Zein bezeroren egoera altu nahi duzu?");
		lblZeinBezerorenEgoera.setBounds(102, 64, 251, 16);
		contentPane.add(lblZeinBezerorenEgoera);
		
		textField = new JTextField();
		textField.setBounds(166, 125, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblsartuBezeroHorren = new JLabel("(Sartu bezero horren kodea)");
		lblsartuBezeroHorren.setBounds(134, 97, 184, 16);
		contentPane.add(lblsartuBezeroHorren);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQL db = new MySQL();
				db.BezeroBatenEgoeraAldatu(Integer.parseInt(textField.getText()));
			}
		});
		btnGorde.setBounds(253, 204, 117, 29);
		contentPane.add(btnGorde);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministratzailearenAukerak aukerak = new AdministratzailearenAukerak();
				aukerak.setVisible(true);
			}
		});
		btnAtzera.setBounds(68, 204, 117, 29);
		contentPane.add(btnAtzera);
	}

}
