/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vta_pasaje_grupo7.AccesoDato.*;
import vta_pasaje_grupo7.Entidades.*;



/**
 *
 * @author ST-P
 */
public class GestionPasajeros extends javax.swing.JInternalFrame {
DefaultTableModel modelo=new DefaultTableModel();
    
    public GestionPasajeros() {
        initComponents();
        armarCabecerea();
        rellenarTabla();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoPasajero = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPasajeros = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        jtTelefono = new javax.swing.JTextField();
        jtEstado = new javax.swing.JRadioButton();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jbNUevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtDNI = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();

        setTitle("Gestión pasajeros");

        jtPasajeros.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPasajeros.setEnabled(false);
        jScrollPane1.setViewportView(jtPasajeros);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Telefono:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Estado:");

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.setEnabled(false);
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Lista de pasajeros");

        jbNUevo.setText("Nuevo");
        jbNUevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNUevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoPasajeroLayout = new javax.swing.GroupLayout(fondoPasajero);
        fondoPasajero.setLayout(fondoPasajeroLayout);
        fondoPasajeroLayout.setHorizontalGroup(
            fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPasajeroLayout.createSequentialGroup()
                .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(fondoPasajeroLayout.createSequentialGroup()
                        .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2))
                            .addComponent(jLabel6)
                            .addGroup(fondoPasajeroLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoPasajeroLayout.createSequentialGroup()
                                .addComponent(jtEstado)
                                .addGap(36, 36, 36)
                                .addComponent(jbNUevo)
                                .addGap(39, 39, 39)
                                .addComponent(jbGuardar)
                                .addGap(27, 27, 27)
                                .addComponent(jbEliminar)
                                .addGap(103, 103, 103))
                            .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(fondoPasajeroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoPasajeroLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoPasajeroLayout.setVerticalGroup(
            fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPasajeroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoPasajeroLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbGuardar)
                            .addComponent(jbEliminar)
                            .addComponent(jbNUevo)))
                    .addGroup(fondoPasajeroLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(fondoPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtEstado)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Gestionar pasajeros");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("DNI:");

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPasajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fondoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
     PasajeroData pd=new PasajeroData();
     try{
         int aux=0;
     int dni=Integer.parseInt(jtDNI.getText());
     for(Pasajero p:pd.listaDePasajeros()){
     if(p.getDni()==dni && dni > 0){
     jtNombre.setText(p.getNombre());
     jtApellido.setText(p.getApellido());
     jtEmail.setText(p.getEmail());
     jtTelefono.setText(String.valueOf(p.getTelefono()));
     jtEstado.setSelected(p.isEstado());
     jbEliminar.setEnabled(true);
     aux=1;
     }
    
     }
     if(aux==0){
     JOptionPane.showMessageDialog(this, "No existe un pasajero con este dni");
     }
     }catch(NumberFormatException ex){
         JOptionPane.showMessageDialog(this, "Verifique que el campo dni no contenga espacios ni letras");
     }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        PasajeroData pd=new PasajeroData();
        int dni=Integer.parseInt(jtDNI.getText()) ;
      for(Pasajero p:pd.listaDePasajeros()){
      if(dni==p.getDni()){
      pd.eliminarPasajero(dni);
      }
      }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbNUevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNUevoActionPerformed
       jtDNI.setText("");
        jtNombre.setText("");
         jtApellido.setText("");
          jtEmail.setText("");
           jtTelefono.setText("");
            jtEstado.setSelected(false);
            jbEliminar.setEnabled(false);
    }//GEN-LAST:event_jbNUevoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try{
        int dni=Integer.parseInt(jtDNI.getText());
        String nombre=jtNombre.getText();
        String apellido=jtApellido.getText();
        String email=jtEmail.getText();
        float telefono=Float.parseFloat(jtTelefono.getText());
        boolean estado=true;
       
        PasajeroData pd=new PasajeroData();
        if(dni>0 && !nombre.equals("")&&!apellido.equals("")&&!email.equals("")&&telefono>0){
         Pasajero pasajero=new Pasajero(nombre,apellido,dni,email, (int) telefono,estado);
        pd.agregarPasajeros(pasajero);
        jtEstado.setSelected(true);
        }else{
        JOptionPane.showMessageDialog(this, "Complete todos los campos para guarda un pasajero");
        }
        }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(this, "Verifique que dni y telefono sean numéricos");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

public void armarCabecerea(){
modelo.addColumn("IdPasajero");
modelo.addColumn("Dni");
modelo.addColumn("apellido");
modelo.addColumn("Nombre");
modelo.addColumn("Telefono");
modelo.addColumn("Email");
jtPasajeros.setModel(modelo);

}
public void rellenarTabla(){
PasajeroData pd=new PasajeroData();
for(Pasajero p:pd.listaDePasajeros()){
modelo.addRow(new Object[]{
    p.getIdPasajero(),
    p.getDni(),
    p.getApellido(),
    p.getNombre(),
    p.getTelefono(),
    p.getEmail()


});
}

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondoPasajero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNUevo;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JRadioButton jtEstado;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTable jtPasajeros;
    private javax.swing.JTextField jtTelefono;
    // End of variables declaration//GEN-END:variables
}
