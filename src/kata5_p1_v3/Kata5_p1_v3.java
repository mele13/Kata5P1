package kata5_p1_v3;

import java.io.IOException;
import java.util.List;

/**
 * @author Mele13
 * 
 * Tercera versión de Kata5P1.
 * Crea y muestra un histograma de dominios de una lista de correos electrónicos
 * almacenados en una base de datos.
 */
public class Kata5_p1_v3 {
        
    /**
     * @param args 
     * @throws java.io.IOException 
     */
    public static void main(String[] args) throws IOException { 
        CrearTabla_p1_v3 crearTabla = new CrearTabla_p1_v3();
        crearTabla.createNewTable();
        
        List<String> mailList;
        String fileName = new String("email.txt");
        mailList = MailListReader_p1_v3.read(fileName);
        
        System.out.println("Cargando datos, espere...");
        InsertarDatosTabla_p1_v3 idt = new InsertarDatosTabla_p1_v3();
        idt.insert(mailList);
        
//        //Datos a insertar
//        idt.insert("algarcia@ulpgc.es");
//        idt.insert("mariamontes@gmail.com");
//        idt.insert("luisacab@yahoo.es");
//        idt.insert("lgilmore@hotmail.com");
//        idt.insert("rgilmore@alu.ulpgc.es");
//        idt.insert("laneking@outlook.com");
//        //---Fin datos a insertar---
        
        SelectApp_p1_v3 app = new SelectApp_p1_v3(); 
        app.selectAll();
    }
}