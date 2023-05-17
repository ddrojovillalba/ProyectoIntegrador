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

# Base de Datos del Proyecto Integrador

Este archivo `README.md` proporciona una descripción detallada de todo lo relacionado con la base de datos en nuestro Proyecto Integrador. Hemos diseñado e implementado una base de datos relacional robusta y eficiente para gestionar la información del proyecto.

## Descripción de la base de datos

La base de datos de nuestro proyecto está diseñada para administrar los Proyectos Integradores creados por los alumnos de los ciclos de DAM, ASIR, DAW y Animaciones 3D y Videojuegos. Esta base de datos está estructurada en tres tablas principales: `proyecto_integrado`, `ciclo` y `alumno`.

- **proyecto_integrado**: Almacena la información de los proyectos, incluyendo su identificador único, nombre, URL de GitHub, nota obtenida, año, curso, grupo y el ciclo al que pertenece.
- **ciclo**: Contiene información sobre los distintos ciclos formativos, con su identificador único, nombre y descripción.
- **alumno**: Guarda los datos de los alumnos, como su identificador único, número de expediente y nombre y apellidos.

## Diagrama Entidad/Relación

Hemos creado un diagrama Entidad/Relación (E/R) para visualizar la estructura de nuestra base de datos. Este diagrama muestra cómo se relacionan las entidades en nuestra base de datos y es una herramienta valiosa para entender el diseño de nuestra base de datos a nivel alto.

## Normalización

Nuestra base de datos ha sido normalizada para reducir la redundancia de datos y mejorar la integridad de los datos. Hemos seguido las reglas de normalización para asegurar que cada tabla tenga una dependencia funcional completa, que no existan dependencias parciales ni transitivas.

## Creación de la base de datos

Hemos utilizado SQL para crear las tablas de nuestra base de datos y para definir las relaciones entre ellas. Los scripts SQL utilizados para la creación de las tablas y las relaciones entre ellas se pueden encontrar en los archivos SQL en este repositorio.

## Inserción de datos

Hemos insertado datos de prueba en nuestras tablas para probar y demostrar la funcionalidad de nuestra base de datos. Estos scripts de inserción también están disponibles en este repositorio.

## Consultas y manipulación de datos

Hemos utilizado SQL para consultar y manipular los datos en nuestra base de datos. Los scripts SQL para estas consultas y operaciones de manipulación de datos también están disponibles en este repositorio.

## Herramientas utilizadas

Para este proyecto, hemos utilizado Oracle como nuestro sistema de gestión de bases de datos relacionales. Además, hemos utilizado Software Ideas Modeler para el diseño y visualización de nuestra base de datos.

Esperamos que este `README.md` te ayude a entender la estructura y funcionalidad de la base de datos de nuestro Proyecto Integrador. Si tienes alguna pregunta o sugerencia, no dudes en ponerte en contacto con nosotros.
