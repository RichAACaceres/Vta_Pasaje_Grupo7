
package vta_pasaje_grupo7.AccesoDato;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vta_pasaje_grupo7.Entidades.*;


public class ColectivoData {
    Connection con=Conexion.getConexion();
    public void cargarColectivo(Colectivo c){
    String sql="INSERT INTO `colectivo`( `matricula`, `marca`, `modelo`, `capacidad`, `estado`)" +
"VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getMatricula());
            ps.setString(2, c.getMarca());
            ps.setString(3,c.getModelo());
            ps.setInt(4, c.getCapacidad());
            ps.setBoolean(5,c.isEstado());
            ps.executeUpdate();
           ResultSet rs= ps.getGeneratedKeys();
             if(rs.next()){
             c.setIdColectivo(rs.getInt("idColectivo"));
             JOptionPane.showMessageDialog(null, "Colectivo cargado");
             }          
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al cargar colectivo");
            System.out.println(ex.getMessage());
        }
    }
public ArrayList<Colectivo> listarColectivos(){
ArrayList<Colectivo>colectivos=new ArrayList();
        String sql="SELECT * FROM colectivo WHERE estado > 0";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
           while(rs.next()){
           Colectivo colectivo=new Colectivo();
           colectivo.setMatricula(rs.getString("matricula"));
           colectivo.setMarca(rs.getString("marca"));
           colectivo.setModelo(rs.getString("modelo"));
           colectivo.setCapacidad(rs.getInt("capacidad"));
           colectivo.setEstado(true);
           colectivo.setIdColectivo(rs.getInt("idColectivo"));
           colectivos.add(colectivo);
           
           }
           ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar colectivos");
            System.out.println(ex.getMessage());
        }


return colectivos;


}
public void ActualizarCapacidad(int capacidad,int id){
String sql="UPDATE colectivo SET capacidad = ? WHERE colectivo.idColectivo = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, capacidad);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar capacidad");
            System.out.println(ex.getMessage());
        }

}
public ArrayList<Colectivo>colectivosPorRuta(Ruta ruta){
ArrayList<Colectivo>colectivos=new ArrayList();
ColectivoData cd=new ColectivoData();
ArrayList<Colectivo>colectivosCargados=cd.listarColectivos();
    
String sql="SELECT * FROM colectivo,ruta WHERE colectivo.idColectivo = Ruta.idColectivo AND ruta.idRuta = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, ruta.getIdRuta());
           ResultSet rs= ps.executeQuery();
           while(rs.next()){
           Colectivo colectivo=new Colectivo();
           for(Colectivo c:colectivosCargados){
               
           if(c.getIdColectivo()==ruta.getColectivo().getIdColectivo()){
               colectivo.setCapacidad(c.getCapacidad());
           colectivo.setIdColectivo(c.getIdColectivo());
           colectivo.setEstado(true);
           colectivo.setMarca(c.getMarca());
           colectivo.setMatricula(c.getMatricula());
           colectivo.setModelo(c.getModelo());
           colectivos.add(colectivo);
           }
           }
           
           }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar colectivos por ruta");
            System.out.println(ex.getMessage());
        }
        return colectivos;
}
}
