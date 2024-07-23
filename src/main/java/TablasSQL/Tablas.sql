-- Active: 1721661117926@@localhost@3306@sistemaDeFundamentacion
CREATE DATABASE sistemaDeFundamentacion;

USE sistemaDeFundamentacion;

DROP TABLE IF EXISTS Cambios;

DROP TABLE IF EXISTS Alternativas;

DROP TABLE IF EXISTS Objetivos;

DROP TABLE IF EXISTS Proyectos;

DROP TABLE IF EXISTS Usuarios;

SELECT * FROM Usuarios;

SELECT * FROM Proyectos;

SELECT * FROM Objetivos;

SELECT * FROM Alternativas;

SELECT * FROM Cambios;

CREATE TABLE Usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    telefono INT NOT NULL,
    password VARCHAR(150) NOT NULL,
    acceso BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Proyectos (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(400) NOT NULL,
    idUsuario INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (idUsuario) REFERENCES Usuarios(id) ON DELETE CASCADE
);


CREATE TABLE Objetivos (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(400) NOT NULL,
    idProyecto INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (idProyecto) REFERENCES Proyectos(id) ON DELETE CASCADE
);


CREATE TABLE Alternativas (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(400) NOT NULL,
    pros VARCHAR(200) NOT NULL,
    contras VARCHAR(200) NOT NULL,
    costo DECIMAL(10, 2) NOT NULL,
    tiempoDeImplementacion INT NOT NULL,
    categoria VARCHAR(150) NOT NULL,
    idProyecto INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (idProyecto) REFERENCES Proyectos(id) ON DELETE CASCADE
);

CREATE TABLE Cambios (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(400) NOT NULL,
    justificacion VARCHAR(400) NOT NULL,
    idProyecto INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (idProyecto) REFERENCES Proyectos(id) ON DELETE CASCADE
);


