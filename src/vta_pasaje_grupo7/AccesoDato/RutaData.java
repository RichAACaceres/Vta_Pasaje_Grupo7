
package vta_pasaje_grupo7.AccesoDato;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vta_pasaje_grupo7.Entidades.*;


public class RutaData {
    Connection con=Conexion.getConexion();
    public void guardarRuta(Ruta r){
    String sql="INSERT INTO ruta ( `origen`, `destino`, `duracionEstima`, `estado`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, r.getOrigen());
            ps.setString(2, r.getDestino());
            ps.setTime(3, Time.valueOf(r.getDuracionEstima()));
            ps.setBoolean(4, r.isEstado());
           ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
            r.setIdRuta(rs.getInt("idRuta"));
            JOptionPane.showMessageDialog(null, "Ruta añadida");
            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar ruta");
            System.out.println(ex.getMessage());
            if(ex.getErrorCode()==1062){
            JOptionPane.showMessageDialog(null, "Este id ya pertenece a un ruta");
            }
        }
    
    
    }
   public ArrayList<Ruta> rutasDisponibles(){
   ArrayList<Ruta>rutas= new ArrayList();
   
   String sql="SELECT * FROM `ruta` WHERE estado > 0";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Ruta ruta=new Ruta();
            ruta.setDestino(rs.getString("destino"));
            ruta.setDuracionEstima(rs.getTime("duracionEstima").toLocalTime());
            ruta.setIdRuta(rs.getInt("idRuta"));
            ruta.setEstado(rs.getBoolean("estado"));
            ruta.setOrigen(rs.getString("origen"));
            rutas.add(ruta);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al obtener rutas disponibles");
            System.out.println(ex.getMessage());
        }
   
        return rutas;
  
   
   }
   public ArrayList<Ruta>rutasPorDestino(String origen,String destino){
       ArrayList<Ruta>rutas=new ArrayList();
       
       String sql="SELECT * FROM `ruta` WHERE destino = ? AND origen = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, destino);
            ps.setString(2, origen);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Ruta ruta=new Ruta();
            ruta.setDestino(rs.getString("destino"));
            ruta.setDuracionEstima(rs.getTime("duracionEstima").toLocalTime());
            ruta.setIdRuta(rs.getInt("idRuta"));
            ruta.setEstado(rs.getBoolean("estado"));
            ruta.setOrigen(rs.getString("origen"));
            rutas.add(ruta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener rutas por destino");
            System.out.println(ex.getMessage());
        }
       
        return rutas;
   
   }
    
   public void eliminarRuta(int idRuta){
   String sql="UPDATE ruta SET estado = 0 WHERE idRuta = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            int verificar=ps.executeUpdate();
            if(verificar > 0){
            JOptionPane.showMessageDialog(null, "Ruta eliminada");
            }
            ps.cancel();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar ruta");
            System.out.println(ex.getMessage());
        }
   
   
   }
}
