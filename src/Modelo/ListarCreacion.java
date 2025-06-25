package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;


public class ListarCreacion {

  public void MostrarTabla(JTable TABLAPREGUNTAS){
    Conexion con = new Conexion();
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("PREGUNTA");
    modelo.addColumn("TIEMPO");
    modelo.addColumn("NIVEL DE BLOOM");

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
              rs.getInt("Tiempo"),
              rs.getString("NivelBloom")
          };
          modelo.addRow(lista);
      }
      System.out.println("Filas cargadas "+ modelo.getRowCount());
      TABLAPREGUNTAS.setModel(modelo);
      cn.close();
    }catch(Exception e){
       System.out.print("Error al mostrar en TABLACREACION "+e);
    }



  }
}
