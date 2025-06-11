package Controlador;

import Interfaz.InterfazExamen;
import Interfaz.InterfazCreacion;
import Modelo.ListarCreacion;
import Modelo.PreguntaExamen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControlCreacion implements ActionListener {

    private InterfazCreacion ic;
    private ListarCreacion modeloPreguntas;
    private List<PreguntaExamen> preguntaSeleccionada;

    public ControlCreacion(InterfazCreacion ic) {
        this.ic = ic;
        this.modeloPreguntas = new ListarCreacion();
        this.preguntaSeleccionada = new ArrayList<>();

        cargarTodasLasPreguntas(); 


        this.ic.BTNSELECT.addActionListener(this);
        this.ic.BTNELIMPREG.addActionListener(this);
        this.ic.BTNINICIAR.addActionListener(this);
    }


    private void cargarTodasLasPreguntas() {
        modeloPreguntas.MostrarTabla(ic.TABLAPREGUNTAS);
    }

    // Actualiza la tabla TABLAPREGSELECT con las preguntas seleccionadas



    // Calcula el tiempo total sumando el tiempo de todas las preguntas seleccionadas
    private void calcularTiempoTotal() {
        int total = 0;
        for (PreguntaExamen pe : preguntaSeleccionada) {
            total += pe.getTiempo();
        }
        
        int minutos = total / 60;
        int segundos = total % 60;
        String tiempototal = minutos+":"+segundos;
        ic.TXTTIEMPOTOTAL.setText(tiempototal);
                
    }


    // Método para seleccionar una pregunta desde la tabla y agregarla a la lista
    private void seleccionarPregunta() {
        int fila = ic.TABLAPREGUNTAS.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(ic, "Por favor, selecciona una pregunta.");
            return;
        }

        // Obtener datos de la fila seleccionada
        int Id = (int) ic.TABLAPREGUNTAS.getValueAt(fila, 0);
        String Pregunta = (String) ic.TABLAPREGUNTAS.getValueAt(fila, 1);
        int Tiempo = (int) ic.TABLAPREGUNTAS.getValueAt(fila, 2);
        String NivelBloom = (String) ic.TABLAPREGUNTAS.getValueAt(fila, 3);

        // Crear objeto Pregunta
        PreguntaExamen pe = new PreguntaExamen(Id, Pregunta, Tiempo, NivelBloom);

        // Validar si ya está en la lista
        if (preguntaSeleccionada.contains(pe)) {
            JOptionPane.showMessageDialog(ic, "Esta pregunta ya fue seleccionada.");
            return;
        }

        // Agregar a la lista
        preguntaSeleccionada.add(pe);

        // Actualizar tabla y tiempo total
        actualizarTablaSeleccionadas();
    }


    private void actualizarTablaSeleccionadas() {
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("PREGUNTA");
        modelo.addColumn("TIEMPO");
        modelo.addColumn("NIVEL DE BLOOM");

        for (PreguntaExamen pe : preguntaSeleccionada) {
            Object[] fila = {
                pe.getId(),
                pe.getPregunta(),
                pe.getTiempo(),
                pe.getNivelBloom()
            };
            modelo.addRow(fila);
        }

        ic.TABLAPREGSELECT.setModel(modelo);
        calcularTiempoTotal();
    }




    // Método auxiliar para crear un objeto Pregunta desde la tabla de preguntas disponibles
    private PreguntaExamen obtenerPreguntaPorIdDesdeTabla(int id) {
        int filas = ic.TABLAPREGUNTAS.getRowCount();
        for (int i = 0; i < filas; i++) {
            int idTabla = (int) ic.TABLAPREGUNTAS.getValueAt(i, 0);
            if (idTabla == id) {
                return new PreguntaExamen(
                    idTabla,
                    (String) ic.TABLAPREGUNTAS.getValueAt(i, 1),
                    (int) ic.TABLAPREGUNTAS.getValueAt(i, 2),
                    (String) ic.TABLAPREGUNTAS.getValueAt(i, 3)
                );
            }
        }
        return null;
    }

    // Eliminar pregunta seleccionada
    private void eliminarPregunta() {
        int fila = ic.TABLAPREGSELECT.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(ic, "Selecciona una pregunta para eliminar.");
            return;
        }
        int idEliminar = (int) ic.TABLAPREGSELECT.getValueAt(fila, 0);

        preguntaSeleccionada.removeIf(p -> p.getId() == idEliminar);
        actualizarTablaSeleccionadas();
    }

    // Iniciar examen: aquí podrías abrir la InterfazExamen y pasar las preguntas
    private void iniciarExamen() {
        if (preguntaSeleccionada.isEmpty()) {
            JOptionPane.showMessageDialog(ic, "Selecciona al menos una pregunta para iniciar el examen.");
            return;
        }

        int tiempoTotal = 0;
        for (PreguntaExamen pe : preguntaSeleccionada) {
            tiempoTotal += pe.getTiempo();
        }

        /*InterfazExamen examen = new InterfazExamen(preguntaSeleccionada, tiempoTotal);
        examen.setVisible(true);
        ic.dispose();*/
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ic.BTNSELECT) {
            seleccionarPregunta();
        } else if (e.getSource() == ic.BTNELIMPREG) {
            eliminarPregunta();
        } else if (e.getSource() == ic.BTNINICIAR) {
            iniciarExamen();
        }
    }
}