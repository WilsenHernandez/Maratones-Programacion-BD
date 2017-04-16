package viewmodel.panels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainWelcome {
	public static ResultSet getCompetenciasRecientes() {
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT Sites, Fecha ");
			SQLQuery.append("FROM (SELECT Sites, Fecha, ROW_NUMBER() OVER (ORDER BY Fecha DESC) AS N FROM Maraton.Competencia) AS Sub ");
			SQLQuery.append("WHERE N <= 5;");
			
			PreparedStatement query = model.Conexion.log.prepareStatement(SQLQuery.toString());
			ResultSet result = query.executeQuery();
			return result;
		} catch (SQLException e) { 
			
		}
		return null;
	}
	
	public static ResultSet getEquiposRecientes() {
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT NombreEquipo, FechaCreacion ");
			SQLQuery.append("FROM (SELECT NombreEquipo, FechaCreacion, ROW_NUMBER() OVER (ORDER BY FechaCreacion DESC) AS N FROM Maraton.Equipo) AS Sub ");
			SQLQuery.append("WHERE N <= 10;");
			
			PreparedStatement query = model.Conexion.log.prepareStatement(SQLQuery.toString());
			ResultSet result = query.executeQuery();
			return result;
		} catch (SQLException e) { 
			
		}
		return null;
	}
}
