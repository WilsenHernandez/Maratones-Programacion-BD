CREATE DATABASE Maraton-Progra TEMPLATE template1;

\c Maraton-Progra

CREATE SCHEMA Maraton;


CREATE TABLE Maraton.Equipo(
	NombreEquipo 		VARCHAR(48),
	AreaExpTecnico 		VARCHAR(48)		NOT NULL,
	Clasificacion 		INT				NOT NULL,
	FechaCreacion 		DATE			NOT NULL,
	CargoCoach		 	DATE			NOT NULL,
	CONSTRAINT PK_Equipo PRIMARY KEY (NombreEquipo)
);

CREATE TABLE Maraton.Integrante(
	CI 					VARCHAR(16)				,
	Nombre 				VARCHAR(48)		NOT NULL,
	Telefono 			INT				NOT NULL,
	Direccion 			VARCHAR(128)	NOT NULL,
	Carrera		 		VARCHAR(48)		NOT NULL,
	Tipo				VARCHAR(11)		NOT NULL,
	FechaNac			DATE			NOT NULL,
	NombreEquipo		VARCHAR(48)				,
	CONSTRAINT PK_Integrante PRIMARY KEY (CI),
	CONSTRAINT FK_Integrante FOREIGN KEY (NombreEquipo) REFERENCES Maraton.Equipo(NombreEquipo),
	CONSTRAINT CK_Maraton_Integrante_Tipo CHECK(tipo IN ('Estudiante','Coach','Tecnico'))
);

CREATE TABLE Maraton.Entrenamiento(
	Tipo				VARCHAR(128)			,
	Fecha				DATE					,
	CONSTRAINT PK_Entrenamiento PRIMARY KEY (Tipo,Fecha)
);

CREATE TABLE Maraton.Competencia(
	Region				VARCHAR(128)			,
	Fecha				DATE					,
	Sites				VARCHAR(128)	NOT NULL,
	Nivel				INT				NOT NULL,
	Duracion			TIME			NOT NULL,
	HoraInicio			TIME			NOT NULL,
	CONSTRAINT PK_Competencia PRIMARY KEY (Region,Fecha)
);

CREATE TABLE Maraton.Problemas(
	CodigoProblema		INT						,
	Enunciado			VARCHAR(2048)	NOT NULL,
	Dificultad			VARCHAR(48)		NOT NULL,
	TiempoLimiteSol		TIME			NOT NULL,
	Region				VARCHAR(128)			,
	Fecha				DATE					,
	CONSTRAINT PK_Problemas PRIMARY KEY (CodigoProblema),
	CONSTRAINT FK_Problemas FOREIGN KEY (Region,Fecha) REFERENCES Maraton.Competencia(Region,Fecha)
);
CREATE TABLE Maraton.Reporte(
	CI-Integrante		VARCHAR(48)				,
	Lugar				VARCHAR(128)			,
	Fecha				DATE					,
	Libros				VARCHAR(128)	NOT NULL,
	Financia			VARCHAR(48)		NOT NULL,
	Sitios				VARCHAR(128)	NOT NULL,
	Otros				VARCHAR(48)		NOT NULL,
	CONSTRAINT PK_Reporte PRIMARY KEY (Lugar,Fecha),
	CONSTRAINT FK_Reporte FOREIGN KEY (CI-Integrante) REFERENCES Maraton.Integrante(CI)
);

CREATE TABLE Maraton.Incentivo-Integrante(
	CI-Incentivado		VARCHAR(48)
	Incentivos			VARCHAR(128)
	CONSTRAINT PK_Incentivo-Integrante PRIMARY KEY (CI-Incentivado,Incentivos),
	CONSTRAINT FK_Incentivo-Integrante FOREIGN KEY (CI-Incentivado) REFERENCES Maraton.Integrante(CI)
);

CREATE TABLE Maraton.Incidente-Viaje(
	CI-Integrante		VARCHAR(48),
	Lugar				VARCHAR(128),
	Fecha				DATE,
	Incidente			VARCHAR(160)	NOT NULL,
	CONSTRAINT PK_Incidente-Viaje PRIMARY KEY (CI-Integrante,Lugar,Fecha),
	CONSTRAINT FK_Incidente-Viaje FOREIGN KEY (CI-Integrante) REFERENCES Maraton.Integrante(CI),
	CONSTRAINT FK_Incidente-Viaje2 FOREIGN KEY (Lugar,Fecha) REFERENCES Maraton.Reporte(Lugar,Fecha)
);

CREATE TABLE Maraton.Recibe(
	NombreEquipo		VARCHAR(48),
	Tipo				VARCHAR(128),
	Fecha				DATE,
	CONSTRAINT PK_Recibe PRIMARY KEY (NombreEquipo,Tipo,Fecha),
	CONSTRAINT FK_Recibe FOREIGN KEY (NombreEquipo) REFERENCES Maraton.Equipo(NombreEquipo),
	CONSTRAINT FK_Recibe2 FOREIGN KEY (Tipo,Fecha) REFERENCES Maraton.Entrenamiento(Tipo,Fecha)
);

CREATE TABLE Maraton.Participa(
	NombreEquipo		VARCHAR(48)				,
	Region				VARCHAR(128)			,
	Fecha				DATE					,
	Ranking				INT 			NOT NULL,
	CONSTRAINT PK_Participa PRIMARY KEY (NombreEquipo,Region,Fecha),
	CONSTRAINT FK_Participa FOREIGN KEY (NombreEquipo) REFERENCES Maraton.Equipo(NombreEquipo),
	CONSTRAINT FK_Participa2 FOREIGN KEY (Region,Fecha) REFERENCES Maraton.Competencia(Region,Fecha)
);

CREATE TABLE Maraton.Resuelve(
	NombreEquipo		VARCHAR(48)
	CodigoProblema		INT
	Fecha				DATE			NOT NULL
	HoraEntrega			TIME			NOT NULL,
	TipoSolucion		VARCHAR(48)		NOT NULL,
	Lenguaje			VARCHAR(48)		NOT NULL,
	TiempoSolucion		TIME			NOT NULL,
	CONSTRAINT PK_Resuelve PRIMARY KEY (NombreEquipo,CodigoProblema),
	CONSTRAINT FK_Resuelve FOREIGN KEY (NombreEquipo) REFERENCES Maraton.Equipo(NombreEquipo),
	CONSTRAINT FK_Resuelve2 FOREIGN KEY (CodigoProblema) REFERENCES Maraton.Problemas(CodigoProblema)
);
