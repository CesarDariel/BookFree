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
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import modelo.Base;
import vista.VistaBuscarProveedor;

/**
 *
 * @author DARIE
 */

public class BuscarProveedor implements ActionListener{
    
    Base base;
    VistaBuscarProveedor BProveedor;
    
    public BuscarProveedor(Base base, VistaBuscarProveedor BProveedor) {
        this.base = base;
        this.BProveedor = BProveedor;
        BProveedor.jbnBuscar.addActionListener(this);
        BProveedor.jbnLimpiar.addActionListener(this);
        BProveedor.jbnSalir.addActionListener(this);
        BProveedor.jrbEditorial.addActionListener(this);
        BProveedor.jrbSocio.addActionListener(this);
        
        
    }
    
    public void limpiar(){
        DefaultTableModel tabla = (DefaultTableModel) BProveedor.jtbProveedor.getModel();
        tabla.setColumnIdentifiers(new Object[]{"Folio", "Nombre", "Domicilio", "Municipio", "Estado", "CP", "Telefono"});
        ResultSet datos = base.consultar("select * from proveedor");
        tabla.setNumRows(0);
        int[] anchos = {80, 150, 150, 100, 80, 100, 100};
        for(int i = 0; i < BProveedor.jtbProveedor.getColumnCount(); i++) {
            BProveedor.jtbProveedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{datos.getString("folio"), datos.getString("nombre"), datos.getString("calle_num"), datos.getString("municipio"), datos.getString("estado"), String.valueOf(datos.getInt("CP")), datos.getString("telefono")});
                BProveedor.jtbProveedor.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Buscar(){
        DefaultTableModel tabla = (DefaultTableModel) BProveedor.jtbProveedor.getModel();
        tabla.setColumnIdentifiers(new Object[]{"Folio", "Nombre", "Domicilio", "Municipio", "Estado", "CP", "Telefono"});
        ResultSet datos = base.consultar("select * from proveedor where nombre like '%"+BProveedor.jtfNombre.getText()+"%'");
        tabla.setNumRows(0);
        int[] anchos = {80, 150, 150, 100, 80, 100, 100};
        for(int i = 0; i < BProveedor.jtbProveedor.getColumnCount(); i++) {
            BProveedor.jtbProveedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{datos.getString("folio"), datos.getString("nombre"), datos.getString("calle_num"), datos.getString("municipio"), datos.getString("estado"), String.valueOf(datos.getInt("CP")), datos.getString("telefono")});
                BProveedor.jtbProveedor.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void socio(){
        DefaultTableModel tabla = (DefaultTableModel) BProveedor.jtbProveedor.getModel();
        tabla.setColumnIdentifiers(new Object[]{"Folio", "Nombre", "Domicilio", "Municipio", "Estado", "CP", "Telefono"});
        ResultSet datos = base.consultar("select * from proveedor where folio like '%SOC%'");
        tabla.setNumRows(0);
        int[] anchos = {80, 150, 150, 100, 80, 100, 100};
        for(int i = 0; i < BProveedor.jtbProveedor.getColumnCount(); i++) {
            BProveedor.jtbProveedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{datos.getString("folio"), datos.getString("nombre"), datos.getString("calle_num"), datos.getString("municipio"), datos.getString("estado"), String.valueOf(datos.getInt("CP")), datos.getString("telefono")});
                BProveedor.jtbProveedor.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editorial(){
        DefaultTableModel tabla = (DefaultTableModel) BProveedor.jtbProveedor.getModel();
        tabla.setColumnIdentifiers(new Object[]{"Folio", "Nombre", "Domicilio", "Municipio", "Estado", "CP", "Telefono"});
        ResultSet datos = base.consultar("select * from proveedor where folio like '%EDI%'");
        tabla.setNumRows(0);
        int[] anchos = {80, 150, 150, 100, 80, 100, 100};
        for(int i = 0; i < BProveedor.jtbProveedor.getColumnCount(); i++) {
            BProveedor.jtbProveedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        try {
            while(datos.next()){
                tabla.addRow(new Object[]{datos.getString("folio"), datos.getString("nombre"), datos.getString("calle_num"), datos.getString("municipio"), datos.getString("estado"), String.valueOf(datos.getInt("CP")), datos.getString("telefono")});
                BProveedor.jtbProveedor.getModel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaBuscarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().getClass().toString().equals("class javax.swing.JButton")) {
            JButton boton = (JButton) ae.getSource();
            
            if (boton.equals(BProveedor.jbnBuscar)) {
                Buscar();
            }
            if (boton.equals(BProveedor.jbnLimpiar)) {
                limpiar();
            }
            if (boton.equals(BProveedor.jbnSalir)) {
                BProveedor.dispose();
            }
        }
        if (ae.getSource().getClass().toString().equals("class javax.swing.JRadioButton")) {
            JRadioButton radio = (JRadioButton) ae.getSource();
            
            if (radio.equals(BProveedor.jrbEditorial)) {
                editorial();
            }
            if (radio.equals(BProveedor.jrbSocio)) {
                socio();
            }
        }
    }
    
}
