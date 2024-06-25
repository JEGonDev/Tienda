package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class InicioTiendaView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JButton btnUsuarios;
	public JButton btnCategorias;
	public JButton btnProductos;


	/**
	 * Create the frame.
	 */
	public InicioTiendaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TIENDA");
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 18));
		lblNewLabel.setBackground(new Color(128, 255, 128));
		lblNewLabel.setBounds(79, 11, 109, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ONDE JUANITO");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(45, 36, 143, 30);
		contentPane.add(lblNewLabel_1);
		
		btnProductos = new JButton("PRODUCTOS");
		btnProductos.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnProductos.setBounds(35, 87, 163, 30);
		contentPane.add(btnProductos);
		
		btnCategorias = new JButton("CATEGORIAS");
		btnCategorias.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnCategorias.setBounds(35, 151, 163, 30);
		contentPane.add(btnCategorias);
		
		btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnUsuarios.setBounds(35, 219, 163, 30);
		contentPane.add(btnUsuarios);
	}
}
