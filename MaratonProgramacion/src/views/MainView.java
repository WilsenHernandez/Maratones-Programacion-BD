package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import model.Conexion;
import views.panels.MainTeamLoad;
import views.panels.MainWelcome;
import java.awt.Rectangle;

/**
 * @author Wilsen Hernandez
 */
@SuppressWarnings("serial")
public class MainView extends JFrame {

	private JPanel welcomePane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainView frame = new MainView();			
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
	public MainView() {
		setResizable(false);
		setBounds(new Rectangle(0, 0, 800, 600));
		setTitle("Maratones de Programación - Usuario: " + Conexion.getUsername());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inscribir Equipo");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPane(new MainTeamLoad());
			}
		});
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPane(new MainWelcome());
			}
		});
		menuBar.add(mntmInicio);
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewmodel.MainViewModel.logout();
			}
		});
		mntmCerrarSesion.setIcon(new ImageIcon(MainView.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		mntmCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmCerrarSesion);
		
		welcomePane = new MainWelcome();
		setContentPane(welcomePane);
	}
	
	private void setNewPane(JPanel arg) {
		welcomePane.removeAll();
		welcomePane = arg;
		setContentPane(welcomePane);
		setVisible(true);
	}
}
