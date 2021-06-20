--CREATE SCHEMA IF NOT EXISTS invaZoras;


CREATE TABLE IF NOT EXISTS usuario (
	id_usuario SERIAL PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	correo VARCHAR (75) NOT NULL,
	clave VARCHAR (64) NOT NULL,
	habilitado BOOLEAN NOT NULL,
	moderador BOOLEAN NOT NULL,
	CONSTRAINT nombre_unique UNIQUE (nombre),
	CONSTRAINT correo_unique UNIQUE (correo)
);

CREATE TABLE IF NOT EXISTS planta (
	id_planta SERIAL PRIMARY KEY,
	nombre VARCHAR (50) NOT NULL,
	descripcion VARCHAR (100) NOT NULL,
	pais_siglas VARCHAR (3) NOT NULL,
	pais VARCHAR (30) NOT NULL
);

CREATE TABLE IF NOT EXISTS incidencia (
	id_incidencia SERIAL PRIMARY KEY,
	fecha TIMESTAMP,
	fk_planta INTEGER REFERENCES planta(Id_planta) NOT NULL,
--	CONSTRAINT fk_planta FOREIGN KEY (id_planta) REFERENCES planta(Id_planta),
	valor_invasion SMALLINT NOT NULL,
	latitud NUMERIC (7,4) NOT NULL,
	longitud NUMERIC (7,4) NOT NULL,
	imagen BYTEA NOT NULL,
	fk_usuario INTEGER REFERENCES usuario(Id_Usuario) NOT NULL,
--	CONSTRAINT fk_usuario FOREIGN KEY (id_Usuario) REFERENCES usuario(Id_Usuario),
	admitida BOOLEAN NOT NULL
	
);

CREATE SEQUENCE usuario_id_serial START 1;

ALTER TABLE usuario ALTER COLUMN id_usuario SET DEFAULT nextval('usuario_id_serial');

ALTER TABLE usuario ALTER COLUMN id_usuario SET NOT NULL;

ALTER SEQUENCE usuario_id_serial OWNED BY usuario.id_usuario;

CREATE SEQUENCE incidencia_id_serial START 100000000;

ALTER TABLE incidencia ALTER COLUMN id_incidencia SET DEFAULT nextval('incidencia_id_serial');

ALTER TABLE incidencia ALTER COLUMN id_incidencia SET NOT NULL;

ALTER SEQUENCE incidencia_id_serial OWNED BY incidencia.id_incidencia;

CREATE SEQUENCE planta_id_serial START 2000000000;

ALTER TABLE planta ALTER COLUMN id_planta SET DEFAULT nextval('planta_id_serial');

ALTER TABLE planta ALTER COLUMN id_planta SET NOT NULL;

ALTER SEQUENCE planta_id_serial OWNED BY planta.id_planta;

INSERT INTO USUARIO (nombre, correo, clave, habilitado, moderador) VALUES ('Prueba', 'prueba@correo.es', 'Prueba12#', false, false);

INSERT INTO PLANTA (nombre, descripcion, pais_siglas, pais) VALUES ('Árbol del cielo', 'Ailanthus altissima', 'ES', 'España');
INSERT INTO PLANTA (nombre, descripcion, pais_siglas, pais) VALUES ('Viña del Tíbet', 'Fallopia baldschuanica', 'ES', 'España');
INSERT INTO PLANTA (nombre, descripcion, pais_siglas, pais) VALUES ('Jengibre blanco', 'Hedychium gardnerianum', 'ES', 'España');
INSERT INTO PLANTA (nombre, descripcion, pais_siglas, pais) VALUES ('Lirio amarillo', 'Nymphaea mexicana', 'ES', 'España');
INSERT INTO PLANTA (nombre, descripcion, pais_siglas, pais) VALUES ('Espartillo', 'Spartina densiflora', 'ES', 'España');