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
    modelo.addColumn("TIEMPO");
    modelo.addColumn("NIVEL BLOOM");

    String consulta="SELECT * FROM pregunta";

    Statement st;
    try{
      Connection cn = con.Conex();
      st = cn.createStatement();
      ResultSet rs = st.executeQuery(consulta);
      while (rs.next()){
          Object [] lista={
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getString(4),
              rs.getString(5),
              rs.getString(6),
              rs.getInt(7),
              rs.getInt(8),
              rs.getString(9)
          };
          modelo.addRow(lista);
      }
      TABLA.setModel(modelo);
      cn.close();
    }catch(Exception e){
       System.out.print("Error al mostrar Preguntas "+e);
    }



  }
}
