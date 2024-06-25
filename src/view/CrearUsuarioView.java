package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class CrearUsuarioView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textNombreUsuario;
    public JTextField textEmailUsuario;
    public JTextField textTelefonoUsuario;
    public JButton btnRegistrarUsuario;
    public JButton btnVolver;
    public JLabel lblTitulo;

    public CrearUsuarioView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 405, 270);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTitulo = new JLabel("CREAR USUARIO");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTitulo.setBounds(10, 11, 369, 14);
        contentPane.add(lblTitulo);

        JLabel lblNombreUsuario = new JLabel("Nombre del usuario:");
        lblNombreUsuario.setBounds(10, 36, 188, 14);
        contentPane.add(lblNombreUsuario);

        textNombreUsuario = new JTextField();
        textNombreUsuario.setBounds(10, 61, 369, 20);
        contentPane.add(textNombreUsuario);
        textNombreUsuario.setColumns(10);

        JLabel lblEmailUsuario = new JLabel("Email del usuario:");
        lblEmailUsuario.setBounds(10, 92, 188, 14);
        contentPane.add(lblEmailUsuario);

        textEmailUsuario = new JTextField();
        textEmailUsuario.setColumns(10);
        textEmailUsuario.setBounds(10, 117, 369, 20);
        contentPane.add(textEmailUsuario);

        JLabel lblTelefonoUsuario = new JLabel("Teléfono del usuario:");
        lblTelefonoUsuario.setBounds(10, 148, 188, 14);
        contentPane.add(lblTelefonoUsuario);

        textTelefonoUsuario = new JTextField();
        textTelefonoUsuario.setColumns(10);
        textTelefonoUsuario.setBounds(10, 173, 186, 20);
        contentPane.add(textTelefonoUsuario);

        btnRegistrarUsuario = new JButton("REGISTRAR");
        btnRegistrarUsuario.setBounds(208, 204, 171, 23);
        contentPane.add(btnRegistrarUsuario);

        btnVolver = new JButton("VOLVER");
        btnVolver.setBackground(new Color(255, 128, 128));
        btnVolver.setBounds(10, 204, 171, 23);
        contentPane.add(btnVolver);
    }
}
