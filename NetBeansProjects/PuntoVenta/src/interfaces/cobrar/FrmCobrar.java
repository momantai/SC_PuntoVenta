/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.cobrar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javax.swing.table.DefaultTableModel;
import conexion.Conexion;
import interfaces.productos.FrmProductos;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author momantai
 */
public class FrmCobrar extends javax.swing.JFrame {

    /**
     * Creates new form FrmCobrar
     */
    public FrmCobrar() {
        initComponents();
        modeloTabla();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    Connection con = new Conexion().conectar();
    
    //Función para modelar la table (Ponerle el titulo y esas cosas).
    public void modeloTabla(){
        String[] columnas = {"Codigo","Producto", "Precio unitario", "Cantidad"};
        //String[][] datos = { {"25155412","Pastillas", "25.30", "3"}, {"5894651","Jabon", "15", "1"}, {"6845135","Jamon", "30.50", "1"} };
        DefaultTableModel m = new DefaultTableModel(null, columnas);
        tblModelar.setModel(m);
    }
    
    private int idEmpleado = 1;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenutabla = new java.awt.PopupMenu();
        menuItem1 = new java.awt.MenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModelar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtCodigoLector = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnCobrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        ventaCliente = new javax.swing.JButton();
        cobroCliente = new javax.swing.JButton();

        popupMenutabla.setLabel("popupMenu1");

        menuItem1.setLabel("Eliminar");
        menuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem1ActionPerformed(evt);
            }
        });
        popupMenutabla.add(menuItem1);

        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblModelar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblModelar.setToolTipText("Eliminar");
        tblModelar.setColumnSelectionAllowed(true);
        tblModelar.setComponentPopupMenu(jPopupMenu1);
        tblModelar.setGridColor(new java.awt.Color(255, 255, 255));
        tblModelar.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tblModelarComponentAdded(evt);
            }
        });
        tblModelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblModelarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblModelarKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblModelar);

        jLabel1.setText("TOTAL");

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 255, 0));
        lblTotal.setText("0.0");

        txtCodigoLector.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoLectorKeyPressed(evt);
            }
        });

        btnCobrar.setText("Cobrar");
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ventaCliente.setText("Venta a cliente");
        ventaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaClienteActionPerformed(evt);
            }
        });

        cobroCliente.setText("Cobro a cliente");
        cobroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobroClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigoLector, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotal)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCancelar))
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cobroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ventaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(35, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addGap(66, 66, 66)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(ventaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cobroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCobrar)
                            .addComponent(btnBuscar)
                            .addComponent(btnCancelar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Funcion para consultar en la base de datos si el producto existe.
    public ResultSet producto(String codigo) {
        ResultSet obtener = null;
        String sql = "SELECT codigoPro, descripcion, precio FROM productos WHERE codigoPro = '" + codigo + "'";
        
        try {
            Statement st = (Statement) con.createStatement();
            obtener = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error con base de datos.");
        }
        
        return obtener;
    }
    
    //Multiplica las cantidades por el precio unitario, y suma los resultados.
    //Da el total de la compra.
    public void total(){
        float Total = 0;
        float precio = 0;
        int cantidad = 0;
        
        int filas = tblModelar.getRowCount()-1;
        
        for(int i = 0; i<=(filas); i++) {
            Total += (Float.parseFloat(String.valueOf(tblModelar.getValueAt(i, 2))) * Integer.parseInt(String.valueOf(tblModelar.getValueAt(i, 3))));
        }
        
        lblTotal.setText(""+Total);
    }
    
    public void descontar(){
        int filas = tblModelar.getRowCount()-1;
        String sql = "";
        String cod = "";
        String cant = "";
        
        try {
            Statement st = (Statement) con.createStatement();
            for(int i = 0; i<=filas; i++){
                cod = String.valueOf(tblModelar.getValueAt(i, 0));
                cant = String.valueOf(tblModelar.getValueAt(i, 3));
                
                sql = "UPDATE inventario SET existencia = existencia-"+ cant +" WHERE codigo=  '" + cod + "'";
                
                st.executeUpdate(sql);
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error con base de datos.");
        }
        
    }
    
    public void cobrar(){
        Float total = Float.parseFloat(lblTotal.getText());
        Date ahora = new Date();
        SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatHora = new SimpleDateFormat("hh:mm:ss");
        
        String dia = formatFecha.format(ahora);
        String hora = formatHora.format(ahora);
        
        String sql = "INSERT INTO ventas(idEmpleado, monto, fecha, hora) VALUES(?,?,?,?)  ";
        
        ResultSet obtener = null;

        try {
            PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
                st.setInt(1, idEmpleado);
                st.setFloat(2, total);
                st.setDate(3, java.sql.Date.valueOf(dia));
                st.setTime(4, java.sql.Time.valueOf(hora));
                
                st.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error con base de datos.");
        }
        
    }
    
    public void cobraraclientequepaga(int idCliente, float monto){
        Date ahora = new Date();
        SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatHora = new SimpleDateFormat("hh:mm:ss");
        
        String dia = formatFecha.format(ahora);
        String hora = formatHora.format(ahora);
        
        String sql = "INSERT INTO pagosCliente(idEmpleadoCP, idClientePago, monto, fecha, hora) VALUES(?,?,?,?,?)";
        String sql1 = "UPDATE clientes SET saldo = saldo - ? WHERE idCliente = " + idCliente;
        
        ResultSet obtener = null;

        try {
            PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
                st.setInt(1, idEmpleado);
                st.setInt(2, idCliente);
                st.setFloat(3, monto);
                st.setDate(4, java.sql.Date.valueOf(dia));
                st.setTime(5, java.sql.Time.valueOf(hora));
                
                st.executeUpdate();
                
            PreparedStatement st1 = (PreparedStatement) con.prepareStatement(sql1);
                st1.setFloat(1, monto);

                st1.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error con base de datos.");
        }
        
    }
    
    public void cobrartoCliente(String identificador){
        Float total = Float.parseFloat(lblTotal.getText());
        Date ahora = new Date();
        SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatHora = new SimpleDateFormat("hh:mm:ss");
        
        String dia = formatFecha.format(ahora);
        String hora = formatHora.format(ahora);
        
        String sql = "INSERT INTO ventasClientes(idEmpleadoC, monto, fecha, hora) VALUES(?,?,?,?)";
        String sql1 = "UPDATE clientes SET saldo = saldo + ? WHERE idCliente = " + identificador;

        try {
            PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
                st.setInt(1, idEmpleado);
                st.setFloat(2, total);
                st.setDate(3, java.sql.Date.valueOf(dia));
                st.setTime(4, java.sql.Time.valueOf(hora));
                
                st.executeUpdate();
                
            PreparedStatement st1 = (PreparedStatement) con.prepareStatement(sql1);
                st1.setFloat(1, total);

                st1.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error con base de datos.");
        }
        
    }

    
    //Esta es una función que verifica si el producto existe en la base de datos por medio del codigo del producto.
    //Si existe extraera los datos de la bd y los agragara a la tabla.
    public void nuevoProductoAComprar() throws SQLException{
        DefaultTableModel m = null;
        m = (DefaultTableModel)this.tblModelar.getModel();
        String datos[] =  new String[4];
        String codigo = txtCodigoLector.getText();
            txtCodigoLector.setText("");
        ResultSet infoProducto = producto(codigo);
        if(infoProducto.next()){
            infoProducto.beforeFirst();
        try {
            while(infoProducto.next()){
                datos[0] = infoProducto.getString(1);
                datos[1] = infoProducto.getString(2);
                datos[2] = infoProducto.getString(3);
                datos[3] = "1";
            }
        } catch (SQLException ex) {
            System.out.println("Error aquí");
            Logger.getLogger(FrmCobrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        m.addRow(datos);
        tblModelar.setModel(m);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Producto agotado o no existe!");
        }
    }
    //Al agregar un producto manualmente.
    //Se agrega el producto a la tabla gracias a la funcion nuevoPruductoAComprar,
    //Y el total a pagar gracias a total.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            nuevoProductoAComprar();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCobrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        total();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblModelarComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tblModelarComponentAdded
        
    }//GEN-LAST:event_tblModelarComponentAdded

    private void tblModelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblModelarKeyPressed

    }//GEN-LAST:event_tblModelarKeyPressed
    //Funciona cuando se hace un cambio de cantidad manual.
    private void tblModelarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblModelarKeyReleased
        total();
    }//GEN-LAST:event_tblModelarKeyReleased

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        String a = JOptionPane.showInputDialog("A pagar con (Monto con el que el cliente pagara):");
        try{
            float pagoCon = Float.parseFloat(a);
            float subTotal = Float.parseFloat(lblTotal.getText());
            if(subTotal != 0) {
                if(pagoCon==0 || pagoCon < subTotal){
                    JOptionPane.showMessageDialog(rootPane, "Cantidad incorrecta!");
                } else {
                    float cambio = pagoCon - subTotal;

                    JOptionPane.showMessageDialog(rootPane, "Su cambio es: " + cambio);

                    descontar();

                    cobrar();

                    modeloTabla();

                    lblTotal.setText("0.0");
                }
            } else
                JOptionPane.showMessageDialog(rootPane, "No hay aticulos registrados.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Hago alguna acción.");
        }
        
        
        
        
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void menuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItem1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int o = JOptionPane.showConfirmDialog(rootPane, "Realmente desea cancelar");
        System.out.println("" + o);
        if(o == 0){
            modeloTabla();
            lblTotal.setText("0.0");
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCodigoLectorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoLectorKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("Presionaste ENTER");
            
            try {
                nuevoProductoAComprar();
            } catch (SQLException ex) {
                Logger.getLogger(FrmCobrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            total();
        }
    }//GEN-LAST:event_txtCodigoLectorKeyPressed
    
    FrmProductos n = new FrmProductos(true);
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        n.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        n.setTitle("Buscar en productos");
        n.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DefaultTableModel t = (DefaultTableModel)tblModelar.getModel();
        int row = tblModelar.getSelectedRow();
        t.removeRow(row);
        
        total();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ventaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaClienteActionPerformed
        String identificador = JOptionPane.showInputDialog("Ingrese identificador del cliente");
        String query = "SELECT nombre, apepatC, apematC FROM clientes WHERE idCliente = " + identificador;
        String nombreC = "";
        Statement sta;
        float subtotal = Float.parseFloat(lblTotal.getText());
        
        if(subtotal > 0){
            try {
                sta = (Statement) con.createStatement();
                ResultSet r = sta.executeQuery(query);

                while (r.next()) {
                    nombreC = r.getString("nombre")+ " " + r.getString("apepatC") + " " + r.getString("apematC");
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmCobrar.class.getName()).log(Level.SEVERE, null, ex);
            }

            int o = JOptionPane.showConfirmDialog(rootPane, "El cliente: ***" + nombreC + "*** ¿Es correcto?");

            if(o == 0){
                int c = JOptionPane.showConfirmDialog(rootPane, "¿Desea confirmar la venta?");
                if(c == 0){
                    cobrartoCliente(identificador);
                    descontar();
                    modeloTabla();
                    lblTotal.setText("0.0");
                    
                    JOptionPane.showMessageDialog(rootPane, "¡Venta realizada!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No hay producto en lista para venta.");
        }
    }//GEN-LAST:event_ventaClienteActionPerformed

    private void cobroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobroClienteActionPerformed
        String identificador = JOptionPane.showInputDialog("Ingrese identificador del cliente");
        int identi = Integer.parseInt(identificador);
        String query = "SELECT nombre, apepatC, apematC FROM clientes WHERE idCliente = " + identificador;
        String nombreC = "";
        Statement sta;
        int pagara = 0;
        int pagocon = 0;
        int cambio = 0;
        try {
            sta = (Statement) con.createStatement();
            ResultSet r = sta.executeQuery(query);

                while (r.next()) {
                    nombreC = r.getString("nombre")+ " " + r.getString("apepatC") + " " + r.getString("apematC");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmCobrar.class.getName()).log(Level.SEVERE, null, ex);
        }

        int o = JOptionPane.showConfirmDialog(rootPane, "El cliente: ***" + nombreC + "*** ¿Es correcto?");
        if(o == 0){
            try{
                pagara = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto pagara?"));
                pagocon = Integer.parseInt(JOptionPane.showInputDialog("Pagara con: "));
                cambio = pagocon - pagara;
            } catch (Exception e){
                JOptionPane.showMessageDialog(rootPane, "No deje los campos vacios!");
            }
            
            if(pagara>pagocon){
                JOptionPane.showMessageDialog(rootPane, "La cantidad a pagar no puede ser mayor al pago a realizar.");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Su cambio es: " + cambio);
                
                int c = JOptionPane.showConfirmDialog(rootPane, "¿En verdad desea realizar el cobro?");
                
                if(c == 0){
                    cobraraclientequepaga(identi, pagara);
                    JOptionPane.showMessageDialog(rootPane, "Pagado con exito!");
                }
            }
        }
        
        
    }//GEN-LAST:event_cobroClienteActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCobrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCobrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton cobroCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTotal;
    private java.awt.MenuItem menuItem1;
    private java.awt.PopupMenu popupMenutabla;
    private javax.swing.JTable tblModelar;
    private javax.swing.JTextField txtCodigoLector;
    private javax.swing.JButton ventaCliente;
    // End of variables declaration//GEN-END:variables
}
