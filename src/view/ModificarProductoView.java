package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class ModificarProductoView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textCodigoProducto;
    public JTextField textNombreProducto;
    public JTextField textIdCategoria;
    public JTextField textCodigoBarras;
    public JTextField textPrecioProducto;
    public JTextField textCantidadProducto;
    public JButton btnActualizarProducto;
    public JButton btnVolver;
    public JButton btnBuscarProductoID;

    public ModificarProductoView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblModificarProducto = new JLabel("MODIFICAR PRODUCTO");
        lblModificarProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblModificarProducto.setBounds(132, 11, 186, 17);
        contentPane.add(lblModificarProducto);

        JLabel lblCodigo = new JLabel("ID Producto:");
        lblCodigo.setBounds(27, 53, 77, 14);
        contentPane.add(lblCodigo);

        textCodigoProducto = new JTextField();
        textCodigoProducto.setBounds(137, 50, 89, 20);
        contentPane.add(textCodigoProducto);
        textCodigoProducto.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(27, 84, 45, 14);
        contentPane.add(lblNombre);

        textNombreProducto = new JTextField();
        textNombreProducto.setBounds(137, 81, 210, 20);
        contentPane.add(textNombreProducto);
        textNombreProducto.setColumns(10);

        JLabel lblIdCategoria = new JLabel("ID Categoría:");
        lblIdCategoria.setBounds(23, 115, 89, 14);
        contentPane.add(lblIdCategoria);

        textIdCategoria = new JTextField();
        textIdCategoria.setBounds(137, 112, 210, 20);
        contentPane.add(textIdCategoria);
        textIdCategoria.setColumns(10);

        JLabel lblCodigoBarras = new JLabel("Código de Barras:");
        lblCodigoBarras.setBounds(23, 140, 104, 14);
        contentPane.add(lblCodigoBarras);

        textCodigoBarras = new JTextField();
        textCodigoBarras.setBounds(137, 143, 210, 20);
        contentPane.add(textCodigoBarras);
        textCodigoBarras.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio de Venta:");
        lblPrecio.setBounds(23, 177, 104, 14);
        contentPane.add(lblPrecio);

        textPrecioProducto = new JTextField();
        textPrecioProducto.setBounds(137, 174, 210, 20);
        contentPane.add(textPrecioProducto);
        textPrecioProducto.setColumns(10);

        JLabel lblCantidad = new JLabel("Cantidad en Stock:");
        lblCantidad.setBounds(23, 208, 104, 14);
        contentPane.add(lblCantidad);

        textCantidadProducto = new JTextField();
        textCantidadProducto.setBounds(137, 205, 210, 20);
        contentPane.add(textCantidadProducto);
        textCantidadProducto.setColumns(10);

        btnActualizarProducto = new JButton("Actualizar Producto");
        btnActualizarProducto.setBounds(137, 236, 160, 23);
        contentPane.add(btnActualizarProducto);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(10, 11, 89, 23);
        contentPane.add(btnVolver);
        
        btnBuscarProductoID = new JButton("BUSCAR");
        btnBuscarProductoID.setBounds(294, 49, 104, 23);
        contentPane.add(btnBuscarProductoID);
    }
}
