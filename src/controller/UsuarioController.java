package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import model.UsuarioDAO;
import view.CrearUsuarioView;
import view.InicioTiendaView;
import view.ModificarUsuarioView;
import view.UsuarioView;

public class UsuarioController implements ActionListener {

    private UsuarioView usuarioView;
    private CrearUsuarioView crearUsuarioView;
    private ModificarUsuarioView modificarUsuarioView;
    private UsuarioDAO usuarioDAO;
    private InicioTiendaView inicio;

    public UsuarioController(UsuarioView usuarioView, UsuarioDAO usuarioDAO, InicioTiendaView inicio) {
        this.usuarioView = usuarioView;
        this.usuarioDAO = usuarioDAO;
        this.inicio = inicio;

        this.usuarioView.btnMostrarUsuarios.addActionListener(this);
        this.usuarioView.btnCrearUsuario.addActionListener(this);
        this.usuarioView.btnModificarUsuario.addActionListener(this);
        this.usuarioView.btnEliminarUsuario.addActionListener(this);
        this.usuarioView.btnVolverUsuarios.addActionListener(this);
    }

    public void iniciar() {
        usuarioView.setTitle("Gestión de Usuarios");
        usuarioView.setLocationRelativeTo(null);
        usuarioView.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usuarioView.btnMostrarUsuarios) {
            usuarioDAO.mostrarUsuarios(usuarioView.model);
        } else if (e.getSource() == usuarioView.btnCrearUsuario) {
            abrirCrearUsuarioView();
        } else if (e.getSource() == usuarioView.btnModificarUsuario) {
            abrirModificarUsuarioView();
        } else if (e.getSource() == usuarioView.btnEliminarUsuario) {
            eliminarUsuario();
        } else if (e.getSource() == usuarioView.btnVolverUsuarios) {
            usuarioView.setVisible(false);
            inicio.setVisible(true); // Mostrar la vista de inicio
        }
    }

    private void abrirCrearUsuarioView() {
        crearUsuarioView = new CrearUsuarioView();
        crearUsuarioView.btnRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario();
                usuario.setNombre(crearUsuarioView.textNombreUsuario.getText());
                usuario.setEmail(crearUsuarioView.textEmailUsuario.getText());
                usuario.setTelefono(crearUsuarioView.textTelefonoUsuario.getText());
                usuarioDAO.crearUsuario(usuario);
                crearUsuarioView.dispose();
            }
        });
        crearUsuarioView.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearUsuarioView.dispose();
            }
        });
        crearUsuarioView.setVisible(true);
    }

    private void abrirModificarUsuarioView() {
        modificarUsuarioView = new ModificarUsuarioView();
        modificarUsuarioView.btnActualizarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario();
                usuario.setIdCliente(Integer.parseInt(modificarUsuarioView.textIdUsuario.getText()));
                usuario.setNombre(modificarUsuarioView.textNombreUsuario.getText());
                usuario.setEmail(modificarUsuarioView.textEmailUsuario.getText());
                usuario.setTelefono(modificarUsuarioView.textTelefonoUsuario.getText());
                usuarioDAO.modificarUsuario(usuario);
                modificarUsuarioView.dispose();
            }
        });
        modificarUsuarioView.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarUsuarioView.dispose();
            }
        });
        modificarUsuarioView.setVisible(true);
    }

    private void eliminarUsuario() {
        try {
            int id = Integer.parseInt(usuarioView.textCodigoEliminarUsuario.getText());
            Usuario usuario = new Usuario();
            usuario.setIdCliente(id);
            usuarioDAO.eliminarUsuario(usuario);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(usuarioView, "Debes ingresar un número válido para el ID del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
