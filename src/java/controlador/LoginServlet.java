package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import controlador.Conexion; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        
        try {
            Connection con = Conexion.conectar();
            String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                response.sendRedirect("dashboard.html");
            } else {
                response.sendRedirect("index.html?error=1");
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.err.println("Error en el login: " + e.getMessage());
        }
    }
}