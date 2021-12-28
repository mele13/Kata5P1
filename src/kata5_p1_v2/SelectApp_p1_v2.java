package kata5_p1_v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mele13
 */
public class SelectApp_p1_v2 {
    
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
     * tabla EMAIL. De estar la tabla vacía, se informará por consola.
     */
    public void selectAll() {
        String sql = "SELECT * FROM EMAIL";
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement(); 
               ResultSet rs = stmt.executeQuery(sql)){
                if(!rs.isBeforeFirst()) {
                    System.out.println("\nLa tabla está vacía");
                } else {
                    while (rs.next()) { 
                        System.out.println(rs.getInt("id") + "\t" +
                                rs.getString("Mail") + "\t");
                    }
                }
        } catch (SQLException e) { 
            System.out.println(e.getMessage());
        } 
    }   
}