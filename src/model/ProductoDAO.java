package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoDAO extends Conexion {
    private Connection conexion;

    public ProductoDAO() {
    }

    public void mostrarProductos(DefaultTableModel modelo) {
        try {
            modelo.setRowCount(0);
            this.conexion = getConnection();
            String sql = "SELECT * FROM productos";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                int idProducto = resultado.getInt("idProducto");
                String nombre = resultado.getString("nombre");
                int idCategoria = resultado.getInt("idCategoria");
                String codigoBarras = resultado.getString("codigoBarras");
                double precioVenta = resultado.getDouble("precioVenta");
                int cantidadStock = resultado.getInt("cantidadStock");

                modelo.addRow(new Object[]{idProducto, nombre, idCategoria, codigoBarras, precioVenta, cantidadStock});
            }

            sentencia.close();
            resultado.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al intentar mostrar los productos: " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }

    public void crearProducto(Producto producto) {
        try {
            this.conexion = getConnection();
            String sql = "INSERT INTO productos (nombre, idCategoria, codigoBarras, precioVenta, cantidadStock) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, producto.getNombre());
            sentencia.setInt(2, producto.getIdCategoria());
            sentencia.setString(3, producto.getCodigoBarras());
            sentencia.setDouble(4, producto.getPrecioVenta());
            sentencia.setInt(5, producto.getCantidadStock());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Producto registrado correctamente!");

            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar registrar producto: " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }

    public void modificarProducto(Producto producto) {
        try {
            this.conexion = getConnection();
            String sql = "UPDATE productos SET nombre=?, idCategoria=?, codigoBarras=?, precioVenta=?, cantidadStock=? WHERE idProducto=?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, producto.getNombre());
            sentencia.setInt(2, producto.getIdCategoria());
            sentencia.setString(3, producto.getCodigoBarras());
            sentencia.setDouble(4, producto.getPrecioVenta());
            sentencia.setInt(5, producto.getCantidadStock());
            sentencia.setInt(6, producto.getIdProducto());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Producto actualizado correctamente!");

            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡El producto no se ha actualizado correctamente! " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }

    public void traerContenidoProducto(Producto producto) {
        try {
            this.conexion = getConnection();
            String sql = "SELECT * FROM productos WHERE idProducto=?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, producto.getIdProducto());
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                producto.setNombre(resultado.getString("nombre"));
                producto.setIdCategoria(resultado.getInt("idCategoria"));
                producto.setCodigoBarras(resultado.getString("codigoBarras"));
                producto.setPrecioVenta(resultado.getDouble("precioVenta"));
                producto.setCantidadStock(resultado.getInt("cantidadStock"));
            } else {
                JOptionPane.showMessageDialog(null, "¡No existe un producto con ese ID!");
            }

            sentencia.close();
            resultado.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al intentar mostrar los productos: " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }

    public void eliminarProducto(Producto producto) {
        try {
            this.conexion = getConnection();
            String sql = "DELETE FROM productos WHERE idProducto=?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, producto.getIdProducto());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "El producto se eliminó correctamente.");

            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al intentar eliminar el producto: " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }
}
