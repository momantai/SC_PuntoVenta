/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.clientes;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javax.swing.table.DefaultTableModel;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author momantai
 */
public class FrmClientes extends javax.swing.JFrame {

    /**
     * Creates new form FrmClientes
     */
    public FrmClientes() {
        initComponents();
        this.setTitle("Clientes");
        consultas();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        lblDebe = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        EditarCliente = new javax.swing.JButton();
        EliminarCliente = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        lblDebe.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblDebe.setText(" ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setText("$");

        jLabel3.setText("Cliente:");

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombre.setText(" ");

        lblApellidos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblApellidos.setText(" ");

        jLabel1.setText("Adeudo desde:");

        lblFecha.setForeground(new java.awt.Color(51, 0, 0));
        lblFecha.setText(" ");

        jLabel5.setText("Contacto:");

        lblTel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTel.setText(" ");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        EditarCliente.setText("Editar");
        EditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarClienteActionPerformed(evt);
            }
        });

        EliminarCliente.setText("Eliminar");
        EliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarClienteActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(EditarCliente)
                                        .addGap(87, 87, 87)
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 61, Short.MAX_VALUE)
                                                .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(225, 225, 225)))
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(EliminarCliente)
                                .addGap(20, 20, 20))
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblFecha)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblNombre))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDebe)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblTel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(EditarCliente)
                    .addComponent(EliminarCliente)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private int id = 0;
    private String [] datospasar = new String[10];
    private void tblDatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMousePressed
        int row = tblDatos.getSelectedRow();
        
        String[] data = new String[10];
        data[0] = tblDatos.getValueAt(row, 1).toString();
        data[1] = tblDatos.getValueAt(row, 2).toString();
        data[2] = tblDatos.getValueAt(row, 3).toString();
        data[3] = tblDatos.getValueAt(row, 4).toString();
        data[4] = tblDatos.getValueAt(row, 5).toString();
        data[5] = tblDatos.getValueAt(row, 6).toString();
        data[6] = tblDatos.getValueAt(row, 7).toString();
        data[7] = tblDatos.getValueAt(row, 8).toString();
        data[8] = tblDatos.getValueAt(row, 9).toString();
        
        
        lblNombre.setText(data[0]);
        lblApellidos.setText(data[1] + " " + data[2]);
        lblTel.setText(data[3]);
        lblDebe.setText(data[4]);
        lblFecha.setText(data[5]);
        
        id = Integer.parseInt(tblDatos.getValueAt(row, 0).toString());
        System.out.println("id: " + id);
        
        datospasar = data;
    }//GEN-LAST:event_tblDatosMousePressed
        
    private void EditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarClienteActionPerformed
        DialClientes clientes = new DialClientes(id);
        if(id!=0){
            clientes.llenardatos(datospasar);
            clientes.setVisible(true);
            consultas();
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Seleccione un cliente.");
    }//GEN-LAST:event_EditarClienteActionPerformed
        DialClientes Actclientes = new DialClientes();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Actclientes.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed
        Connection con = new Conexion().conectar();
    private void EliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarClienteActionPerformed
        float a;
        String delete = "DELETE FROM clientes WHERE idCliente = " + id;
        
        PreparedStatement stmt;
        
        if(id!=0){
            a = Float.parseFloat(lblDebe.getText());
            if (a == 0){
                
                try {
                    stmt = con.prepareStatement(delete);
                    stmt.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(rootPane, "El usuario se ha eliminado.");
                consultas();
            } else 
                JOptionPane.showMessageDialog(rootPane, "El usuario no se puede eliminar hasta que pague su adeudo.");
        } else
            JOptionPane.showMessageDialog(rootPane, "Seleccione un cliente.");
    }//GEN-LAST:event_EliminarClienteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        consultas();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    public void consultas(){
        
        String[] nColumns = {"id", "Nombre", "Apellido P.", "Apellido M.", "Telefono", "Saldo", "Fecha", "RFC", "Domicilio", "Correo" };
        String query = "SELECT idCliente, nombre, apepatC, apematC, telefonoC, saldo, fechaAlta, rfc, Domicilio, correo FROM clientes;";
        DefaultTableModel m = new DefaultTableModel(null, nColumns){
            public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        
        String datos[] = new String[10];
        
        try {
            Statement sta = (Statement) con.createStatement();
            ResultSet r = sta.executeQuery(query);
            
            while (r.next()) {
                datos[0] = r.getString(1);
                datos[1] = r.getString(2);
                datos[2] = r.getString(3);
                datos[3] = r.getString(4);
                datos[4] = r.getString(5);
                datos[5] = r.getString(6);
                datos[6] = r.getString(7);
                datos[7] = r.getString(8);
                datos[8] = r.getString(9);
                datos[9] = r.getString(10);
                
                m.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tblDatos.setModel(m);
        tblDatos.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDatos.getColumnModel().getColumn(0).setMinWidth(0);
        tblDatos.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblDatos.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDatos.getColumnModel().getColumn(5).setMinWidth(0);
        tblDatos.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblDatos.getColumnModel().getColumn(7).setMaxWidth(0);
        tblDatos.getColumnModel().getColumn(7).setMinWidth(0);
        tblDatos.getColumnModel().getColumn(7).setPreferredWidth(0);
        tblDatos.getColumnModel().getColumn(8).setMaxWidth(0);
        tblDatos.getColumnModel().getColumn(8).setMinWidth(0);
        tblDatos.getColumnModel().getColumn(8).setPreferredWidth(0);
        tblDatos.getColumnModel().getColumn(9).setMaxWidth(0);
        tblDatos.getColumnModel().getColumn(9).setMinWidth(0);
        tblDatos.getColumnModel().getColumn(9).setPreferredWidth(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditarCliente;
    private javax.swing.JButton EliminarCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblDebe;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTel;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
