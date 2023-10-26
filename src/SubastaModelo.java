import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

public class SubastaModelo extends UnicastRemoteObject implements SubastaInterface {
    Hashtable<String, String> usuarios;
    Hashtable<String, InformacionProducto> productos;
    Hashtable<String, InformacionOferta> ofertas;

    public int serverTime= 5;

    public SubastaModelo() throws RemoteException {
        super();
        usuarios = new Hashtable<>();
        productos = new Hashtable<>();
        ofertas = new Hashtable<>();
    }

    @Override
    public boolean registraUsuario(String nombre) throws RemoteException {
        if( !usuarios.containsKey(nombre) ) {
            System.out.println( "Agregando un nuevo usuario: " + nombre );
            usuarios.put( nombre, nombre );
            return true;
        } else
            return false;
    }

    @Override
    public boolean agregaProductoALaVenta(String vendedor, String producto, float precioInicial) throws RemoteException {
        if( !productos.containsKey(producto) ) {

            System.out.println( "Agregando un nuevo producto: " + producto );
            productos.put( producto, new InformacionProducto( vendedor,producto,precioInicial ) );
            return true;
        } else
            return false;
    }

    @Override
    public boolean agregaOferta(String comprador, String producto, float monto) throws RemoteException {
        if( productos.containsKey(producto) ) {
            InformacionProducto infoProd;
            infoProd = (InformacionProducto) productos.get(producto);
            System.out.println( "Agregando un nuevo Oferta producto: " + producto +", monto: "+ monto );
            if( infoProd.actualizarPrecio(monto) ) {
                System.out.println( "Actualizando Oferta producto: " + producto +", monto: "+ monto );
                ofertas.put( producto + comprador, new InformacionOferta( comprador, producto, monto) );
                return true;
            } else
                return false;
        } else
            return false;
    }

    public java.util.Date sendDate(Date d){
        System.out.println(d);
        return new java.util.Date();
    }

    public int getTime(){
        return serverTime;
    }
    @Override
    public Vector obtieneCatalogo() throws RemoteException {
        Vector resultado;
        resultado = new Vector( productos.values() );
        return resultado;
    }

}
