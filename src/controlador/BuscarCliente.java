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

/**
 *
 * @author DARIE
 */
public class BuscarCliente implements ActionListener{

    Base base;
    VistaBuscarCliente Bcliente;
    public BuscarCliente(Base base, VistaBuscarCliente Bcliente) {
        this.base = base;
        this.Bcliente = Bcliente;
        this.Bcliente.jbnFiltrar.addActionListener(this);
        this.Bcliente.jbnLimpiar.addActionListener(this);
    }
    
    public void llenardatos(){
        DefaultTableModel tabla = (DefaultTableModel) Bcliente.JtbCliente.getModel();
        tabla.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellidos", "RFC", "Telefono", "CP", "Colonia", "Direccion", "Email"});
        ResultSet datos = base.consultar("select * from cliente");
        tabla.setNumRows(0);
        int[] anchos = {40, 180, 180, 140, 100, 50, 100, 150, 200};
        for(int i = 0; i < Bcliente.JtbCliente.getColumnCount(); i++) {
            Bcliente.JtbCliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{String.valueOf(datos.getInt("id")), datos.getString("nombre"), datos.getString("apellidos"), datos.getString("RFC"), datos.getString("telefono"), String.valueOf(datos.getInt("CP")), datos.getString("colonia"), datos.getString("calle_num"), datos.getString("email")});
                Bcliente.JtbCliente.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void filtro(){
        DefaultTableModel tabla = (DefaultTableModel) Bcliente.JtbCliente.getModel();
        tabla.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellidos", "RFC", "Telefono", "CP", "Colonia", "Direccion", "Email"});
        int[] anchos = {40, 180, 180, 140, 100, 50, 100, 150, 200};
        for(int i = 0; i < Bcliente.JtbCliente.getColumnCount(); i++) {
            Bcliente.JtbCliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
        String ID = ""; String nombre = ""; String apellidos = "";
        ID = Bcliente.jtfIDCliente.getText(); nombre = Bcliente.jtfNombre.getText(); apellidos = Bcliente.jtfApellidos.getText();
        String opc = String.valueOf(Bcliente.jcbOrdenar.getSelectedItem());
        
        if (!ID.equals("")) {
        ResultSet datos = base.consultar("select * from cliente where id ='"+Integer.parseInt(ID)+"'");
        tabla.setNumRows(0);
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{String.valueOf(datos.getInt("id")), datos.getString("nombre"), datos.getString("apellidos"), datos.getString("RFC"), datos.getString("telefono"), String.valueOf(datos.getInt("CP")), datos.getString("colonia"), datos.getString("calle_num"), datos.getString("email")});
                Bcliente.JtbCliente.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }   
            }
        
        if (!nombre.equals("")) {
        ResultSet datos = base.consultar("select * from cliente where nombre like '%"+nombre+"%'");
        tabla.setNumRows(0);
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{String.valueOf(datos.getInt("id")), datos.getString("nombre"), datos.getString("apellidos"), datos.getString("RFC"), datos.getString("telefono"), String.valueOf(datos.getInt("CP")), datos.getString("colonia"), datos.getString("calle_num"), datos.getString("email")});
                Bcliente.JtbCliente.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
        if (!apellidos.equals("")) {
        ResultSet datos = base.consultar("select * from cliente where nombre like '%"+apellidos+"%'");
        tabla.setNumRows(0);
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{String.valueOf(datos.getInt("id")), datos.getString("nombre"), datos.getString("apellidos"), datos.getString("RFC"), datos.getString("telefono"), String.valueOf(datos.getInt("CP")), datos.getString("colonia"), datos.getString("calle_num"), datos.getString("email")});
                Bcliente.JtbCliente.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
        if (opc.equals("Ordenar A - Z")) {
        ResultSet datos = base.consultar("select * from cliente order by nombre asc");
        tabla.setNumRows(0);
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{String.valueOf(datos.getInt("id")), datos.getString("nombre"), datos.getString("apellidos"), datos.getString("RFC"), datos.getString("telefono"), String.valueOf(datos.getInt("CP")), datos.getString("colonia"), datos.getString("calle_num"), datos.getString("email")});
                Bcliente.JtbCliente.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }    
            
        }
        if (opc.equals("Ordenar Z - A")) {
        ResultSet datos = base.consultar("select * from cliente order by nombre desc");
        tabla.setNumRows(0);
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{String.valueOf(datos.getInt("id")), datos.getString("nombre"), datos.getString("apellidos"), datos.getString("RFC"), datos.getString("telefono"), String.valueOf(datos.getInt("CP")), datos.getString("colonia"), datos.getString("calle_num"), datos.getString("email")});
                Bcliente.JtbCliente.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }     
        }
        
        if (opc.equals("Ordenar mayor a menor")) {
        ResultSet datos = base.consultar("select * from cliente order by id desc");
        tabla.setNumRows(0);
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{String.valueOf(datos.getInt("id")), datos.getString("nombre"), datos.getString("apellidos"), datos.getString("RFC"), datos.getString("telefono"), String.valueOf(datos.getInt("CP")), datos.getString("colonia"), datos.getString("calle_num"), datos.getString("email")});
                Bcliente.JtbCliente.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }     
        }
        
        if (opc.equals("Ordenar menor a mayor")) {
        ResultSet datos = base.consultar("select * from cliente order by id asc");
        tabla.setNumRows(0);
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{String.valueOf(datos.getInt("id")), datos.getString("nombre"), datos.getString("apellidos"), datos.getString("RFC"), datos.getString("telefono"), String.valueOf(datos.getInt("CP")), datos.getString("colonia"), datos.getString("calle_num"), datos.getString("email")});
                Bcliente.JtbCliente.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }       
        }
   
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        
        if (boton.equals(Bcliente.jbnFiltrar)) {
            filtro();
        }
        if (boton.equals(Bcliente.jbnLimpiar)) {
            llenardatos();
        }
    }
}
