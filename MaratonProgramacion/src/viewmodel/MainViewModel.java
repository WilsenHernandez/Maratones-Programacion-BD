package viewmodel;

import java.sql.SQLException;

import javax.swing.JFrame;

import model.Conexion;

public class MainViewModel {
public static JFrame mainWindow = null;
	
	public static JFrame launch() {
		if (mainWindow == null) {
			mainWindow = new views.MainView();
		} else {
			mainWindow.dispose();
			mainWindow = new views.MainView();
		}
		mainWindow.requestFocus();
		mainWindow.setLocationRelativeTo(null);
		return mainWindow;
	}
	
	public static void logout() {
		if (Conexion.isConnected()) {
			try {
				Conexion.logout();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Eliminar la ventana principal de Main
		if (mainWindow != null)
			mainWindow.dispose();
		
		// Inicializar nuevamente la vista de Login
		views.LoginView.main(null);
	}

}
