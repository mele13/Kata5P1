package kata5_p1_v3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertarDatosTabla_p1_v3 {
    
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
     * Método que inserta datos en la tabla EMAIL.
     * 
     * @param emailList
     */
    public void insert(List<String> emailList) {
        String sql = "INSERT INTO EMAIL(mail) VALUES(?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for(String email: emailList){
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            }      
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   
}