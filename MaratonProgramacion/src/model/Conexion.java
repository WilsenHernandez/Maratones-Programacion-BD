package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	private static String username = "NO CONECTADO";
	public static Connection log = null;

	public static boolean login(String user, char[] password)
	{
		String url = "jdbc:postgresql://localhost:5432/postgres";
		try {
			log = DriverManager.getConnection(url, user, new String(password));
			if (log != null)
				username = user;
		} catch (SQLException e) {
			username = "ERROR DE CONEXIÓN";
			JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Error", 0);
		}
		return log != null;
	}
	
	public static boolean isConnected() {
		if (log != null) {
			try {
				return log.isValid(0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static void logout() throws SQLException
	{
		if (log.isValid(0)) {
			try {
				username = "DESCONECTADO";
				log.close();
			} catch (Exception e) { }
		}
			
	}
}
