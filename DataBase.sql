CREATE database if not exists chatCliSer;
use chatCliSer;

CREATE TABLE if not exists usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE if not exists mensajes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_remitente INT,
    id_destinatario INT,
    txtMensaje TEXT,
    FOREIGN KEY (id_remitente) REFERENCES Usuarios(id),
    FOREIGN KEY (id_destinatario) REFERENCES Usuarios(id)
);
