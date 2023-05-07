Tabla de modelo E/R
![normalizacion](https://user-images.githubusercontent.com/118363138/234532750-470c9419-51dd-4ebe-be3d-accf81249511.jpg)
Tabla de relación 
![Captura de pantalla 2023-04-24 092715](https://user-images.githubusercontent.com/118363138/233928011-1aaa831b-d2bf-44ed-ac7c-6fa8d83c0c35.jpg)
Normalización
[TRABAJO (1).pdf](https://github.com/ddrojovillalba/ProyectoIntegrador/files/11331213/TRABAJO.1.pdf)

SQL: Crear tabla 

drop table ciclo;
drop table alumno;
drop table proyecto_integrado; 

create table proyecto_integrado (
    id_proyecto number(3) generated always as identity, 
    nombre varchar2(50) not null, 
    URL varchar2(50), 
    nota number(3), 
    anio varchar2(10), 
    curso number constraint curso_check check (curso in (1, 2)), 
    grupo varchar2(20), 
    constraint id_proyecto_pk primary key (id_proyecto) 
);

create table ciclo (
    id_ciclo number (3) generated always as identity, 
    nombre varchar2(20),
    descripcion varchar2(100),
    id_proyecto number(5),
    constraint ciclo_id_ciclo_PK primary key (id_ciclo),
    constraint ciclo_Integrado_FK foreign key (id_proyecto) references Proyecto_Integrado (id_proyecto)

);

create table alumno (
    id_alumno number (20) generated always as identity, 
    num_expendiente varchar2 (10) not null, 
    nom_apellido varchar2(50) not null, 
    id_proyecto number(5),
    constraint id_alumno_pk primary key (id_alumno),
    constraint Proyecto_Integrado_FK foreign key (id_proyecto) references Proyecto_Integrado (id_proyecto)
);

insert into proyecto_integrado (nombre, URL, nota, anio, curso, grupo ) values ('Terraza', 'git', 8, '2023-2024', 1, 'DAW'); 
insert into proyecto_integrado (nombre, URL, nota, anio, curso, grupo ) values ('Hemana', 'git', 7, '2023-2024', 1, 'DAW');
insert into proyecto_integrado (nombre, URL, nota, anio, curso, grupo ) values ('EAC', 'git', 6, '2023-2024', 1, 'DAM');
insert into proyecto_integrado (nombre, URL, nota, anio, curso, grupo ) values ('Cocinero', 'git', 9, '2023-2024' , 1, 'ASIR');

insert into ciclo (nombre, descripcion) values ('DAW', 'Desarrollo de aplicaciones de web');
insert into ciclo (nombre, descripcion) values ('DAM', 'Desarrollo de aplicaciones en multiplataforma');
insert into ciclo (nombre, descripcion) values ('ASIR', 'Administración de Sistemas Informaticas');

insert into alumno(num_expendiente, nom_apellido, id_proyecto) values ('22A5223', 'Sandra Terresa', 1);
