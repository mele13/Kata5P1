package kata5_p1_v3;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;

public class CrearTabla_p1_v3 {
    public void createNewTable() {
        String url = "jdbc:sqlite:SqLite/KATA5.db"; //Cadena de conexión a SQLite
        
        // Instrucción SQL para crear nueva tabla
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n" + 
                " Id integer PRIMARY KEY AUTOINCREMENT,\n" 
                + " Mail text NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(url);
               Statement stmt = conn.createStatement()) {            
            stmt.execute(sql); // Se crea la nueva tabla
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }        
    }
}