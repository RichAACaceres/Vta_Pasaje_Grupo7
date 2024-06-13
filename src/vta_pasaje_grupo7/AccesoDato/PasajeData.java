
package vta_pasaje_grupo7.AccesoDato;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vta_pasaje_grupo7.Entidades.*;


public class PasajeData {
    
    Connection con=Conexion.getConexion();
    
    public boolean asientosDisponibles(Colectivo c,Pasaje p){ 
    boolean disponibilidad=false;
   
    int capacidad=c.getCapacidad();


    System.out.println("Capacidad original: "+capacidad);
        if( capacidad >= 0){
            
                 capacidad--;
            
        }
        
        c.setCapacidad(capacidad);
        
        System.out.println("Capacidad luego de la venta: "+c.getCapacidad());
        ColectivoData cd= new ColectivoData();
        cd.ActualizarCapacidad(capacidad,c.getIdColectivo());
        
        if(capacidad>=0){
        disponibilidad=true;
        }else{
        disponibilidad=false;
        JOptionPane.showMessageDialog(null, "No queda más capacidad en este colectivo");
        }
        return disponibilidad;

}
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
               ColectivoData cd=new ColectivoData();
                
               for(Colectivo c:cd.listarColectivos()){
                   
               if(c.getIdColectivo()==p.getColectivo().getIdColectivo()){
                   System.out.println("Capacidad de la base de datos: "+c.getCapacidad());
                   
                   System.out.println("--------------------------------------------------");
                  
                   if(asientosDisponibles(c, p)==true){
                    
                       System.out.println("Capacidad luego de vender: "+c.getCapacidad());
                     ps.executeUpdate();
                   }
               }
               }
          
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
public ArrayList<Pasaje>pasajesVendidos(){
    RutaData rd=new RutaData();
    PasajeroData pd=new PasajeroData();
    ColectivoData cd=new ColectivoData();
ArrayList<Ruta> rutas=rd.rutasDisponibles();
ArrayList<Pasajero> pasajeros=pd.listaDePasajeros();
ArrayList<Colectivo> colectivos=cd.listarColectivos();
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
public ArrayList<Pasaje>pasajesVendidosPorRuta(int id ){
   RutaData rd=new RutaData();
   PasajeData pd=new PasajeData();
   PasajeroData pasajerod=new PasajeroData();
   ColectivoData cd=new ColectivoData();
ArrayList<Pasaje>pasajes=new ArrayList();
ArrayList<Ruta> rutas=rd.rutasDisponibles();
ArrayList<Pasajero> pasajeros=pasajerod.listaDePasajeros();
ArrayList<Colectivo> colectivos=cd.listarColectivos();
String sql="SELECT * FROM pasaje,ruta WHERE pasaje.idRuta=ruta.idRuta AND ruta.idRuta = ? ";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
           
          
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
public ArrayList<Colectivo> obtenerColectivoPorRuta(int id){
String sql="SELECT * FROM colectivo,ruta,pasaje WHERE pasaje.idColectivo=colectivo.idColectivo AND ruta.idRuta = pasaje.idRuta AND ruta.idRuta = ?";

ColectivoData cd=new ColectivoData();
PasajeData pd=new PasajeData();
ArrayList<Colectivo>colectivos=new ArrayList();
ArrayList<Colectivo>coles=cd.listarColectivos();
ArrayList<Pasaje>pasajes=pd.pasajesVendidos();
try {
            PreparedStatement ps=con.prepareStatement(sql);
          ps.setInt(1, id);
           ResultSet rs= ps.executeQuery();
           if(rs.next()){
               Colectivo colectivo=new Colectivo(); 
           for(Colectivo c:coles){
               for(Pasaje p: pasajes){
           if(c.getIdColectivo()==p.getColectivo().getIdColectivo() && p.getRuta().getIdRuta()==id){
               colectivo=c;
            colectivos.add(colectivo);
           }
               }
              
           }
           
           }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener colectivo");
            System.out.println(ex.getMessage());
        }
        return colectivos;
}
}
