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

CREATE TABLE Usuarios (
    idUsuario INT NOT NULL AUTO_INCREMENT,
    nombres VARCHAR(150),
    telefono INT,
    PRIMARY KEY(idUsuario)
);

CREATE TABLE Proyectos (
    idProyecto INT NOT NULL AUTO_INCREMENT,
    nombreProyecto VARCHAR(150) NOT NULL,
    descripcionProyecto VARCHAR(400) NOT NULL,
    Usuarios_idUsuarios INT,
    PRIMARY KEY(idProyecto),
    FOREIGN KEY (Usuarios_idUsuarios) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE ProyectosDelUsuarios (
    Proyectos_idProyecto INT,
    Proyectos_Usuarios_idUsuarios INT,
    PRIMARY KEY (Proyectos_idProyecto, Proyectos_Usuarios_idUsuarios),
    FOREIGN KEY (Proyectos_idProyecto) REFERENCES Proyectos(idProyecto),
    FOREIGN KEY (Proyectos_Usuarios_idUsuarios) REFERENCES Usuarios(idUsuario)
);


CREATE TABLE Objetivos (
    idObjetivos INT NOT NULL AUTO_INCREMENT,
    objetivo VARCHAR(400) NOT NULL,
    PRIMARY KEY(idObjetivos)
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
    idAlternativa INT NOT NULL AUTO_INCREMENT,
    nombreAlternativa VARCHAR(150) NOT NULL,
    descripcionAlternativa VARCHAR(400) NOT NULL,
    prosAlternativa VARCHAR(200) NOT NULL,
    contrasAlternativa VARCHAR(200) NOT NULL,
    costoAlternativa DECIMAL(10, 2) NOT NULL,
    tiempoDeImplementacion INT NOT NULL,
    Proyectos_idProyecto INT NOT NULL,
    Proyectos_Usuarios_idUsuarios INT NOT NULL,
    PRIMARY KEY(idAlternativa),
    FOREIGN KEY (Proyectos_idProyecto) REFERENCES Proyectos(idProyecto),
    FOREIGN KEY (Proyectos_Usuarios_idUsuarios) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE Cambios (
    idCambios INT NOT NULL AUTO_INCREMENT,
    nombreCambio VARCHAR(100) NOT NULL,
    descripcion VARCHAR(400) NOT NULL,
    Proyectos_idProyecto INT,
    PRIMARY KEY(idCambios),
    FOREIGN KEY (Proyectos_idProyecto) REFERENCES Proyectos(idProyecto)
);


CREATE TABLE Justificaciones (
    idJustificaciones INT NOT NULL AUTO_INCREMENT,
    descripcionDeLaJustificacion VARCHAR(400) NOT NULL,
    Cambios_idCambios INT,
    Cambios_Proyectos_idProyecto INT,
    PRIMARY KEY(idJustificaciones),
    FOREIGN KEY (Cambios_idCambios) REFERENCES Cambios(idCambios),
    FOREIGN KEY (Cambios_Proyectos_idProyecto) REFERENCES Proyectos(idProyecto)
);


