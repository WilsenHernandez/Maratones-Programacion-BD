package viewmodel.panels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchProblems {
	public static ResultSet getProblems(int codigo) {
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT * ");
			SQLQuery.append("FROM Maraton.Problemas P ");
			SQLQuery.append("WHERE P.CodigoProblema = ? ;");
			
			PreparedStatement query = model.Conexion.log.prepareStatement(SQLQuery.toString());
			query.setInt(1, codigo);
			ResultSet result = query.executeQuery();
			return result;
		} catch (SQLException e) { 
			
		}
		return null;
	}
}
