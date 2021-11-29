
package BaseDeDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Francisco Castillo
 * @version 25-11-2021
 */
public class Conexion {
    public Connection obtenerConexion(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/optica","root","");
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    
    };
}
