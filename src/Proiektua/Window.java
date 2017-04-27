package Proiektua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Window extends JFrame {   //HASIERAKO LEHIOA 
	
	MySQL db = new MySQL();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {   //METODO NAGUSIA
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
	public Window() {   //LEHIOAREN DISEINUA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);  //(_____________,_____________,laukiaren zabalera,laukiaren altuera)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnDatuBaseraKonektatu = new JButton("Datu basera konektatu");
		btnDatuBaseraKonektatu.setFont(new Font("Eras Medium ITC", Font.BOLD, 16));
		
		JButton btnBezeroBerriaSartu = new JButton("Kontu berria sortu");
		btnBezeroBerriaSartu.setFont(new Font("Eras Medium ITC", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBezeroBerriaSartu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
						.addComponent(btnDatuBaseraKonektatu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
					.addGap(39))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addComponent(btnDatuBaseraKonektatu, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBezeroBerriaSartu, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception{
		db.mySQLConnection("root", "", "Proiektua");
		//TODO
		
	}
}
