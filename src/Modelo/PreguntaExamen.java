package Modelo;

public class PreguntaExamen {
    private int Id;
    private String Pregunta;
    private int Tiempo;
    private String NivelBloom;

    public PreguntaExamen(int id, String pregunta, int tiempo, String nivelBloom) {
        this.Id = id;
        this.Pregunta = pregunta;
        this.Tiempo = tiempo;
        this.NivelBloom = nivelBloom;
    }

    public int getId() { 
        return Id; 
    }
    public String getPregunta() {
        return Pregunta; 
    }
    public int getTiempo() { 
        return Tiempo; 
    }
    public String getNivelBloom() { 
        return NivelBloom; 
    }
}