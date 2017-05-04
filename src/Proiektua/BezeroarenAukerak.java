package Proiektua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Proiektua.MySQL;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BezeroarenAukerak extends JFrame {

	private JPanel contentPane;
	private MySQL db = new MySQL();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroarenAukerak frame = new BezeroarenAukerak();
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
	public BezeroarenAukerak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDatuPertsonalakAldatu = new JButton("Datu pertsonalak aldatu");
		btnDatuPertsonalakAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatuPertsonalakAldatu datuPertsonalakAldatu = new DatuPertsonalakAldatu();
				datuPertsonalakAldatu.setVisible(true);
			}
		});
		btnDatuPertsonalakAldatu.setBounds(122, 45, 210, 29);
		contentPane.add(btnDatuPertsonalakAldatu);
		
		JButton btnKredituaGehitu = new JButton("Kreditua gehitu");
		btnKredituaGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KredituaGehitu kredituaGehitu = new KredituaGehitu();
				kredituaGehitu.setVisible(true);
			}
		});
		btnKredituaGehitu.setBounds(122, 86, 210, 29);
		contentPane.add(btnKredituaGehitu);
		
		JButton btnNewButton = new JButton("Kotxea gasolindegira eraman");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KotxeaGasolindegiraEraman gasolindegia = new KotxeaGasolindegiraEraman();
				gasolindegia.setVisible(true);
			}
		});
		btnNewButton.setBounds(122, 127, 210, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Kotxe bat alokatu");
		btnNewButton_1.setBounds(122, 168, 210, 29);
		contentPane.add(btnNewButton_1);
	}
}
