package viewmodel.panels;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchTeam {
	public static ResultSet buscarEquipo(String nombreEquipo) {
		ResultSet result = null;
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT NombreEquipo, Clasificacion, FechaCreacion, AreaExpTecnico, CargoCoach ");
			SQLQuery.append("FROM Maraton.Equipo ");
			SQLQuery.append("WHERE NombreEquipo = ?;");
			
			PreparedStatement query = model.Conexion.log.prepareStatement(SQLQuery.toString());
			query.setString(1, nombreEquipo);
			result = query.executeQuery();
			return result;
		} catch (SQLException e) { 
			
		}
		return result;
	}
	
	public static ResultSet buscarEstudiantes(String nombreEquipo) {
		ResultSet result = null;
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT P.CI AS Cedula, P.Nombre AS Nombre, P.Telefono AS Telefono, P.Direccion AS Direccion, P.Carrera AS Carrera, P.FechaNac AS FechaDeNacimiento ");
			SQLQuery.append("FROM Maraton.Equipo T JOIN Maraton.Integrante P ");
			SQLQuery.append("ON T.NombreEquipo = P.NombreEquipo ");
			SQLQuery.append("WHERE T.NombreEquipo = ? ");
			SQLQuery.append("AND P.Tipo = 'Estudiante';");
			
			PreparedStatement query = model.Conexion.log.prepareStatement(SQLQuery.toString());
			query.setString(1, nombreEquipo);
			result = query.executeQuery();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static ResultSet buscarTecnico(String nombreEquipo) {
		ResultSet result = null;
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT P.Nombre ");
			SQLQuery.append("FROM Maraton.Equipo T JOIN Maraton.Integrante P ");
			SQLQuery.append("ON T.NombreEquipo = P.NombreEquipo ");
			SQLQuery.append("WHERE T.NombreEquipo = ? ");
			SQLQuery.append("AND P.Tipo = 'Tecnico';");
			
			PreparedStatement query = model.Conexion.log.prepareStatement(SQLQuery.toString());
			query.setString(1, nombreEquipo);
			result = query.executeQuery();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet buscarCoach(String nombreEquipo) {
		ResultSet result = null;
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT P.Nombre ");
			SQLQuery.append("FROM Maraton.Equipo T JOIN Maraton.Integrante P ");
			SQLQuery.append("ON T.NombreEquipo = P.NombreEquipo ");
			SQLQuery.append("WHERE T.NombreEquipo = ? ");
			SQLQuery.append("AND P.Tipo = 'Coach';");
			
			PreparedStatement query = model.Conexion.log.prepareStatement(SQLQuery.toString());
			query.setString(1, nombreEquipo);
			result = query.executeQuery();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
