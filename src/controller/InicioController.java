package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CategoriaView;
import view.InicioTiendaView;
import view.ProductoView;
import view.UsuarioView;

public class InicioController implements ActionListener {
    private CategoriaView categoria;
    private ProductoView producto;
    private UsuarioView usuario;
    private InicioTiendaView inicio;
    
    public InicioController(CategoriaView categoria, ProductoView producto, UsuarioView usuario, InicioTiendaView inicio) {
        this.categoria = categoria;
        this.producto = producto;
        this.usuario = usuario;
        this.inicio = inicio;
        
        // Configuración de la vista de inicio
        inicio.setLocationRelativeTo(null);
        inicio.setResizable(false);
        inicio.setVisible(true);

        // Registro de los botones en la vista de inicio
        this.inicio.btnCategorias.addActionListener(this);
        this.inicio.btnProductos.addActionListener(this);
        this.inicio.btnUsuarios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inicio.btnCategorias) {
            mostrarVista(categoria);
        } else if (e.getSource() == inicio.btnProductos) {
            mostrarVista(producto);
        } else if (e.getSource() == inicio.btnUsuarios) {
            mostrarVista(usuario);
        }
    }

    // Método auxiliar para mostrar una vista específica y ocultar la vista de inicio
    private void mostrarVista(javax.swing.JFrame vista) {
        if (vista != null) {
            vista.setVisible(true);
            inicio.setVisible(false);
        } else {
            System.err.println("La vista no está inicializada.");
        }
    }
}
