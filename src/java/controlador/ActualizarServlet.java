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

@WebServlet(name = "ActualizarServlet", urlPatterns = {"/ActualizarServlet"})
public class ActualizarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 
        String idStr = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        
        try {

            int id = Integer.parseInt(idStr);
            
     
            Connection con = Conexion.conectar();
            
    
            String sql = "UPDATE usuarios SET nombre = ?, correo = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setInt(3, id);
           
            int filasAfectadas = ps.executeUpdate();
            
            ps.close();
            con.close();
            
            if (filasAfectadas > 0) {
                System.out.println("¡Usuario con ID " + id + " actualizado con éxito!");
            } else {
                System.out.println("No se encontró ningún usuario con el ID: " + id);
            }
            
        } catch (Exception e) {
            System.err.println("Error al actualizar en la base de datos: " + e.getMessage());
        }
        
        request.setAttribute("nombreUsuario", nombre + " (Actualizado)");
        request.setAttribute("correoUsuario", correo);
        
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}