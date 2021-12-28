package kata5_p1_v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mele13
 */
public class SelectApp_p1_v1 {
    
    /**
     * Método que conecta a la base de datos de SQLite.
     * 
     * @return conn conexión
     */
    private Connection connect() {
        String url = "jdbc:sqlite:SqLite/KATA5.db"; //Cadena de conexión a SQLite
        Connection conn = null; //Conexión a la base de datos
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) { 
            System.out.println(e.getMessage());
        }   
        return conn;
    }
    
    /**
     * Método que selecciona e imprime por consola todos los registros de la
     * tabla PEOPLE.
     */
    public void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement(); 
                ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()) { 
                    System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("Name") + "\t" + rs.getString("Apellidos") + "\t" + rs.getString("Departamento") + "\t");
                }
        } catch (SQLException e) { 
            System.out.println(e.getMessage());
        } 
    }
}