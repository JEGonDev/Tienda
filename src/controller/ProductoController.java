package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Producto;
import model.ProductoDAO;
import view.CrearProductoView;
import view.InicioTiendaView;
import view.ModificarProductoView;
import view.ProductoView;

public class ProductoController implements ActionListener {

    private ProductoView productoView;
    private CrearProductoView crearProductoView;
    private ModificarProductoView modificarProductoView;
    private ProductoDAO productoDAO;

    // Constructor
    public ProductoController(ProductoView productoView, ProductoDAO productoDAO, InicioTiendaView inicio) {
        this.productoView = productoView;
        this.productoDAO = productoDAO;

        // Registrar ActionListener para los botones en ProductoView
        this.productoView.btnMostrarProductos.addActionListener(this);
        this.productoView.btnCrearProducto.addActionListener(this);
        this.productoView.btnModificarProducto.addActionListener(this);
        this.productoView.btnEliminarProducto.addActionListener(this);
        this.productoView.btnVolverProductos.addActionListener(this);

        // Inicializar y ocultar las vistas de creación y modificación de productos
        this.crearProductoView = new CrearProductoView();
        this.modificarProductoView = new ModificarProductoView();

        // Registrar ActionListener para los botones en CrearProductoView
        this.crearProductoView.btnRegistrarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarProducto();
            }
        });
        this.crearProductoView.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearProductoView.setVisible(false);
            }
        });

        // Registrar ActionListener para los botones en ModificarProductoView
        this.modificarProductoView.btnActualizarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });
        this.modificarProductoView.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarProductoView.setVisible(false);
            }
        });
    }

    // Iniciar la vista de productos
    public void iniciar() {
        productoView.setTitle("Gestión de Productos");
        productoView.setLocationRelativeTo(null);
        productoView.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == productoView.btnMostrarProductos) {
            productoDAO.mostrarProductos(productoView.model);
        } else if (e.getSource() == productoView.btnCrearProducto) {
            abrirCrearProductoView();
        } else if (e.getSource() == productoView.btnModificarProducto) {
            abrirModificarProductoView();
        } else if (e.getSource() == productoView.btnEliminarProducto) {
            eliminarProducto();
        } else if (e.getSource() == productoView.btnVolverProductos) {
            productoView.setVisible(false);
            // Aquí puedes manejar la acción de volver a otra vista o cerrar la aplicación.
        }
    }

    private void abrirCrearProductoView() {
        crearProductoView.setLocationRelativeTo(productoView);
        crearProductoView.setVisible(true);
    }

    private void abrirModificarProductoView() {
        modificarProductoView.setLocationRelativeTo(productoView);
        modificarProductoView.setVisible(true);
    }

    private void registrarProducto() {
        try {
            Producto producto = new Producto();
            producto.setNombre(crearProductoView.textNombreProducto.getText());
            producto.setIdCategoria(Integer.parseInt(crearProductoView.textIdCategoria.getText()));
            producto.setCodigoBarras(crearProductoView.textCodigoBarras.getText());
            producto.setPrecioVenta(Double.parseDouble(crearProductoView.textPrecioProducto.getText()));
            producto.setCantidadStock(Integer.parseInt(crearProductoView.textCantidadProducto.getText()));

            productoDAO.crearProducto(producto);
            JOptionPane.showMessageDialog(crearProductoView, "Producto creado exitosamente.");
            crearProductoView.setVisible(false);
            productoDAO.mostrarProductos(productoView.model); // Actualizar la vista principal

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(crearProductoView, "Por favor ingresa valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(crearProductoView, "Error al crear el producto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarProducto() {
        try {
            Producto producto = new Producto();
            producto.setIdProducto(Integer.parseInt(modificarProductoView.textCodigoProducto.getText()));
            producto.setNombre(modificarProductoView.textNombreProducto.getText());
            producto.setIdCategoria(Integer.parseInt(modificarProductoView.textIdCategoria.getText()));
            producto.setCodigoBarras(modificarProductoView.textCodigoBarras.getText());
            producto.setPrecioVenta(Double.parseDouble(modificarProductoView.textPrecioProducto.getText()));
            producto.setCantidadStock(Integer.parseInt(modificarProductoView.textCantidadProducto.getText()));

            productoDAO.modificarProducto(producto);
            JOptionPane.showMessageDialog(modificarProductoView, "Producto modificado exitosamente.");
            modificarProductoView.setVisible(false);
            productoDAO.mostrarProductos(productoView.model); // Actualizar la vista principal

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(modificarProductoView, "Por favor ingresa valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(modificarProductoView, "Error al modificar el producto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarProducto() {
        try {
            int id = Integer.parseInt(productoView.textCodigoEliminarProducto.getText());
            Producto producto = new Producto();
            producto.setIdProducto(id);
            productoDAO.eliminarProducto(producto);
            JOptionPane.showMessageDialog(productoView, "Producto eliminado exitosamente.");
            productoDAO.mostrarProductos(productoView.model); // Actualizar la vista principal

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(productoView, "Debes ingresar un número válido para el ID del producto.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(productoView, "Error al eliminar el producto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
