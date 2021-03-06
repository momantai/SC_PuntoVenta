/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.compras;

import conexion.Control;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reportes.Reporte;

/**
 *
 * @author awelo
 */
public class FrmCompras extends javax.swing.JFrame {

    java.util.Calendar calendario = new java.util.GregorianCalendar();
    Control controla = new Control();
    private DefaultTableModel modelo= new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int columnIndex){return false;}
    };
    /**
     * Creates new form FrmCompras
     */
    public FrmCompras() {
        initComponents();
        //setearDias();
        llenarTabla();
    }
    
    /*private void setearDias(){
        for(int i=1; i<=31; i++){
            cmbxDiaIn.addItem(i);
        }
        String[] meses={"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
        for(int i=0; i<=11; i++){
            cmbxMesIn.addItem(meses[i]);
            cmbxMesFin.addItem(meses[i]);
        }
        for(int i=calendario.get(calendario.YEAR); i>=2000; i--){
            cmbxAnioIn.addItem(i);
            cmbxAnioFin.addItem(i);
        }
        
        cmbxMesFin.setSelectedIndex(calendario.get(calendario.MONTH));
        if(calendario.get(calendario.MONTH)==2){
            cmbxDiaFin.removeAllItems();
            if(calendario.get(calendario.YEAR)%4==0){
                for(int i=1; i<=29; i++){
                    cmbxDiaFin.addItem(i);
                }
            }else{
                for(int i=1; i<=28; i++){
                    cmbxDiaFin.addItem(i);
                }
            }
        }else if(calendario.get(calendario.MONTH)==4 || calendario.get(calendario.MONTH)==6 || calendario.get(calendario.MONTH)==9 || calendario.get(calendario.MONTH)==11){
            for(int i=1; i<=30; i++){
                cmbxDiaFin.addItem(i);
            }
        }
        cmbxDiaFin.setSelectedIndex(calendario.get(calendario.DAY_OF_MONTH)-1);
    }*/
    private void setearModelo(){
        if(modelo.getColumnCount()==0){
            modelo.addColumn("No Compra");
            modelo.addColumn("Monto");
            modelo.addColumn("Proveedor");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora");
        }
        
        while(modelo.getRowCount()!=0){
            modelo.removeRow(modelo.getRowCount()-1);
        }
    }
    public void llenarTabla(){
        setearModelo();
        ResultSet obtenido=controla.mostrarCompras();
        if(obtenido!=null){
            try{
                String[] datos = new String[5];
                while(obtenido.next()){
                    datos[0]=obtenido.getString(1);
                    datos[1]=obtenido.getString(2);
                    datos[2]=obtenido.getString(3);
                    datos[3]=obtenido.getString(4);
                    datos[4]=obtenido.getString(5);
                    modelo.addRow(datos);
                }
                tblCompras.setModel(modelo);
            } catch(SQLException e){
                System.out.println("Error al cargar "+e);
            }
        }
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
        tblCompras = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compras");

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCompras);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(117, 117, 117)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReporte)
                        .addGap(56, 56, 56)
                        .addComponent(btnCancelar)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar)
                        .addComponent(btnEliminar)
                        .addComponent(btnCancelar))
                    .addComponent(btnReporte))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(tblCompras.getSelectedRow()>-1){
            if(JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar esta compra?")==0){
                if(controla.borrarCompra((String) tblCompras.getValueAt((int) tblCompras.getSelectedRow(), 0))==1){
                    JOptionPane.showMessageDialog(this, "Compra Eliminada");
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al actualizar");
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        
        ResultSet obte=controla.mostrarCompras();
        Reporte reporta = new Reporte();
        reporta.escribirArchivoCompra("reporte", obte);
        reporta.conevertirPdf("reporte");
    }//GEN-LAST:event_btnReporteActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCompras;
    // End of variables declaration//GEN-END:variables
}
