/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///que onda mi dary..!!
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
import vista.VistaAgregarCliente;

/**
 *
 * @author DARIE
 */
public class AgregarCliente implements ActionListener{

    VistaAgregarCliente AgregarCliente;
    Base base;
    
    public AgregarCliente(VistaAgregarCliente AgregarCliente, Base base) {
        this.AgregarCliente = AgregarCliente;
        this.base = base;
        this.AgregarCliente.jbnBuscar.addActionListener(this);
        this.AgregarCliente.jbnGuardar.addActionListener(this);
        this.AgregarCliente.jbnLimpiar.addActionListener(this);
        this.AgregarCliente.jbnNuevo.addActionListener(this);
        this.AgregarCliente.jbnSalir.addActionListener(this);
        this.AgregarCliente.jtfApellido.addActionListener(this);
        this.AgregarCliente.jtfBuscarCliente.addActionListener(this);
        this.AgregarCliente.jtfCP.addActionListener(this);
        this.AgregarCliente.jtfCalle.addActionListener(this);
        this.AgregarCliente.jtfColonia.addActionListener(this);
        this.AgregarCliente.jtfEmail.addActionListener(this);
        this.AgregarCliente.jtfNombre.addActionListener(this);
        this.AgregarCliente.jtfRFC.addActionListener(this);
        this.AgregarCliente.jtfTelefono.addActionListener(this);
        
    }
    
    public void desbloqueartextos(){
        AgregarCliente.jtfApellido.setEnabled(true);
        AgregarCliente.jtfCP.setEnabled(true);
        AgregarCliente.jtfCalle.setEnabled(true);
        AgregarCliente.jtfColonia.setEnabled(true);
        AgregarCliente.jtfEmail.setEnabled(true);
        AgregarCliente.jtfNombre.setEnabled(true);
        AgregarCliente.jtfRFC.setEnabled(true);
        AgregarCliente.jtfTelefono.setEnabled(true);
    }
    
    public void bloqueartextos(){
        AgregarCliente.jtfApellido.setEnabled(false);
        AgregarCliente.jtfCP.setEnabled(false);
        AgregarCliente.jtfCalle.setEnabled(false);
        AgregarCliente.jtfColonia.setEnabled(false);
        AgregarCliente.jtfEmail.setEnabled(false);
        AgregarCliente.jtfNombre.setEnabled(false);
        AgregarCliente.jtfRFC.setEnabled(false);
        AgregarCliente.jtfTelefono.setEnabled(false);
    }

    public void limpiar(){
        AgregarCliente.jtfApellido.setText("");
        AgregarCliente.jtfBuscarCliente.setText("");
        AgregarCliente.jtfCP.setText("");
        AgregarCliente.jtfCalle.setText("");
        AgregarCliente.jtfColonia.setText("");
        AgregarCliente.jtfEmail.setText("");
        AgregarCliente.jtfNombre.setText("");
        AgregarCliente.jtfRFC.setText("");
        AgregarCliente.jtfTelefono.setText("");
    }  
    
    public void agregar(){
        base.actualizar("INSERT INTO cliente (nombre, apellidos, RFC, telefono, CP, colonia, calle_num, email) VALUES ('"+AgregarCliente.jtfNombre.getText()+"','"+AgregarCliente.jtfApellido.getText()+"','"+AgregarCliente.jtfRFC.getText()+"','"+AgregarCliente.jtfTelefono.getText()+"','"+Integer.parseInt(AgregarCliente.jtfCP.getText())+"','"+AgregarCliente.jtfColonia.getText()+"','"+AgregarCliente.jtfCalle.getText()+"','"+AgregarCliente.jtfEmail.getText()+"');");
        JOptionPane.showMessageDialog(AgregarCliente, "Dato Guardado");
        limpiar();
    }   
    
    public void buscar(){
        ResultSet dat = base.consultar("Select * from cliente where id ='"+Integer.parseInt(AgregarCliente.jtfBuscarCliente.getText())+"'");
        try {
            while(dat.next()){
                AgregarCliente.jtfNombre.setText(dat.getString("nombre"));
                AgregarCliente.jtfApellido.setText(dat.getString("apellidos"));
                AgregarCliente.jtfRFC.setText(dat.getString("RFC"));
                AgregarCliente.jtfTelefono.setText(dat.getString("telefono"));
                AgregarCliente.jtfCP.setText(dat.getString("CP"));
                AgregarCliente.jtfColonia.setText(dat.getString("colonia"));
                AgregarCliente.jtfCalle.setText(dat.getString("calle_num"));
                AgregarCliente.jtfEmail.setText(dat.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        AgregarCliente.jtfBuscarCliente.setText("");
        bloqueartextos();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        //Boton Nuevo
        if (boton.equals(AgregarCliente.jbnNuevo)) {
            limpiar();
            desbloqueartextos();
        }
        //Boton Limpiar
        if (boton.equals(AgregarCliente.jbnLimpiar)) {
            limpiar();
        }
        // Boton Guardar
        if (boton.equals(AgregarCliente.jbnGuardar)) {
            agregar();
        }
        // Boton Buscar
        if (boton.equals(AgregarCliente.jbnBuscar)) {
            buscar();
        }
        // Boton Salir
        if (boton.equals(AgregarCliente.jbnSalir)) {
            AgregarCliente.dispose();
        }
    }
    
}
