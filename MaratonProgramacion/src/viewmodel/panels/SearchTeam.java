package viewmodel.panels;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchTeam {
	public static ResultSet buscarEquipo(String nombreEquipo) {
		ResultSet result = null;
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT NombreEquipo, Clasificacion, FechaCreacion ");
			SQLQuery.append("FROM Maraton.Equipo ");
			SQLQuery.append("WHERE NombreEquipo = '" + nombreEquipo+ "';");
			
			Statement query = model.Conexion.log.createStatement();
			result = query.executeQuery(SQLQuery.toString());
		} catch (SQLException e) { 
			
		}
		return result;
	}
	
	public static ResultSet buscarIntergrantes(String nombreEquipo) {
		ResultSet result = null;
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT NombreEquipo, Clasificacion, FechaCreacion ");
			SQLQuery.append("FROM Maraton.Equipo ");
			SQLQuery.append("WHERE NombreEquipo = '" + nombreEquipo+ "';");
			
			Statement query = model.Conexion.log.createStatement();
			result = query.executeQuery(SQLQuery.toString());
		} catch (SQLException e) {
			
		}
		return result;
	}

}
