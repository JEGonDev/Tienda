package run;

import controller.CategoriaController;
import controller.InicioController;
import controller.ProductoController;
import controller.UsuarioController;
import model.CategoriaDAO;
import model.ProductoDAO;
import model.UsuarioDAO;
import view.CategoriaView;
import view.InicioTiendaView;
import view.ProductoView;
import view.UsuarioView;

public class Main {
    public static void main(String[] args) {
    	
    	InicioTiendaView inicio = new InicioTiendaView();
    	
        ProductoView productoView = new ProductoView();
        ProductoDAO productoDAO = new ProductoDAO();
        ProductoController productoController = new ProductoController(productoView, productoDAO, inicio);
        
        CategoriaView categoriaView = new CategoriaView();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        CategoriaController categoriaController = new CategoriaController(categoriaView, categoriaDAO, inicio);
        
        UsuarioView usuarioView = new UsuarioView();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioController usuarioController = new UsuarioController(usuarioView, usuarioDAO, inicio);
        
        InicioController inicioController = new InicioController(categoriaView, productoView, usuarioView, inicio);
        inicio.setVisible(true);
    }
}
