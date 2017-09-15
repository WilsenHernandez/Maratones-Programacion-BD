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

import views.panels.*;
import java.awt.Dimension;

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
		setBounds(new Rectangle(0, 0, 800, 800));
		setTitle("Maratones de Programación - Usuario: " + Conexion.getUsername());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mntmInicio.setPreferredSize(new Dimension(50, 27));
		mntmInicio.setHorizontalAlignment(SwingConstants.LEFT);
		mntmInicio.setIcon(new ImageIcon(MainView.class.getResource("/assets/32x32/201-home.png")));
		menuBar.add(mntmInicio);
		mntmInicio.setFont(new Font("Open Sans", Font.BOLD, 18));
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPane(new MainWelcome());
			}
		});
		
		JMenu mnEquipos = new JMenu("Equipos");
		mnEquipos.setIcon(new ImageIcon(MainView.class.getResource("/assets/32x32/201-user-1.png")));
		mnEquipos.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnEquipos);
		
		JMenuItem inscribirEquipo = new JMenuItem("Inscribir Equipo");
		inscribirEquipo.setFont(new Font("Open Sans", Font.BOLD, 14));
		mnEquipos.add(inscribirEquipo);
		if (model.Conexion.getUsername() == "Programador")
			inscribirEquipo.setVisible(false);
		
		JMenuItem buscarEquipo = new JMenuItem("Buscar Equipo");
		buscarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPane(new MainSearchTeam());
			}
		});
		buscarEquipo.setFont(new Font("Open Sans", Font.BOLD, 14));
		mnEquipos.add(buscarEquipo);
		
		JMenuItem topEquipos = new JMenuItem("Top Equipos");
		topEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPane(new MainTopTeams());
			}
		});
		topEquipos.setFont(new Font("Open Sans", Font.BOLD, 14));
		mnEquipos.add(topEquipos);
		inscribirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPane(new MainTeamLoad());
			}
		});
		
		JMenu mnCompetencias = new JMenu("Competencias");
		mnCompetencias.setIcon(new ImageIcon(MainView.class.getResource("/assets/32x32/201-computer.png")));
		mnCompetencias.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnCompetencias);
		
		JMenuItem mntmVerCompetencias = new JMenuItem("Buscar Competencias");
		mntmVerCompetencias.setFont(new Font("Open Sans", Font.BOLD, 14));
		mnCompetencias.add(mntmVerCompetencias);
		
		JMenu mnProblemas = new JMenu("Problemas");
		mnProblemas.setIcon(new ImageIcon(MainView.class.getResource("/assets/32x32/201-light-bulb.png")));
		mnProblemas.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnProblemas);
		
		JMenuItem mntmBuscarProblemas = new JMenuItem("Buscar Problemas");
		mntmBuscarProblemas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPane(new SearchProblems());
			}
		});
		mntmBuscarProblemas.setFont(new Font("Open Sans", Font.BOLD, 14));
		mnProblemas.add(mntmBuscarProblemas);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.setIcon(new ImageIcon(MainView.class.getResource("/assets/32x32/201-close.png")));
		menuBar.add(mntmCerrarSesion);
		mntmCerrarSesion.setFont(new Font("Open Sans", Font.BOLD, 18));
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewmodel.MainViewModel.logout();
			}
		});
		mntmCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		
		welcomePane = new MainWelcome();
		setContentPane(welcomePane);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar, mntmInicio, mntmCerrarSesion, mnEquipos, inscribirEquipo, buscarEquipo, topEquipos, mnCompetencias, mnProblemas}));
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
