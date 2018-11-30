/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import modelo.Base;
import vista.VistaAgregarProveedor;

/**
 *
 * @author DARIE
 */
public class AgregarProveedor implements ActionListener{

    Base base;
    VistaAgregarProveedor AProveedor;

    public AgregarProveedor(Base base, VistaAgregarProveedor AProveedor) {
        this.base = base;
        this.AProveedor = AProveedor;
        this.AProveedor.jbnAgregar.addActionListener(this);
        this.AProveedor.jbnLimpiar.addActionListener(this);
        this.AProveedor.jbnSalir.addActionListener(this);
        this.AProveedor.jrbEditorial.addActionListener(this);
        this.AProveedor.jrbSocio.addActionListener(this);
        AProveedor.jtfRFC.setEnabled(false);
        AProveedor.jtfApellido.setEnabled(false);
    }
    
    public void limpiar(){
        AProveedor.jtfApellido.setText("");
        AProveedor.jtfCP.setText("");
        AProveedor.jtfCodigo.setText("");
        AProveedor.jtfDireccion.setText("");
        AProveedor.jtfEstado.setText("");
        AProveedor.jtfMunicipio.setText("");
        AProveedor.jtfNombre.setText("");
        AProveedor.jtfRFC.setText("");
        AProveedor.jtfTelefono.setText("");
    }
    
    public void agregar(){ // FALTA TERMINAR
        base.actualizar("INSERT INTO proveedor VALUES ('"+AProveedor.jtfCodigo.getText()+"','"+AProveedor.jtfNombre.getText()+"','"+AProveedor.jtfDireccion.getText()+"','"+AProveedor.jtfMunicipio.getText()+"','"+AProveedor.jtfEstado.getText()+"','"+Integer.parseInt(AProveedor.jtfCP.getText())+"','"+AProveedor.jtfTelefono.getText()+"')");
        if (AProveedor.jrbEditorial.isSelected()) {
            base.actualizar("INSERT INTO editorial VALUES ('"+AProveedor.jtfRFC.getText()+"','"+AProveedor.jtfCodigo.getText()+"')");
        }
        if (AProveedor.jrbSocio.isSelected()) {
            base.actualizar("INSERT INTO socio VALUES ('"+AProveedor.jtfCodigo.getText()+"','"+AProveedor.jtfApellido.getText()+"')");
        }
        limpiar();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().getClass().toString().equals("class javax.swing.JButton")){
        JButton boton = (JButton) ae.getSource();
        
        if (boton.equals(AProveedor.jbnSalir)) {
            AProveedor.dispose();
        }
        if (boton.equals(AProveedor.jbnLimpiar)) {
            limpiar();
        }
        if (boton.equals(AProveedor.jbnAgregar)) {
            agregar();
        }
            }
        if (ae.getSource().getClass().toString().equals("class javax.swing.JRadioButton")){
            JRadioButton radio = (JRadioButton) ae.getSource();
            
            if (radio.equals(AProveedor.jrbEditorial)) {
                AProveedor.jtfRFC.setEnabled(true);
                AProveedor.jtfApellido.setEnabled(false);
                AProveedor.jtfApellido.setText("");
            }
            if (radio.equals(AProveedor.jrbSocio)) {
                AProveedor.jtfApellido.setEnabled(true);
                AProveedor.jtfRFC.setEnabled(false);
                AProveedor.jtfRFC.setText("");
            }
        }
    }
    
}
