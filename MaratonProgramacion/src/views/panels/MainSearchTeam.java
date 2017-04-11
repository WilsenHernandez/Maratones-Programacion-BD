package views.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author whernandez6
 *
 */
@SuppressWarnings("serial")
public class MainSearchTeam extends JPanel {
	private JTextField nombreEquipo;
	private JTextField fechaResult;
	private JTextField clasificacionResult;
	private JLabel nombreResult;
	
	/**
	 * Create the panel.
	 */
	public MainSearchTeam() {
		
		JLabel lblNewLabel = new JLabel("Buscar Equipo");
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNombreDelEquipo = new JLabel("Nombre del Equipo");
		lblNombreDelEquipo.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		nombreEquipo = new JTextField();
		nombreEquipo.setFont(new Font("Open Sans", Font.PLAIN, 12));
		nombreEquipo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Open Sans", Font.BOLD, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarResult(viewmodel.panels.SearchTeam.buscarEquipo(nombreEquipo.getText()));
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		
		nombreResult = new JLabel("New label");
		nombreResult.setFont(new Font("Open Sans", Font.BOLD, 14));
		
		JLabel lblFechaCreacion = new JLabel("Fecha Creación:");
		lblFechaCreacion.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		fechaResult = new JTextField();
		fechaResult.setFont(new Font("Open Sans", Font.PLAIN, 12));
		fechaResult.setEnabled(false);
		fechaResult.setEditable(false);
		fechaResult.setColumns(10);
		
		JLabel clasificacion = new JLabel("Clasificación:");
		clasificacion.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		clasificacionResult = new JTextField();
		clasificacionResult.setFont(new Font("Open Sans", Font.PLAIN, 12));
		clasificacionResult.setEnabled(false);
		clasificacionResult.setEditable(false);
		clasificacionResult.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Técnico");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 14));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Open Sans", Font.BOLD, 12));
		btnEditar.setEnabled(false);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 12));
		btnNewButton.setEnabled(false);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/home/whernandez6/Maratones-Programacion-BD/MaratonProgramacion/src/png/16x16/201-check.png"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(nombreResult)
							.addContainerGap(720, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechaCreacion)
								.addComponent(clasificacion))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(clasificacionResult)
								.addComponent(fechaResult, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
							.addContainerGap(471, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addContainerGap(736, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addContainerGap(674, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombreDelEquipo)
							.addGap(18)
							.addComponent(nombreEquipo, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombreDelEquipo)
								.addComponent(nombreEquipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nombreResult)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaCreacion)
						.addComponent(fechaResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(clasificacion)
						.addComponent(clasificacionResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	void mostrarResult(ResultSet arg) {
		try {
			arg.next();
			nombreResult.setText(arg.getString(1));
			clasificacionResult.setText(arg.getString(2));
			fechaResult.setText(arg.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
