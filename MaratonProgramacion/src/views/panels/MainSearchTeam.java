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
	private JTextField intCedula1;
	private JTextField intCedula2;
	private JTextField intCedula3;
	private JTextField intNombre1;
	private JTextField intNombre2;
	private JTextField intNombre3;
	private JTextField intTelefono1;
	private JTextField intTelefono2;
	private JTextField intTelefono3;
	private JTextField intDireccion1;
	private JTextField intDireccion2;
	private JTextField intDireccion3;
	private JTextField intCarrera1;
	private JTextField intCarrera2;
	private JTextField intCarrera3;
	private JTextField intFecha1;
	private JTextField intFecha2;
	private JTextField intFecha3;
	
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
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		JLabel lblNombre_2 = new JLabel("Nombre:");
		lblNombre_2.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Open Sans", Font.PLAIN, 12));
		
		intCedula1 = new JTextField();
		intCedula1.setEnabled(false);
		intCedula1.setEditable(false);
		intCedula1.setColumns(10);
		
		intCedula2 = new JTextField();
		intCedula2.setEnabled(false);
		intCedula2.setEditable(false);
		intCedula2.setColumns(10);
		
		intCedula3 = new JTextField();
		intCedula3.setEnabled(false);
		intCedula3.setEditable(false);
		intCedula3.setColumns(10);
		
		intNombre1 = new JTextField();
		intNombre1.setEnabled(false);
		intNombre1.setEditable(false);
		intNombre1.setColumns(10);
		
		intNombre2 = new JTextField();
		intNombre2.setEnabled(false);
		intNombre2.setEditable(false);
		intNombre2.setColumns(10);
		
		intNombre3 = new JTextField();
		intNombre3.setEnabled(false);
		intNombre3.setEditable(false);
		intNombre3.setColumns(10);
		
		intTelefono1 = new JTextField();
		intTelefono1.setEnabled(false);
		intTelefono1.setEditable(false);
		intTelefono1.setColumns(10);
		
		intTelefono2 = new JTextField();
		intTelefono2.setEnabled(false);
		intTelefono2.setEditable(false);
		intTelefono2.setColumns(10);
		
		intTelefono3 = new JTextField();
		intTelefono3.setEnabled(false);
		intTelefono3.setEditable(false);
		intTelefono3.setColumns(10);
		
		intDireccion1 = new JTextField();
		intDireccion1.setEnabled(false);
		intDireccion1.setEditable(false);
		intDireccion1.setColumns(10);
		
		intDireccion2 = new JTextField();
		intDireccion2.setEnabled(false);
		intDireccion2.setEditable(false);
		intDireccion2.setColumns(10);
		
		intDireccion3 = new JTextField();
		intDireccion3.setEnabled(false);
		intDireccion3.setEditable(false);
		intDireccion3.setColumns(10);
		
		intCarrera1 = new JTextField();
		intCarrera1.setEnabled(false);
		intCarrera1.setEditable(false);
		intCarrera1.setColumns(10);
		
		intCarrera2 = new JTextField();
		intCarrera2.setEnabled(false);
		intCarrera2.setEditable(false);
		intCarrera2.setColumns(10);
		
		intCarrera3 = new JTextField();
		intCarrera3.setEnabled(false);
		intCarrera3.setEditable(false);
		intCarrera3.setColumns(10);
		
		intFecha1 = new JTextField();
		intFecha1.setEnabled(false);
		intFecha1.setEditable(false);
		intFecha1.setColumns(10);
		
		intFecha2 = new JTextField();
		intFecha2.setEnabled(false);
		intFecha2.setEditable(false);
		intFecha2.setColumns(10);
		
		intFecha3 = new JTextField();
		intFecha3.setEnabled(false);
		intFecha3.setEditable(false);
		intFecha3.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
							.addContainerGap())
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
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED, 646, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCoach)
									.addPreferredGap(ComponentPlacement.RELATED, 656, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEstudiantes)
									.addPreferredGap(ComponentPlacement.RELATED, 617, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFechaCreacion)
										.addComponent(clasificacion)
										.addComponent(lblNombre)
										.addComponent(lblAreaExperticia)
										.addComponent(lblNombre_1)
										.addComponent(lblNewLabel_2)
										.addComponent(lblCedula)
										.addComponent(lblNombre_2)
										.addComponent(lblTelefono)
										.addComponent(lblDireccion)
										.addComponent(lblCarrera)
										.addComponent(lblFechaNacimiento))
									.addGap(7)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(intFecha1)
										.addComponent(intCarrera1)
										.addComponent(intDireccion1)
										.addComponent(intTelefono1)
										.addComponent(intNombre1)
										.addComponent(intCedula1)
										.addComponent(coachCargo)
										.addComponent(coachNombre)
										.addComponent(areaExpResult)
										.addComponent(clasificacionResult)
										.addComponent(fechaResult, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
										.addComponent(nombreTecnicoResult, Alignment.TRAILING))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(intCedula2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(intCedula3, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(intNombre2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(intNombre3, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(intTelefono2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(intTelefono3, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(intDireccion2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(intDireccion3, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(intCarrera2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(intCarrera3, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(intFecha2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(intFecha3, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))))
							.addContainerGap(90, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
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
						.addComponent(lblCedula)
						.addComponent(intCedula1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intCedula2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intCedula3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre_2)
						.addComponent(intNombre1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intNombre2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intNombre3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(intTelefono1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intTelefono2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intTelefono3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(intDireccion1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intDireccion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intDireccion3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarrera)
						.addComponent(intCarrera1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intCarrera2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intCarrera3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaNacimiento)
						.addComponent(intFecha1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intFecha2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intFecha3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
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
			arg.next();
			
			intCedula1.setText(arg.getString(1));
			intNombre1.setText(arg.getString(2));
			intTelefono1.setText(arg.getString(3));
			intDireccion1.setText(arg.getString(4));
			intCarrera1.setText(arg.getString(5));
			intFecha1.setText(arg.getString(6));
			
			arg.next();
			
			intCedula2.setText(arg.getString(1));
			intNombre2.setText(arg.getString(2));
			intTelefono2.setText(arg.getString(3));
			intDireccion2.setText(arg.getString(4));
			intCarrera2.setText(arg.getString(5));
			intFecha2.setText(arg.getString(6));
			
			arg.next();
			
			intCedula3.setText(arg.getString(1));
			intNombre3.setText(arg.getString(2));
			intTelefono3.setText(arg.getString(3));
			intDireccion3.setText(arg.getString(4));
			intCarrera3.setText(arg.getString(5));
			intFecha3.setText(arg.getString(6));
			
		} catch (SQLException e) {
			intCedula1.setText("");
			intNombre1.setText("");
			intTelefono1.setText("");
			intDireccion1.setText("");
			intCarrera1.setText("");
			intFecha1.setText("");
			intCedula2.setText("");
			intNombre2.setText("");
			intTelefono2.setText("");
			intDireccion2.setText("");
			intCarrera2.setText("");
			intFecha2.setText("");
			intCedula3.setText("");
			intNombre3.setText("");
			intTelefono3.setText("");
			intDireccion3.setText("");
			intCarrera3.setText("");
			intFecha3.setText("");
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
