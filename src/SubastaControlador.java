//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.rmi.Naming;
import java.util.TimerTask;


public class SubastaControlador implements ActionListener, ListSelectionListener {
    SubastaVista vista;
    SubastaInterface modelo;
    Hashtable listaConPrecios;



    public SubastaControlador(SubastaVista var1, SubastaInterface var2) {
        this.vista = var1;
        this.modelo = var2;
    }

    public void ActualizarCatalogo(){
        Vector var5 = null;
        try {
            var5 = this.modelo.obtieneCatalogo();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        this.listaConPrecios = new Hashtable();
        this.vista.reinicializaListaProductosActualizados();

        Enumeration var6 = var5.elements();

        while (var6.hasMoreElements()) {
            InformacionProductoInterface var7 = (InformacionProductoInterface) var6.nextElement();
            try {
                String nombreProducto = var7.getNombreProducto();
                float precioActual = var7.getPrecioActual();

                this.listaConPrecios.put(nombreProducto, String.valueOf(precioActual));
                this.vista.agregaProductoActualizado("Producto: "+nombreProducto+" ---> Mejor Oferta: " + precioActual);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void actionPerformed(ActionEvent var1) {

        System.out.println("<<" + var1.getActionCommand() + ">>");
        if (var1.getActionCommand().equals("Salir")) {
            System.exit(1);
        } else {
            String var2;
            if (var1.getActionCommand().equals("Conectar")) {
                var2 = this.vista.getUsuario();
                System.out.println("Registrarse como usuario: " + var2);
                try {
                    this.modelo.registraUsuario(var2);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            } else {
                String var3;
                float var4;
                if (var1.getActionCommand().equals("Poner a la venta")) {

                    var2 = this.vista.getUsuario();
                    var3 = this.vista.getProducto();
                    var4 = this.vista.getPrecioInicial();
                    System.out.println("Haciendo oferta del producto: " + var3);
                    try {
                        this.modelo.agregaProductoALaVenta(var2, var3, var4);
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                } else if (var1.getActionCommand().equals("Obtener lista" )|| this.vista.Timeout) {
                    Vector var5 = null;
                    try {
                        var5 = this.modelo.obtieneCatalogo();
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }

                    this.listaConPrecios = new Hashtable();
                    this.vista.reinicializaListaProductos();

                    Enumeration var6 = var5.elements();

                    while (var6.hasMoreElements()) {
                        InformacionProductoInterface var7 = (InformacionProductoInterface) var6.nextElement();
                        try {
                            String nombreProducto = var7.getNombreProducto();
                            float precioActual = var7.getPrecioActual();

                            this.listaConPrecios.put(nombreProducto, String.valueOf(precioActual));
                            this.vista.agregaProducto(nombreProducto);
                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                else if (var1.getActionCommand().equals("Ofrecer")) {
                    var3 = this.vista.getProductoSeleccionado();
                    var4 = this.vista.getMontoOfrecido();
                    var2 = this.vista.getUsuario();
                    try {
                        this.modelo.agregaOferta(var2, var3, var4);
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }

    }

    public void valueChanged(ListSelectionEvent var1) {
        if (!var1.getValueIsAdjusting()) {
            JList var2 = (JList)var1.getSource();
            String var3 = (String)var2.getSelectedValue();
            if (var3 != null) {
                System.out.println(var3);
                String var4 = (String)this.listaConPrecios.get(var3);
                this.vista.desplegarPrecio(var4);
            }
        }

    }
}
