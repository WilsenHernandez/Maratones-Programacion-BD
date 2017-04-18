SELECT NombreEquipo, ROW_NUMBER() OVER(PARTITION BY NombreEquipo
                              ORDER BY Clasificacion) AS Orden
FROM Maraton.Equipo
ORDER BY Orden, CAST(SUBSTRING(NombreEquipo FROM 7) AS INTEGER);

