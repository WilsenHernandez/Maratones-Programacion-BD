package viewmodel;

import java.sql.SQLException;

import model.Conexion;

public class MainViewModel {
	public static void logout() {
		if (Conexion.isConnected()) {
			try {
				Conexion.logout();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Eliminar la ventana principal de Main
		if (views.launcher.Main.mainWindow != null)
			views.launcher.Main.mainWindow.dispose();
		
		// Inicializar nuevamente la vista de Login
		views.LoginView.main(null);
	}

}
