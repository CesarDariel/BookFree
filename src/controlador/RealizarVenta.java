/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Base;
import vista.VistaRealizarVenta;

/**
 *
 * @author DARIE
 */
public class RealizarVenta implements ActionListener, KeyListener{

    Base base;
    VistaRealizarVenta RVenta;
    public int cliente = 0;
    public String articulo = "";
    
    public RealizarVenta(Base base, VistaRealizarVenta RVenta) {
        this.base = base;
        this.RVenta = RVenta;
        this.RVenta.jbnAgregar.addActionListener(this);
        this.RVenta.jbnBuscar.addActionListener(this);
        this.RVenta.jbnBuscarventa.addActionListener(this);
        this.RVenta.jbnEliminarProducto.addActionListener(this);
        this.RVenta.jbnGenerarFactura.addActionListener(this);
        this.RVenta.jbnRealizarVenta.addActionListener(this);
        this.RVenta.jtfCodigo.addKeyListener(this);
    }
    
    public void buscarcliente(){
        try {
                ResultSet datos = base.consultar("SELECT * FROM cliente where id = '"+Integer.parseInt(RVenta.jtfBuscar.getText())+"'");
                if (datos.next()) {
                    RVenta.jlbApellidos.setText(datos.getString("apellidos"));
                    RVenta.jlbCP.setText(String.valueOf(datos.getInt("CP")));
                    RVenta.jlbColonia.setText(datos.getString("colonia"));
                    RVenta.jlbDireccion.setText(datos.getString("calle_num"));
                    RVenta.jlbEmail.setText(datos.getString("email"));
                    RVenta.jlbNombre.setText(datos.getString("nombre"));
                    RVenta.jlbRFC.setText(datos.getString("RFC"));
                    RVenta.jlbTelefono.setText(datos.getString("telefono"));
                    cliente = Integer.parseInt(RVenta.jtfBuscar.getText());
                }
            } catch (SQLException ex) {
                Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void agregarlibro(){
        ResultSet libro = base.consultar("SELECT * from libro where cod_libro = '"+RVenta.jtfCodigo.getText()+"'");
        try {
            if (libro.next()) {
                RVenta.jlbNombre_Producto.setText(libro.getString("titulo"));
                ResultSet socio = base.consultar("SELECT * FROM socio_libro where Cod_libro_sl = '"+RVenta.jtfCodigo.getText()+"'");
                if (socio.next()) {
                    RVenta.jspCantidad_Producto.setValue(socio.getInt("Existencia_vjo"));
                    RVenta.jlbPrecio.setText(socio.getString("precio_vjo"));
                }
                ResultSet editorial = base.consultar("SELECT * FROM libro_editorial where cod_libro_LE = '"+RVenta.jtfCodigo.getText()+"'");
                if (editorial.next()) {
                    RVenta.jspCantidad_Producto.setValue(editorial.getInt("existencia_nuevo"));
                    RVenta.jlbPrecio.setText(editorial.getString("precio_nuevo"));
                }
                articulo = RVenta.jtfCodigo.getText();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tabla(){ //Aqui me quede
        DefaultTableModel tabla = (DefaultTableModel) RVenta.jtbProductos.getModel();
        tabla.setColumnIdentifiers(new Object[]{"Codigo", "Titulo", "Autor", "Paginas", "Editorial", "ISBN", "Cantidad", "Monto"});
        tabla.setNumRows(0);
        int[] anchos = {80, 150, 150, 100, 80, 100, 100, 100};
        for(int i = 0; i < RVenta.jtbProductos.getColumnCount(); i++) {
            RVenta.jtbProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource().getClass().toString().equals("class javax.swing.JButton")) {
            JButton boton = (JButton) ae.getSource();
            
            if (boton.equals(RVenta.jbnBuscar)) {
                buscarcliente();
            }
        }
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            agregarlibro();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}
