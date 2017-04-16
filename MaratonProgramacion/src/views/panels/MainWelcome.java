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
		competencias.setFont(new Font("Open Sans", Font.PLAIN, 14));
		competencias.setEnabled(false);
		competencias.setRowSelectionAllowed(false);
		
		JLabel lblEquiposRecientementeInscritos = new JLabel("Equipos recientemente inscritos");
		
		equipos = new JTable();
		equipos.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		equipos.setEnabled(false);
		equipos.setFont(new Font("Open Sans", Font.PLAIN, 14));
		GroupLayout gl_welcomePane = new GroupLayout(this);
		gl_welcomePane.setHorizontalGroup(
			gl_welcomePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomePane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_welcomePane.createParallelGroup(Alignment.LEADING)
						.addComponent(bienvenido, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
						.addComponent(lblCompetenciasMasRecientes)
						.addComponent(lblEquiposRecientementeInscritos)
						.addGroup(gl_welcomePane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(equipos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(competencias, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_welcomePane.setVerticalGroup(
			gl_welcomePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomePane.createSequentialGroup()
					.addContainerGap()
					.addComponent(bienvenido)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCompetenciasMasRecientes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(competencias, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEquiposRecientementeInscritos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(equipos, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		gl_welcomePane.setAutoCreateContainerGaps(true);
		setLayout(gl_welcomePane);
		
		
		if (model.Conexion.isConnected()) {
			competencias.setModel(DbUtils.resultSetToTableModel(viewmodel.panels.MainWelcome.getCompetenciasRecientes()));
			equipos.setModel(DbUtils.resultSetToTableModel(viewmodel.panels.MainWelcome.getEquiposRecientes()));
		}
	}
}
