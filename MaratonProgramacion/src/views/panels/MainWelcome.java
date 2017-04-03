package views.panels;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Conexion;

@SuppressWarnings("serial")
public class MainWelcome extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainWelcome() {		
		JLabel bienvenido = new JLabel("Bienvenido " + Conexion.getUsername());
		bienvenido.setFont(new Font("Open Sans", Font.BOLD, 16));
		GroupLayout gl_welcomePane = new GroupLayout(this);
		gl_welcomePane.setHorizontalGroup(
			gl_welcomePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomePane.createSequentialGroup()
					.addContainerGap()
					.addComponent(bienvenido, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_welcomePane.setVerticalGroup(
			gl_welcomePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomePane.createSequentialGroup()
					.addContainerGap()
					.addComponent(bienvenido)
					.addContainerGap(265, Short.MAX_VALUE))
		);
		gl_welcomePane.setAutoCreateContainerGaps(true);
		setLayout(gl_welcomePane);
	}

}
