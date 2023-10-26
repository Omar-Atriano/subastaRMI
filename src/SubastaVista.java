import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class SubastaVista {
    /*
    JFrame principal;
    JTextField usuario;
    JTextField producto;
    JTextField precioInicial;
    JTextField monto;
    DefaultComboBoxModel productos;
    JLabel precioActual;
    JList lista;
    JButton conectar;
    JButton salir;
    JButton ponerALaVenta;
    JButton obtenerLista;
    JButton ofrecer;
     */
    boolean Timeout=false;
    private JFrame principal;
    private JTextField usuario;
    private JButton conectar;
    private JButton salir;
    private JTextField producto;
    private JTextField precioInicial;
    private JButton ponerALaVenta;
    private DefaultComboBoxModel<String> productos;
    private JList<String> lista;
    private JButton obtenerLista;
    private JLabel precioActual;
    private JTextField monto;
    private JButton ofrecer;
    private DefaultComboBoxModel<String> productos2;
    private JList<String> lista2;

    public JLabel cronometroLabel;  // Etiqueta para mostrar el cronómetro




    public SubastaVista() {
        principal = new JFrame("Cliente Subasta");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        principal.add(splitPane);

        JPanel var1 = new JPanel(new GridLayout(0, 2));
        splitPane.setLeftComponent(var1);

        var1.setLayout(new GridLayout(0, 2));
        this.usuario = new JTextField();
        var1.add(new JLabel("Nombre del usuario"));
        var1.add(this.usuario);
        this.conectar = new JButton("Conectar");
        this.salir = new JButton("Salir");
        var1.add(this.conectar);
        var1.add(this.salir);
        this.producto = new JTextField();
        this.precioInicial = new JTextField();
        var1.add(new JLabel("Producto a ofrecer"));
        var1.add(this.producto);
        var1.add(new JLabel("Precio inicial"));
        var1.add(this.precioInicial);
        this.ponerALaVenta = new JButton("Poner a la venta");
        var1.add(this.ponerALaVenta);
        var1.add(new JLabel());
        this.productos = new DefaultComboBoxModel();
        this.lista = new JList(this.productos);
        this.lista.setSelectionMode(0);
        this.lista.setLayoutOrientation(0);
        JScrollPane var2 = new JScrollPane(this.lista);
        var2.setPreferredSize(new Dimension(250, 80));
        this.obtenerLista = new JButton("Obtener lista");
        var1.add(this.obtenerLista);
        var1.add(var2);
        this.precioActual = new JLabel();
        var1.add(new JLabel("Precio actual"));
        var1.add(this.precioActual);
        this.monto = new JTextField();
        this.ofrecer = new JButton("Ofrecer");
        var1.add(this.ofrecer);
        var1.add(this.monto);

        // Agregar el cronómetroLabel al panelIzquierdo
        cronometroLabel = new JLabel("Actualizando catálogo en: 00:00");

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.add(cronometroLabel, BorderLayout.NORTH);

        // Crear y configurar la segunda lista y su modelo
        productos2 = new DefaultComboBoxModel<>();
        lista2 = new JList<>(productos2);
        // Deshabilitar la selección
        lista2.setSelectionModel(new DefaultListSelectionModel());

// Deshabilitar la JList completa
        lista2.setEnabled(false);

        lista2.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane2 = new JScrollPane(lista2);
        scrollPane2.setPreferredSize(new Dimension(200, 300));

        panelDerecho.add(scrollPane2, BorderLayout.CENTER);
        splitPane.setRightComponent(panelDerecho);

        principal.setSize(600, 400); // Ajustar el tamaño total de la ventana
        principal.setVisible(true);
    }

    public void asignarActionListener(ActionListener var1) {
        this.conectar.addActionListener(var1);
        this.salir.addActionListener(var1);
        this.ponerALaVenta.addActionListener(var1);
        this.obtenerLista.addActionListener(var1);
        this.ofrecer.addActionListener(var1);
    }

    public void asignarListSelectionListener(ListSelectionListener var1) {
        this.lista.addListSelectionListener(var1);
    }

    public String getUsuario() {
        return this.usuario.getText();
    }

    public String getProducto() {
        return this.producto.getText();
    }

    public float getPrecioInicial() {
        float var1 = 0.0F;

        try {
            var1 = Float.parseFloat(this.precioInicial.getText());
        } catch (Exception var3) {
            System.out.println("Hay problemas con el precio inicial");
        }

        return var1;
    }

    public void reinicializaListaProductos() {
        this.productos.removeAllElements();
    }

    public void agregaProducto(String var1) {
        this.productos.addElement(var1);
    }

    public void agregaProductoActualizado(String var1) {
        this.productos2.addElement(var1);
    }

    public void reinicializaListaProductosActualizados() {
        this.productos2.removeAllElements();
    }

    public void desplegarPrecio(String var1) {
        this.precioActual.setText(var1);
    }

    public float getMontoOfrecido() {
        float var1 = 0.0F;

        try {
            var1 = Float.parseFloat(this.monto.getText());
        } catch (Exception var3) {
            System.out.println("Hay problemas con el monto ofrecido");
        }

        return var1;
    }

    public String getProductoSeleccionado() {
        return (String)this.lista.getSelectedValue();
    }
}

