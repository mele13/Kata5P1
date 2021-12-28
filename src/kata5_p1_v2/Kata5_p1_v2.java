package kata5_p1_v2;

/**
 * @author Mele13
 * 
 * Segunda versión de Kata5P1.
 * Crea y muestra un histograma de dominios de una lista de correos electrónicos
 * almacenados en una base de datos.
 */
public class Kata5_p1_v2 {
        
    /**
     * @param args 
     */
    public static void main(String[] args) {           
        CrearTabla_p1_v2 crearTabla = new CrearTabla_p1_v2();
        crearTabla.createNewTable();
        
        SelectApp_p1_v2 app = new SelectApp_p1_v2(); 
        app.selectAll();
    }
}