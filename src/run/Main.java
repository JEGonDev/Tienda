package run;

import controller.CategoriaController;
import controller.InicioController;
import controller.ProductoController;
import controller.UsuarioController;
import model.CategoriaDAO;
import model.ProductoDAO;
import model.UsuarioDAO;
import view.CategoriaView;
import view.CrearCategoriaView;
import view.CrearProductoView;
import view.CrearUsuarioView;
import view.InicioTiendaView;
import view.ModificarCategoriaView;
import view.ModificarProductoView;
import view.ModificarUsuarioView;
import view.ProductoView;
import view.UsuarioView;

public class Main {
    public static void main(String[] args) {
    	
    	InicioTiendaView inicio = new InicioTiendaView();
    	
        ProductoView productoView = new ProductoView();
        ProductoDAO productoDAO = new ProductoDAO();
        CrearProductoView crearProductoView = new CrearProductoView();
        ModificarProductoView modificarProductoView = new ModificarProductoView();
        
        ProductoController productoController = new ProductoController(productoView, crearProductoView, modificarProductoView, inicio);
        //
        CategoriaView categoriaView = new CategoriaView();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        CrearCategoriaView crearCategoriaView = new CrearCategoriaView();
        ModificarCategoriaView modificarCategoriaView = new ModificarCategoriaView();
        
        CategoriaController categoriaController = new CategoriaController(categoriaView, crearCategoriaView, modificarCategoriaView, categoriaDAO, inicio);
        //
        UsuarioView usuarioView = new UsuarioView();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CrearUsuarioView crearUsuarioView = new CrearUsuarioView();
        ModificarUsuarioView modificarUsuarioView = new ModificarUsuarioView();
        
        UsuarioController usuarioController = new UsuarioController(usuarioView, usuarioDAO, crearUsuarioView, modificarUsuarioView, inicio);
        //
        InicioController inicioController = new InicioController(categoriaView, productoView, usuarioView, inicio);
        inicio.setVisible(true);
    }
}
