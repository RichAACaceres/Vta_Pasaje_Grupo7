/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.time.LocalTime;
import javax.swing.table.DefaultTableModel;
import vta_pasaje_grupo7.AccesoDato.*;
import vta_pasaje_grupo7.Entidades.*;

/**
 *
 * @author ST-P
 */
public class GestionHorarios extends javax.swing.JInternalFrame {

    DefaultTableModel modelo= new DefaultTableModel();
    DefaultTableModel modelo2= new DefaultTableModel();
    public GestionHorarios() {
        initComponents();
        armarCabeceraRutas();
        rellenarTablaRutas();
        armarCabeceraHorarios();
        rellenarTablaConTodosLosHorarios();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoHorarios = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRutas = new javax.swing.JTable();
        jbAgregarHorarios = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtHorarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Gestión de horarios");
        setToolTipText("");

        fondoHorarios.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Elija una ruta");

        jtRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtRutasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtRutas);

        jbAgregarHorarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAgregarHorarios.setText("Agregar horarios a la ruta seleccionada");
        jbAgregarHorarios.setEnabled(false);
        jbAgregarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarHorariosActionPerformed(evt);
            }
        });

        jtHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtHorarios.setEnabled(false);
        jScrollPane2.setViewportView(jtHorarios);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Horarios disponibles");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Gestionar horarios");

        javax.swing.GroupLayout fondoHorariosLayout = new javax.swing.GroupLayout(fondoHorarios);
        fondoHorarios.setLayout(fondoHorariosLayout);
        fondoHorariosLayout.setHorizontalGroup(
            fondoHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoHorariosLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(fondoHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoHorariosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(fondoHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoHorariosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(273, 273, 273))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoHorariosLayout.createSequentialGroup()
                        .addComponent(jbAgregarHorarios)
                        .addGap(208, 208, 208))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoHorariosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(294, 294, 294))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoHorariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(254, 254, 254))
        );
        fondoHorariosLayout.setVerticalGroup(
            fondoHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoHorariosLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbAgregarHorarios)
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Gestión de horarios");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtRutasMouseClicked
      HorarioData hd=new HorarioData();
      
try{
      rellenarTablaHorariosPorRuta();
        jbAgregarHorarios.setEnabled(true);
}catch(Exception e){
    System.out.println(e.getMessage());
}    
    }//GEN-LAST:event_jtRutasMouseClicked

    private void jbAgregarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarHorariosActionPerformed
       int filaSeleccionada= jtRutas.getSelectedRow();
       RutaData rd=new RutaData();
    
       if(filaSeleccionada!=-1){
        fondoHorarios.removeAll();
       fondoHorarios.repaint();
       GestionHorarios2 gh=new GestionHorarios2();
     fondoHorarios.add(gh);
     gh.setVisible(true);
     gh.moveToFront();
   
   
       }
       
       
    }//GEN-LAST:event_jbAgregarHorariosActionPerformed


public void armarCabeceraRutas(){
modelo.addColumn("idRuta");
modelo.addColumn("Origen");
modelo.addColumn("Origen");
modelo.addColumn("Duración estimada");
jtRutas.setModel(modelo);
}
public void borrarFilas(){
while(modelo2.getRowCount()>0){
modelo2.removeRow(0);
}
}
public void rellenarTablaRutas(){
    RutaData rd=new RutaData();
for(Ruta r:rd.rutasDisponibles()){
modelo.addRow(new Object[]{r.getIdRuta(),r.getOrigen(),r.getDestino(),r.getDuracionEstima()});
}
}
public void armarCabeceraHorarios(){
modelo2.addColumn("idHorario");
modelo2.addColumn("Ruta");
modelo2.addColumn("Horario salida");
modelo2.addColumn("Horario de llegada");
jtHorarios.setModel(modelo2);
}
public void rellenarTablaHorariosPorRuta(){
borrarFilas();
HorarioData hd=new HorarioData();
RutaData rd=new RutaData();

int fila=jtRutas.getSelectedRow();
if(fila!=-1){
    int idRuta=(int) modelo.getValueAt(fila, 0);
    String origen=(String) modelo.getValueAt(fila, 1);
    String destino=(String) modelo.getValueAt(fila, 2);
    LocalTime duracion=(LocalTime) modelo.getValueAt(fila, 3);
    Colectivo cole=ColeGuardado.getCole();
    Ruta ruta=new Ruta(idRuta,origen,destino,duracion,cole,true);
    RutaSeleccionada.setRutaSeleccionada(ruta);
    
for(Horario h:hd.horarioDisponiblesPorRuta(ruta)){
modelo2.addRow(new Object[]{h.getIdHorario(),h.getRuta(),h.getHoraSalida(),h.getHoraLlegada()});

}
}
}
public void rellenarTablaConTodosLosHorarios(){
    HorarioData hd=new HorarioData();
    
for(Horario h:hd.horariosDisponibles()){
modelo2.addRow(new Object[]{h.getIdHorario(),h.getRuta(),h.getHoraSalida(),h.getHoraSalida()});
}
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondoHorarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAgregarHorarios;
    private javax.swing.JTable jtHorarios;
    private javax.swing.JTable jtRutas;
    // End of variables declaration//GEN-END:variables
}
