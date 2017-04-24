package Proiektua;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

public class MySQL {
	
	private static Connection Conexion;


	public void mySQLConnection(String user, String pass, String db_name) throws Exception{  //KONEXIOA EZARRI
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
			JOptionPane.showMessageDialog(null, "Zerbitzariarekin konexioa ondo ezarri da.");
		}catch(ClassNotFoundException ex){
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		}catch(SQLException ex){
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void closeConnection(){    //KONEXIOA ITXI
		try{
			Conexion.close();
			JOptionPane.showMessageDialog(null, "Zerbitzariarekin konexioa amaitu da");
		}catch(SQLException ex){
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	public static void main(String[] args){   //METODO NAGUSIA
		MySQL db = new MySQL();
		try {
			db.mySQLConnection("root", "", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public void createDB(String Proiektua){   //DATU BASEA SORTU
		try{
			String Query = "CREATE DATABASE" + Proiektua;
			Statement st = new Conexion.c
			Statement st = Conexion.createStatement();
			st.executeUpdate(Query);
			closeConnection();
			mySQLConnection("root","","Proiektua");
			JOptionPane.showMessageDialog(null,Proiektua + "datu basea sortu da");
		}catch (SQLException ex){
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
	}*/

	

	public void bezeroBerriaSartu(String table_name, int kodea, String pasahitza, String izena,
			String abizena, String helbidea, boolean egoera, DateFormat noiztik, int kreditua){
		try{
			String Query = "INSERT INTO " + table_name + "VALUES("
					+"\"" + kodea + "\" , "
					+"\"" + pasahitza + "\" , "
					+ "\"" + izena + "\" , "
					+ "\"" + abizena + "\" , "
					+ "\"" + helbidea + "\", "
					+ "\"" + egoera + "\" , "
					+ "\"" + noiztik +"\", "
					+"\"" + kreditua + "\")";
			Statement st =  (Statement) Conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Bezero erabiltzailea ondo sortu da.");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erabiltzaile berria sortzean errore bat gertatu da. Barkatu eragozpenak.");
		}
	}

	
	

	//public void insert
	//public void getValues
	//public void deleteRecord
	
	
	
}
