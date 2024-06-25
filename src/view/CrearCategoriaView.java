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

public class CrearCategoriaView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textNombreCategoria;
    public JButton btnRegistrarCategoria;
    public JButton btnVolver;
    public JLabel lblTitulo;

    public CrearCategoriaView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 405, 160);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTitulo = new JLabel("CREAR CATEGORÍA");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTitulo.setBounds(10, 11, 369, 14);
        contentPane.add(lblTitulo);

        JLabel lblNombreCategoria = new JLabel("Nombre de la categoría:");
        lblNombreCategoria.setBounds(10, 36, 188, 14);
        contentPane.add(lblNombreCategoria);

        textNombreCategoria = new JTextField();
        textNombreCategoria.setBounds(10, 61, 369, 20);
        contentPane.add(textNombreCategoria);
        textNombreCategoria.setColumns(10);

        btnRegistrarCategoria = new JButton("REGISTRAR");
        btnRegistrarCategoria.setBounds(208, 92, 171, 23);
        contentPane.add(btnRegistrarCategoria);

        btnVolver = new JButton("VOLVER");
        btnVolver.setBackground(new Color(255, 128, 128));
        btnVolver.setBounds(10, 92, 171, 23);
        contentPane.add(btnVolver);
    }
}
