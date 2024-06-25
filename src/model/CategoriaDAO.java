package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CategoriaDAO extends Conexion {

    private Connection conexion;

    public void mostrarCategorias(DefaultTableModel modelo) {
        try {
            modelo.setRowCount(0);
            this.conexion = getConnection();
            String sql = "SELECT * FROM categorias";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("idCategoria");
                String nombre = resultado.getString("nombre");

                modelo.addRow(new Object[]{id, nombre});
            }

            sentencia.close();
            resultado.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al intentar mostrar las categorías: " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }

    public void crearCategoria(Categoria categoria) {
        try {
            this.conexion = getConnection();
            String sql = "INSERT INTO categorias (nombre) VALUES (?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, categoria.getNombre());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Categoría registrada correctamente!");

            sentencia.close();
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            closeConnection(conexion);
        }
    }

    public void modificarCategoria(Categoria categoria) {
        try {
            this.conexion = getConnection();
            String sql = "UPDATE categorias SET nombre=? WHERE idCategoria=?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, categoria.getNombre());
            sentencia.setInt(2, categoria.getIdCategoria());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Categoría actualizada correctamente!");

            sentencia.close();
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            closeConnection(conexion);
        }
    }

    public void eliminarCategoria(Categoria categoria) {
        try {
            this.conexion = getConnection();
            String sql = "DELETE FROM categorias WHERE idCategoria=?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, categoria.getIdCategoria());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "La categoría se eliminó correctamente.");

            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al intentar eliminar la categoría: " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }
}
