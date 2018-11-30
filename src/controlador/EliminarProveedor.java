/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Base;
import vista.VistaEliminarProveedor;

/**
 *
 * @author DARIE
 */
public class EliminarProveedor implements ActionListener{

    Base base;
    VistaEliminarProveedor EProveedor;
    
    public EliminarProveedor(Base base, VistaEliminarProveedor EProveedor) {
        this.base = base;
        this.EProveedor = EProveedor;
        this.EProveedor.jbnBuscar.addActionListener(this);
        this.EProveedor.jbnEliminar.addActionListener(this);
        this.EProveedor.jbnSalir.addActionListener(this);
        this.EProveedor.jbnlimpiar.addActionListener(this);
    }
    
    public void Buscar(){
        ResultSet datos = base.consultar("SELECT FROM * proveedor where folio = '"+EProveedor.jtfBuscar.getText()+"'");
        try {
            EProveedor.jlbCP.setText(String.valueOf(datos.getInt("CP")));
            EProveedor.jlbCodigo.setText(datos.getString("folio"));
            EProveedor.jlbDireccion.setText(datos.getString("calle_num"));
            EProveedor.jlbEstado.setText(datos.getString("estado"));
            EProveedor.jlbMunicipio.setText(datos.getString("municipio"));
            EProveedor.jlbNombre.setText(datos.getString("nombre"));
            EProveedor.jlbTelefono.setText(datos.getString("telefono"));
        } catch (SQLException ex) {
            Logger.getLogger(EliminarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet socio = base.consultar("SELECT FROM * socio where folio_socio = '"+EProveedor.jtfBuscar.getText()+"'");
        try {
            if (socio.next()) {
                EProveedor.jlbCAMBIANTE.setText(socio.getString("apellido"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EliminarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet editorial = base.consultar("SELECT FROM * editorial where folio_editorial = '"+EProveedor.jtfBuscar.getText()+"'");
        try {
            if (editorial.next()) {
                EProveedor.jlbCAMBIANTE.setText(editorial.getString("RFC"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EliminarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrar(){
        int opc = JOptionPane.showConfirmDialog(EProveedor, "¿Seguro que decea borrar este dato");
        if (opc == 0) {
            base.actualizar("DELETE FROM proveedor where folio = '"+EProveedor.jtfBuscar.getText()+"'");
            base.actualizar("DELETE FROM socio where folio_socio = '"+EProveedor.jtfBuscar.getText()+"'");
            base.actualizar("DELETE FROM editorial where folio_editorial = '"+EProveedor.jtfBuscar.getText()+"'");
            JOptionPane.showMessageDialog(EProveedor, "Se ha borrado el registro");
            limpiar();
        }
    }

    public void limpiar(){
        EProveedor.jtfBuscar.setText("");
        EProveedor.jlbCAMBIANTE.setText("RFC / Apellidos");
        EProveedor.jlbCP.setText("CP");
        EProveedor.jlbCodigo.setText("Codigo");
        EProveedor.jlbDireccion.setText("Direccion");
        EProveedor.jlbEstado.setText("Estado");
        EProveedor.jlbMunicipio.setText("Municipio");
        EProveedor.jlbNombre.setText("Nombre");
        EProveedor.jlbTelefono.setText("Telefono");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        
        if (boton.equals(EProveedor.jbnBuscar)) {
            Buscar();
        }
        if (boton.equals(EProveedor.jbnEliminar)) {
            borrar();
        }
        if (boton.equals(EProveedor.jbnSalir)) {
            EProveedor.dispose();
        }
        if (boton.equals(EProveedor.jbnlimpiar)) {
            limpiar();
        }
    }
    
    
}
