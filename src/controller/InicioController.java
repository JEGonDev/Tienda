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
    		categoria.setVisible(true);
    		inicio.setVisible(false);
    	}
    	
    	if (e.getSource() == inicio.btnProductos) {
    		producto.setVisible(true);
    		inicio.setVisible(false);
    	}
    	
    	if (e.getSource() == inicio.btnUsuarios) {
    		usuario.setVisible(true);
    		inicio.setVisible(false);
    	}
    }
}
