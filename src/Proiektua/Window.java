package Proiektua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdministratzaileBezalaSartu = new JButton("Administratzaile bezala sartu");
		btnAdministratzaileBezalaSartu.setBounds(123, 67, 215, 29);
		contentPane.add(btnAdministratzaileBezalaSartu);
		
		JButton btnBezeroBezalaSartu = new JButton("Bezero bezala sartu");
		btnBezeroBezalaSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BezeroaEgiaztatu bezeroarenAukerak = new BezeroaEgiaztatu();
				bezeroarenAukerak.setVisible(true);
			}
		});
		btnBezeroBezalaSartu.setBounds(123, 110, 215, 29);
		contentPane.add(btnBezeroBezalaSartu);
	}
}
