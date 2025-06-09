package Main;

import Interfaz.InterfazPrincipal;
import Interfaz.InterfazCreacion;
import Controlador.Control;
import Controlador.ControlCreacion;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
           
            InterfazPrincipal principal = new InterfazPrincipal();
            Control controlPrincipal = new Control(principal);

           
            InterfazCreacion creacion = new InterfazCreacion();

            
            controlPrincipal.setInterfazCreacion(creacion);  

            
            principal.setVisible(true);
        });
    }
}
