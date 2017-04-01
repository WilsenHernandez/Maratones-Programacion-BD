package views.launcher;

import javax.swing.JFrame;

public class Main {
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

}
