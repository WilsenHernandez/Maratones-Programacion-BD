CREATE DATABASE maraton_progra TEMPLATE template1;

\c maraton_progra

CREATE SCHEMA Maraton;

CREATE DOMAIN Maraton.Cedula VARCHAR(16);
CREATE DOMAIN Maraton.NombreEquipo VARCHAR(48);

CREATE TABLE Maraton.Equipo(
	NombreEquipo 		Maraton.NombreEquipo,
	AreaExpTecnico 		VARCHAR(48)		NOT NULL,
	Clasificacion 		INT				NOT NULL,
	FechaCreacion 		DATE			NOT NULL,
	CargoCoach		 	VARCHAR(48)			NOT NULL,
	CONSTRAINT PK_Equipo PRIMARY KEY (NombreEquipo)
);

CREATE TABLE Maraton.Integrante(
	CI 					Maraton.Cedula,
	Nombre 				VARCHAR(48)		NOT NULL,
	Telefono 			VARCHAR(16)			NOT NULL,
	Direccion 			VARCHAR(128)	NOT NULL,
	Carrera		 		VARCHAR(48)		NOT NULL,
	Tipo				VARCHAR(11)		NOT NULL,
	FechaNac			DATE			NOT NULL,
	NombreEquipo		Maraton.NombreEquipo,
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
	Sites				VARCHAR(128)			,
	Fecha				DATE					,
	Region				VARCHAR(128)	NOT NULL,
	Nivel				VARCHAR(48)		NOT NULL,
	Duracion			TIME			NOT NULL,
	HoraInicio			TIME			NOT NULL,
	CONSTRAINT PK_Competencia PRIMARY KEY (Sites,Fecha)
);

CREATE TABLE Maraton.Problemas(
	CodigoProblema		INT						,
	Enunciado			VARCHAR(2048)	NOT NULL,
	Dificultad			VARCHAR(48)		NOT NULL,
	TiempoLimiteSol		TIME			NOT NULL,
	Region				VARCHAR(128)			,
	Fecha				DATE					,
	CONSTRAINT PK_Problemas PRIMARY KEY (CodigoProblema),
	CONSTRAINT FK_Problemas FOREIGN KEY (Sites,Fecha) REFERENCES Maraton.Competencia(Sites,Fecha)
);
CREATE TABLE Maraton.Reporte(
	CI_Integrante		Maraton.Cedula,
	Lugar				VARCHAR(128)			,
	Fecha				DATE					,
	Libros				VARCHAR(128)	NOT NULL,
	Financia			VARCHAR(48)		NOT NULL,
	Sitios				VARCHAR(128)	NOT NULL,
	Otros				VARCHAR(48)		NOT NULL,
	CONSTRAINT PK_Reporte PRIMARY KEY (Lugar,Fecha),
	CONSTRAINT FK_Reporte FOREIGN KEY (CI_Integrante) REFERENCES Maraton.Integrante(CI)
);

CREATE TABLE Maraton.Incentivo_Integrante(
	CI_Incentivado		Maraton.Cedula,
	Incentivos			VARCHAR(128),
	CONSTRAINT PK_Incentivo_Integrante PRIMARY KEY (CI_Incentivado,Incentivos),
	CONSTRAINT FK_Incentivo_Integrante FOREIGN KEY (CI_Incentivado) REFERENCES Maraton.Integrante(CI)
);

CREATE TABLE Maraton.Incidente_Viaje(
	CI_Integrante		Maraton.Cedula,
	Lugar				VARCHAR(128),
	Fecha				DATE,
	Incidente			VARCHAR(160)	NOT NULL,
	CONSTRAINT PK_Incidente_Viaje PRIMARY KEY (CI_Integrante,Lugar,Fecha),
	CONSTRAINT FK_Incidente_Viaje FOREIGN KEY (CI_Integrante) REFERENCES Maraton.Integrante(CI),
	CONSTRAINT FK_Incidente_Viaje2 FOREIGN KEY (Lugar,Fecha) REFERENCES Maraton.Reporte(Lugar,Fecha)
);

CREATE TABLE Maraton.Recibe(
	NombreEquipo		Maraton.NombreEquipo,
	Tipo				VARCHAR(128),
	Fecha				DATE,
	CONSTRAINT PK_Recibe PRIMARY KEY (NombreEquipo,Tipo,Fecha),
	CONSTRAINT FK_Recibe FOREIGN KEY (NombreEquipo) REFERENCES Maraton.Equipo(NombreEquipo),
	CONSTRAINT FK_Recibe2 FOREIGN KEY (Tipo,Fecha) REFERENCES Maraton.Entrenamiento(Tipo,Fecha)
);

CREATE TABLE Maraton.Participa(
	NombreEquipo		Maraton.NombreEquipo,
	Region				VARCHAR(128)			,
	Fecha				DATE					,
	Ranking				INT 			NOT NULL,
	CONSTRAINT PK_Participa PRIMARY KEY (NombreEquipo,Region,Fecha),
	CONSTRAINT FK_Participa FOREIGN KEY (NombreEquipo) REFERENCES Maraton.Equipo(NombreEquipo),
	CONSTRAINT FK_Participa2 FOREIGN KEY (Sites,Fecha) REFERENCES Maraton.Competencia(Sites,Fecha)
);

CREATE TABLE Maraton.Resuelve(
	NombreEquipo		Maraton.NombreEquipo,
	CodigoProblema		INT,
	Fecha				DATE			NOT NULL,
	HoraEntrega			TIME			NOT NULL,
	TipoSolucion		VARCHAR(48)		NOT NULL,
	Lenguaje			VARCHAR(48)		NOT NULL,
	TiempoSolucion		TIME			NOT NULL,
	CONSTRAINT PK_Resuelve PRIMARY KEY (NombreEquipo,CodigoProblema),
	CONSTRAINT FK_Resuelve FOREIGN KEY (NombreEquipo) REFERENCES Maraton.Equipo(NombreEquipo),
	CONSTRAINT FK_Resuelve2 FOREIGN KEY (CodigoProblema) REFERENCES Maraton.Problemas(CodigoProblema)
);
