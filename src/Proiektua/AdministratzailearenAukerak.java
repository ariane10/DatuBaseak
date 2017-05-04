package Proiektua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministratzailearenAukerak extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratzailearenAukerak frame = new AdministratzailearenAukerak();
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
	public AdministratzailearenAukerak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBezeroBerriaSartu = new JButton("Bezero berria sartu");
		btnBezeroBerriaSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BezeroBerriaSartu bezeroBerria = new BezeroBerriaSartu();
				bezeroBerria.setVisible(true);
			}
		});
		btnBezeroBerriaSartu.setBounds(122, 58, 197, 29);
		contentPane.add(btnBezeroBerriaSartu);
		
		JButton btnNewButton = new JButton("Bezero baten egoera aldatu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BezeroBatenEgoeraAldatu bezeroarenEgoeraAldatu = new BezeroBatenEgoeraAldatu();
				bezeroarenEgoeraAldatu.setVisible(true);
			}
		});
		btnNewButton.setBounds(122, 99, 197, 29);
		contentPane.add(btnNewButton);
		
		JButton btnKotxeBerriaSartu = new JButton("Kotxe berria sartu");
		btnKotxeBerriaSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KotxeBerriaSartu kotxeBerria = new KotxeBerriaSartu();
				kotxeBerria.setVisible(true);
			}
		});
		btnKotxeBerriaSartu.setBounds(122, 140, 197, 29);
		contentPane.add(btnKotxeBerriaSartu);
		
		JButton btnKotxeBatiBaja = new JButton("Kotxe bati baja eman");
		btnKotxeBatiBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KotxeBatiBajaEman kotxeBatiBajaEman = new KotxeBatiBajaEman();
				kotxeBatiBajaEman.setVisible(true);
			}
		});
		btnKotxeBatiBaja.setBounds(122, 181, 197, 29);
		contentPane.add(btnKotxeBatiBaja);
	}

}
