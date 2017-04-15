\c maraton_progra

CREATE ROLE Coordinador NOSUPERUSER;
CREATE ROLE Programador NOSUPERUSER;
CREATE USER user1 NOSUPERUSER IN ROLE Coordinador PASSWORD '12345';
CREATE USER user2 NOSUPERUSER IN ROLE Programador PASSWORD '12345';
GRANT SELECT,UPDATE,DELETE ON ALL TABLES IN SCHEMA Maraton to Coordinador; --Puede consultar,modificar,y borrar todas las tablas

GRANT INSERT,SELECT ON Maraton.Integrante TO Programador; --Aqui solo debe ver e insertar su informacion personal y solo ver el de su coach y entrenador
GRANT INSERT,SELECT ON Maraton.Reporte TO Programador; -- Puede ver e insertar su informacion referida a los viajes
GRANT SELECT ON Maraton.Resuelve TO Programador; --Puede ver sus problemas resueltos
GRANT SELECT ON Maraton.Participa TO Programador;--  Puede ver su informacion sobre las competencia
GRANT SELECT ON Maraton.Equipo TO Programador;
GRANT SELECT ON Maraton.Competencia TO Programador;
GRANT SELECT ON Maraton.Recibe TO Programador;
GRANT SELECT ON Maraton.Problemas TO Programador;
GRANT SELECT ON Maraton.Entrenamiento TO Programador;
