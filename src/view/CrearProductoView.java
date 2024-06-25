package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class CrearProductoView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textNombreProducto;
    public JTextField textIdCategoria;
    public JTextField textCodigoBarras;
    public JTextField textPrecioProducto;
    public JTextField textCantidadProducto;
    public JButton btnRegistrarProducto;
    public JButton btnVolver;

    public CrearProductoView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCrearProducto = new JLabel("CREAR PRODUCTO");
        lblCrearProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCrearProducto.setBounds(142, 11, 154, 17);
        contentPane.add(lblCrearProducto);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(24, 53, 63, 14);
        contentPane.add(lblNombre);

        textNombreProducto = new JTextField();
        textNombreProducto.setBounds(131, 50, 216, 20);
        contentPane.add(textNombreProducto);
        textNombreProducto.setColumns(10);

        JLabel lblIdCategoria = new JLabel("ID Categoría:");
        lblIdCategoria.setBounds(24, 84, 77, 14);
        contentPane.add(lblIdCategoria);

        textIdCategoria = new JTextField();
        textIdCategoria.setBounds(131, 81, 216, 20);
        contentPane.add(textIdCategoria);
        textIdCategoria.setColumns(10);

        JLabel lblCodigoBarras = new JLabel("Código de Barras:");
        lblCodigoBarras.setBounds(20, 115, 101, 14);
        contentPane.add(lblCodigoBarras);

        textCodigoBarras = new JTextField();
        textCodigoBarras.setBounds(131, 112, 216, 20);
        contentPane.add(textCodigoBarras);
        textCodigoBarras.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio de Venta:");
        lblPrecio.setBounds(24, 146, 92, 14);
        contentPane.add(lblPrecio);

        textPrecioProducto = new JTextField();
        textPrecioProducto.setBounds(131, 143, 216, 20);
        contentPane.add(textPrecioProducto);
        textPrecioProducto.setColumns(10);

        JLabel lblCantidad = new JLabel("Cantidad en Stock:");
        lblCantidad.setBounds(24, 177, 111, 14);
        contentPane.add(lblCantidad);

        textCantidadProducto = new JTextField();
        textCantidadProducto.setBounds(131, 174, 216, 20);
        contentPane.add(textCantidadProducto);
        textCantidadProducto.setColumns(10);

        btnRegistrarProducto = new JButton("Registrar Producto");
        btnRegistrarProducto.setBounds(160, 205, 154, 23);
        contentPane.add(btnRegistrarProducto);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(10, 11, 89, 23);
        contentPane.add(btnVolver);
    }
}
