package Proiektua;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Random;
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

	//BIHAR GALDETU
	public int binary (boolean egoera){
		int emaitza=0;
		if (egoera){
			emaitza=1;
		}
		return emaitza;
	}
	
	//BIHAR GALDETU
	public int kodeaSortu(){
		Random random = new Random();
		int kodea = random.nextInt(999999998)+1;
		return kodea;
	}

	
	/************ADMINISTRATZAILEAREN ZATIA************/
	
	public void bezeroBerriaSartu(String pasahitza, String izena,
			String abizena, String helbidea, int kreditua){
		try{
			String Query = "INSERT INTO " + "BEZEROA" + "VALUES" +
					"(" + kodeaSortu() + ", " +"\"" +pasahitza+"\"" + ", " + 
					"\"" + izena + "\"" + " ," + "\"" + abizena + "\"" +
					", " + "\"" + helbidea + "\"" + ", " + binary(true) + DateFormat.getTimeInstance() 
					+ ", " +kreditua + ");";
			Statement st =  (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Bezero erabiltzailea ondo sortu da.");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erabiltzaile berria sortzean errore bat gertatu da. Barkatu eragozpenak.");
		}
	}
	
	//BIHAR GALDETU!!!!!
	public void BezeroBatenEgoeraAldatu(int pKodea){
		try{
			String Query= "UPDATE BEZEROA SET EGOERA= NOT (EGOERA)"  + 
					" WHERE KODEA=" + pKodea+ ";";
			Statement st =  (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeUpdate(Query);
			JOptionPane.showMessageDialog(null, pKodea + " duen bezeroa bajan eman da");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, pKodea + "duen bezeroa ezin izan da bajan eman. Barkatu eragozpenak.");
		}
	}
	
	public void kotxeBerriaSartu(String pMatrikula, String pMarka, int pEgunPrezioa, String pEgoera,
								int pAteKopurua, boolean pAireEgokitua, int pDepositoa,
								String pKarburanteMota){
		try{
			String Query = "INSERT INTO " + "KOTXEA" + "VALUES("
					+ "\"" + pMatrikula + "\", " + "\"" + pMarka + "\", " +
					pEgunPrezioa + "\", " + "\"" + pEgoera + "\", " +
					pAteKopurua + ", " + binary(pAireEgokitua) + ", " + pDepositoa +
					", " + pDepositoa + ", " + DateFormat.getTimeInstance() + ", " + 
					"\"" + pKarburanteMota + "\");";
			Statement st =  (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Kotxea Datu Basean ondo sartu da.");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Kotxea gure Datu Basean sartzean arazo bat sortu da. Barkatu eragozpenak.");
		}
	}
	
	public void kotxeBatiBajaEman (String pMatrikula){
		try{
			String Query = "DELETE FROM KOTXEA WHERE MATRIKULA=" + "\"" + pMatrikula +"\";";
			Statement st = (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeQuery(Query);
			JOptionPane.showMessageDialog(null, "Kotxea datu basetik ondo ezabatu da.");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null,"Sartutako kotxearen matrikularekin errore bat gertatu da eta ezin izan da Kotxea datu basetik ezabatu.");
		}
	}
	
	public void karburanteGutxikoKotxeakIkusi(){
		try{
			String Query = "SELECT MATRIKULA FROM KOTXEA WHERE "
					+ "KARBURANTEA <(DEPOSITOA*0.2);";
			Statement st = (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeQuery(Query);
			JOptionPane.showMessageDialog(null, "%20 baino gutxiago duten kotxeak hauek dira");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null,"Kontsultarekin errore bat gertatu da.");
		}
	}
	
	//BIHAR GALDETU
	public void kotxeaGasolindegiraEraman(String pMatrikula){
		try{
			String Query = "UPDATE KOTXEA SET KARBURANTEKOP=DEPOSITOA"
					+ " WHERE MATRIKULA=" + pMatrikula;
			Statement st = (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeQuery(Query);
			JOptionPane.showMessageDialog(null, pMatrikula + "duen kotxea gasolindegira eraman da eta depositoa guztiz bete da.");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Barkatu baina " + pMatrikula + " kotxea duen matrikula ezin izan da gasolindegira eraman.");
		}
	
	}
	
	/**********BEZEROAREN ZATIA**************/
	
	public void datuPertsonalakAldatu(String kodea, String pasahitza, String helbidea, String izena, String abizena){
		if (pasahitza!=null){
			pasahitzaAldatu(kodea, pasahitza);
		}
		if (helbidea!=null){
			helbideaAldatu(kodea, helbidea);
		}
		if (izena!=null){
			izenaAldatu(kodea, izena);
		}
		if (abizena!=null){
			abizenaAldatu(kodea, abizena);
		}
	}
	
	public void pasahitzaAldatu(String kodea, String pasahitza){
		try{
			String Query = "UPDATE BEZEROA SET PASAHITZA=" + pasahitza +
					" WHERE KODEA=" + kodea + ";";
			Statement st = (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeQuery(Query);
			JOptionPane.showMessageDialog(null,  "Zure pasahitza ondo aldatu da.");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Zure pasahitza ezin izan da aldatu. Barkatu eragozpenak.");
		}
	}
	
	public void helbideaAldatu(String kodea, String helbidea){
		try{
			String Query = "UPDATE BEZEROA SET HELBIDEA=" + helbidea +
					" WHERE KODEA=" + kodea + ";";
			Statement st = (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeQuery(Query);
			JOptionPane.showMessageDialog(null,  "Zure helbidea ondo aldatu da.");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Zure helbidea ezin izan da aldatu. Barkatu eragozpenak.");
		}
	}
	
	public void izenaAldatu(String kodea, String izena){
		try{
			String Query = "UPDATE BEZEROA SET IZENA=" + izena +
					" WHERE KODEA=" + kodea + ";";
			Statement st = (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeQuery(Query);
			JOptionPane.showMessageDialog(null,  "Zure izena ondo aldatu da.");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Zure izena ezin izan da aldatu. Barkatu eragozpenak.");
		}
	}
	
	public void abizenaAldatu(String kodea, String abizena){
		try{
			String Query = "UPDATE BEZEROA SET ABIZENA=" + abizena +
					" WHERE KODEA=" + kodea + ";";
			Statement st = (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeQuery(Query);
			JOptionPane.showMessageDialog(null,  "Zure abizena ondo aldatu da.");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Zure abizena ezin izan da aldatu. Barkatu eragozpenak.");
			}
		}
	
	public void kredituGehitu(String kodea, int kreditua){
		try{
			String Query="UPDATE BEZEROA SET KREDITUA=KREDITUA+" + kreditua +
					" WHERE KODEA=" + kodea+ ";";
			Statement st = (Statement) Conexion.createStatement();
			((java.sql.Statement) st).executeQuery(Query);
			JOptionPane.showMessageDialog(null,  "Zure kreditua ondo gehitu da.");
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Zure kreditua ezin izan da gehitu. Barkatu eragozpenak.");
			}
	}      
   
	public void bezeroakKotxeaGasolindegiraEraman(String kodea, String matrikula, int karburanteKop){
        int prezioa=0,kreditua=0,depositoa=0,karbKop=0;
		String karbMota="Ezezaguna",errorea="Ezer";
        boolean denaOndo=true;
		
		String Query="MySQL-rako komandoak";
        Statement st = null;
        java.sql.ResultSet resultSet;
		
        //Bezeroa========================================================
		try {
            Query = "SELECT * FROM BEZERO" + /*Asteriskoa jartzen da bezero horren informazio osoa nahi dugulako*/
							" WHERE KODEA=" + kodea+ ";";
            st = (Statement) Conexion.createStatement();
            resultSet = ((java.sql.Statement) st).executeQuery(Query);
            
            kreditua=resultSet.getInt("KREDITUA"); /*Bezeroak duen kreditua lortzen da*/
 
        } catch (SQLException ex) {
            errorea="Ez da bezeroa aurkitu";
            denaOndo=false;
        }
	
		//Kotxea==========================================================
		if(denaOndo){
			try {
	            Query = "SELECT * FROM KOTXE" +	//Kotxearen infoa lortu
								" WHERE MATRIKULA=" + matrikula+ ";";
	            st = (Statement) Conexion.createStatement();
	            resultSet = ((java.sql.Statement) st).executeQuery(Query);

	            depositoa=resultSet.getInt("DEPOSITOA");
	            karbKop=resultSet.getInt("KARBURANTEKOP");
	            karbMota=resultSet.getString("KARBURANTEMOTA");
	 
	        } catch (SQLException ex) {
	        	errorea="Ez da kotxea aurkitu";
	            denaOndo=false;
	        }
		}
		
		//Karburantea========================================================
		if(denaOndo){
			try {
	            Query = "SELECT * FROM KARBURANTEMOTA" +
								" WHERE IZENA=" + karbMota+ ";";
	            st = (Statement) Conexion.createStatement();
	            resultSet = ((java.sql.Statement) st).executeQuery(Query);
	
	            prezioa=depositoa-karbKop * resultSet.getInt("PREZIOA"); //Prezioa kalkulatu
	            
	        } catch (SQLException ex) {
	        	errorea="Ez da karburantea aurkitu";
	            denaOndo=false;
	        }
		}
		//Dirua Aldatu========================================================
		if(denaOndo){
			if(kreditua>=prezioa){
				try {
					Query="UPDATE BEZEROA SET KREDITUA=" + (kreditua-prezioa) +
							" WHERE KODEA=" + kodea+ ";";
		            st = (Statement) Conexion.createStatement();
		            resultSet = ((java.sql.Statement) st).executeQuery(Query);
		            
		        } catch (SQLException ex) {
		        	errorea="Ezin izan da dirua aldatu";
		            denaOndo=false;
		        }
				
				try {
					Query="UPDATE KOTXE SET KARBURANTEKOP=" + depositoa +
							" WHERE MATRIKULA=" + matrikula+ ";";
		            resultSet = ((java.sql.Statement) st).executeQuery(Query);
		            
		        } catch (SQLException ex) {
		        	errorea="Ezin izan da karburantea aldatu";
		            denaOndo=false;
		        }
			}else errorea="Ez du diru nahikorik";			
		}
		if(!denaOndo){	JOptionPane.showMessageDialog(null,errorea);}
	}
}

	//public void insert
	//public void getValues
	//public void deleteRecord

