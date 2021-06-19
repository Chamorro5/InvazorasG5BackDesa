CREATE SCHEMA IF NOT EXISTS invaZoras;

CREATE TABLE IF NOT EXISTS invaZoras.usuario (
	id_usuario SERIAL PRIMARY KEY,
	nombre VARCHAR(30) UNIQUE,
	correo VARCHAR (75) UNIQUE,
	clave VARCHAR (64),
	habilitado BOOLEAN,
	moderador BOOLEAN
	CONSTRAINT nombre_unique UNIQUE (nombre)
	CONSTRAINT correo_unique UNIQUE (correo)
);

CREATE TABLE IF NOT EXISTS invaZoras.planta (
	id_planta SERIAL PRIMARY KEY,
	nombre VARCHAR (50),
	descripcion VARCHAR (100),
	pais_siglas VARCHAR (3),
	pais VARCHAR (30)
);

CREATE TABLE IF NOT EXISTS invaZoras.incidencia (
	id_incidencia SERIAL PRIMARY KEY,
	fecha TIMESTAMP,
	CONSTRAINT fk_planta FOREIGN KEY (Id_planta) REFERENCES Plantas(Id_planta),
	valor_invasion SMALLINT,
	latitud NUMERIC (7,4),
	longitud NUMERIC (7,4),
	imagen BYTEA,
	CONSTRAINT fk_usuario FOREIGN KEY (Id_Usuario) REFERENCES Usuario(Id_Usuario),
	admitida BOOLEAN
);

CREATE SEQUENCE usuarios_id_serial START 1;

ALTER SEQUENCE usuarios_id_serial OWNED BY invaZoras.usuarios.id;

CREATE SEQUENCE incidencia_id_serial START 100000000;

ALTER SEQUENCE incidencia_id_serial OWNED BY invaZoras.incidencia.id;

CREATE SEQUENCE plantas_id_serial START 2000000000;

ALTER SEQUENCE plantas_id_serial OWNED BY invaZoras.plantas.id;


--CREATE TABLE IF NOT EXISTS usuario (
--	id_usuario SERIAL PRIMARY KEY,
--	nombre VARCHAR(30),
--	correo VARCHAR (75),
--	clave VARCHAR (64),
--	habilitado BOOLEAN,
--	moderador BOOLEAN
--);

--CREATE TABLE IF NOT EXISTS planta (
--	id_planta SERIAL PRIMARY KEY,
--	nombre VARCHAR (50),
--	descripcion VARCHAR (100),
--	pais_siglas VARCHAR (3),
--	pais VARCHAR (30)
--);

--CREATE TABLE IF NOT EXISTS incidencia (
--	id_incidencia SERIAL PRIMARY KEY,
--	fecha TIMESTAMP,
--	fk_planta INTEGER REFERENCES planta(Id_planta),
--	CONSTRAINT fk_planta FOREIGN KEY (id_planta) REFERENCES planta(Id_planta),
--	valor_invasion SMALLINT,
--	latitud NUMERIC (7,4),
--	longitud NUMERIC (7,4),
--	imagen BYTEA,
--	fk_usuario INTEGER REFERENCES usuario(Id_Usuario),
--	CONSTRAINT fk_usuario FOREIGN KEY (id_Usuario) REFERENCES usuario(Id_Usuario),
--	admitida BOOLEAN
	
--);

--CREATE SEQUENCE usuario_id_serial START 1;

--ALTER SEQUENCE usuario_id_serial OWNED BY usuario.id_usuario;

--CREATE SEQUENCE incidencia_id_serial START 100000000;

--ALTER SEQUENCE incidencia_id_serial OWNED BY incidencia.id_incidencia;

--CREATE SEQUENCE planta_id_serial START 2000000000;

--ALTER SEQUENCE planta_id_serial OWNED BY planta.id_planta;