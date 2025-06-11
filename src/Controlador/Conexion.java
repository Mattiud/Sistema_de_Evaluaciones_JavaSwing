package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    Connection cn;
    String user="root";
    String password="contraseña";
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://127.0.0.1:3306/preguntas";

    public Connection Conex(){
        try{
         //Class.forName("com.mysql.cj.jdbc.Driver");
         cn = (Connection)DriverManager.getConnection(url,user,password);
         System.out.println("Conexion Exitosa");
        }catch(Exception e){
         System.err.println("Error de Conexion: "+e.getMessage());
        }
        return cn;
    }

}