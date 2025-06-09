# Sistema de Evaluacion en Java Swing

Sistema de Evaluaciones (Java Swing)

-----------------
1. Descripción

Este es un sistema de evaluación educativa desarrollado en Java utilizando Swing. La aplicación permite crear y rendir exámenes con preguntas de opción múltiple y verdadero/falso, basados en la taxonomía de Bloom. Los exámenes se cargan desde una Base de Datos, y durante la evaluación el sistema registra las respuestas del usuario, calcula el puntaje final y muestra un resumen al finalizar.


-----------------
2.Repositorio

[GitHub - Sistema de Evaluaciones] https://github.com/Mattiud/Sistema_de_Evaluaciones_JavaSwing

-----------------
3.Características Principales

 - Crear preguntas con distintas opciones de respuesta.
 - Clasificar preguntas según nivel de Bloom.
 - Seleccionar preguntas para crear un examen.
 - Realizar el examen mediante una interfaz gráfica.
 - Calcular y mostrar el puntaje final.

-----------------
4.Requisitos:

 - Java JDK 21
 - IDE compatible con Java Swing (recomendado: NetBeans)
 - Librerías externas: 
 	 - mysql-connector-j-9.3.0.jar
 - Sistema operativo: Windows
 - Git (opcional, para clonar el proyecto)

-----------------
5.Estructura de Proyecto

 src/
 
 ├── Main/              --> Lanza el programa (Main.java)
 
 ├── Modelo/            --> Clases de datos (Pregunta.java, PreguntaExamen.java, Modelo.java, ListarPreguntas.java, ListarCreacion.java)
 
 ├── Controlador/       --> Lógica de control (Conexion.java, Control.java, ControlCreacion.java, ControlExamen.java)
 
 ├── Interfaz/          --> Interfaces gráficas (InterfazPrincipal.java, InterfazExamen.java, InterfazCreacion.java)

-----------------
6.Cómo Ejecutar

 1) Clona el repositorio:
	 https://github.com/Mattiud/Sistema_de_Evaluaciones_JavaSwing.git
 2) Abre el proyecto en NetBeans u otro IDE compatible con Java Swing
 3) Añade las librerías externas ubicadas en dist/lib
 4) Ejecuta la clase Main.java

-----------------

7.Configuración de la Base de Datos

 Para que el sistema funcione correctamente, se debe crear e inicializar una base de datos en MySQL con las tablas necesarias. A continuación se detalla cómo hacerlo.

 	1) Conéctate a tu servidor MySQL y ejecuta:

 	 CREATE DATABASE sistema_evaluaciones;
	 USE sistema_evaluaciones;

 	2) Crear las tablas necesarias
  
	 CREATE TABLE preguntas (
	     Id INT AUTO_INCREMENT PRIMARY KEY,
	     Pregunta VARCHAR(255) NOT NULL,
	     Respuesta1 VARCHAR(255) NOT NULL,
	     Respuesta2 VARCHAR(255) NOT NULL,
	     Respuesta3 VARCHAR(255) NOT NULL,
	     Respuesta4 VARCHAR(255) NOT NULL,
	     RespuestaCorrecta VARCHAR(255) NOT NULL,
	     nivelBloom VARCHAR(50) NOT NULL,
	     Tiempo INT
	 );

 	4) Configurar conexión en el código
  
	 En el método "Conexión.java" asegúrate de que los datos de conexión coincidan con tu entorno local:

	 	 String url = "jdbc:mysql://[hostname]:[port]/sistema_evaluaciones";
	 	 String user = "[Usuario]";
		 String password = "[Contraseña]";

-----------------
8.Autores
 - Matias Sanhueza 
 - Tomas Ramirez 
 - José Tomas Serri
