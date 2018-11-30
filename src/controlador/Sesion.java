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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Base;
import vista.VistaSesion;
import vista.VistaPrincipal;

/**
 *
 * @author DARIE
 */
public class Sesion implements ActionListener{
    Base base;
    VistaSesion log;
    VistaPrincipal menu;
    public Sesion(Base base, VistaSesion log, VistaPrincipal menu ) {
        this.menu = menu;
        this.base = base;
        this.log = log;
        log.jbnEntrar.addActionListener(this);
        log.jbnSalir.addActionListener(this);
        log.jtfusuario.addActionListener(this);
        log.jpfContraseña.addActionListener(this);
        
    }
    
    public void entrar(){
        ResultSet login = base.consultar("select * from usuario where id_usu='"+log.jtfusuario.getText()+"' and contraseña='"+log.jpfContraseña.getText()+"';");
        try {
            if (login.next()) {
                menu.setVisible(true);
                menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
                log.dispose();
            }else{
                JOptionPane.showMessageDialog(log, "Usuario no encontrado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        if (boton.equals(log.jbnSalir)) {
            System.exit(0);
        }if (boton.equals(log.jbnEntrar)) {
            entrar();
        }
    }
    
    
}
