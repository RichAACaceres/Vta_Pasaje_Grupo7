
package vta_pasaje_grupo7.AccesoDato;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vta_pasaje_grupo7.Entidades.*;


public class HorarioData {
    Connection con=Conexion.getConexion();
    public void agregarHorario(Horario h){
        String sql="INSERT INTO `horario` (`idRuta`, `horasalida`, `horallegada`, `estado`) "
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            System.out.println(h.getRuta().getIdRuta());
            ps.setInt(1,h.getRuta().getIdRuta());
            ps.setTime(2,Time.valueOf(h.getHoraSalida()));
            ps.setTime(3,Time.valueOf(h.getHoraLlegada()));
            ps.setBoolean(4,h.isEstado());
           ps.executeUpdate();
           ResultSet rs= ps.getGeneratedKeys();
           if(rs.next()){
           h.setIdHorario(rs.getInt("idHorario"));
           JOptionPane.showMessageDialog(null, "Horario cargado");
           }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar horario");
            System.out.println(ex.getMessage());
        }
    
    }
    public ArrayList<Horario>horariosDisponibles(){
   RutaData rd=new RutaData();
   
   ArrayList<Ruta>rutas=rd.rutasDisponibles();
        ArrayList<Horario>horarios=new ArrayList();
        String sql="SELECT * FROM horario WHERE estado > 0";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
            Horario horario=new Horario();
            horario.setIdHorario(rs.getInt("idHorario"));
            for(Ruta r:rutas){
            if(r.getIdRuta()==rs.getInt("idRuta")){
            horario.setRuta(r);
            }
            }
            horario.setHoraSalida(rs.getTime("horasalida").toLocalTime());
            horario.setHoraSalida(rs.getTime("horallegada").toLocalTime());
            horario.setEstado(true);
            horarios.add(horario);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar horarios disponibles");
            System.out.println(ex.getMessage());
        }
    
    return horarios;
    
    }
public ArrayList<Horario> horarioDisponiblesPorRuta(Ruta r){
    ArrayList<Horario>horarios=new ArrayList();
    
    String sql="SELECT * FROM `horario` WHERE idRuta = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,r.getIdRuta());
           ResultSet rs= ps.executeQuery();
           while(rs.next()){
           Horario horario=new Horario();
           horario.setEstado(rs.getBoolean("estado"));
           horario.setHoraLlegada(rs.getTime("horallegada").toLocalTime());
           horario.setHoraSalida(rs.getTime("horasalida").toLocalTime());
           horario.setIdHorario(rs.getInt("idHorario"));
           horario.setRuta(r);
          horarios.add(horario);
           }
           ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar horarios disponibles por ruta");
            System.out.println(ex.getMessage());
        }
        return horarios;
    
    

}
//public ArrayList<Horario>horariosPorHorarioSalida(Horario h,ArrayList<Ruta> rutas){
//ArrayList<Horario>horarios=new ArrayList();
//
//String sql="SELECT * FROM ruta,horario WHERE ruta.idRuta=horario.idRuta AND horario.horasalida = ?";
//        try {
//            PreparedStatement ps=con.prepareStatement(sql);
//             
//            ps.setTime(1, Time.valueOf(h.getHoraSalida()));
//           
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//            Horario horario=new Horario();
//       for(Ruta r:rutas){
//       if(rs.getInt("idRuta")==r.getIdRuta()){
//       horario.setEstado(rs.getBoolean("estado"));
//           horario.setHoraLlegada(rs.getTime("horallegada").toLocalTime());
//           horario.setHoraSalida(rs.getTime("horasalida").toLocalTime());
//           horario.setIdHorario(rs.getInt("idHorario"));
//         horario.setRuta(r);
//          horarios.add(horario);
//       }
//       }
//           
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al listar horarios por salida");
//            System.out.println(ex.getMessage());
//        }
//
//return horarios;
//}
}


