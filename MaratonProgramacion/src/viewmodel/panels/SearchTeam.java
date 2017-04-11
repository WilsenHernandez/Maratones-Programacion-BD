package viewmodel.panels;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchTeam {
	public static ResultSet buscarEquipo(String nombreEquipo) {
		ResultSet result = null;
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT NombreEquipo, Clasificacion, FechaCreacion, AreaExpTecnico, CargoCoach ");
			SQLQuery.append("FROM Maraton.Equipo ");
			SQLQuery.append("WHERE NombreEquipo = '" + nombreEquipo+ "';");
			
			Statement query = model.Conexion.log.createStatement();
			result = query.executeQuery(SQLQuery.toString());
			return result;
		} catch (SQLException e) { 
			
		}
		return result;
	}
	
	public static ResultSet buscarEstudiantes(String nombreEquipo) {
		ResultSet result = null;
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT P.CI, P.Nombre, P.Telefono, P.Direccion, P.Carrera, P.FechaNac ");
			SQLQuery.append("FROM Maraton.Equipo T JOIN Maraton.Integrante P ");
			SQLQuery.append("ON T.NombreEquipo = P.NombreEquipo ");
			SQLQuery.append("WHERE T.NombreEquipo = '" + nombreEquipo + "' ");
			SQLQuery.append("AND P.Tipo = 'Estudiante' ;");
			
			Statement query = model.Conexion.log.createStatement();
			result = query.executeQuery(SQLQuery.toString());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
