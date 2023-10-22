import java.rmi.Naming;

public class SubastaServidor {
    public static void main(String[] args) {
        try {
            SubastaModelo subasta = new SubastaModelo();
            Naming.rebind("rmi://localhost/SubastaServicio", subasta);
            System.out.println("Servidor de Subasta está listo.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
