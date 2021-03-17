create table funcionario (
 idFuncionario int(11) not null auto_increment,
 nombre varchar(100) not null,
 cedula varchar(45) not null,
 salario DOUBLE not null,
 fechaNacimiento DATE not null,
 fechaIngreso DATE not null,
 primary key (idFuncionario)
);


create table solicitud (
 idFuncionario int(11) not null,
 numSolicitud int(11) not null auto_increment,
 fechaSolicitud DATE,
 justificacion VARCHAR(200),
 estado VARCHAR(20),
 respuesta VARCHAR(200),
 primary key (numSolicitud)
);

create table dia_festivo (
codigoFecha int(11) not null auto_increment,
dia VARCHAR(200),
fecha DATE,
primary key (codigoFecha)
)