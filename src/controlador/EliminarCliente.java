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
import vista.VistaEliminarCliente;

/**
 *
 * @author DARIE
 */
public class EliminarCliente implements ActionListener{

    Base base;
    VistaEliminarCliente VEliminarCliente; 
    public int eliminar = 0;
    public EliminarCliente(Base base, VistaEliminarCliente VEliminarcliente) {
        this.base = base;
        this.VEliminarCliente = VEliminarcliente;
        this.VEliminarCliente.jbnBuscar.addActionListener(this);
        this.VEliminarCliente.jbnEliminar.addActionListener(this);
        this.VEliminarCliente.jbnSalir.addActionListener(this);
    }
    
    public void buscar(){
        eliminar = Integer.parseInt(VEliminarCliente.jtfbuscar.getText());
        ResultSet datos = base.consultar("select * from cliente where id ='"+Integer.parseInt(VEliminarCliente.jtfbuscar.getText())+"'");
        try {
            while(datos.next()){
                VEliminarCliente.jlbCP.setText(datos.getString("CP"));
                VEliminarCliente.jlbCalle.setText(datos.getString("calle_num"));
                VEliminarCliente.jlbEmail.setText(datos.getString("email"));
                VEliminarCliente.jlbID.setText(String.valueOf(datos.getInt("id")));
                VEliminarCliente.jlbNombre.setText(datos.getString("nombre"));
                VEliminarCliente.jlbRFC.setText(datos.getString("RFC"));
                VEliminarCliente.jlbTelefono.setText(datos.getString("telefono"));
                VEliminarCliente.jlbnColonia.setText(datos.getString("colonia"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EliminarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        VEliminarCliente.jtfbuscar.setText("");
    }
    
    public void textodefault(){
        VEliminarCliente.jlbCP.setText("CP");
        VEliminarCliente.jlbCalle.setText("CALLE");
        VEliminarCliente.jlbEmail.setText("EMAIL");
        VEliminarCliente.jlbID.setText("ID");
        VEliminarCliente.jlbNombre.setText("NOMBRE");
        VEliminarCliente.jlbRFC.setText("RFC");
        VEliminarCliente.jlbTelefono.setText("TELEFONO");
        VEliminarCliente.jlbnColonia.setText("COLONIA");
    }

    public void eliminar(){
        int opc = JOptionPane.showConfirmDialog(VEliminarCliente, "¿Seguro que desea borrar el registro");
        if (opc == 0) {
            base.actualizar("DELETE FROM cliente where id = '"+eliminar+"'");
            JOptionPane.showMessageDialog(VEliminarCliente, "Registro borrado");
            textodefault();
            eliminar = 0;
        }else{
            
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        if (boton.equals(VEliminarCliente.jbnBuscar)) {
            buscar();
        }
        if (boton.equals(VEliminarCliente.jbnEliminar)) {
            eliminar();
        }
        if (boton.equals(VEliminarCliente.jbnSalir)) {
            VEliminarCliente.dispose();
        }
    }
    
}
