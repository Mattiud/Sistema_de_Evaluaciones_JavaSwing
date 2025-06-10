package Modelo;

public class Pregunta {
    private int Id;
    private String Pregunta;
    private String Respuesta1;
    private String Respuesta2;
    private String Respuesta3;
    private String Respuesta4;
    private int RespuestaCorrecta;
    private int Tiempo;
    private String NivelBloom;

    public Pregunta(){

    }


    public Pregunta(int Id,String Preg,String Resp1, String Resp2, String Resp3, String Resp4, int RespC, int Tiempo, String NivelBloom){
        this.Id = Id;
        this.Pregunta = Preg;
        this.Respuesta1 = Resp1;
        this.Respuesta2 = Resp2;
        this.Respuesta3 = Resp3;
        this.Respuesta4 = Resp4;
        this.RespuestaCorrecta = RespC;
        this.Tiempo = Tiempo;
        this.NivelBloom = NivelBloom;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    public String getRespuesta1() {
        return Respuesta1;
    }

    public void setRespuesta1(String Respuesta1) {
        this.Respuesta1 = Respuesta1;
    }

    public String getRespuesta2() {
        return Respuesta2;
    }

    public void setRespuesta2(String Respuesta2) {
        this.Respuesta2 = Respuesta2;
    }

    public String getRespuesta3() {
        return Respuesta3;
    }

    public void setRespuesta3(String Respuesta3) {
        this.Respuesta3 = Respuesta3;
    }

    public String getRespuesta4() {
        return Respuesta4;
    }

    public void setRespuesta4(String Respuesta4) {
        this.Respuesta4 = Respuesta4;
    }    

    public int getRespuestaCorrecta() {
        return RespuestaCorrecta;
    }

    public void setRespuestaCorrecta(int RespuestaCorrecta) {
        this.RespuestaCorrecta = RespuestaCorrecta;
    }

    public int getTiempo(){
        return Tiempo;
    }

    public void setTiempo(int Tiempo){
        this.Tiempo = Tiempo;
    }

    public String getNivelBloom(){
        return NivelBloom;
    }

    public void setNivelBloom(String NivelBloom){
        this.NivelBloom = NivelBloom;
    }
}