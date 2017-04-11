package views;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import model.Conexion;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import views.panels.MainSearchTeam;
import views.panels.MainTeamLoad;
import views.panels.MainWelcome;

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
	 * @throws IOException 
	 */
	public MainView() {
		setResizable(false);
		setBounds(new Rectangle(0, 0, 800, 600));
		setTitle("Maratones de Programación - Usuario: " + Conexion.getUsername());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Menú");
		mnInicio.setIcon(new ImageIcon(MainView.class.getResource("/assets/32x32/201-menu.png")));
		mnInicio.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnInicio);
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mnInicio.add(mntmInicio);
		mntmInicio.setFont(new Font("Open Sans", Font.BOLD, 14));
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mnInicio.add(mntmCerrarSesion);
		mntmCerrarSesion.setFont(new Font("Open Sans", Font.BOLD, 14));
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewmodel.MainViewModel.logout();
			}
		});
		mntmCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPane(new MainWelcome());
			}
		});
		
		JMenu mnEquipos = new JMenu("Equipos");
		mnEquipos.setIcon(new ImageIcon(MainView.class.getResource("/assets/32x32/201-user-1.png")));
		mnEquipos.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnEquipos);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inscribir Equipo");
		mntmNewMenuItem.setFont(new Font("Open Sans", Font.BOLD, 14));
		mnEquipos.add(mntmNewMenuItem);
		
		JMenuItem mntmBuscarEquio = new JMenuItem("Buscar Equipo");
		mntmBuscarEquio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPane(new MainSearchTeam());
			}
		});
		mntmBuscarEquio.setFont(new Font("Open Sans", Font.BOLD, 14));
		mnEquipos.add(mntmBuscarEquio);
		
		JMenuItem mntmTopEquipos = new JMenuItem("Top Equipos");
		mntmTopEquipos.setFont(new Font("Open Sans", Font.BOLD, 14));
		mnEquipos.add(mntmTopEquipos);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPane(new MainTeamLoad());
			}
		});
		
		JMenu mnCompetencias = new JMenu("Competencias");
		mnCompetencias.setIcon(new ImageIcon(MainView.class.getResource("/assets/32x32/201-computer.png")));
		mnCompetencias.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnCompetencias);
		
		JMenu mnProblemas = new JMenu("Problemas");
		mnProblemas.setIcon(new ImageIcon(MainView.class.getResource("/assets/32x32/201-light-bulb.png")));
		mnProblemas.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnProblemas);
		
		welcomePane = new MainWelcome();
		setContentPane(welcomePane);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar, welcomePane, mnInicio, mntmInicio, mntmCerrarSesion, mnEquipos, mntmNewMenuItem, mntmBuscarEquio, mntmTopEquipos, mnCompetencias, mnProblemas}));
	}
	
	/**
	 * @param arg Panel nuevo a crear.
	 */
	private void setNewPane(JPanel arg) {
		welcomePane.removeAll();
		welcomePane = arg;
		setContentPane(welcomePane);
		setVisible(true);
	}
}
