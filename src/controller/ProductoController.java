package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Producto;
import model.ProductoDAO;
import view.CrearProductoView;
import view.InicioTiendaView;
import view.ModificarProductoView;
import view.ProductoView;


public class ProductoController implements ActionListener {

    private ProductoView vista;
    private CrearProductoView crear;
    private ModificarProductoView modificar;
    private ProductoDAO modelo;
    private Producto producto = new Producto();
    private InicioTiendaView inicio = new InicioTiendaView();

    // Constructor
    public ProductoController(ProductoView vista, CrearProductoView crear, ModificarProductoView modificar,ProductoDAO modelo, InicioTiendaView inicio) {
        this.vista = vista;
        this.crear = crear;
        this.modificar = modificar;
        this.modelo = modelo;
        this.inicio = inicio;
        
        vista.setLocationRelativeTo(null);
		vista.setResizable(false);
		crear.setLocationRelativeTo(null);
		crear.setResizable(false);
		modificar.setLocationRelativeTo(null);
		modificar.setResizable(false);

        // Asignar listeners a los botones de la vista principal
        this.vista.btnCrearProducto.addActionListener(this);
        this.vista.btnEliminarProducto.addActionListener(this);
        this.vista.btnModificarProducto.addActionListener(this);
        this.vista.btnMostrarProductos.addActionListener(this);
        this.vista.btnVolverProductos.addActionListener(this);
        
        // Asignar listeners a los botones de la vista de creación
        this.crear.btnRegistrarProducto.addActionListener(this);
        this.crear.btnVolver.addActionListener(this);
        
        // Asignar listeners a los botones de la vista modificar
        this.modificar.btnActualizarProducto.addActionListener(this);
        this.modificar.btnVolver.addActionListener(this);
        this.modificar.btnBuscarProductoID.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica de manejo de eventos
    	
    	//boton volver ventana principal
    	if (e.getSource() == vista.btnVolverProductos) {
    		inicio.setVisible(true);
    		vista.setVisible(false);
    	}
    	
    	//Esto lo que hace es mostrar la tabla en el formulario
    	if (e.getSource() == vista.btnMostrarProductos) {
    	    modelo.mostrarProductos(vista.model); // Lee y actualiza la tabla    
    	}

    	//toma id del campo de texto y elimina segun ese id
    	if (e.getSource() == vista.btnEliminarProducto) {
    	    int idProducto = Integer.parseInt(vista.textCodigoEliminarProducto.getText());
    	    producto.setIdProducto(idProducto);
    	    modelo.eliminarProducto(producto);
    	    vista.textCodigoEliminarProducto.setText(""); 	        
    	    } 
    	
        //Esto lo que hace es que al oprimir el boton crear libro se muestre el formulario en cuestion
        if (e.getSource() == vista.btnCrearProducto) {
            crear.setVisible(true);
            vista.dispose();
        }
        
        if (e.getSource() == crear.btnVolver) {
        	vista.setVisible(true);
        	crear.setVisible(false);
        }

        //Esto permite que al oprimir el boton se guarden los datos suministrados
        if (e.getSource() == crear.btnRegistrarProducto) {
            // Obtener valores de la ventana de creación
            String nombre = crear.textNombreProducto.getText();
            int idCategoria = Integer.parseInt(crear.textIdCategoria.getText());
            String codigoBarras = crear.textCodigoBarras.getText();
            double precioVenta = Double.parseDouble(crear.textPrecioProducto.getText());
            int cantidadStock = Integer.parseInt(crear.textCantidadProducto.getText());
           
            // Asignar valores al objeto libro
            producto.setNombre(nombre);
            producto.setIdCategoria(idCategoria);
            producto.setCodigoBarras(codigoBarras);
            producto.setPrecioVenta(precioVenta);
            producto.setCantidadStock(cantidadStock);
            // Crear el libro en el modelo
            modelo.crearProducto(producto);

            crear.textCantidadProducto.setText("");
            crear.textCodigoBarras.setText("");
            crear.textIdCategoria.setText("");
            crear.textNombreProducto.setText("");
            crear.textPrecioProducto.setText("");
        }

        //Esto permite que al oprimir el boton se abra el formulario en cuestion
        if (e.getSource() == vista.btnModificarProducto) {
        	modificar.setVisible(true);
        	vista.dispose();
        }
        
        if (e.getSource() == modificar.btnVolver) {
        	vista.setVisible(true);
        	modificar.setVisible(false);
        }
        
        	//Esto trae el contenido del libro que el usuario propocione en los campos de texto
            if (e.getSource() == modificar.btnBuscarProductoID) {
            	int idProducto = Integer.parseInt(modificar.textCodigoProducto.getText());
                producto.setIdProducto(idProducto);
                modelo.traerContenidoProducto(producto);

                // Asignar valores obtenidos al formulario de modificación
                modificar.textCodigoProducto.setText(String.valueOf(producto.getIdProducto()));
                modificar.textNombreProducto.setText(producto.getNombre());
                modificar.textIdCategoria.setText(String.valueOf(producto.getIdCategoria()));
                modificar.textCodigoBarras.setText(producto.getCodigoBarras());
                modificar.textPrecioProducto.setText(String.valueOf(producto.getPrecioVenta()));
                modificar.textCantidadProducto.setText(String.valueOf(producto.getCantidadStock()));
            }

            //Esto guarda las modificaciones del usuario
            if (e.getSource() == modificar.btnActualizarProducto) {
            	// Obtener valores modificados del formulario
                String nombre = modificar.textNombreProducto.getText();
                int idCategoria = Integer.parseInt(modificar.textIdCategoria.getText().trim());
                String codigoBarras = modificar.textCodigoBarras.getText();
                double precioVenta = Double.parseDouble(modificar.textPrecioProducto.getText().trim());
                int cantidadStock = Integer.parseInt(modificar.textCantidadProducto.getText().trim());

                // Actualizar la base de datos en el campo id
                producto.setNombre(nombre);
                producto.setIdCategoria(idCategoria);
                producto.setCodigoBarras(codigoBarras);
                producto.setPrecioVenta(precioVenta);
                producto.setCantidadStock(cantidadStock);

                // Guardar cambios en el modelo
                modelo.modificarProducto(producto);

                // Limpiar campos después de actualizar
                modificar.textCodigoProducto.setText("");
                modificar.textNombreProducto.setText("");
                modificar.textIdCategoria.setText("");
                modificar.textCodigoBarras.setText("");
                modificar.textPrecioProducto.setText("");
                modificar.textCantidadProducto.setText("");
            }
        }
}
