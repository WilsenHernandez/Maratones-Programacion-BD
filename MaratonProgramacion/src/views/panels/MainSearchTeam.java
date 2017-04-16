package views.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

/**
 * @author whernandez6
 *
 */
@SuppressWarnings("serial")
public class MainSearchTeam extends JPanel {
	private JTextField nombreEquipo;
	private JTextField fechaResult;
	private JTextField clasificacionResult;
	private JTextField nombreTecnicoResult;
	private JTextField areaExpResult;
	private JTextField coachNombre;
	private JTextField coachCargo;
	private JTable estudiantes;
	
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
		nombreEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipo = nombreEquipo.getText();
				mostrarEquipo(viewmodel.panels.SearchTeam.buscarEquipo(equipo));
				mostrarIntegrantes(viewmodel.panels.SearchTeam.buscarEstudiantes(equipo));
				mostrarTecnico(viewmodel.panels.SearchTeam.buscarTecnico(equipo));
				mostrarCoach(viewmodel.panels.SearchTeam.buscarCoach(equipo));
			}
		});
		nombreEquipo.setFont(new Font("Open Sans", Font.PLAIN, 12));
		nombreEquipo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Open Sans", Font.BOLD, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipo = nombreEquipo.getText();
				mostrarEquipo(viewmodel.panels.SearchTeam.buscarEquipo(equipo));
				mostrarIntegrantes(viewmodel.panels.SearchTeam.buscarEstudiantes(equipo));
				mostrarTecnico(viewmodel.panels.SearchTeam.buscarTecnico(equipo));
				mostrarCoach(viewmodel.panels.SearchTeam.buscarCoach(equipo));
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblFechaCreacion = new JLabel("Fecha Creación:");
		lblFechaCreacion.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		fechaResult = new JTextField();
		lblFechaCreacion.setLabelFor(fechaResult);
		fechaResult.setFont(new Font("Open Sans", Font.PLAIN, 12));
		fechaResult.setEnabled(false);
		fechaResult.setEditable(false);
		fechaResult.setColumns(10);
		
		JLabel clasificacion = new JLabel("Clasificación:");
		clasificacion.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		clasificacionResult = new JTextField();
		clasificacion.setLabelFor(clasificacionResult);
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
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		nombreTecnicoResult = new JTextField();
		nombreTecnicoResult.setEditable(false);
		nombreTecnicoResult.setEnabled(false);
		nombreTecnicoResult.setColumns(10);
		
		JLabel lblAreaExperticia = new JLabel("Área Experticia:");
		lblAreaExperticia.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		areaExpResult = new JTextField();
		areaExpResult.setEnabled(false);
		areaExpResult.setEditable(false);
		areaExpResult.setColumns(10);
		
		JLabel lblCoach = new JLabel("Coach");
		lblCoach.setFont(new Font("Open Sans", Font.BOLD, 14));
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Cargo:");
		lblNewLabel_2.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		coachNombre = new JTextField();
		coachNombre.setEnabled(false);
		coachNombre.setEditable(false);
		coachNombre.setColumns(10);
		
		coachCargo = new JTextField();
		coachCargo.setEnabled(false);
		coachCargo.setEditable(false);
		coachCargo.setColumns(10);
		
		JLabel lblEstudiantes = new JLabel("Estudiantes");
		lblEstudiantes.setFont(new Font("Open Sans", Font.BOLD, 14));
		
		estudiantes = new JTable();
		estudiantes.setEnabled(false);
		estudiantes.setRowSelectionAllowed(false);
		estudiantes.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		JLabel lblNombre_2 = new JLabel("Cedula");
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		JLabel lblCarrera = new JLabel("Carrera");
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(estudiantes, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addContainerGap(674, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombreDelEquipo)
							.addGap(18)
							.addComponent(nombreEquipo, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscar)
							.addContainerGap(400, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1)
									.addComponent(lblCoach)
									.addComponent(lblEstudiantes)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblFechaCreacion)
											.addComponent(clasificacion)
											.addComponent(lblNombre)
											.addComponent(lblAreaExperticia)
											.addComponent(lblNombre_1)
											.addComponent(lblNewLabel_2))
										.addGap(21)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(coachCargo)
											.addComponent(coachNombre)
											.addComponent(areaExpResult)
											.addComponent(clasificacionResult)
											.addComponent(fechaResult, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
											.addComponent(nombreTecnicoResult, Alignment.TRAILING)
											.addComponent(lblNewLabel_4, Alignment.TRAILING))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombre_2)
									.addGap(93)
									.addComponent(lblNewLabel_3)))
							.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
							.addComponent(lblDireccion)
							.addGap(79)
							.addComponent(lblCarrera)
							.addGap(85)
							.addComponent(lblFechaNacimiento)
							.addGap(25))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDelEquipo)
						.addComponent(nombreEquipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(nombreTecnicoResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAreaExperticia)
						.addComponent(areaExpResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCoach)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre_1)
						.addComponent(coachNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(coachCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEstudiantes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblDireccion)
						.addComponent(lblCarrera)
						.addComponent(lblFechaNacimiento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(estudiantes, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	void mostrarEquipo(ResultSet arg) {
		try {
			arg.next();
			// nombreResult.setText(arg.getString(1));
			// nombreResult.setVisible(true);
			clasificacionResult.setText(arg.getString(2));
			fechaResult.setText(arg.getString(3));
			areaExpResult.setText(arg.getString(4));
			coachCargo.setText(arg.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "Equipo no encontrado o no existe.", "Error", 0);
			// nombreResult.setText("");
			// nombreResult.setVisible(true);
			clasificacionResult.setText("");
			fechaResult.setText("");
			areaExpResult.setText("");
			coachCargo.setText("");
			
		}
	}
	
	
	void mostrarIntegrantes(ResultSet arg) {
		try {
			estudiantes.setModel(DbUtils.resultSetToTableModel(arg));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void mostrarTecnico(ResultSet arg) {
		try {
			arg.next();
			nombreTecnicoResult.setText(arg.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
			
			nombreTecnicoResult.setText("");
		}
	}
	
	void mostrarCoach(ResultSet arg) {
		try {
			arg.next();
			coachNombre.setText(arg.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
			
			coachNombre.setText("");
		}
	}
}
