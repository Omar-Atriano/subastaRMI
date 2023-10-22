import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InformacionOferta extends UnicastRemoteObject implements InformacionOfertaInterface {
    private String comprador;
    private String producto;
    private float monto;

    public InformacionOferta(String c, String p, float m) throws RemoteException {
        super();
        comprador = c;
        producto = p;
        monto = m;
    }

    @Override
    public void setInformacionOferta(String c, String p, float m) throws RemoteException {
        comprador = c;
        producto = p;
        monto = m;
    }

    @Override
    public String getComprador() throws RemoteException {
        return comprador;
    }

    @Override
    public String getProducto() throws RemoteException {
        return producto;
    }

    @Override
    public float getMonto() throws RemoteException {
        return monto;
    }
}
