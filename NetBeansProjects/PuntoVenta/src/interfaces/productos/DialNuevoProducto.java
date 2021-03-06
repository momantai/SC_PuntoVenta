/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.productos;

import conexion.*;
import entidades.Productos;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author awelo
 */
public class DialNuevoProducto extends javax.swing.JDialog {

    private Conexion cone= new Conexion();
    private String paquete;
    private int cantidad;
    /**
     * Creates new form DialNuevoProducto
     */
    public DialNuevoProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenarClasificacion(cone.datosClasificacion());
        paquete="";
        cantidad=1;
        txtCantidad.setEnabled(false);
    }
    
    /*
        Metodo para llenar el combobox
    */
    public void llenarClasificacion(ResultSet obten){
        try{
            while(obten.next()){
                cmbxClasificacion.addItem(obten.getString(1));
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion"+e);
        }
    }
    public void limpiarCampos(){
        for(Component prueba : panContener.getComponents()){
            if(prueba instanceof JTextField){
                ((JTextField) prueba).setText("");
            }
        }
    }
    public boolean camposVacios(){
        boolean vacio=false;
        for(Component prueba : panContener.getComponents()){
            if(prueba instanceof JTextField){
                if(prueba!=txtCantidad)
                if(((JTextField) prueba).getText().equals("")){
                    vacio=true;
                }
            }
        }
        return vacio;
    }
    
    public void darDatos(String Codigo){
        txtCodigo.setText(Codigo);
        txtCodigo.setEnabled(false);
        try{
            ResultSet valores = cone.darUnValor(Codigo);
            while(valores.next()){
                txtDescripcion.setText(valores.getString(1));
                cmbxClasificacion.setSelectedIndex(valores.getInt(2)-1);
                txtPrecio.setText(valores.getString(3));
                if(valores.getInt(4)==1){
                    chbxActivo.setSelected(true);
                }
                int cant=valores.getInt(5);
                if(cant==1){
                    txtCantidad.setEnabled(false);
                }else{
                    txtCantidad.setText(String.valueOf(cant));
                }
                String pap=valores.getString(6);
                if(!txtDescripcion.getText().equals(pap)){
                    lblPaquete.setText("Paquete de "+pap);
                    chbxPaquete.setSelected(true);
                }else{
                    chbxPaquete.setEnabled(false);
                }
            }
            btnLimpiar.setEnabled(false);
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Error al cargar los Datos "+e);
        }
    }
    public boolean verificar(String cod){
        ResultSet obtener = cone.datosClasificacion();
        boolean ok= true;
        try{
            if(obtener.next()){
                if(obtener.getString(1).equals(cod)){
                    ok=false;
                }
            }
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return ok;
    }
    public void setBoton(String texto){
        btnAceptar.setText(texto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        panContener = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        cmbxClasificacion = new javax.swing.JComboBox<String>();
        txtPrecio = new javax.swing.JTextField();
        chbxActivo = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chbxPaquete = new javax.swing.JCheckBox();
        lblPaquete = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnClasif = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Producto");

        btnAceptar.setText("Agregar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        chbxActivo.setText("ACTIVO");

        jLabel1.setText("CODIGO:");

        jLabel2.setText("DESCRIPCION:");

        jLabel3.setText("CLASIFICACION:");

        jLabel4.setText("PRECIO:");

        chbxPaquete.setText("Paquete");
        chbxPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxPaqueteActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad:");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnClasif.setText("Nueva Clas.");
        btnClasif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panContenerLayout = new javax.swing.GroupLayout(panContener);
        panContener.setLayout(panContenerLayout);
        panContenerLayout.setHorizontalGroup(
            panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panContenerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(chbxPaquete))
                .addGroup(panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panContenerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chbxActivo)
                        .addGap(136, 136, 136))
                    .addGroup(panContenerLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panContenerLayout.createSequentialGroup()
                                .addGroup(panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panContenerLayout.createSequentialGroup()
                                .addComponent(cmbxClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(btnClasif)
                                .addGap(21, 21, 21))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panContenerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPaquete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panContenerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(60, 60, 60)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panContenerLayout.setVerticalGroup(
            panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panContenerLayout.createSequentialGroup()
                .addGroup(panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panContenerLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addGroup(panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chbxActivo)
                            .addComponent(chbxPaquete)))
                    .addGroup(panContenerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbxClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClasif))))
                .addGap(18, 18, 18)
                .addComponent(lblPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panContener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panContener, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnAceptar))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        if(camposVacios()){
            JOptionPane.showMessageDialog(this, "Datos incompletos");
        }else if(btnAceptar.getText().equals("Agregar")){
            if(verificar(txtCodigo.getText())){
                Productos producto = new Productos();
                Control controla = new Control();
        
                producto.setCodigo(Integer.parseInt(txtCodigo.getText()));
                producto.setDescripcion(txtDescripcion.getText());
                producto.setClasificacion(cmbxClasificacion.getSelectedIndex()+1);
                producto.setPrecio(Float.parseFloat(txtPrecio.getText()));
        
                if(chbxActivo.isSelected()){
                    producto.setActivo(1);
                }else{
                    producto.setActivo(0);
                }
                
                if(!txtCantidad.isEnabled()){
                    producto.setCantidad(1);
                }else{
                    producto.setCantidad(Integer.parseInt(txtCantidad.getText()));
                }
                
                if(chbxPaquete.isSelected()){
                    producto.setRef(paquete);
                }else{
                    producto.setRef(txtCodigo.getText());
                }
        
                if(controla.registrarProductos(producto, paquete)==1){
                    JOptionPane.showMessageDialog(this, "Producto Registrado");
                    this.dispose();
                } else{
                    JOptionPane.showMessageDialog(this, "Error al Cargar");
                }    
            } else{
                JOptionPane.showMessageDialog(this, "El Producto con ese código ya existe");
            }
        } else{
            Productos producto = new Productos();
            Control controla = new Control();
        
            producto.setCodigo(Integer.parseInt(txtCodigo.getText()));
            producto.setDescripcion(txtDescripcion.getText());
            producto.setClasificacion(cmbxClasificacion.getSelectedIndex()+1);
            producto.setPrecio(Float.parseFloat(txtPrecio.getText()));
        
            if(chbxActivo.isSelected()){
                producto.setActivo(1);
            }else{
                producto.setActivo(0);
            }
            if(controla.modificarProductos(producto, paquete)==1){
                JOptionPane.showMessageDialog(this, "Producto Actualizado");
                this.dispose();
            } else{
                JOptionPane.showMessageDialog(this, "Error al Cargar");
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
        char tecla =evt.getKeyChar();
        if(!Character.isDigit(tecla)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
        char tecla = evt.getKeyChar();
        
        int contador = 0, numeros=0;
        boolean bandera= false;
        while(contador<txtPrecio.getText().length()){
            if(txtPrecio.getText().charAt(contador)=='.'){
                bandera=true;
                numeros=contador;
            }
            contador++;
        }
        
        if(!Character.isDigit(tecla) & tecla!='.'){
            evt.consume();
        } else if(tecla=='.' & bandera){
            evt.consume();
        } else if(contador-numeros==3 & bandera){
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed

    }//GEN-LAST:event_txtCodigoKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        cmbxClasificacion.setSelectedIndex(0);
        chbxActivo.setSelected(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost
        // TODO add your handling code here:
        txtDescripcion.setText(txtDescripcion.getText().toUpperCase());
    }//GEN-LAST:event_txtDescripcionFocusLost

    private void chbxPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxPaqueteActionPerformed
        // TODO add your handling code here:
        if(chbxPaquete.isSelected()){
            paquete=JOptionPane.showInputDialog("Inserta el codigo del producto");
            String obte=cone.buscarInven(paquete);
            if(obte!=null){
                lblPaquete.setText("Paquete de "+obte);
                txtCantidad.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "El codigo especificado no existe");
                paquete="";
                chbxPaquete.setSelected(false);
            }
        }else{
            paquete="";
            lblPaquete.setText("");
            txtCantidad.setEnabled(false);
        }
    }//GEN-LAST:event_chbxPaqueteActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
        char tecla =evt.getKeyChar();
        if(!Character.isDigit(tecla)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnClasifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasifActionPerformed
        // TODO add your handling code here:
        String dato=JOptionPane.showInputDialog("Ingresa la clasificación").toUpperCase();
        Control cono = new Control();
        if(cono.agregarClasificacion(dato)==1){
            JOptionPane.showMessageDialog(this, "Clasificación agregada con éxtip");
            llenarClasificacion(cone.datosClasificacion());
        }else{
            JOptionPane.showMessageDialog(this, "Error en la conexion");
        }
    }//GEN-LAST:event_btnClasifActionPerformed

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
            java.util.logging.Logger.getLogger(DialNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialNuevoProducto dialog = new DialNuevoProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnClasif;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox chbxActivo;
    private javax.swing.JCheckBox chbxPaquete;
    private javax.swing.JComboBox<String> cmbxClasificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblPaquete;
    private javax.swing.JPanel panContener;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
