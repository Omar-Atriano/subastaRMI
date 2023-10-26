import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class SubastaCliente {

    public static void main(String[] args) {
        Timer cronometro;

        try {

            SubastaVista var1 = new SubastaVista();
            SubastaModelo var3 = new SubastaModelo();
            SubastaInterface subasta = (SubastaInterface) Naming.lookup("rmi://localhost/SubastaServicio");
            SubastaControlador var2 = new SubastaControlador(var1, subasta);
            var1.asignarActionListener(var2);
            var1.asignarListSelectionListener(var2);

            cronometro = new Timer(1000, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int time= 0;
                    try {
                        time = subasta.getTime();
                    } catch (RemoteException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (time > 0) {
                        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
                        Date date = new Date(time * 1000);
                        var1.cronometroLabel.setText("Actualizando catálogo en: " + format.format(date));
                    } else {
                        var2.ActualizarCatalogo();
                        var1.cronometroLabel.setText("Actualizando catálogo en: 00:00 ");
                    }
                }
            });
            cronometro.start(); // Inicia el cronómetro



        } catch (Exception e) {
            // Paso 3: Manejar excepciones
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
