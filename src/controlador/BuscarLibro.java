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
import javax.swing.table.DefaultTableModel;
import modelo.Base;
import vista.VistaBuscarCliente;
import vista.VistaBuscarLibro;

/**
 *
 * @author DARIE
 */
public class BuscarLibro implements ActionListener{

    Base base;
    VistaBuscarLibro Vlibro;
    
    public BuscarLibro(Base base, VistaBuscarLibro Vlibro) {
        this.base = base;
        this.Vlibro = Vlibro;
        this.Vlibro.jbnBuscar.addActionListener(this);
        this.Vlibro.jbnlimpiar.addActionListener(this);
    }

    public void limpiar(){
        DefaultTableModel tabla = (DefaultTableModel) Vlibro.jtbLibros.getModel();
        tabla.setColumnIdentifiers(new Object[]{"Codigo", "Titulo", "Autor", "Paginas", "Editorial", "ISBN"});
        ResultSet datos = base.consultar("select * from libro");
        tabla.setNumRows(0);
        
        try {
            while(datos.next()){
                
                tabla.addRow(new Object[]{datos.getString("cod_libro"), datos.getString("titulo"), datos.getString("autor"), String.valueOf(datos.getInt("num_paginas")), datos.getString("editorial"), datos.getString("ISBN")});
                Vlibro.jtbLibros.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int[] anchos = {50, 200, 100, 10, 80, 100};
        for(int i = 0; i < Vlibro.jtbLibros.getColumnCount(); i++) {
            Vlibro.jtbLibros.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
    
    public void buscar(){
        DefaultTableModel tabla = (DefaultTableModel) Vlibro.jtbLibros.getModel();
        tabla.setColumnIdentifiers(new Object[]{"Codigo", "Titulo", "Autor", "Paginas", "Editorial", "ISBN"});
        
        int[] anchos = {50, 200, 100, 10, 80, 100};
        for(int i = 0; i < Vlibro.jtbLibros.getColumnCount(); i++) {
            Vlibro.jtbLibros.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        String id = "", titulo = "", autor = "";
        id = Vlibro.jtfID.getText();
        titulo = Vlibro.jtfTitulo.getText();
        autor = Vlibro.jtfAutor.getText();
        
        
        if (!id.equals("")) {
            ResultSet datos = base.consultar("select * from libro where cod_libro = '"+id+"'");
            tabla.setNumRows(0);
            try {
                while(datos.next()){
                    
                    tabla.addRow(new Object[]{datos.getString("cod_libro"), datos.getString("titulo"), datos.getString("autor"), String.valueOf(datos.getInt("num_paginas")), datos.getString("editorial"), datos.getString("ISBN")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscarLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!titulo.equals("")) {
            ResultSet datos = base.consultar("select * from libro where titulo like '%"+titulo+"%'");
            tabla.setNumRows(0);
            try {
                while(datos.next()){
                    
                    tabla.addRow(new Object[]{datos.getString("cod_libro"), datos.getString("titulo"), datos.getString("autor"), String.valueOf(datos.getInt("num_paginas")), datos.getString("editorial"), datos.getString("ISBN")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscarLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!autor.equals("")) {
            ResultSet datos = base.consultar("select * from libro where autor like '%"+autor+"%'");
            tabla.setNumRows(0);
            try {
                while(datos.next()){
                    
                    tabla.addRow(new Object[]{datos.getString("cod_libro"), datos.getString("titulo"), datos.getString("autor"), String.valueOf(datos.getInt("num_paginas")), datos.getString("editorial"), datos.getString("ISBN")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscarLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void vaciar(){
        Vlibro.jtfAutor.setText("");
        Vlibro.jtfID.setText("");
        Vlibro.jtfTitulo.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        
        if (boton.equals(Vlibro.jbnlimpiar)) {
            limpiar();
            vaciar();
        }if (boton.equals(Vlibro.jbnBuscar)) {
            buscar();
            vaciar();
        }
                
    }
    
}
