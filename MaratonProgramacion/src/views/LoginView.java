package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import model.Conexion;

import viewmodel.LoginViewModel;

public class LoginView {

	private JFrame frmMaratonesProgramacin;
	private JTextField userField;
	private JPasswordField passwordField;
	private JFrame mainWindow;
	private JPanel panel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			LoginView window = new LoginView();
			window.frmMaratonesProgramacin.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMaratonesProgramacin = new JFrame();
		frmMaratonesProgramacin.setResizable(false);
		frmMaratonesProgramacin.setTitle("Maratones Programación");
		frmMaratonesProgramacin.setBounds(100, 100, 285, 246);
		frmMaratonesProgramacin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMaratonesProgramacin.setLocationRelativeTo(null);
		
		panel = new JPanel();
		frmMaratonesProgramacin.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblLoginScreen = new JLabel("Maratones de Programación");
		lblLoginScreen.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		JLabel lblContrasea = new JLabel("Contraseña");
		
		userField = new JTextField();
		userField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.requestFocus();
			}
		});
		lblUsuario.setLabelFor(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginViewModel.Login(userField.getText(), passwordField.getPassword());
				if (Conexion.isConnected()) {
					mainWindow = views.launcher.Main.launch();
					mainWindow.setLocationRelativeTo(null);
					mainWindow.setVisible(true);
					frmMaratonesProgramacin.dispose();
				}
			}
		});
		lblContrasea.setLabelFor(passwordField);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginViewModel.Login(userField.getText(), passwordField.getPassword());
				if (Conexion.isConnected()) {
					mainWindow = views.launcher.Main.launch();
					mainWindow.setLocationRelativeTo(null);
					mainWindow.setVisible(true);
					frmMaratonesProgramacin.dispose();
				}
			}
		});

		
		JLabel lblVersion = new JLabel("Version 0.1");
		lblVersion.setEnabled(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 255, Short.MAX_VALUE)
						.addComponent(lblLoginScreen)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsuario)
								.addComponent(lblContrasea))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnIniciarSesion)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
								.addComponent(userField))
							.addGap(14))
						.addComponent(lblVersion, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLoginScreen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(userField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnIniciarSesion)
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(lblVersion)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
}

