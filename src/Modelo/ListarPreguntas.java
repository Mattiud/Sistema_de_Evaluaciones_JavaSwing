package Modelo;
import Controlador.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;


public class ListarPreguntas {
    
  public void MostrarTabla(JTable TABLA){
    Conexion con = new Conexion();
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("PREGUNTA");
    modelo.addColumn("RESPUESTA1");
    modelo.addColumn("RESPUESTA2");
    modelo.addColumn("RESPUESTA3");
    modelo.addColumn("RESPUESTA4");
    modelo.addColumn("RESPUESTA CORRECTA");
    modelo.addColumn("Tiempo");
    modelo.addColumn("NivelBloom");
    
    String consulta="SELECT * FROM pregunta";
    
    Statement st;
    try{
      Connection cn = con.Conex();
      st = cn.createStatement();
      ResultSet rs = st.executeQuery(consulta);
      while (rs.next()){
          Object [] lista={
              rs.getInt("Id"),
              rs.getString("Pregunta"),
              rs.getString("Respuesta1"),
              rs.getString("Respuesta2"),
              rs.getString("Respuesta3"),
              rs.getString("Respuesta4"),
              rs.getInt("RespuestaCorrecta"),
              rs.getInt("Tiempo"),
              rs.getString("NivelBloom")
          };
          modelo.addRow(lista);
      }
      TABLA.setModel(modelo);
      cn.close();
    }catch(Exception e){
       System.out.print("Error "+e);
    }
    
    
    
  }
}

