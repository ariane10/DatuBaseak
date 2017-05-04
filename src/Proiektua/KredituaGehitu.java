package Proiektua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KredituaGehitu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KredituaGehitu frame = new KredituaGehitu();
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
	public KredituaGehitu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZenbatKredituGehitu = new JLabel("Zenbat kreditu gehitu nahi duzu?");
		lblZenbatKredituGehitu.setBounds(107, 68, 213, 16);
		contentPane.add(lblZenbatKredituGehitu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "30", "40", "50", "60", "80", "100"}));
		comboBox.setBounds(183, 96, 70, 27);
		contentPane.add(comboBox);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BezeroarenAukerak bezeroarenAukerak = new BezeroarenAukerak();
				bezeroarenAukerak.setVisible(true);
			}
		});
		btnAtzera.setBounds(73, 214, 117, 29);
		contentPane.add(btnAtzera);
		
		JButton btnIrten = new JButton("Irten");
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnIrten.setBounds(239, 214, 117, 29);
		contentPane.add(btnIrten);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQL db = new MySQL();
				db.kredituGehitu(db.getBezeroKodea(), comboBox.getSelectedIndex());
			}
		});
		btnGorde.setBounds(154, 160, 117, 29);
		contentPane.add(btnGorde);
	}
}
