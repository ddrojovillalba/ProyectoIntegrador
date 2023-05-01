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
    id_proyecto number(3) constraint proyecto_integrado_pk primary key, 
    nombre varchar2(50) not null, 
    URL varchar2(50), 
    nota number(3), 
    anio date, 
    curso varchar2(50), 
    grupo varchar2(20)
);

create table ciclo (
    id_ciclo number (3) constraint ciclo_pk primary key, 
    nombre varchar2(20),
    descripcion varchar2(20),
    id_proyecto number(5) not null,
    constraint ciclo_Integrado_FK foreign key (id_proyecto) references Proyecto_Integrado (id_proyecto)

);

create table alumno (
    id_alumno number (3) constraint alumno_pk primary key, 
    num_expendiente number (3) not null, 
    nom_apellido varchar2(50) not null, 
    id_proyecto number(5) not null,
    constraint Proyecto_Integrado_FK foreign key (id_proyecto) references Proyecto_Integrado (id_proyecto)
);

