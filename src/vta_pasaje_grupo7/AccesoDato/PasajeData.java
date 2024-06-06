
package vta_pasaje_grupo7.AccesoDato;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vta_pasaje_grupo7.Entidades.*;


public class PasajeData {
    Connection con=Conexion.getConexion();
    
    public void venderPasaje(Pasaje p){
    String sql="INSERT INTO `pasaje`( `idPasajero`, `idColectivo`, `idRuta`, `fechaviaje`, `horaviaje`, `asiento`, `precio`) "
            + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,p.getPasajero().getIdPasajero());
            ps.setInt(2, p.getColectivo().getIdColectivo());
            ps.setInt(3, p.getRuta().getIdRuta());
            ps.setDate(4, Date.valueOf(p.getFechaViaje()));
            ps.setTime(5, Time.valueOf(p.getHoraViaje()));
            ps.setInt(6, p.getAsiento());
            ps.setDouble(7, p.getPrecio());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
            p.setIdPasaje(rs.getInt("idPasaje"));
            JOptionPane.showMessageDialog(null, "Pasaje vendido");
            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al vender pasaje");
            System.out.println(ex.getMessage());
        }
    }
public ArrayList<Pasaje>pasajesVendidos(ArrayList<Ruta> rutas,ArrayList<Pasajero> pasajeros, ArrayList<Colectivo> colectivos){
ArrayList<Pasaje>pasajes=new ArrayList();
String sql="SELECT * FROM pasaje";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
while(rs.next()){
Pasaje pasaje =new Pasaje();
pasaje.setIdPasaje(rs.getInt("idPasaje"));
pasaje.setHoraViaje(rs.getTime("horaviaje").toLocalTime());
pasaje.setPrecio(rs.getDouble("precio"));
pasaje.setFechaViaje(rs.getDate("fechaviaje").toLocalDate());
pasaje.setAsiento(rs.getInt("asiento"));
for(Ruta r:rutas){
if(rs.getInt("idRuta")==r.getIdRuta()){
pasaje.setRuta(r);

}
}
for(Pasajero p:pasajeros){
if(rs.getInt("idPasajero")==p.getIdPasajero()){
   pasaje.setPasajero(p);

}
}
for(Colectivo c:colectivos){
if(rs.getInt("idColectivo")==c.getIdColectivo()){
  pasaje.setColectivo(c);

}
}
pasajes.add(pasaje);

}            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar pasajes");
            System.out.println(ex.getMessage());
        }

return pasajes;
}
public ArrayList<Pasaje>pasajesVendidosPorRuta(String origen,String destino,ArrayList<Ruta> rutas,ArrayList<Pasajero> pasajeros, ArrayList<Colectivo> colectivos){
ArrayList<Pasaje>pasajes=new ArrayList();
String sql="SELECT * FROM pasaje,ruta WHERE pasaje.idRuta=ruta.idRuta AND ruta.origen = ? AND ruta.destino = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, destino);
          
           ResultSet rs= ps.executeQuery();
while(rs.next()){
Pasaje pasaje =new Pasaje();
pasaje.setIdPasaje(rs.getInt("idPasaje"));
pasaje.setHoraViaje(rs.getTime("horaviaje").toLocalTime());
pasaje.setPrecio(rs.getDouble("precio"));
pasaje.setFechaViaje(rs.getDate("fechaviaje").toLocalDate());
pasaje.setAsiento(rs.getInt("asiento"));
for(Ruta r:rutas){
if(rs.getInt("idRuta")==r.getIdRuta()){
pasaje.setRuta(r);

}
}
for(Pasajero p:pasajeros){
if(rs.getInt("idPasajero")==p.getIdPasajero()){
   pasaje.setPasajero(p);

}
}
for(Colectivo c:colectivos){
if(rs.getInt("idColectivo")==c.getIdColectivo()){
  pasaje.setColectivo(c);

}
}
pasajes.add(pasaje);

}            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar pasajes por ruta");
            System.out.println(ex.getMessage());
        }

return pasajes;
}

public void anularVenta(int idPasaje){
String sql="DELETE FROM `pasaje` WHERE idPasaje = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idPasaje);
           int verificar= ps.executeUpdate();
            if(verificar > 0){
            JOptionPane.showMessageDialog(null,"Venta anulada");
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al anular venta");
            System.out.println(ex.getMessage());
        }
}
public boolean asientosDisponibles(Colectivo c,Pasaje p ){ 
    boolean disponibilidad=false;
   
int capacidad=c.getCapacidad();

        if(p.getColectivo().getIdColectivo()==c.getIdColectivo() && c.getCapacidad()>0){
            if(capacidad < p.getAsiento()){
                capacidad--;  
            }
        }
        System.out.println("Capacidad: "+capacidad);
        if(capacidad>0){
        disponibilidad=true;
        }
        return disponibilidad;

}
}
