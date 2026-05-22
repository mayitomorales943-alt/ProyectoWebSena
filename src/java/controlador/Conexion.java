package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection conectar() {
        Connection con = null;
        try {
     
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_sena", "root", "");
            System.out.println("Conexión exitosa!");
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e);
        }
        return con;
    }
}