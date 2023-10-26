import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class SubastaServidor {

    public static void main(String[] args) {
        Timer cronometroServidor;
        try {
            SubastaModelo subasta = new SubastaModelo();
            Naming.rebind("rmi://localhost/SubastaServicio", subasta);
            System.out.println("Servidor de Subasta está listo.");

            cronometroServidor = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (subasta.serverTime>0) {
                        subasta.serverTime--;
                    } else {
                        subasta.serverTime=5;

                    }
                }
            });
            cronometroServidor.start(); // Inicia el cronómetro

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
