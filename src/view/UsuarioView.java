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

public class UsuarioView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textCodigoEliminarUsuario;
    public JTable table;
    public JButton btnMostrarUsuarios;
    public JButton btnCrearUsuario;
    public JButton btnEliminarUsuario;
    public JButton btnModificarUsuario;
    public DefaultTableModel model;
    public JButton btnVolverUsuarios;

    public UsuarioView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 594, 355);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblModificarUsuarios = new JLabel("USUARIOS");
        lblModificarUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
        lblModificarUsuarios.setBounds(271, 0, 137, 29);
        lblModificarUsuarios.setForeground(new Color(0, 0, 0));
        lblModificarUsuarios.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        contentPane.add(lblModificarUsuarios);

        btnMostrarUsuarios = new JButton("Mostrar usuarios existentes");
        btnMostrarUsuarios.setBounds(169, 31, 271, 23);
        contentPane.add(btnMostrarUsuarios);

        btnCrearUsuario = new JButton("CREAR usuario");
        btnCrearUsuario.setBounds(298, 271, 271, 34);
        contentPane.add(btnCrearUsuario);

        JLabel lblEliminarUsuario = new JLabel("Ingresar el ID del usuario que deseas eliminar:");
        lblEliminarUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        lblEliminarUsuario.setBounds(10, 212, 398, 14);
        contentPane.add(lblEliminarUsuario);

        textCodigoEliminarUsuario = new JTextField();
        textCodigoEliminarUsuario.setColumns(10);
        textCodigoEliminarUsuario.setBounds(10, 237, 398, 23);
        contentPane.add(textCodigoEliminarUsuario);

        btnEliminarUsuario = new JButton("ELIMINAR");
        btnEliminarUsuario.setBackground(new Color(255, 128, 128));
        btnEliminarUsuario.setBounds(418, 237, 151, 23);
        contentPane.add(btnEliminarUsuario);

        btnModificarUsuario = new JButton("MODIFICAR usuario");
        btnModificarUsuario.setBounds(10, 270, 271, 34);
        contentPane.add(btnModificarUsuario);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 65, 559, 136);
        contentPane.add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel();
        model.addColumn("idUsuario");
        model.addColumn("nombre");
        model.addColumn("email");
        model.addColumn("telefono");

        table.setModel(model);
        scrollPane.setViewportView(table);
        

        // Otros componentes...

        btnVolverUsuarios = new JButton("VOLVER");
        btnVolverUsuarios.setBackground(new Color(0, 255, 0));
        btnVolverUsuarios.setBounds(10, 11, 100, 30); // Ajusta según tu diseño
        contentPane.add(btnVolverUsuarios);
    }

    public void mostrarDatos(Object[] fila) {
        model.addRow(fila);
    }

    public void limpiarTabla() {
        model.setRowCount(0);
    }

    public JButton getBtnVolverUsuarios() {
        return btnVolverUsuarios;
    }
}
