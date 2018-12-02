/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import vista.VistaAgregarCliente;
import vista.VistaAgregarLibro;
import vista.VistaAgregarProveedor;
import vista.VistaBuscarCliente;
import vista.VistaBuscarLibro;
import vista.VistaBuscarProveedor;
import vista.VistaEliminarCliente;
import vista.VistaEliminarLibro;
import vista.VistaEliminarProveedor;
import vista.VistaModificarCliente;
import vista.VistaModificarLibro;
import vista.VistaModificarProveedor;
import vista.VistaPrincipal;
import vista.VistaRealizarVenta;

/**
 *
 * @author DARIE
 */
public class Principal implements ActionListener{

    VistaPrincipal principal;
    VistaAgregarCliente Acliente;
    VistaEliminarCliente Ecliente;
    VistaBuscarCliente Bcliente;
    VistaModificarCliente Mcliente;
    VistaAgregarLibro Alibro;
    VistaEliminarLibro Elibro;
    VistaBuscarLibro Blibro;
    VistaModificarLibro Mlibro;
    VistaAgregarProveedor AProveedor;
    VistaEliminarProveedor EProveedor;
    VistaBuscarProveedor BProveedor;
    VistaModificarProveedor MProveedor;
    VistaRealizarVenta RVenta;
    
    public Principal(VistaPrincipal principal, VistaAgregarCliente Acliente, VistaEliminarCliente Ecliente, VistaBuscarCliente Bcliente
    , VistaModificarCliente Mcliente, VistaAgregarLibro Alibro, VistaEliminarLibro Elibro, VistaBuscarLibro Blibro
    , VistaModificarLibro Mlibro, VistaAgregarProveedor AProveedor, VistaEliminarProveedor EProveedor,
    VistaBuscarProveedor BProveedor, VistaModificarProveedor MProveedor, VistaRealizarVenta RVenta) {
        this.principal=principal;
        this.Acliente=Acliente;
        this.Ecliente=Ecliente;
        this.Bcliente=Bcliente;
        this.Mcliente=Mcliente;
        this.Alibro = Alibro;
        this.Elibro = Elibro;
        this.Blibro = Blibro;
        this.Mlibro = Mlibro;
        this.AProveedor = AProveedor;
        this.EProveedor = EProveedor;
        this.BProveedor = BProveedor;
        this.MProveedor = MProveedor;
        this.RVenta = RVenta;
        this.principal.ItemAgregarClientes.addActionListener(this);
        this.principal.ItemAgregarLibro.addActionListener(this);
        this.principal.ItemAgregarProveedor.addActionListener(this);
        this.principal.ItemBuscarCliente.addActionListener(this);
        this.principal.ItemBuscarFactura.addActionListener(this);
        this.principal.ItemBuscarLibro.addActionListener(this);
        this.principal.ItemBuscarProveedor.addActionListener(this);
        this.principal.ItemBuscarVenta.addActionListener(this);
        this.principal.ItemEliminarClientes.addActionListener(this);
        this.principal.ItemEliminarLibro.addActionListener(this);
        this.principal.ItemEliminarProveedor.addActionListener(this);
        this.principal.ItemModificarCliente.addActionListener(this);
        this.principal.ItemModificarLibro.addActionListener(this);
        this.principal.ItemModificarProveedor.addActionListener(this);
        this.principal.ItemNuevoFactura.addActionListener(this);
        this.principal.ItemNuevoVenta.addActionListener(this);
        this.principal.ItemCerrarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JMenuItem Item = (JMenuItem) ae.getSource();
        
        if (Item.equals(principal.ItemAgregarClientes)){
            principal.Panel.add(Acliente);
            Acliente.setVisible(true);
            Acliente.setClosable(true);
            Acliente.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize = Acliente.getSize();
            Acliente.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        }if (Item.equals(principal.ItemEliminarClientes)) {
            principal.Panel.add(Ecliente);
            Ecliente.setVisible(true);
            Ecliente.setClosable(true);
            Ecliente.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize = Ecliente.getSize();
            Ecliente.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        }if (Item.equals(principal.ItemBuscarCliente)) {
            principal.Panel.add(Bcliente);
            Bcliente.setVisible(true);
            Bcliente.setClosable(true);
            Bcliente.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize = Bcliente.getSize();
            Bcliente.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        }if (Item.equals(principal.ItemModificarCliente)) {
            principal.Panel.add(Mcliente);
            Mcliente.setVisible(true);
            Mcliente.setClosable(true);
            Mcliente.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize =Mcliente.getSize();
            Mcliente.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        }if (Item.equals(principal.ItemAgregarLibro)) {
            principal.Panel.add(Alibro);
            Alibro.setVisible(true);
            Alibro.setClosable(true);
            Alibro.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize =Alibro.getSize();
            Alibro.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);       
        }if (Item.equals(principal.ItemEliminarLibro)) {
            principal.Panel.add(Elibro);
            Elibro.setVisible(true);
            Elibro.setClosable(true);
            Elibro.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize =Elibro.getSize();
            Elibro.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2); 
        }if (Item.equals(principal.ItemBuscarLibro)) {
            principal.Panel.add(Blibro);
            Blibro.setVisible(true);
            Blibro.setClosable(true);
            Blibro.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize =Blibro.getSize();
            Blibro.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2); 
        }if (Item.equals(principal.ItemModificarLibro)) {
            principal.Panel.add(Mlibro);
            Mlibro.setVisible(true);
            Mlibro.setClosable(true);
            Mlibro.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize =Mlibro.getSize();
            Mlibro.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2); 
        }if (Item.equals(principal.ItemAgregarProveedor)) {
            principal.Panel.add(AProveedor);
            AProveedor.setVisible(true);
            AProveedor.setClosable(true);
            AProveedor.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize =AProveedor.getSize();
            AProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2); 
        }if (Item.equals(principal.ItemBuscarProveedor)) {
            principal.Panel.add(BProveedor);
            BProveedor.setVisible(true);
            BProveedor.setClosable(true);
            BProveedor.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize =BProveedor.getSize();
            BProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2); 
        }if (Item.equals(principal.ItemEliminarProveedor)) {
            principal.Panel.add(EProveedor);
            EProveedor.setVisible(true);
            EProveedor.setClosable(true);
            EProveedor.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize =EProveedor.getSize();
            EProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        }if (Item.equals(principal.ItemModificarProveedor)) {
            principal.Panel.add(MProveedor);
            MProveedor.setVisible(true);
            MProveedor.setClosable(true);
            MProveedor.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize =MProveedor.getSize();
            MProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        }if (Item.equals(principal.ItemNuevoVenta)) {
            principal.Panel.add(RVenta);
            RVenta.setVisible(true);
            RVenta.setClosable(true);
            RVenta.setMaximizable(true);
            // Centrar la venta de AgregarClientes
            Dimension desktopSize = principal.Panel.getSize();
            Dimension FrameSize =RVenta.getSize();
            RVenta.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        }
    }
    
}
