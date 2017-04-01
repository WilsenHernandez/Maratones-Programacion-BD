package views.panels;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Conexion;

@SuppressWarnings("serial")
public class MainWelcome extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainWelcome() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel bienvenido = new JLabel("Bienvenido " + Conexion.getUsername());
		bienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenido.setFont(new Font("Open Sans", Font.PLAIN, 18));
		GroupLayout gl_welcomePane = new GroupLayout(this);
		gl_welcomePane.setHorizontalGroup(
			gl_welcomePane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_welcomePane.createSequentialGroup()
					.addContainerGap()
					.addComponent(bienvenido, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_welcomePane.setVerticalGroup(
			gl_welcomePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomePane.createSequentialGroup()
					.addComponent(bienvenido)
					.addContainerGap(460, Short.MAX_VALUE))
		);
		gl_welcomePane.setAutoCreateContainerGaps(true);
		setLayout(gl_welcomePane);
	}

}
