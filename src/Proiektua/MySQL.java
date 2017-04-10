package Proiektua;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class MySQL {
	
	public void createDB(String Proiektua){
		try{
			String Query = "CREATE DATABASE" + Proiektua;
			Statement st = Conexion.createStatement();
			st.executeUpdate(Query);
			closeConnection();
			mySQLConnection("root","","Proiektua");
			JOptionPane.showMessageDialog(null,Proiektua + "datu basea sortu da");
		}catch (SQLException ex){
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	

}
