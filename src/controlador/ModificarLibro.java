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
import vista.VistaModificarLibro;

/**
 *
 * @author DARIE
 */
public class ModificarLibro implements ActionListener {

    Base base;
    VistaModificarLibro Mlibro;
    public String bus = "";
    
    public ModificarLibro(Base base, VistaModificarLibro Mlibro) {
        this.base = base;
        this.Mlibro = Mlibro;
        this.Mlibro.jbnBuscar.addActionListener(this);
        this.Mlibro.jbnLimpiar.addActionListener(this);
        this.Mlibro.jbnModificar.addActionListener(this);
        this.Mlibro.jbnSalir.addActionListener(this);
    }
    
    public void limpiar(){
        Mlibro.jtfAutor.setText("");
        Mlibro.jtfCodigo.setText("");
        Mlibro.jtfEditorial.setText("");
        Mlibro.jtfExistencia.setText("");
        Mlibro.jtfISBN.setText("");
        Mlibro.jtfPaginas.setText("");
        Mlibro.jtfPrecio.setText("");
        Mlibro.jtfTitulo.setText("");
    }
    
    public void buscar(){
        bus = Mlibro.jtfCodigo.getText();
        ResultSet datos = base.consultar("select * from libro where cod_libro = '"+Mlibro.jtfCodigo.getText()+"'");
        ResultSet soc = base.consultar("select * from socio_libro where Cod_libro_sl = '"+Mlibro.jtfCodigo.getText()+"'");
        ResultSet edi = base.consultar("select * from libro_editorial where Cod_libro_LE = '"+Mlibro.jtfCodigo.getText()+"'");
        try {
            if (soc.next()) { // FALTA TERMINAR
                Mlibro.jtfPrecio.setText(String.valueOf(soc.getFloat("precio_vjo")));
                Mlibro.jtfExistencia.setText(String.valueOf(soc.getInt("Existencia_vjo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (edi.next()) {
                Mlibro.jtfPrecio.setText(String.valueOf(edi.getFloat("precio_nuevo")));
                Mlibro.jtfExistencia.setText(String.valueOf(edi.getInt("existencia_nuevo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(datos.next()){
                Mlibro.jtfAutor.setText(datos.getString("autor"));
                Mlibro.jtfCodigo.setText(datos.getString("cod_libro"));
                Mlibro.jtfEditorial.setText(datos.getString("editorial"));
                Mlibro.jtfISBN.setText(datos.getString("ISBN")); 
                Mlibro.jtfPaginas.setText(datos.getString("num_paginas")); 
                Mlibro.jtfTitulo.setText(datos.getString("titulo"));
                bus = Mlibro.jtfCodigo.getText();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModificarLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
        Mlibro.jtfCodigo.setText("");
    }
    
    public void modificar(){
        int opc = JOptionPane.showConfirmDialog(Mlibro, "¿Seguro que desea realizar los cambios");
        if (opc == 0) {
            base.actualizar("UPDATE libro SET titulo='"+Mlibro.jtfTitulo.getText()+"', autor = '"+Mlibro.jtfAutor.getText()+"', num_paginas = '"+Integer.parseInt(Mlibro.jtfPaginas.getText())+"', editorial = '"+Mlibro.jtfEditorial.getText()+"', ISBN = '"+Mlibro.jtfISBN.getText()+"' where cod_libro = '"+bus+"'");
            base.actualizar("UPDATE socio_libro SET precio_vjo = '"+Mlibro.jtfPrecio.getText()+"', Existencia_vjo = '"+Integer.parseInt(Mlibro.jtfExistencia.getText())+"' where Cod_libro_sl = '"+bus+"'");
            base.actualizar("UPDATE libro_editorial set precio_nuevo = '"+Float.parseFloat(Mlibro.jtfPrecio.getText())+"', existencia_nuevo = '"+Integer.parseInt(Mlibro.jtfExistencia.getText())+"' where cod_libro_LE = '"+bus+"'");
            JOptionPane.showMessageDialog(Mlibro, "Los cambios han sido realizado");
            bus = "";
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        
        if (boton.equals(Mlibro.jbnBuscar)) {
            buscar();
        }
        if (boton.equals(Mlibro.jbnLimpiar)) {
            limpiar();
        }
        if (boton.equals(Mlibro.jbnModificar)) {
            modificar();
            limpiar();
        }
        if (boton.equals(Mlibro.jbnSalir)) {
            Mlibro.dispose();
        }
    }
    
}
