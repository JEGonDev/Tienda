package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO extends Conexion {
    private Connection conexion;

    public UsuarioDAO() {
    }

    public void mostrarUsuarios(DefaultTableModel modelo) {
        try {
            modelo.setRowCount(0);
            this.conexion = getConnection();
            String sql = "SELECT * FROM clientes";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                int idUsuario = resultado.getInt("idCliente");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");

                modelo.addRow(new Object[]{idUsuario, nombre, email, telefono});
            }

            sentencia.close();
            resultado.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al intentar mostrar los usuarios: " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }

    public void crearUsuario(Usuario usuario) {
        try {
            this.conexion = getConnection();
            String sql = "INSERT INTO clientes (nombre, email, telefono) VALUES (?, ?, ?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getEmail());
            sentencia.setString(3, usuario.getTelefono());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Usuario registrado correctamente!");

            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar registrar usuario: " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }

    public void modificarUsuario(Usuario usuario) {
        try {
            this.conexion = getConnection();
            String sql = "UPDATE clientes SET nombre=?, email=?, telefono=? WHERE idCliente=?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getEmail());
            sentencia.setString(3, usuario.getTelefono());
            sentencia.setInt(4, usuario.getIdCliente());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Usuario actualizado correctamente!");

            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡El usuario no se ha actualizado correctamente! " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }

    public void traerContenidoUsuario(Usuario usuario) {
        try {
            this.conexion = getConnection();
            String sql = "SELECT * FROM clientes WHERE idCliente=?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, usuario.getIdCliente());
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setTelefono(resultado.getString("telefono"));
            } else {
                JOptionPane.showMessageDialog(null, "¡No existe un usuario con ese ID!");
            }

            sentencia.close();
            resultado.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al intentar mostrar los usuarios: " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }

    public void eliminarUsuario(Usuario usuario) {
        try {
            this.conexion = getConnection();
            String sql = "DELETE FROM clientes WHERE idCliente=?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, usuario.getIdCliente());

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "El usuario se eliminó correctamente.");

            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al intentar eliminar el usuario: " + e.getMessage());
        } finally {
            closeConnection(conexion);
        }
    }
}
