SELECT NombreEquipo, Orden
FROM (SELECT NombreEquipo, ROW_NUMBER() OVER(ORDER BY Clasificacion) AS Orden
FROM Maraton.Equipo
ORDER BY Orden, CAST(SUBSTRING(NombreEquipo FROM 7) AS INTEGER)) AS RA
WHERE Orden <= 10;

