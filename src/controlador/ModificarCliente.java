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
import vista.VistaModificarCliente;

/**
 *
 * @author DARIE
 */
public class ModificarCliente implements ActionListener{

    Base base;
    VistaModificarCliente Mcliente;
    public int id = 0; 
            
    public ModificarCliente(Base base, VistaModificarCliente Mcliente) {
        this.base = base;
        this.Mcliente = Mcliente;
        this.Mcliente.jbnBuscar.addActionListener(this);
        this.Mcliente.jbnModificar.addActionListener(this);
        this.Mcliente.jbnSalir.addActionListener(this);
        this.Mcliente.jbnLimpiar.addActionListener(this);
    }
    
    public void buscar(){
        ResultSet datos = base.consultar("select * from cliente where id ='"+Integer.parseInt(Mcliente.jtfBuscar.getText())+"'");
        try {
            while(datos.next()){
                Mcliente.jtfApellidos.setText(datos.getString("apellidos"));
                Mcliente.jtfCP.setText(String.valueOf(datos.getInt("CP")));
                Mcliente.jtfColonia.setText(datos.getString("colonia"));
                Mcliente.jtfDireccion.setText(datos.getString("calle_num"));
                Mcliente.jtfEmail.setText(datos.getString("email"));
                Mcliente.jtfNombre.setText(datos.getString("nombre"));
                Mcliente.jtfRFC.setText(datos.getString("RFC"));
                Mcliente.jtfTelefono.setText(datos.getString("telefono"));
            }
            id = Integer.parseInt(Mcliente.jtfBuscar.getText());
            Mcliente.jtfBuscar.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar(){
        int opc = JOptionPane.showConfirmDialog(Mcliente, "¿Seguro que desea hacer la modificacion?");
        if (opc == 0) {
            base.actualizar("UPDATE cliente set nombre='"+Mcliente.jtfNombre.getText()+"', apellidos='"+Mcliente.jtfApellidos.getText()+"', RFC='"+Mcliente.jtfRFC.getText()+"', telefono = '"+Mcliente.jtfTelefono.getText()+"', CP ='"+Integer.parseInt(Mcliente.jtfCP.getText())+"', colonia = '"+Mcliente.jtfColonia.getText()+"', calle_num ='"+Mcliente.jtfDireccion.getText()+"', email = '"+Mcliente.jtfEmail.getText()+"' where id='"+id+"'");
            id = 0;
            JOptionPane.showMessageDialog(Mcliente, "Se han guardado los cambios");
        }else{
            
        }
    }
    
    public void limpiar(){
        Mcliente.jtfApellidos.setText("");
        Mcliente.jtfCP.setText("");
        Mcliente.jtfColonia.setText("");
        Mcliente.jtfDireccion.setText("");
        Mcliente.jtfEmail.setText("");
        Mcliente.jtfNombre.setText("");
        Mcliente.jtfRFC.setText("");
        Mcliente.jtfTelefono.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        
        if (boton.equals(Mcliente.jbnBuscar)) {
            buscar();
        }
        if (boton.equals(Mcliente.jbnModificar)) {
            modificar();
            limpiar();
        }
        if (boton.equals(Mcliente.jbnLimpiar)) {
            limpiar();
        }
        if (boton.equals(Mcliente.jbnSalir)) {
            Mcliente.dispose();
        }
    }
    
    
}
