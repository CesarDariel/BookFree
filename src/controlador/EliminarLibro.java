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
import vista.VistaEliminarLibro;

/**
 *
 * @author DARIE
 */
public class EliminarLibro implements ActionListener{

    Base base;
    VistaEliminarLibro Elibro;
    public String buscar = "";
    
    public EliminarLibro(Base base, VistaEliminarLibro Elibro) {
        this.base = base;
        this.Elibro = Elibro;
        this.Elibro.jbnBuscar.addActionListener(this);
        this.Elibro.jbnEliminar.addActionListener(this);
        this.Elibro.jbnLimpiar.addActionListener(this);
        this.Elibro.jbnSalir.addActionListener(this);
    }
    
    public void buscar(){
        ResultSet datos = base.consultar("select * from libro where cod_libro ='"+Elibro.jtfBuscar.getText()+"'");
        try {
            while(datos.next()){
                Elibro.jlbAutor.setText(datos.getString("autor"));
                Elibro.jlbCodigo.setText(datos.getString("cod_libro"));
                Elibro.jlbEditorial.setText(datos.getString("editorial"));
                Elibro.jlbISBN.setText(datos.getString("ISBN"));
                Elibro.jlbPaginas.setText(datos.getString("num_paginas"));
                Elibro.jlbTitulo.setText(datos.getString("titulo"));
            }
            buscar = Elibro.jtfBuscar.getText();
            Elibro.jtfBuscar.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(EliminarLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           
    public void eliminar(){
        int opc = JOptionPane.showConfirmDialog(Elibro, "¿Seguro que desea borrar este libro");
        if (opc == 0) {
            base.actualizar("DELETE FROM libro_editorial where cod_libro_LE ='"+buscar+"'");
            base.actualizar("DELETE FROM libro where cod_libro ='"+buscar+"'");
            JOptionPane.showMessageDialog(Elibro, "Se ha borrado el registro");
            buscar = "";
        }
    }
    
    public void limpiar(){
        Elibro.jlbAutor.setText("Autor");
        Elibro.jlbCodigo.setText("Codigo");
        Elibro.jlbEditorial.setText("Editorial");
        Elibro.jlbISBN.setText("ISBN");
        Elibro.jlbPaginas.setText("Paginas");
        Elibro.jlbTitulo.setText("Titulo");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        
        if (boton.equals(Elibro.jbnBuscar)) {
            buscar();
        }
        if (boton.equals(Elibro.jbnEliminar)) {
            eliminar();
            limpiar();
        }
        if (boton.equals(Elibro.jbnLimpiar)) {
            limpiar();
        }
        if (boton.equals(Elibro.jbnSalir)) {
            Elibro.dispose();
        }
    }
    
}
