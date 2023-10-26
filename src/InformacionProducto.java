import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InformacionProducto extends UnicastRemoteObject implements InformacionProductoInterface {
    private String vendedor;
    private String producto;
    private float precioInicial;
    private float precioActual;

    public InformacionProducto(String v, String p, float pi) throws RemoteException {
        super();
        vendedor = v;
        producto = p;
        precioInicial = pi;
        precioActual = pi;
    }
    @Override
    public void setInformacionProducto(String v, String p, float pi) throws RemoteException {
        vendedor = v;
        producto = p;
        precioInicial = pi;
        precioActual = pi;
    }
    @Override
    public boolean actualizarPrecio(float precio) throws RemoteException {
        if (precio > precioActual) {
            precioActual = precio;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String getNombreProducto() throws RemoteException {
        return producto;
    }
    @Override
    public float getPrecioActual() throws RemoteException {
        return precioActual;
    }
}
