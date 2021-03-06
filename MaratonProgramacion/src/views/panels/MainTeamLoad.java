package views.panels;

import java.awt.Component;
import java.awt.Font;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.eclipse.wb.swing.FocusTraversalOnArray;

@SuppressWarnings("serial")
public class MainTeamLoad extends JPanel {
	private JTextField textField;
	private JTextField txtAsd;

	/**
	 * Create the panel.
	 */
	public MainTeamLoad() {
		
		JLabel tituloPanel = new JLabel("Inscribir Equipo Nuevo");
		tituloPanel.setFont(new Font("Open Sans", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNombreDelEquipo = new JLabel("Nombre del Equipo");
		lblNombreDelEquipo.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton inscribirEquipo = new JButton("Inscribir Equipo");
		inscribirEquipo.setEnabled(false);
		
		JLabel lblIntegrantes = new JLabel("Fecha Inscripcion");
		lblIntegrantes.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		txtAsd = new JTextField();
		txtAsd.setText((new Date()).toString());
		txtAsd.setEnabled(false);
		txtAsd.setVisible(false);
		txtAsd.setEditable(false);
		txtAsd.setColumns(10);
		
		JLabel lblhoy = new JLabel("(Hoy)");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(tituloPanel)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreDelEquipo)
								.addComponent(lblIntegrantes))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField)
								.addComponent(txtAsd, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblhoy)
								.addComponent(inscribirEquipo, Alignment.TRAILING))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tituloPanel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDelEquipo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAsd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIntegrantes)
						.addComponent(lblhoy))
					.addGap(232)
					.addComponent(inscribirEquipo)
					.addContainerGap())
		);
		setLayout(groupLayout);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, separator, tituloPanel, inscribirEquipo, lblNombreDelEquipo, lblIntegrantes}));

	}
}
