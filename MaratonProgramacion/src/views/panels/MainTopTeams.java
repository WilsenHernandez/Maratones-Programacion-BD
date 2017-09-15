package views.panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;

@SuppressWarnings("serial")
public class MainTopTeams extends JPanel {
	private JTable consultaUno;

	/**
	 * Create the panel.
	 */
	public MainTopTeams() {
		
		JLabel lblNewLabel = new JLabel("Top Equipos");
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblEstudiantesQueMas = new JLabel("Estudiantes que mas han participado");
		
		consultaUno = new JTable();
		consultaUno.setRowSelectionAllowed(false);
		consultaUno.setEnabled(false);
		consultaUno.setFont(new Font("Open Sans", Font.PLAIN, 14));
		consultaUno.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
						.addComponent(lblNewLabel)
						.addComponent(lblEstudiantesQueMas)
						.addComponent(consultaUno, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEstudiantesQueMas)
					.addGap(59)
					.addComponent(consultaUno, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(168, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		consultaUno.setModel(DbUtils.resultSetToTableModel(viewmodel.panels.MainTopTeams.getTopTeams()));
	}
}
