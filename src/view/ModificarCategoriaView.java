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

public class ModificarCategoriaView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textCodigoCategoria;
    public JTextField textNombreCategoria;
    public JButton btnActualizarCategoria;
    public JButton btnVolver;
    public JLabel lblTitulo;
    public JButton btnBuscarIDCategoria;

    public ModificarCategoriaView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 405, 221);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTitulo = new JLabel("MODIFICAR CATEGORÍA");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTitulo.setBounds(10, 11, 369, 14);
        contentPane.add(lblTitulo);

        JLabel lblCodigoCategoria = new JLabel("Código de la categoría a modificar:");
        lblCodigoCategoria.setBounds(10, 36, 252, 14);
        contentPane.add(lblCodigoCategoria);

        textCodigoCategoria = new JTextField();
        textCodigoCategoria.setBounds(10, 61, 198, 20);
        contentPane.add(textCodigoCategoria);
        textCodigoCategoria.setColumns(10);

        JLabel lblNombreCategoria = new JLabel("Nuevo nombre de la categoría:");
        lblNombreCategoria.setBounds(10, 92, 188, 14);
        contentPane.add(lblNombreCategoria);

        textNombreCategoria = new JTextField();
        textNombreCategoria.setColumns(10);
        textNombreCategoria.setBounds(10, 117, 369, 20);
        contentPane.add(textNombreCategoria);

        btnActualizarCategoria = new JButton("ACTUALIZAR");
        btnActualizarCategoria.setBounds(208, 148, 171, 23);
        contentPane.add(btnActualizarCategoria);

        btnVolver = new JButton("VOLVER");
        btnVolver.setBackground(new Color(255, 128, 128));
        btnVolver.setBounds(10, 148, 171, 23);
        contentPane.add(btnVolver);
        
        btnBuscarIDCategoria = new JButton("BUSCAR");
        btnBuscarIDCategoria.setBounds(252, 60, 103, 23);
        contentPane.add(btnBuscarIDCategoria);
    }
}
