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

public class KotxeBatiBajaEman extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KotxeBatiBajaEman frame = new KotxeBatiBajaEman();
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
	public KotxeBatiBajaEman() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZeinKotxeriEman = new JLabel("Zein kotxeri eman nahi diozu baja?");
		lblZeinKotxeriEman.setBounds(99, 59, 253, 16);
		contentPane.add(lblZeinKotxeriEman);
		
		JLabel lblsartuBereMatrikula = new JLabel("(Sartu bere matrikula zenbakia) ");
		lblsartuBereMatrikula.setBounds(109, 87, 227, 16);
		contentPane.add(lblsartuBereMatrikula);
		
		textField = new JTextField();
		textField.setBounds(141, 115, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQL db = MySQL.getMySQL();
				db.kotxeBatiBajaEman(textField.getText());
			}
		});
		btnGorde.setBounds(247, 212, 117, 29);
		contentPane.add(btnGorde);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AdministratzailearenAukerak administratzailearenAukerak = new AdministratzailearenAukerak();
				administratzailearenAukerak.setVisible(true);
			}
		});
		btnAtzera.setBounds(60, 212, 117, 29);
		contentPane.add(btnAtzera);
	}

}
