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

public class KotxebatAlokatu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KotxebatAlokatu frame = new KotxebatAlokatu();
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
	public KotxebatAlokatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZeinDaAlokatu = new JLabel("Zein da alokatu nahi duzun kotxearen matrikula?");
		lblZeinDaAlokatu.setBounds(56, 59, 328, 16);
		contentPane.add(lblZeinDaAlokatu);
		
		textField = new JTextField();
		textField.setBounds(152, 87, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblZenbatEgunetarakoAlkulatu = new JLabel("Zenbat egunetarako alokatu nahi duzu kotxea?");
		lblZenbatEgunetarakoAlkulatu.setBounds(56, 134, 328, 16);
		contentPane.add(lblZenbatEgunetarakoAlkulatu);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 162, 65, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAlokatu = new JButton("Alokatu");
		btnAlokatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQL db = new MySQL();
				db.kotxeBatAlokatu(textField.getText(), kodea, Integer.parseInt(textField_1.getText()));
			}
		});
		btnAlokatu.setBounds(267, 218, 117, 29);
		contentPane.add(btnAlokatu);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BezeroarenAukerak aukerak = new BezeroarenAukerak();
				aukerak.setVisible(true);
			}
		});
		btnAtzera.setBounds(56, 218, 117, 29);
		contentPane.add(btnAtzera);
	}

}
