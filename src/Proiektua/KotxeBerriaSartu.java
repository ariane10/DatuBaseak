package Proiektua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KotxeBerriaSartu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ButtonGroup botoiak = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KotxeBerriaSartu frame = new KotxeBerriaSartu();
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
	public KotxeBerriaSartu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatrikula = new JLabel("Matrikula:");
		lblMatrikula.setBounds(51, 20, 91, 16);
		contentPane.add(lblMatrikula);
		
		JLabel lblMarka = new JLabel("Marka:");
		lblMarka.setBounds(51, 48, 61, 16);
		contentPane.add(lblMarka);
		
		JLabel lblEgunprezioa = new JLabel("Egun prezioa:");
		lblEgunprezioa.setBounds(51, 76, 91, 16);
		contentPane.add(lblEgunprezioa);
		
		JLabel lblAteKopurua = new JLabel("Ate kopurua:");
		lblAteKopurua.setBounds(51, 104, 91, 16);
		contentPane.add(lblAteKopurua);
		
		JLabel lblAireEgokitua = new JLabel("Aire egokitua:");
		lblAireEgokitua.setBounds(51, 132, 91, 16);
		contentPane.add(lblAireEgokitua);
		
		JLabel lblDepositoarenTamaina = new JLabel("Depositoaren tamaina:");
		lblDepositoarenTamaina.setBounds(51, 160, 150, 16);
		contentPane.add(lblDepositoarenTamaina);
		
		JLabel lblKarburanteKantitatea = new JLabel("Hasierako karburante kantitatea:");
		lblKarburanteKantitatea.setBounds(51, 188, 216, 16);
		contentPane.add(lblKarburanteKantitatea);
		
		textField = new JTextField();
		textField.setBounds(147, 15, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 43, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnBai = new JRadioButton("Bai");
		rdbtnBai.setBounds(167, 128, 61, 23);
		contentPane.add(rdbtnBai);
		
		JRadioButton rdbtnEz = new JRadioButton("Ez");
		rdbtnEz.setBounds(239, 128, 61, 23);
		contentPane.add(rdbtnEz);
		
		botoiak.add(rdbtnBai);
		botoiak.add(rdbtnEz);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "5"}));
		comboBox.setBounds(167, 100, 61, 27);
		contentPane.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(213, 155, 76, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(279, 183, 76, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQL db = MySQL.getMySQL();
				int aireEgokitua;
				if (rdbtnBai.isSelected()){
					aireEgokitua=1;
				}else{
					aireEgokitua=0;
				}
				db.kotxeBerriaSartu(textField.getText(), textField_1.getText(), textField_4.getText(), pEgoera, Integer.parseInt(comboBox.getSelectedItem()), aireEgokitua, textField_2.getText(), textField_3.getText());
			}
		});
		btnGorde.setBounds(274, 230, 117, 29);
		contentPane.add(btnGorde);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministratzailearenAukerak aukerak = new AdministratzailearenAukerak();
				aukerak.setVisible(true);
			}
		});
		btnAtzera.setBounds(51, 230, 117, 29);
		contentPane.add(btnAtzera);
		
		textField_4 = new JTextField();
		textField_4.setBounds(147, 71, 81, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
