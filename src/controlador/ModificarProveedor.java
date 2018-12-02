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
import vista.VistaModificarProveedor;

/**
 *
 * @author DARIE
 */
public class ModificarProveedor implements ActionListener {

    Base base;
    VistaModificarProveedor MProveedor;
    
    public ModificarProveedor(Base base, VistaModificarProveedor MProveedor) {
        this.base = base;
        this.MProveedor = MProveedor;
        this.MProveedor.jbnBuscar.addActionListener(this);
        this.MProveedor.jbnModificar.addActionListener(this);
        this.MProveedor.jbnLimpiar.addActionListener(this);
        this.MProveedor.jbnSalir.addActionListener(this);
        MProveedor.jtfApellidos.setEnabled(false);
        MProveedor.jtfRFC.setEnabled(false);
    }

    public void limpiar(){
        MProveedor.jtfApellidos.setText("");
        MProveedor.jtfBuscar.setText("");
        MProveedor.jtfCP.setText("");
        MProveedor.jtfDireccion.setText("");
        MProveedor.jtfEstado.setText("");
        MProveedor.jtfMunicipio.setText("");
        MProveedor.jtfNombre.setText("");
        MProveedor.jtfRFC.setText("");
        MProveedor.jtfTelefono.setText("");
        MProveedor.jtfApellidos.setEnabled(false);
        MProveedor.jtfRFC.setEnabled(false);
    }
    
    public void buscar(){
        ResultSet datos = base.consultar("SELECT * FROM proveedor where folio = '"+MProveedor.jtfBuscar.getText()+"'");
        try {
            if (datos.next()) {
                MProveedor.jtfCP.setText(String.valueOf(datos.getInt("CP")));
                MProveedor.jtfDireccion.setText(datos.getString("calle_num"));
                MProveedor.jtfEstado.setText(datos.getString("estado"));
                MProveedor.jtfMunicipio.setText(datos.getString("municipio"));
                MProveedor.jtfNombre.setText(datos.getString("nombre"));
                MProveedor.jtfTelefono.setText(datos.getString("telefono"));
                ResultSet socio = base.consultar("SELECT * FROM socio where folio_socio = '"+MProveedor.jtfBuscar.getText()+"'");
                if (socio.next()) {      
                    MProveedor.jtfApellidos.setText(socio.getString("apellido"));
                    MProveedor.jtfApellidos.setEnabled(true);
                }
                ResultSet editorial = base.consultar("SELECT * FROM editorial where folio_editorial = '"+MProveedor.jtfBuscar.getText()+"'");
                if (editorial.next()) {
                    MProveedor.jtfRFC.setText(editorial.getString("RFC"));
                    MProveedor.jtfRFC.setEnabled(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(){
        int opc = JOptionPane.showConfirmDialog(MProveedor, "Los libros ligados a este proveedor tambian van a cambiar, ¿Seguro que desea realizar los cambios?");
        if (opc == 0) {
            base.actualizar("UPDATE proveedor SET nombre='"+MProveedor.jtfNombre.getText()+"', calle_num = '"+MProveedor.jtfDireccion.getText()+"', municipio = '"+MProveedor.jtfMunicipio.getText()+"', estado = '"+MProveedor.jtfEstado.getText()+"', CP = '"+Integer.parseInt(MProveedor.jtfCP.getText())+"', telefono = '"+MProveedor.jtfTelefono.getText()+"' where folio = '"+MProveedor.jtfBuscar.getText()+"'");
            base.actualizar("UPDATE socio SET apellido = '"+MProveedor.jtfApellidos.getText()+"' where folio_socio = '"+MProveedor.jtfBuscar.getText()+"'");
            base.actualizar("UPDATE editorial SET RFC = '"+MProveedor.jtfRFC.getText()+"' where folio_editorial = '"+MProveedor.jtfBuscar.getText()+"'");
            JOptionPane.showMessageDialog(MProveedor, "Se han realizado los cambios");
        }  
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        
        if (boton.equals(MProveedor.jbnBuscar)) {
            buscar();
        }
        if (boton.equals(MProveedor.jbnModificar)) {
            modificar();
            limpiar();
        }
        if (boton.equals(MProveedor.jbnLimpiar)) {
            limpiar();
        }
        if (boton.equals(MProveedor.jbnSalir)) {
            MProveedor.dispose();
        }
    }
    
}
