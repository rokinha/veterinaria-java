package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Matias Posada
 *  @version 12/11/2025
 */
public class Conexion {
    
    public Connection obtenerConexion() {
        
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/veterinaria_db", "root","");
            
            System.out.println("Conexion exitosa!");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro de conexion " + e.getMessage());
        }
        return connection;
    }
    
}
