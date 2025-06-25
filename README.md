# Sistema de Evaluacion en Java Swing

Sistema de Evaluaciones (Java Swing)

-----------------
1.Descripción

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
 	 -mysql-connector-j-9.3.0.jar
	  Descárgalo desde: https://dev.mysql.com/downloads/connector/j/
	  (Si utilizas Windows, elige la opción Platform Independent)
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
 2) Crea un nuevo proyecto en NetBeans (o en otro IDE compatible con Java Swing) y copia el contenido de la carpeta src/ del repositorio a la carpeta src/ de tu nuevo proyecto.
 3) Añade las librerías externas indicadas en la sección 4.Requisitos.
 4) Ejecuta la clase Main.java como clase Principal.

-----------------

7.Configuración de la Base de Datos

 Para que el sistema funcione correctamente, se debe crear e inicializar una base de datos en MySQL con las tablas necesarias. A continuación se detalla cómo hacerlo.

  1) Conéctate a tu servidor MySQL y ejecuta:

	 	 CREATE DATABASE sistema_evaluaciones;
		 USE sistema_evaluaciones;

  2) Crear las tablas necesarias
  
		 CREATE TABLE pregunta (
		     Id INT AUTO_INCREMENT PRIMARY KEY,
		     Pregunta VARCHAR(255) NOT NULL,
		     Respuesta1 VARCHAR(255) NOT NULL,
		     Respuesta2 VARCHAR(255) NOT NULL,
		     Respuesta3 VARCHAR(255) NOT NULL,
		     Respuesta4 VARCHAR(255) NOT NULL,
		     RespuestaCorrecta VARCHAR(255) NOT NULL,
                     Tiempo INT NOT NULL,
		     NivelBloom VARCHAR(50) NOT NULL
		     
		 );

  4) Configurar conexión en el código
  
	 En el método "Conexión.java" asegúrate de que los datos de conexión coincidan con tu entorno local:

	 	 String url = "jdbc:mysql://[hostname]:[port]/sistema_evaluaciones";
	 	 String user = "[Usuario]";
		 String password = "[Contraseña]";

 5) Ejemplos de preguntas
      	
	    	-- VERDADERO/FALSO
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('La cordillera de los Andes está en Sudamérica.', 'Verdadero', 'Falso', '', '', 1, 'Recordar', 20),
		('El agua hierve a 100 grados Celsius.', 'Verdadero', 'Falso', '', '', 1, 'Recordar', 15),
		('Los perros son animales herbívoros.', 'Verdadero', 'Falso', '', '', 2, 'Recordar', 20),
		('La luna es un planeta.', 'Verdadero', 'Falso', '', '', 2, 'Recordar', 20);
		
		-- SELECCIÓN MÚLTIPLE
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('¿Cuál es el continente donde se encuentra Egipto?', 'África', 'Asia', 'Europa', 'Oceanía', 1, 'Recordar', 25),
		('¿Cuántos lados tiene un cuadrado?', '3', '4', '5', '6', 2, 'Recordar', 15),
		('¿Cuál es el planeta rojo?', 'Venus', 'Marte', 'Júpiter', 'Saturno', 2, 'Recordar', 20),
		('¿Qué gas respiramos los humanos?', 'Oxígeno', 'Hidrógeno', 'Nitrógeno', 'Dióxido de carbono', 1, 'Recordar', 20);
		
		
		-- VERDADERO/FALSO
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('Las plantas necesitan luz para hacer la fotosíntesis.', 'Verdadero', 'Falso', '', '', 1, 'Entender', 25),
		('El corazón humano bombea sangre.', 'Verdadero', 'Falso', '', '', 1, 'Entender', 20),
		('Los seres vivos no necesitan agua para vivir.', 'Verdadero', 'Falso', '', '', 2, 'Entender', 20),
		('Los animales carnívoros comen plantas.', 'Verdadero', 'Falso', '', '', 2, 'Entender', 20);
		
		-- SELECCIÓN MÚLTIPLE
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('¿Por qué el sol se ve más grande al atardecer?', 'Porque se acerca a la Tierra', 'Porque está más caliente', 'Por un efecto óptico', 'Porque cambia de tamaño', 3, 'Entender', 30),
		('¿Qué representa la bandera de un país?', 'Un animal', 'Una planta', 'La identidad nacional', 'Una comida típica', 3, 'Entender', 20),
		('¿Qué pasa cuando mezclamos azul y amarillo?', 'Rojo', 'Verde', 'Naranja', 'Blanco', 2, 'Entender', 15),
		('¿Por qué flotan los barcos?', 'Porque son pesados', 'Por la forma del casco', 'Porque tienen motores', 'Porque son metálicos', 2, 'Entender', 30);
		
		
		-- VERDADERO/FALSO
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('Puedo usar una regla para medir la longitud de una hoja.', 'Verdadero', 'Falso', '', '', 1, 'Aplicar', 20),
		('Para saber cuánta agua hay en una botella uso una balanza.', 'Verdadero', 'Falso', '', '', 2, 'Aplicar', 20),
		('Las fracciones se pueden usar para repartir una pizza.', 'Verdadero', 'Falso', '', '', 1, 'Aplicar', 20),
		('El microscopio se usa para ver objetos grandes.', 'Verdadero', 'Falso', '', '', 2, 'Aplicar', 20);
		
		-- SELECCIÓN MÚLTIPLE
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('¿Qué herramienta usarías para medir la temperatura?', 'Regla', 'Termómetro', 'Balanza', 'Compás', 2, 'Aplicar', 20),
		('¿Cuál operación usarías para repartir dulces entre amigos?', 'Suma', 'Resta', 'Multiplicación', 'División', 4, 'Aplicar', 25),
		('¿Qué objeto usarías para observar planetas?', 'Telescopio', 'Microscopio', 'Lupa', 'Cámara', 1, 'Aplicar', 25),
		('Si un árbol mide 3 metros y crece 2 más, ¿cuánto mide?', '4 metros', '5 metros', '6 metros', '7 metros', 2, 'Aplicar', 20);
		
		
		-- VERDADERO/FALSO
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('Los cuentos siempre terminan con la misma estructura.', 'Verdadero', 'Falso', '', '', 2, 'Analizar', 25),
		('Una gráfica ayuda a interpretar datos.', 'Verdadero', 'Falso', '', '', 1, 'Analizar', 20),
		('Los insectos y los mamíferos tienen el mismo número de patas.', 'Verdadero', 'Falso', '', '', 2, 'Analizar', 20),
		('Los mapas solo sirven para decorar.', 'Verdadero', 'Falso', '', '', 2, 'Analizar', 20);
		
		-- SELECCIÓN MÚLTIPLE
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('¿Qué parte del texto muestra el conflicto?', 'Introducción', 'Nudo', 'Desenlace', 'Título', 2, 'Analizar', 30),
		('¿Cuál opción contiene solo animales herbívoros?', 'León, Tigre, Puma', 'Vaca, Conejo, Caballo', 'Perro, Gato, Ratón', 'Águila, Halcón, Búho', 2, 'Analizar', 25),
		('¿Qué sucede si eliminamos el sujeto de una oración?', 'No cambia', 'Pierde sentido', 'Se vuelve más clara', 'Se convierte en pregunta', 2, 'Analizar', 25),
		('¿Cuál es la causa del calentamiento global?', 'Lluvias', 'Actividad humana', 'Rotación de la Tierra', 'Cambios naturales', 2, 'Analizar', 30);
		
		
		-- VERDADERO/FALSO
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('Revisar el trabajo antes de entregarlo es innecesario.', 'Verdadero', 'Falso', '', '', 2, 'Evaluar', 20),
		('Comparar dos ideas ayuda a tomar decisiones.', 'Verdadero', 'Falso', '', '', 1, 'Evaluar', 25),
		('Una fuente confiable siempre es una red social.', 'Verdadero', 'Falso', '', '', 2, 'Evaluar', 25),
		('Pensar en consecuencias es parte de evaluar una acción.', 'Verdadero', 'Falso', '', '', 1, 'Evaluar', 30);
		
		-- SELECCIÓN MÚLTIPLE
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('¿Qué criterio es mejor para elegir un libro?', 'Color de la portada', 'Recomendación de amigos', 'Tamaño del libro', 'Estilo de letra', 2, 'Evaluar', 30),
		('¿Qué es lo más importante al resolver un conflicto?', 'Gritar', 'Escuchar a ambos', 'Imponer mi opinión', 'Ignorar el problema', 2, 'Evaluar', 25),
		('¿Cuál es una señal de que una fuente es confiable?', 'Muchos likes', 'Nombre conocido', 'Cita con evidencia', 'Comentario divertido', 3, 'Evaluar', 30),
		('¿Cuál opción es la mejor manera de cuidar el medio ambiente?', 'Tirar basura al mar', 'Reciclar y reutilizar', 'Usar más autos', 'Destruir bosques', 2, 'Evaluar', 25);
		
		
		-- VERDADERO/FALSO
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('Crear una historia original requiere imaginación.', 'Verdadero', 'Falso', '', '', 1, 'Crear', 30),
		('Diseñar un experimento implica seguir pasos.', 'Verdadero', 'Falso', '', '', 1, 'Crear', 30),
		('Inventar una solución no necesita creatividad.', 'Verdadero', 'Falso', '', '', 2, 'Crear', 25),
		('Para crear una canción solo se necesita copiar otra.', 'Verdadero', 'Falso', '', '', 2, 'Crear', 25);
		
		-- SELECCIÓN MÚLTIPLE
		INSERT INTO pregunta (Pregunta, Respuesta1, Respuesta2, Respuesta3, Respuesta4, RespuestaCorrecta, NivelBloom, Tiempo) VALUES
		('¿Qué es necesario para escribir un poema?', 'Copiar uno existente', 'Tener ideas propias', 'Buscar palabras difíciles', 'No usar emociones', 2, 'Crear', 30),
		('¿Qué harías para resolver un problema de basura en tu escuela?', 'Ignorarlo', 'Esperar que otro lo haga', 'Proponer un plan de reciclaje', 'Echarle la culpa a otros', 3, 'Crear', 30),
		('¿Cómo podrías representar una historia?', 'Con dibujos', 'Con chismes', 'Con gritos', 'Con símbolos sin sentido', 1, 'Crear', 25),
		('¿Qué material usarías para construir un puente en maqueta?', 'Papel higiénico', 'Plástico y palitos', 'Fideos cocidos', 'Tierra', 2, 'Crear', 25);


-----------------
8.Autores
 - Matias Sanhueza 
 - Tomas Ramirez 
 - José Tomas Serri
