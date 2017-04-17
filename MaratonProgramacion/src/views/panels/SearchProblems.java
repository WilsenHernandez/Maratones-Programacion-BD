package views.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class SearchProblems extends JPanel {
	private JTextField codigo;
	private JTextField site;
	private JTextField fecha;
	private JTextField dificultad;
	private JTextField tiempoLimite;
	private JTextArea enunciado;
	
	/**
	 * Create the panel.
	 */
	public SearchProblems() {
		
		JLabel lblBuscarProblemas = new JLabel("Buscar Problemas");
		lblBuscarProblemas.setFont(new Font("Open Sans", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblCodigoDeProblema = new JLabel("Codigo de Problema");
		
		codigo = new JTextField();
		codigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int cod = Integer.parseInt(codigo.getText());
					mostrarProblema(viewmodel.panels.SearchProblems.getProblems(cod));
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		codigo.setColumns(5);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int cod = Integer.parseInt(codigo.getText());
					mostrarProblema(viewmodel.panels.SearchProblems.getProblems(cod));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		JLabel lblAparecioEn = new JLabel("Aparecio en:");
		
		site = new JTextField();
		site.setEditable(false);
		site.setEnabled(false);
		site.setColumns(10);
		
		fecha = new JTextField();
		fecha.setEditable(false);
		fecha.setEnabled(false);
		fecha.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		
		enunciado = new JTextArea();
		enunciado.setEnabled(false);
		enunciado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		enunciado.setWrapStyleWord(true);
		enunciado.setLineWrap(true);
		
		JLabel lblDificultad = new JLabel("Dificultad:");
		
		dificultad = new JTextField();
		dificultad.setEnabled(false);
		dificultad.setEditable(false);
		dificultad.setColumns(10);
		
		tiempoLimite = new JTextField();
		tiempoLimite.setEnabled(false);
		tiempoLimite.setEditable(false);
		tiempoLimite.setColumns(10);
		
		JLabel lblTiempoLimite = new JLabel("Tiempo limite:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(lblBuscarProblemas)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCodigoDeProblema)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(codigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDescripcion)
										.addComponent(lblDificultad)
										.addComponent(lblTiempoLimite))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(dificultad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tiempoLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(enunciado, GroupLayout.PREFERRED_SIZE, 249, Short.MAX_VALUE)))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblAparecioEn)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(site, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(131)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBuscarProblemas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(codigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigoDeProblema)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(site, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAparecioEn)
						.addComponent(fecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcion)
						.addComponent(enunciado, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDificultad)
						.addComponent(dificultad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tiempoLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTiempoLimite))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	private void mostrarProblema(ResultSet arg) {
		try {
			arg.next();
			enunciado.setText(arg.getString(2));
			dificultad.setText(arg.getString(3));
			tiempoLimite.setText(arg.getString(4));
			site.setText(arg.getString(5));
			fecha.setText(arg.getString(6));			
		} catch (Exception e) {
			e.printStackTrace();
			enunciado.setText("");
			dificultad.setText("");
			tiempoLimite.setText("");
			site.setText("");
			fecha.setText("");
		}
	}
}
