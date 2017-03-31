package viewmodel;

import java.sql.SQLException;

import model.Conexion;

public class MainViewModel {
	public static void logout() {
		if (Conexion.isConnected()) {
			try {
				Conexion.logout();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (views.launcher.Main.mainWindow != null)
			views.launcher.Main.mainWindow.dispose();
		views.LoginView.main(null);
	}

}
