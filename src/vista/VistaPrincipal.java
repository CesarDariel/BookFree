/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author DARIE
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    public VistaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMClientes = new javax.swing.JMenu();
        ItemAgregarClientes = new javax.swing.JMenuItem();
        ItemEliminarClientes = new javax.swing.JMenuItem();
        ItemBuscarCliente = new javax.swing.JMenuItem();
        ItemModificarCliente = new javax.swing.JMenuItem();
        JMLibros = new javax.swing.JMenu();
        ItemAgregarLibro = new javax.swing.JMenuItem();
        ItemEliminarLibro = new javax.swing.JMenuItem();
        ItemBuscarLibro = new javax.swing.JMenuItem();
        ItemModificarLibro = new javax.swing.JMenuItem();
        jmiProveedores = new javax.swing.JMenu();
        ItemAgregarProveedor = new javax.swing.JMenuItem();
        ItemEliminarProveedor = new javax.swing.JMenuItem();
        ItemBuscarProveedor = new javax.swing.JMenuItem();
        ItemModificarProveedor = new javax.swing.JMenuItem();
        JMVenta = new javax.swing.JMenu();
        ItemNuevoVenta = new javax.swing.JMenuItem();
        ItemBuscarVenta = new javax.swing.JMenuItem();
        JMFacturacion = new javax.swing.JMenu();
        ItemNuevoFactura = new javax.swing.JMenuItem();
        ItemBuscarFactura = new javax.swing.JMenuItem();
        JMSesion = new javax.swing.JMenu();
        ItemCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Free");
        setFocusCycleRoot(false);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        JMClientes.setText("Clientes");

        ItemAgregarClientes.setText("Agregar");
        JMClientes.add(ItemAgregarClientes);

        ItemEliminarClientes.setText("Eliminar");
        JMClientes.add(ItemEliminarClientes);

        ItemBuscarCliente.setText("Buscar");
        JMClientes.add(ItemBuscarCliente);

        ItemModificarCliente.setText("Modificar");
        JMClientes.add(ItemModificarCliente);

        jMenuBar1.add(JMClientes);

        JMLibros.setText("Libros");

        ItemAgregarLibro.setText("Agregar");
        JMLibros.add(ItemAgregarLibro);

        ItemEliminarLibro.setText("Eliminar");
        JMLibros.add(ItemEliminarLibro);

        ItemBuscarLibro.setText("Buscar");
        JMLibros.add(ItemBuscarLibro);

        ItemModificarLibro.setText("Modificar");
        JMLibros.add(ItemModificarLibro);

        jMenuBar1.add(JMLibros);

        jmiProveedores.setText("Proveedores");

        ItemAgregarProveedor.setText("Agregar");
        jmiProveedores.add(ItemAgregarProveedor);

        ItemEliminarProveedor.setText("Eliminar");
        jmiProveedores.add(ItemEliminarProveedor);

        ItemBuscarProveedor.setText("Buscar");
        jmiProveedores.add(ItemBuscarProveedor);

        ItemModificarProveedor.setText("Modificar");
        jmiProveedores.add(ItemModificarProveedor);

        jMenuBar1.add(jmiProveedores);

        JMVenta.setText("Venta");

        ItemNuevoVenta.setText("Nuevo");
        JMVenta.add(ItemNuevoVenta);

        ItemBuscarVenta.setText("Buscar");
        JMVenta.add(ItemBuscarVenta);

        jMenuBar1.add(JMVenta);

        JMFacturacion.setText("Facturacion");

        ItemNuevoFactura.setText("Nuevo");
        JMFacturacion.add(ItemNuevoFactura);

        ItemBuscarFactura.setText("Buscar");
        JMFacturacion.add(ItemBuscarFactura);

        jMenuBar1.add(JMFacturacion);

        JMSesion.setText("Sesion");

        ItemCerrarSesion.setText("Cerrar sesion");
        ItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCerrarSesionActionPerformed(evt);
            }
        });
        JMSesion.add(ItemCerrarSesion);

        jMenuBar1.add(JMSesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCerrarSesionActionPerformed
        
    }//GEN-LAST:event_ItemCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem ItemAgregarClientes;
    public javax.swing.JMenuItem ItemAgregarLibro;
    public javax.swing.JMenuItem ItemAgregarProveedor;
    public javax.swing.JMenuItem ItemBuscarCliente;
    public javax.swing.JMenuItem ItemBuscarFactura;
    public javax.swing.JMenuItem ItemBuscarLibro;
    public javax.swing.JMenuItem ItemBuscarProveedor;
    public javax.swing.JMenuItem ItemBuscarVenta;
    public javax.swing.JMenuItem ItemCerrarSesion;
    public javax.swing.JMenuItem ItemEliminarClientes;
    public javax.swing.JMenuItem ItemEliminarLibro;
    public javax.swing.JMenuItem ItemEliminarProveedor;
    public javax.swing.JMenuItem ItemModificarCliente;
    public javax.swing.JMenuItem ItemModificarLibro;
    public javax.swing.JMenuItem ItemModificarProveedor;
    public javax.swing.JMenuItem ItemNuevoFactura;
    public javax.swing.JMenuItem ItemNuevoVenta;
    public javax.swing.JMenu JMClientes;
    public javax.swing.JMenu JMFacturacion;
    public javax.swing.JMenu JMLibros;
    public javax.swing.JMenu JMSesion;
    public javax.swing.JMenu JMVenta;
    public javax.swing.JDesktopPane Panel;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu jmiProveedores;
    // End of variables declaration//GEN-END:variables
}
