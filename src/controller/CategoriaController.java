package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Categoria;
import model.CategoriaDAO;
import view.CrearCategoriaView;
import view.InicioTiendaView;
import view.ModificarCategoriaView;
import view.CategoriaView;

public class CategoriaController implements ActionListener {

    private CategoriaView categoriaView;
    private CrearCategoriaView crearCategoriaView;
    private ModificarCategoriaView modificarCategoriaView;
    private CategoriaDAO categoriaDAO;
    private InicioTiendaView inicio;

    // Modificación para recibir inicio como parámetro
    public CategoriaController(CategoriaView categoriaView, CategoriaDAO categoriaDAO, InicioTiendaView inicio) {
        this.categoriaView = categoriaView;
        this.categoriaDAO = categoriaDAO;
        this.inicio = inicio;  // Asignar el objeto InicioTiendaView

        // Registro de los botones
        this.categoriaView.btnMostrarCategorias.addActionListener(this);
        this.categoriaView.btnCrearCategoria.addActionListener(this);
        this.categoriaView.btnModificarCategoria.addActionListener(this);
        this.categoriaView.btnEliminarCategoria.addActionListener(this);
        this.categoriaView.btnVolverCategorias.addActionListener(this);
    }

    public void iniciar() {
        categoriaView.setTitle("Gestión de Categorías");
        categoriaView.setLocationRelativeTo(null);
        categoriaView.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == categoriaView.btnMostrarCategorias) {
            categoriaDAO.mostrarCategorias(categoriaView.model);
        } else if (e.getSource() == categoriaView.btnCrearCategoria) {
            abrirCrearCategoriaView();
        } else if (e.getSource() == categoriaView.btnModificarCategoria) {
            abrirModificarCategoriaView();
        } else if (e.getSource() == categoriaView.btnEliminarCategoria) {
            eliminarCategoria();
        } else if (e.getSource() == categoriaView.btnVolverCategorias) {
            categoriaView.setVisible(false);
            if (inicio != null) {
                inicio.setVisible(true);  // Mostrar la vista de inicio
            } else {
                System.err.println("InicioTiendaView es null. No se puede hacer visible.");
            }
        }
    }

    private void abrirCrearCategoriaView() {
        crearCategoriaView = new CrearCategoriaView();
        crearCategoriaView.btnRegistrarCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categoria categoria = new Categoria();
                categoria.setNombre(crearCategoriaView.textNombreCategoria.getText());
                categoriaDAO.crearCategoria(categoria);
                crearCategoriaView.dispose();
            }
        });
        crearCategoriaView.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearCategoriaView.dispose();
            }
        });
        crearCategoriaView.setVisible(true);
    }

    private void abrirModificarCategoriaView() {
        modificarCategoriaView = new ModificarCategoriaView();
        modificarCategoriaView.btnActualizarCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(Integer.parseInt(modificarCategoriaView.textCodigoCategoria.getText()));
                categoria.setNombre(modificarCategoriaView.textNombreCategoria.getText());
                categoriaDAO.modificarCategoria(categoria);
                modificarCategoriaView.dispose();
            }
        });
        modificarCategoriaView.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarCategoriaView.dispose();
            }
        });
        modificarCategoriaView.setVisible(true);
    }

    private void eliminarCategoria() {
        try {
            int id = Integer.parseInt(categoriaView.textCodigoEliminarCategoria.getText());
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(id);
            categoriaDAO.eliminarCategoria(categoria);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(categoriaView, "Debes ingresar un número válido para el ID de la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
