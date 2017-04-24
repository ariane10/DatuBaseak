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
		
		JButton btnBezeroBerriaSartu = new JButton("Bezero berria sartu");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnBezeroBerriaSartu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDatuBaseraKonektatu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(185, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(btnDatuBaseraKonektatu)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBezeroBerriaSartu)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception{
		db.mySQLConnection("root", "", "Proiektua");
		//TODO
		
	}
	
	
	
	

}
