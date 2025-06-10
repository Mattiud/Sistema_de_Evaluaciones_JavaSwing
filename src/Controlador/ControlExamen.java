package Controlador;

import Modelo.Pregunta;
import java.util.ArrayList;
import java.util.List;

public class ControlExamen {

    private List<Pregunta> preguntaSeleccionada;

    public ControlExamen(){
        preguntaSeleccionada = new ArrayList<>();
    }

    public void agregarPregunta(Pregunta p){
        if(!preguntaSeleccionada.contains(p)){
            preguntaSeleccionada.add(p);
        }
    }

    public void eliminarPregunta(int id){
        preguntaSeleccionada.removeIf(p -> p.getId() == id);
    }

    public List<Pregunta> obtenerPregunta(){
        return preguntaSeleccionada;
    }

    public int tiempoTotal(){
        int total = 0;
        for (Pregunta p : preguntaSeleccionada){
            total += p.getTiempo();
        }
        return total;
    }

    public void limpiarPregunta(){
        preguntaSeleccionada.clear();
    }
}