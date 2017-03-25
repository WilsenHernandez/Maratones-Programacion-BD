CREATE ROLE Coordinador NOSUPERUSER;
CREATE ROLE Programador NOSUPERUSER;

GRANT SELECT on SCHEMA Maraton-Progra to Coordinador; --Puede consultar todas las tablas
GRANT UPDATE on SCHEMA Maraton-Progra to Coordinador; --Puede modificar todas las tablas
GRANT DELETE on SCHEMA Maraton-Progra to Coordinador; -- Puede Borrar cualquier tabla

CREATE USER Coordinador NOSUPERUSER IN ROLE Coordinador PASSWORD '12345';
