import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InformacionOfertaInterface extends Remote {
    void setInformacionOferta(String comprador, String producto, float monto) throws RemoteException;
    String getComprador() throws RemoteException;
    String getProducto() throws RemoteException;
    float getMonto() throws RemoteException;
}