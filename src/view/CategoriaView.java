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

public class CategoriaView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textCodigoEliminarCategoria;
    public JTable table;
    public JButton btnMostrarCategorias;
    public JButton btnCrearCategoria;
    public JButton btnEliminarCategoria;
    public JButton btnModificarCategoria; // Botón para modificar categoría
    public DefaultTableModel model;
    public JButton btnVolverCategorias;

    public CategoriaView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 594, 355);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("CATEGORÍAS");
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitulo.setBounds(271, 0, 137, 29);
        lblTitulo.setForeground(new Color(0, 0, 0));
        lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        contentPane.add(lblTitulo);

        btnMostrarCategorias = new JButton("Mostrar categorías existentes");
        btnMostrarCategorias.setBounds(169, 31, 271, 23);
        contentPane.add(btnMostrarCategorias);

        btnCrearCategoria = new JButton("CREAR categoría");
        btnCrearCategoria.setBounds(10, 271, 271, 34);
        contentPane.add(btnCrearCategoria);

        JLabel lblEliminarCategoria = new JLabel("Ingresar el ID de la categoría que deseas eliminar:");
        lblEliminarCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        lblEliminarCategoria.setBounds(10, 212, 398, 14);
        contentPane.add(lblEliminarCategoria);

        textCodigoEliminarCategoria = new JTextField();
        textCodigoEliminarCategoria.setColumns(10);
        textCodigoEliminarCategoria.setBounds(10, 237, 398, 23);
        contentPane.add(textCodigoEliminarCategoria);

        btnEliminarCategoria = new JButton("ELIMINAR");
        btnEliminarCategoria.setBackground(new Color(255, 128, 128));
        btnEliminarCategoria.setBounds(418, 237, 151, 23);
        contentPane.add(btnEliminarCategoria);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 65, 559, 136);
        contentPane.add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel();
        model.addColumn("idCategoria");
        model.addColumn("nombre");

        table.setModel(model);
        scrollPane.setViewportView(table);

        // Botón para modificar categoría
        btnModificarCategoria = new JButton("MODIFICAR");
        btnModificarCategoria.setBackground(new Color(255, 255, 255));
        btnModificarCategoria.setBounds(291, 271, 278, 34);
        contentPane.add(btnModificarCategoria);

        btnVolverCategorias = new JButton("VOLVER");
        btnVolverCategorias.setBackground(Color.GREEN);
        btnVolverCategorias.setBounds(10, 11, 89, 23);
        contentPane.add(btnVolverCategorias);
    }
}
