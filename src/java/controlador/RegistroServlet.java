package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import controlador.Conexion; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password"); 
        
        try {
            Connection con = Conexion.conectar();

            String sql = "INSERT INTO usuarios (nombre, correo, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, password);

            ps.executeUpdate();

            ps.close();
            con.close();
            
            System.out.println("¡Usuario guardado en la base de datos con éxito, incluyendo su contraseña!");
        } catch (Exception e) {
            System.err.println("Error al insertar en la base de datos: " + e.getMessage());
        }

        request.setAttribute("nombreUsuario", nombre);
        request.setAttribute("correoUsuario", correo);
        
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}