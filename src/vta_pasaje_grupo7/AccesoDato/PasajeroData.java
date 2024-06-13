
package vta_pasaje_grupo7.AccesoDato;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vta_pasaje_grupo7.Entidades.*;


public class PasajeroData {
    Connection con=Conexion.getConexion();
    public void agregarPasajeros(Pasajero p){
    String sql="INSERT INTO `pasajero`( `nombre`, `apellido`, `dni`, `email`, `telefono`, `estado`)" +
"VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNombre());
            ps.setString(2,p.getApellido());
            ps.setInt(3, p.getDni());
            ps.setString(4, p.getEmail());
            ps.setInt(5, p.getTelefono());
            ps.setBoolean(6,p.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
            p.setIdPasajero(rs.getInt("idPasajero"));
            JOptionPane.showMessageDialog(null, "Pasajero cargado");
            }
            ps.close();
        } catch (SQLException ex) {
           
                     if(ex.getErrorCode()==1062){
                     JOptionPane.showMessageDialog(null, "Ya existe un pasajero cargado con este dni");
                     }
        }
    }
    
    public ArrayList<Pasajero>listaDePasajeros(){
    ArrayList<Pasajero>pasajeros=new ArrayList();
    String sql="SELECT * FROM pasajero WHERE estado > 0";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Pasajero pasajero=new Pasajero();
            pasajero.setIdPasajero(rs.getInt("idPasajero"));
            pasajero.setNombre(rs.getString("nombre"));
            pasajero.setApellido(rs.getString("apellido"));
            pasajero.setDni(rs.getInt("dni"));
            pasajero.setEmail(rs.getString("email"));
            pasajero.setTelefono(rs.getInt("telefono"));
            pasajero.setEstado(true);
            pasajeros.add(pasajero);
            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de pasajeros");
            System.out.println(ex.getMessage());
        }
    return pasajeros;
    }
    
    public Pasajero PasajeroPorDni(int dni){
    Pasajero pasajero=new Pasajero();
        String sql="SELECT * FROM `pasajero` WHERE dni = ? AND estado > 0";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,dni);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                
                
            pasajero.setIdPasajero(rs.getInt("idPasajero"));
            pasajero.setNombre(rs.getString("nombre"));
            pasajero.setApellido(rs.getString("apellido"));
            pasajero.setDni(rs.getInt("dni"));
            pasajero.setEmail(rs.getString("email"));
            pasajero.setTelefono(rs.getInt("telefono"));
            pasajero.setEstado(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener pasajero por dni");
            System.out.println(ex.getMessage());
    }
        return pasajero;
        
        
}
    public void eliminarPasajero(int dni){
    String sql="UPDATE pasajero SET estado = 0 WHERE dni = ? ";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
           int verificar=ps.executeUpdate();
           if(verificar>0){
           JOptionPane.showMessageDialog(null,"Pasajero eliminado");
           }
           ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al eliminar pasajero");
            System.out.println(ex.getMessage());
        }
    }
}

