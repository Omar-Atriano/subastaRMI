import java.rmi.Naming;
import java.util.Vector;

public class SubastaCliente {

    public static void main(String[] args) {
        try {
            // Paso 1: Obtener una referencia al objeto remoto
            SubastaInterface subasta = (SubastaInterface) Naming.lookup("rmi://localhost/SubastaServicio");

            // Paso 2: Invocar métodos en el objeto remoto
            // Ejemplo: registrar un usuario
            if (subasta.registraUsuario("Juan")) {
                System.out.println("Usuario registrado exitosamente.");
            } else {
                System.out.println("El usuario ya existe.");
            }

            // Ejemplo: agregar un producto a la venta
            if (subasta.agregaProductoALaVenta("Juan", "Libro", 10.0f)) {
                System.out.println("Producto agregado exitosamente.");
            } else {
                System.out.println("El producto ya existe.");
            }

            // Ejemplo: obtener el catálogo de productos
            Vector catalogo = subasta.obtieneCatalogo();
            System.out.println("Catálogo de productos: " + catalogo);

        } catch (Exception e) {
            // Paso 3: Manejar excepciones
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
