import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InformacionProductoInterface extends Remote {
    void setInformacionProducto(String vendedor, String producto, float precioInicial) throws RemoteException;
    boolean actualizarPrecio(float precio) throws RemoteException;
    String getNombreProducto() throws RemoteException;
    float getPrecioActual() throws RemoteException;
}
