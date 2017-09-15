package viewmodel.panels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainTopTeams {
	public static ResultSet getTopTeams() {
		try {
			StringBuilder SQLQuery = new StringBuilder();
			SQLQuery.append("SELECT CI,Nombre,Direccion, Cantidad ");
			SQLQuery.append("FROM ( SELECT distinct I.CI, I.Nombre, I.Direccion, COUNT(P.Fecha) OVER(PARTITION BY I.CI) AS Cantidad ");
			SQLQuery.append("FROM	Maraton.Integrante AS I JOIN Maraton.Participa AS P ON P.NombreEquipo = I.NombreEquipo ");
			SQLQuery.append("GROUP BY CI,Fecha ");
			SQLQuery.append("ORDER BY Cantidad DESC, CI) RA ");
			SQLQuery.append("WHERE Cantidad = (SELECT Max(Cantidad) FROM (SELECT distinct I.CI, I.Nombre, I.Direccion, ");
			SQLQuery.append("COUNT(P.Fecha) OVER(PARTITION BY I.CI) AS Cantidad ");
			SQLQuery.append("FROM	Maraton.Integrante AS I JOIN Maraton.Participa AS P ON P.NombreEquipo = I.NombreEquipo ");
			SQLQuery.append("GROUP BY CI,Fecha ");
			SQLQuery.append("ORDER BY Cantidad DESC, CI) RE);");
			
			PreparedStatement query = model.Conexion.log.prepareStatement(SQLQuery.toString());
			ResultSet result = query.executeQuery();
			return result;
		} catch (SQLException e) { 
			
		}
		return null;
	}

}
