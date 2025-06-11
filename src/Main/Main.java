package Main;

import Interfaz.InterfazPrincipal;
import Interfaz.InterfazCreacion;
import Modelo.ListarPreguntas;
import Controlador.Control;
import Controlador.ControlCreacion;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            // Crear ventana principal
            InterfazPrincipal principal = new InterfazPrincipal();
            Control controlPrincipal = new Control(principal);
            
            ListarPreguntas listar = new ListarPreguntas();

            // Crear ventana creación (pero no mostrar aún)
            InterfazCreacion creacion = new InterfazCreacion();
            ControlCreacion controlCreacion = new ControlCreacion(creacion);

            // Pasar la referencia de la ventana creación al controlador principal (si hace falta)
            controlPrincipal.setInterfazCreacion(creacion);  // O el método que tengas para eso

            // Mostrar ventana principal
            principal.setVisible(true);
            listar.MostrarTabla(principal.TABLA);



        });
    }
}