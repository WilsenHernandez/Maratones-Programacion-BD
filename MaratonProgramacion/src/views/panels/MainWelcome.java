package views.panels;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Conexion;
import net.proteanit.sql.DbUtils;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class MainWelcome extends JPanel {
	private JTable competencias;
	private JTable equipos;

	/**
	 * Create the panel.
	 */
	public MainWelcome() {		
		JLabel bienvenido = new JLabel("Bienvenido " + Conexion.getUsername());
		bienvenido.setFont(new Font("Open Sans", Font.BOLD, 16));
		
		JLabel lblCompetenciasMasRecientes = new JLabel("Competencias mas recientes");
		lblCompetenciasMasRecientes.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		competencias = new JTable();
		competencias.setBorder(new LineBorder(null, 1, true));
		competencias.setFont(new Font("Open Sans", Font.PLAIN, 16));
		competencias.setEnabled(false);
		competencias.setRowSelectionAllowed(false);
		
		JLabel lblEquiposRecientementeInscritos = new JLabel("Equipos recientemente inscritos");
		lblEquiposRecientementeInscritos.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		equipos = new JTable();
		equipos.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		equipos.setEnabled(false);
		equipos.setFont(new Font("Open Sans", Font.PLAIN, 14));
		
		JLabel lblAbril = new JLabel("Abril, 2017");
		lblAbril.setFont(new Font("Open Sans", Font.PLAIN, 14));
		
		JLabel lblWilsenHernandez = new JLabel("Wilsen Hernandez");
		lblWilsenHernandez.setFont(new Font("Open Sans", Font.PLAIN, 14));
		
		JLabel lblJoseBriceo = new JLabel("Jose Briceño");
		lblJoseBriceo.setFont(new Font("Open Sans", Font.PLAIN, 14));
		
		JLabel lblFreddyDuran = new JLabel("Freddy Duran");
		lblFreddyDuran.setFont(new Font("Open Sans", Font.PLAIN, 14));
		GroupLayout gl_welcomePane = new GroupLayout(this);
		gl_welcomePane.setHorizontalGroup(
			gl_welcomePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomePane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_welcomePane.createParallelGroup(Alignment.LEADING)
						.addComponent(bienvenido, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_welcomePane.createSequentialGroup()
							.addGroup(gl_welcomePane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCompetenciasMasRecientes)
								.addComponent(competencias, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_welcomePane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEquiposRecientementeInscritos)
								.addComponent(equipos, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_welcomePane.createSequentialGroup()
							.addComponent(lblAbril)
							.addPreferredGap(ComponentPlacement.RELATED, 435, Short.MAX_VALUE)
							.addComponent(lblWilsenHernandez))
						.addComponent(lblJoseBriceo, Alignment.TRAILING)
						.addComponent(lblFreddyDuran, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_welcomePane.setVerticalGroup(
			gl_welcomePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomePane.createSequentialGroup()
					.addContainerGap()
					.addComponent(bienvenido)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_welcomePane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCompetenciasMasRecientes)
						.addComponent(lblEquiposRecientementeInscritos))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_welcomePane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(competencias, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(equipos, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
					.addComponent(lblFreddyDuran)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblJoseBriceo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_welcomePane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbril)
						.addComponent(lblWilsenHernandez))
					.addContainerGap())
		);
		gl_welcomePane.setAutoCreateContainerGaps(true);
		setLayout(gl_welcomePane);
		
		
		if (model.Conexion.isConnected()) {
			try {
				competencias.setModel(DbUtils.resultSetToTableModel(viewmodel.panels.MainWelcome.getCompetenciasRecientes()));
				equipos.setModel(DbUtils.resultSetToTableModel(viewmodel.panels.MainWelcome.getEquiposRecientes()));
			} catch (Exception e) { }
		}
	}
}
