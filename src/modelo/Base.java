/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author DARIE
 */
public class Base {
    Connection conect;

    public Base() {
        conectar();
    }

    public Connection getConect() {
        return conect;
    }

    public void setConect(Connection conect) {
        this.conect = conect;
    }
    
    
    public void conectar(){
        String Base="Bookfree",User="sa",Pass="root";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName="+Base+";user="+User+";password="+Pass+";";
            conect = DriverManager.getConnection(url);
            System.err.println("Conectado a SQLServer");
        } catch (ClassNotFoundException ex) {
            System.out.println("error "+ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
    }
    
    public ResultSet consultar(String query){
        Statement sm;
        ResultSet datos = null;
        try {
            sm = conect.createStatement();
            datos = sm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    public void actualizar(String query){
        Statement sm;
        ResultSet datos = null;
        try {
            sm = conect.createStatement();
            sm.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
