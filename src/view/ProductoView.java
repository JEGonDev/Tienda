package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductoView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textCodigoEliminarProducto;
    public JTable table;
    public JButton btnMostrarProductos;
    public JButton btnCrearProducto;
    public JButton btnEliminarProducto;
    public JButton btnModificarProducto;
    public DefaultTableModel model;
    public JButton btnVolverProductos;

    public ProductoView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 594, 356);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblModificarProductos = new JLabel("PRODUCTOS");
        lblModificarProductos.setHorizontalAlignment(SwingConstants.LEFT);
        lblModificarProductos.setBounds(271, 0, 137, 29);
        lblModificarProductos.setForeground(new Color(0, 0, 0));
        lblModificarProductos.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        contentPane.add(lblModificarProductos);

        btnMostrarProductos = new JButton("Mostrar productos existentes");
        btnMostrarProductos.setBounds(169, 31, 271, 23);
        contentPane.add(btnMostrarProductos);

        btnCrearProducto = new JButton("CREAR producto");
        btnCrearProducto.setBounds(298, 271, 271, 34);
        contentPane.add(btnCrearProducto);

        JLabel lblEliminarProducto = new JLabel("Ingresar el ID del producto que deseas eliminar:");
        lblEliminarProducto.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        lblEliminarProducto.setBounds(10, 212, 398, 14);
        contentPane.add(lblEliminarProducto);

        textCodigoEliminarProducto = new JTextField();
        textCodigoEliminarProducto.setColumns(10);
        textCodigoEliminarProducto.setBounds(10, 237, 398, 23);
        contentPane.add(textCodigoEliminarProducto);

        btnEliminarProducto = new JButton("ELIMINAR");
        btnEliminarProducto.setBackground(new Color(255, 128, 128));
        btnEliminarProducto.setBounds(418, 237, 151, 23);
        contentPane.add(btnEliminarProducto);

        btnModificarProducto = new JButton("MODIFICAR producto");
        btnModificarProducto.setBounds(10, 270, 271, 34);
        contentPane.add(btnModificarProducto);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 65, 559, 136);
        contentPane.add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("ID Categoría");
        model.addColumn("Código de Barras");
        model.addColumn("Precio de Venta");
        model.addColumn("Cantidad en Stock");

        table.setModel(model);
        scrollPane.setViewportView(table);

        btnVolverProductos = new JButton("VOLVER");
        btnVolverProductos.setBackground(new Color(0, 255, 0));
        btnVolverProductos.setBounds(10, 11, 93, 23);
        contentPane.add(btnVolverProductos);
    }
}
