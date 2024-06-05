
package vta_pasaje_grupo7.AccesoDato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    
    private static final String URL="jdbc:mariadb://localhost:3308/venta_pasajes";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    
    private static Connection connection;

    public Conexion() {
    }
    
    public static Connection getConexion(){
    
        if(connection==null){
        
            try{
            
                Class.forName("org.mariadb.jdbc.Driver");
                
                System.out.println("Driver cargado");
                connection= DriverManager.getConnection(URL,USUARIO,PASSWORD);
                System.out.println("Conectado a la base de datos");
                
                
                
            }catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null,"Error a cargar el driver"+ex.getMessage());
            }catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"Error a cconectarse a la base de datos"+ex.getMessage());
            }
        }
        return connection;
    }
}
