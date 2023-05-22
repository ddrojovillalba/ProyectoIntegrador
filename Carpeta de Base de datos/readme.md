Tabla de modelo E/R
![Captura de pantalla 2023-05-18 095801](https://github.com/ddrojovillalba/ProyectoIntegrador/assets/118363138/f4b8b876-a90f-49e8-8128-2de4b4cb6ba8)

![Captura de pantalla 2023-05-18 103329](https://github.com/ddrojovillalba/ProyectoIntegrador/assets/118363138/d0c3bcb6-249d-434c-bf07-a7ddf25becbf)

Normalización
[TRABAJO (1).pdf](https://github.com/ddrojovillalba/ProyectoIntegrador/files/11331213/TRABAJO.1.pdf)

[Nuevo Documento de Microsoft Word (Recuperado automáticamente).docx](https://github.com/ddrojovillalba/ProyectoIntegrador/files/11529206/Nuevo.Documento.de.Microsoft.Word.Recuperado.automaticamente.docx)

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
