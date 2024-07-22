-- Active: 1721661117926@@localhost@3306@sistemaDeFundamentacion
CREATE DATABASE sistemaDeFundamentacion;

USE sistemaDeFundamentacion;

DROP TABLE IF EXISTS Justificaciones;

DROP TABLE IF EXISTS Cambios;

DROP TABLE IF EXISTS Alternativas;

DROP TABLE IF EXISTS ObjetivosDeProyectos;

DROP TABLE IF EXISTS ProyectosDelUsuarios;

DROP TABLE IF EXISTS Proyectos;

DROP TABLE IF EXISTS Objetivos;

DROP TABLE IF EXISTS Usuarios;

SELECT * FROM Usuarios;

SELECT * FROM Proyectos;

SELECT * FROM ProyectosDelUsuarios;

SELECT * FROM Objetivos;

SELECT * FROM ObjetivosDeProyectos;

SELECT * FROM Alternativas;

SELECT * FROM Cambios;

SELECT * FROM Justificaciones;


CREATE TABLE Usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    telefono INT NOT NULL,
    password VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Proyectos (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(400) NOT NULL,
    idUsuario INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idUsuario) REFERENCES Usuarios(id)
);

CREATE TABLE ProyectosDeUsuarios (
    idProyecto INT NOT NULL,
    idUsuario INT NOT NULL,
    PRIMARY KEY (idProyecto, idUsuario),
    FOREIGN KEY (idProyecto) REFERENCES Proyectos(id),
    FOREIGN KEY (idUsuario) REFERENCES Usuarios(id)
);


CREATE TABLE Objetivos (
    idObjetivos INT PRIMARY KEY,
    objetivo VARCHAR(400)
);

CREATE TABLE ObjetivosDeProyectos (
    Objetivos_idObjetivos INT,
    Proyectos_idProyecto INT,
    Proyectos_Usuarios_idUsuarios INT,
    PRIMARY KEY (Objetivos_idObjetivos, Proyectos_idProyecto, Proyectos_Usuarios_idUsuarios),
    FOREIGN KEY (Objetivos_idObjetivos) REFERENCES Objetivos(idObjetivos),
    FOREIGN KEY (Proyectos_idProyecto) REFERENCES Proyectos(idProyecto),
    FOREIGN KEY (Proyectos_Usuarios_idUsuarios) REFERENCES Usuarios(idUsuario)
);


CREATE TABLE Alternativas (
    idAlternativa INT PRIMARY KEY,
    nombreAlternativa VARCHAR(150),
    descripcionAlternativa VARCHAR(400),
    prosAlternativa VARCHAR(200),
    contrasAlternativa VARCHAR(200),
    costoAlternativa DECIMAL(10, 2),
    tiempoDeImplementacion INT,
    Proyectos_idProyecto INT,
    Proyectos_Usuarios_idUsuarios INT,
    FOREIGN KEY (Proyectos_idProyecto) REFERENCES Proyectos(idProyecto),
    FOREIGN KEY (Proyectos_Usuarios_idUsuarios) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE Cambios (
    idCambios INT PRIMARY KEY,
    nombreCambio VARCHAR(100),
    descripcion VARCHAR(400),
    Proyectos_idProyecto INT,
    FOREIGN KEY (Proyectos_idProyecto) REFERENCES Proyectos(idProyecto)
);


CREATE TABLE Justificaciones (
    idJustificaciones INT PRIMARY KEY,
    descripcionDeLaJustificacion VARCHAR(400),
    Cambios_idCambios INT,
    Cambios_Proyectos_idProyecto INT,
    FOREIGN KEY (Cambios_idCambios) REFERENCES Cambios(idCambios),
    FOREIGN KEY (Cambios_Proyectos_idProyecto) REFERENCES Proyectos(idProyecto)
);


