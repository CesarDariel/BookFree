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
import javax.swing.JRadioButton;
import modelo.Base;
import vista.VistaAgregarLibro;

/**
 *
 * @author DARIE
 */
public class AgregarLibro implements ActionListener, KeyListener{

    Base base;
    VistaAgregarLibro Alibro;
    
    public AgregarLibro(Base base, VistaAgregarLibro Alibro) {
        this.base=base;
        this.Alibro=Alibro;
        this.Alibro.jbnGuardar.addActionListener(this);
        this.Alibro.jbnLimpiar.addActionListener(this);
        this.Alibro.jbnSalir.addActionListener(this);
        this.Alibro.jrbEditorial.addActionListener(this);
        this.Alibro.jrbSocio.addActionListener(this);
    }

    public void MostrarSocio(){
        Alibro.jcbSocio.removeAllItems();
        try {                  
            ResultSet datos = base.consultar("select folio_socio from socio");                    
            while(datos.next()){                      
                Alibro.jcbSocio.setEnabled(true);                  
                Alibro.jcbSocio.addItem(datos.getString("folio_socio"));               
            }              
            Alibro.jcbEditorial.removeAllItems();
        } catch (SQLException ex) {         
            Logger.getLogger(AgregarLibro.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }
    
    public void MostrarEditorial(){
        Alibro.jcbEditorial.removeAllItems();
        try {
            ResultSet datos = base.consultar("select folio_editorial from editorial");       
            while(datos.next()){         
                Alibro.jcbEditorial.setEnabled(true);         
                Alibro.jcbEditorial.addItem(datos.getString("folio_editorial"));        
            }     
            Alibro.jcbSocio.removeAllItems();
        } catch (SQLException ex) {    
            Logger.getLogger(AgregarLibro.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }
    
    public void limpiar(){
        Alibro.jtfAutor.setText("");
        Alibro.jtfCodigo.setText("");
        Alibro.jtfEditorial.setText("");
        Alibro.jtfExistencia.setText("");
        Alibro.jtfISBN.setText("");
        Alibro.jtfPaginas.setText("");
        Alibro.jtfPrecio.setText("");
        Alibro.jtfTitulo.setText("");
    }
    
    public void registrarSOCIO(){
        String socio = String.valueOf(Alibro.jcbSocio.getSelectedItem());
        base.actualizar("INSERT INTO libro VALUES ('"+Alibro.jtfCodigo.getText()+"','"+Alibro.jtfTitulo.getText()+"','"+Alibro.jtfAutor.getText()+"','"+Integer.parseInt(Alibro.jtfPaginas.getText())+"','"+Alibro.jtfEditorial.getText()+"','"+Alibro.jtfISBN.getText()+"')");
        base.actualizar("INSERT INTO socio_libro VALUES('"+socio+"','"+Alibro.jtfCodigo.getText()+"','"+Float.parseFloat(Alibro.jtfPrecio.getText())+"','"+Integer.parseInt(Alibro.jtfExistencia.getText())+"')");
    }
    
    public void registrarEDITORIAL(){
        String editorial = String.valueOf(Alibro.jcbEditorial.getSelectedItem());
        base.actualizar("INSERT INTO libro VALUES ('"+Alibro.jtfCodigo.getText()+"','"+Alibro.jtfTitulo.getText()+"','"+Alibro.jtfAutor.getText()+"','"+Integer.parseInt(Alibro.jtfPaginas.getText())+"','"+Alibro.jtfEditorial.getText()+"','"+Alibro.jtfISBN.getText()+"')");
        base.actualizar("INSERT INTO libro_editorial VALUES('"+Alibro.jtfCodigo.getText()+"','"+editorial+"','"+Float.parseFloat(Alibro.jtfPrecio.getText())+"','"+Integer.parseInt(Alibro.jtfExistencia.getText())+"')");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().getClass().toString().equals("class javax.swing.JButton")) {
            JButton boton = (JButton) ae.getSource();
            
            if (boton.equals(Alibro.jbnGuardar)) {
                if (Alibro.jrbEditorial.isSelected()) {
                    registrarEDITORIAL();
                    limpiar();
                }
                if (Alibro.jrbSocio.isSelected()) {
                    registrarSOCIO();
                    limpiar();
                }
            }
            if (boton.equals(Alibro.jbnLimpiar)) {
                limpiar();
            }      
            if (boton.equals(Alibro.jbnSalir)) {
                Alibro.dispose();
            }
        }
        
        if (ae.getSource().getClass().toString().equals("class javax.swing.JRadioButton")) {
            JRadioButton Radio = (JRadioButton) ae.getSource();
            
            if (Radio.equals(Alibro.jrbEditorial)) {
                MostrarEditorial();
            }
            
            if (Radio.equals(Alibro.jrbSocio)) {
                MostrarSocio();      
            }
        }
       
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
    
}
