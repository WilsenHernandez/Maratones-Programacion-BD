--Test de consultas



--Esto es la consulta 1
SELECT CI,Nombre,Direccion
FROM (
		SELECT  	distinct I.CI,
				I.Nombre,
				I.Direccion,
				COUNT(P.Fecha) OVER(PARTITION BY I.CI) AS Cantidad
		FROM	Maraton.Integrante AS I JOIN Maraton.Participa AS P ON P.NombreEquipo = I.NombreEquipo
		GROUP BY CI,Fecha
		ORDER BY Cantidad DESC, CI
		
		
	) as RA
WHERE Cantidad = (SELECT Max(Cantidad)
			FROM (SELECT  	distinct I.CI,
				I.Nombre,
				I.Direccion,
				COUNT(P.Fecha) OVER(PARTITION BY I.CI) AS Cantidad
		FROM	Maraton.Integrante AS I JOIN Maraton.Participa AS P ON P.NombreEquipo = I.NombreEquipo
		GROUP BY CI,Fecha
		ORDER BY Cantidad DESC, CI) RE) ;

--Esto son todos los usuarios con sus respectivas veces en que participaron

SELECT  	distinct I.CI,
				I.Nombre,
				I.Direccion,
				COUNT(P.Fecha) OVER(PARTITION BY I.CI) AS Cantidad
		FROM	Maraton.Integrante AS I JOIN Maraton.Participa AS P ON P.NombreEquipo = I.NombreEquipo
		GROUP BY CI,Fecha
		ORDER BY Cantidad DESC, CI
