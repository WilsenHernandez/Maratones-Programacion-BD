/* Diga el nombre, cédula y dirección del estudiante de FaCyT que ha 
participado en más maratones de programación a lo largo de la 
historia.  */

SELECT CI,Nombre,Direccion, Cantidad
FROM (
		SELECT  	distinct I.CI,
				I.Nombre,
				I.Direccion,
				COUNT(P.Fecha) OVER(PARTITION BY I.CI) AS Cantidad
		FROM	Maraton.Integrante AS I JOIN Maraton.Participa AS P ON P.NombreEquipo = I.NombreEquipo
		GROUP BY CI,Fecha
		ORDER BY Cantidad DESC, CI
		
		
	) RA
WHERE Cantidad = (SELECT Max(Cantidad)
			FROM (SELECT  	distinct I.CI,
				I.Nombre,
				I.Direccion,
				COUNT(P.Fecha) OVER(PARTITION BY I.CI) AS Cantidad
		FROM	Maraton.Integrante AS I JOIN Maraton.Participa AS P ON P.NombreEquipo = I.NombreEquipo
		GROUP BY CI,Fecha
		ORDER BY Cantidad DESC, CI) RE) ;
