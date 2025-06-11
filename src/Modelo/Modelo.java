package Modelo;
import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
public class Modelo {
  Conexion con = new Conexion();
  Connection cn = con.Conex();

  public void RegistrarBD(Pregunta p){
   try{
    String consulta;
        consulta = "INSERT INTO pregunta(Id, Pregunta, Respuesta1, Respuesta2, Respuesta3,Respuesta4, RespuestaCorrecta, Tiempo, NivelBloom) VALUES(?,?,?,?,?,?,?,?,?) ";
    PreparedStatement ps = cn.prepareStatement(consulta);
    ps.setInt(1, p.getId());
    ps.setString(2, p.getPregunta());
    ps.setString(3, p.getRespuesta1());
    ps.setString(4, p.getRespuesta2());
    ps.setString(5, p.getRespuesta3());
    ps.setString(6, p.getRespuesta4());
    ps.setInt(7, p.getRespuestaCorrecta());
    ps.setInt(8, p.getTiempo());
    ps.setString(9, p.getNivelBloom());
    ps.executeUpdate();
    cn.close();
    JOptionPane.showMessageDialog(null,"Registro Guardado");
   }catch(Exception e){
    JOptionPane.showMessageDialog(null,"Error Registro BD "+e);
   }
  }
  public void ModificarBD(Pregunta p){
   try{
    String consulta;
        consulta = "UPDATE pregunta SET Pregunta=?, Respuesta1=?, Respuesta2=?, Respuesta3=?, Respuesta4=?, RespuestaCorrecta=?, Tiempo=?, NivelBloom=? WHERE Id="+p.getId()+" ";
    PreparedStatement ps = cn.prepareStatement(consulta);

    ps.setString(1, p.getPregunta());
    ps.setString(2, p.getRespuesta1());
    ps.setString(3, p.getRespuesta2());
    ps.setString(4, p.getRespuesta3());
    ps.setString(5, p.getRespuesta4());
    ps.setInt(6, p.getRespuestaCorrecta());
    ps.setInt(7, p.getTiempo());
    ps.setString(8, p.getNivelBloom());
    ps.executeUpdate();
    cn.close();
    JOptionPane.showMessageDialog(null,"Registro Actualizado ");
   }catch(Exception e){
    JOptionPane.showMessageDialog(null,"Error de Actualizacion BD "+e);
   }
  }
  public void EliminarBD(Pregunta p){
   try{
    String consulta;
        consulta = "DELETE FROM pregunta WHERE Id="+p.getId()+" ";
    PreparedStatement ps = cn.prepareStatement(consulta);
    ps.executeUpdate();
    cn.close();
    JOptionPane.showMessageDialog(null,"Registro Eliminado ");
   }catch(Exception e){
    JOptionPane.showMessageDialog(null,"Error Eliminando Registro "+e);
   }
  }
}