/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JFrame;
import modelo.Base;
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
import vista.VistaSesion;
import vista.VistaPrincipal;
import vista.VistaRealizarVenta;

/**
 *
 * @author DARIE
 */
public class BookFreeJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Base BD = new Base();
        VistaSesion VSesion = new VistaSesion();
        VistaPrincipal VPrincipal = new VistaPrincipal();
        VistaAgregarCliente VAgregarCliente = new VistaAgregarCliente();
        VistaEliminarCliente VEliminarCliente = new VistaEliminarCliente();
        VistaBuscarCliente VBuscarCliente = new VistaBuscarCliente(BD);
        VistaModificarCliente VModificarCliente = new VistaModificarCliente();
        VistaAgregarLibro VAgregarLibro = new VistaAgregarLibro();
        VistaEliminarLibro VEliminarLibro = new VistaEliminarLibro();
        VistaBuscarLibro VBuscarLibro = new VistaBuscarLibro(BD);
        VistaModificarLibro VModificarLibro = new VistaModificarLibro();
        VistaAgregarProveedor VAgregarProveedor = new VistaAgregarProveedor();
        VistaEliminarProveedor VEliminarProveedor = new VistaEliminarProveedor();
        VistaBuscarProveedor VBuscarProveedor = new VistaBuscarProveedor(BD);
        VistaModificarProveedor VModificarProveedor = new VistaModificarProveedor();
        VistaRealizarVenta VRealizarVenta = new VistaRealizarVenta();
        
        Sesion Sesion = new Sesion(BD, VSesion, VPrincipal);
        Principal Principal = new Principal(VPrincipal, VAgregarCliente, VEliminarCliente, VBuscarCliente
        , VModificarCliente, VAgregarLibro, VEliminarLibro, VBuscarLibro, VModificarLibro, VAgregarProveedor,
        VEliminarProveedor, VBuscarProveedor, VModificarProveedor,VRealizarVenta);
        AgregarCliente AgreCliente = new AgregarCliente(VAgregarCliente, BD);
        EliminarCliente EliCliente = new  EliminarCliente(BD, VEliminarCliente);
        BuscarCliente BusCliente = new BuscarCliente(BD, VBuscarCliente);
        ModificarCliente ModCliente = new ModificarCliente(BD, VModificarCliente);
        AgregarLibro AgreLibro = new AgregarLibro(BD, VAgregarLibro);
        EliminarLibro EliLibro = new EliminarLibro(BD, VEliminarLibro);
        BuscarLibro Buslibro = new BuscarLibro(BD, VBuscarLibro);
        ModificarLibro ModLibro = new ModificarLibro(BD, VModificarLibro);
        AgregarProveedor AgreProveedor = new AgregarProveedor(BD, VAgregarProveedor);
        EliminarProveedor EliProveedor = new EliminarProveedor(BD, VEliminarProveedor);
        BuscarProveedor BusProveedor = new BuscarProveedor(BD, VBuscarProveedor);
        ModificarProveedor ModProveedor = new ModificarProveedor(BD, VModificarProveedor);
        RealizarVenta ReaVenta = new RealizarVenta(BD, VRealizarVenta);
        
        VSesion.setVisible(true);
        
    }
    
}
