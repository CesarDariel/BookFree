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
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
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
    Sesion sesion;
    public int cliente = 0;
    public String articulo = "";
    public float precio = 0;
    public float sub = 0;
    public int existencia = 0;
    public String folio = "";
    public int c = 0;
    public String titulo = "";
    public String autor = "";
    
    public RealizarVenta(Base base, VistaRealizarVenta RVenta, Sesion sesion) {
        this.base = base;
        this.RVenta = RVenta;
        this.sesion = sesion;
        this.RVenta.jbnAgregar.addActionListener(this);
        this.RVenta.jbnBuscar.addActionListener(this);
        this.RVenta.jbnBuscarventa.addActionListener(this);
        this.RVenta.jbnEliminarProducto.addActionListener(this);
        this.RVenta.jbnGenerarFactura.addActionListener(this);
        this.RVenta.jbnRealizarVenta.addActionListener(this);
        this.RVenta.jtfCodigo.addKeyListener(this);
        
        DefaultTableModel tabla = (DefaultTableModel) RVenta.jtbProductos.getModel();
        tabla.setColumnIdentifiers(new Object[]{"Codigo", "Titulo", "Autor", "Cantidad", "Monto"});
        tabla.setNumRows(0);
        int[] anchos = {80, 250, 150, 65, 75};
        for(int i = 0; i < RVenta.jtbProductos.getColumnCount(); i++) {
            RVenta.jtbProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
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
                    folio = RVenta.jtfFolio.getText();
                }
            } catch (SQLException ex) {
                Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        Calendar c1 = Calendar.getInstance();
        String dia = String.valueOf(c1.get(Calendar.DATE));
        String mes = String.valueOf(c1.get(Calendar.MONTH));
        String año = String.valueOf(c1.get(Calendar.YEAR));
        RVenta.jlbFecha.setText(dia+ "/" +mes+ "/" +año);
        
        //BASE DE DATOS
        
        base.actualizar("INSERT INTO venta VALUES ('"+folio+"','"+sesion.usr+"','"+RVenta.jlbFecha.getText()+"','"+RVenta.jtfBuscar.getText()+"')");
    }
    
    public void agregarlibro(){
        ResultSet libro = base.consultar("SELECT * from libro where cod_libro = '"+RVenta.jtfCodigo.getText()+"'");
        try {
            if (libro.next()) {
                RVenta.jlbNombre_Producto.setText(libro.getString("titulo"));
                ResultSet socio = base.consultar("SELECT * FROM socio_libro where Cod_libro_sl = '"+RVenta.jtfCodigo.getText()+"'");
                if (socio.next()) {
                    RVenta.jlbPrecio.setText(socio.getString("precio_vjo"));
                    precio = Float.parseFloat(socio.getString("precio_vjo"));
                    existencia = socio.getInt("Existencia_vjo");
                }
                ResultSet editorial = base.consultar("SELECT * FROM libro_editorial where cod_libro_LE = '"+RVenta.jtfCodigo.getText()+"'");
                if (editorial.next()) {
                    RVenta.jlbPrecio.setText(editorial.getString("precio_nuevo"));
                    precio = Float.parseFloat(editorial.getString("precio_nuevo"));
                    existencia = editorial.getInt("existencia_nuevo");
                }
                articulo = RVenta.jtfCodigo.getText();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tabla(){ 
        DecimalFormat formato1 = new DecimalFormat("#.00");
        DefaultTableModel tabla = (DefaultTableModel) RVenta.jtbProductos.getModel();
        ResultSet producto = base.consultar("SELECT * FROM libro where cod_libro = '"+articulo+"'");
        try {
            if (producto.next()) {
                c = (int) RVenta.jspCantidad_Producto.getValue();
                tabla.addRow(new Object[]{producto.getString("cod_libro"), producto.getString("titulo"), producto.getString("autor"), RVenta.jspCantidad_Producto.getValue(), precio * c});
                titulo = producto.getString("titulo");
                autor = producto.getString("autor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Inicio Codigo Reutilizable
        sub = 0;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            sub += (float) tabla.getValueAt(i, 4);
        }
        
        float IVA = (float) (sub*0.16);
        RVenta.jlbSubTotal.setText(String.valueOf(formato1.format(sub)));
        RVenta.jlbIVA.setText(String.valueOf(formato1.format(IVA)));
        RVenta.jlbTotal.setText(String.valueOf(formato1.format(sub+IVA)));
        //Fin Codigo Reutilizable
        // BASE DE DATOS
        
        base.actualizar("INSERT INTO venta_libro VALUES('"+folio+"','"+articulo+"','"+c+"','"+precio*c+"','"+titulo+"','"+autor+"')");
        
        
        // Limpieza
        RVenta.jtfCodigo.setText("");
        RVenta.jlbNombre_Producto.setText("Nombre");
        RVenta.jlbPrecio.setText("Precio");
        RVenta.jspCantidad_Producto.setValue(0);
    }
    
    public void eliminarproducto(){ // PENDIENTE
        DecimalFormat formato1 = new DecimalFormat("#.00");
        DefaultTableModel tabla = (DefaultTableModel) RVenta.jtbProductos.getModel();
        
        int seleccion = RVenta.jtbProductos.getSelectedRow();
        
        String codigo = (String) tabla.getValueAt(seleccion, 0);
        tabla.removeRow(seleccion);
        base.actualizar("DELETE FROM venta_libro where Cod_libroV = '"+codigo+"' and Folio_ventaL = '"+RVenta.jtfFolio.getText()+"'");
        
        sub = 0;
                
        for (int i = 0; i < tabla.getRowCount(); i++) {
            sub += (float) tabla.getValueAt(i, 4);
        }
        float IVA = (float) (sub*0.16);
        RVenta.jlbSubTotal.setText(String.valueOf(formato1.format(sub)));
        RVenta.jlbIVA.setText(String.valueOf(formato1.format(IVA)));
        RVenta.jlbTotal.setText(String.valueOf(formato1.format(sub+IVA)));
    }
    
    public void buscarventa(){
        DecimalFormat formato1 = new DecimalFormat("#.00");
        DefaultTableModel tabla = (DefaultTableModel) RVenta.jtbProductos.getModel();
        tabla.setNumRows(0);
        
        String buscar_venta = JOptionPane.showInputDialog(RVenta, "Ingrese el folio de factura");
        try {
            ResultSet venta = base.consultar("SELECT * FROM venta where Folio_venta = '"+buscar_venta+"'");
            if (venta.next()) {
                RVenta.jlbFecha.setText(venta.getString("Fecha"));
                RVenta.jtfFolio.setText(venta.getString("Folio_venta"));
                RVenta.jtfFolio.setEnabled(false);
                RVenta.jtfBuscar.setText(String.valueOf(venta.getInt("id_cliente")));
                RVenta.jtfBuscar.setEnabled(false);
                RVenta.jtfCodigo.setEnabled(false);
                RVenta.jbnAgregar.setEnabled(false);
                ResultSet cliente = base.consultar("SELECT * FROM cliente where id = '"+venta.getInt("id_cliente")+"'");
                if (cliente.next()) {
                    RVenta.jlbApellidos.setText(cliente.getString("apellidos"));
                    RVenta.jlbCP.setText(String.valueOf(cliente.getInt("CP")));
                    RVenta.jlbColonia.setText(cliente.getString("colonia"));
                    RVenta.jlbDireccion.setText(cliente.getString("calle_num"));
                    RVenta.jlbEmail.setText(cliente.getString("email"));
                    RVenta.jlbNombre.setText(cliente.getString("nombre"));
                    RVenta.jlbRFC.setText(cliente.getString("RFC"));
                    RVenta.jlbTelefono.setText(cliente.getString("telefono"));
                }
                ResultSet libros = base.consultar("SELECT * FROM venta_libro where Folio_ventaL = '"+buscar_venta+"'");
                while(libros.next()){
                    tabla.addRow(new Object[]{libros.getString("Cod_libroV"), libros.getString("titulo"), libros.getString("autor"), String.valueOf(libros.getInt("cantidad")), libros.getString("precio_libro")});
                }
        
                sub = 0;
                
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    sub += Float.parseFloat((String) tabla.getValueAt(i, 4));
                }
                float IVA = (float) (sub*0.16);
                RVenta.jlbSubTotal.setText(String.valueOf(formato1.format(sub)));
                RVenta.jlbIVA.setText(String.valueOf(formato1.format(IVA)));
                RVenta.jlbTotal.setText(String.valueOf(formato1.format(sub+IVA)));
            }else{
                JOptionPane.showMessageDialog(RVenta, "No se encontro la factura");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limpiezar(){
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource().getClass().toString().equals("class javax.swing.JButton")) {
            JButton boton = (JButton) ae.getSource();
            
            if (boton.equals(RVenta.jbnBuscar)) {
                buscarcliente();
            }
            if (boton.equals(RVenta.jbnAgregar)) {
                tabla();
            }
            if (boton.equals(RVenta.jbnRealizarVenta)) {
                JOptionPane.showMessageDialog(RVenta, "La venta se ha realizado");
                RVenta.dispose();
            }
            if (boton.equals(RVenta.jbnEliminarProducto)) {
                eliminarproducto();
            }
            if (boton.equals(RVenta.jbnBuscarventa)) {
                buscarventa();
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
