package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Categoria;
import model.CategoriaDAO;
import view.CrearCategoriaView;
import view.InicioTiendaView;
import view.ModificarCategoriaView;
import view.CategoriaView;

public class CategoriaController implements ActionListener {

    private CategoriaView vista;
    private CrearCategoriaView crear;
    private ModificarCategoriaView modificar;
    private CategoriaDAO modelo;
    private Categoria categoria = new Categoria();
    private InicioTiendaView inicio = new InicioTiendaView();

    // Modificación para recibir inicio como parámetro
    public CategoriaController(CategoriaView vista, CrearCategoriaView crear, ModificarCategoriaView modificar, CategoriaDAO modelo, InicioTiendaView inicio) {
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
        this.vista.btnModificarCategoria.addActionListener(this);
        this.vista.btnCrearCategoria.addActionListener(this);
        this.vista.btnEliminarCategoria.addActionListener(this);
        this.vista.btnMostrarCategorias.addActionListener(this);
        this.vista.btnVolverCategorias.addActionListener(this);
        
        // Asignar listeners a los botones de la vista de creación
        this.crear.btnRegistrarCategoria.addActionListener(this);
        this.crear.btnVolver.addActionListener(this);
        
        // Asignar listeners a los botones de la vista modificar
        this.modificar.btnActualizarCategoria.addActionListener(this);
        this.modificar.btnVolver.addActionListener(this);
        this.modificar.btnBuscarIDCategoria.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica de manejo de eventos
    	
    	//boton volver ventana principal
    	if (e.getSource() == vista.btnVolverCategorias) {
    		inicio.setVisible(true);
    		vista.setVisible(false);
    	}
    	
    	//Esto lo que hace es mostrar la tabla en el formulario
    	if (e.getSource() == vista.btnMostrarCategorias) {
    	    modelo.mostrarCategorias(vista.model); // Lee y actualiza la tabla    
    	}

    	//toma id del campo de texto y elimina segun ese id
    	if (e.getSource() == vista.btnEliminarCategoria) {
    	    int idCategoria = Integer.parseInt(vista.textCodigoEliminarCategoria.getText());
    	    categoria.setIdCategoria(idCategoria);
    	    modelo.eliminarCategoria(categoria);
    	    vista.textCodigoEliminarCategoria.setText(""); 	        
    	    } 
    	
        //Esto lo que hace es que al oprimir el boton crear libro se muestre el formulario en cuestion
        if (e.getSource() == vista.btnCrearCategoria) {
            crear.setVisible(true);
            vista.dispose();
        }
        
        if (e.getSource() == crear.btnVolver) {
        	vista.setVisible(true);
        	crear.setVisible(false);
        }

        //Esto permite que al oprimir el boton se guarden los datos suministrados
        if (e.getSource() == crear.btnRegistrarCategoria) {
            // Obtener valores de la ventana de creación
            String nombre = crear.textNombreCategoria.getText();
           
            // Asignar valores al objeto libro
            categoria.setNombre(nombre);
            // Crear el libro en el modelo
            modelo.crearCategoria(categoria);

            crear.textNombreCategoria.setText("");
        }

        //Esto permite que al oprimir el boton se abra el formulario en cuestion
        if (e.getSource() == vista.btnModificarCategoria) {
        	modificar.setVisible(true);
        	vista.dispose();
        }
        
        if (e.getSource() == modificar.btnVolver) {
        	vista.setVisible(true);
        	modificar.setVisible(false);
        }
        
        	//Esto trae el contenido del libro que el usuario propocione en los campos de texto
            if (e.getSource() == modificar.btnBuscarIDCategoria) {
               int id = Integer.parseInt(modificar.textCodigoCategoria.getText());
                categoria.setIdCategoria(id);
                modelo.traerContenidoCategoria(categoria);

                // Asignar valores obtenidos al formulario de modificación
                modificar.textCodigoCategoria.setText(String.valueOf(categoria.getIdCategoria()));
                modificar.textNombreCategoria.setText(categoria.getNombre());
      
            }

            //Esto guarda las modificaciones del usuario
            if (e.getSource() == modificar.btnActualizarCategoria) {
                // Obtener valores modificados del formulario
                String nombre = modificar.textNombreCategoria.getText();
                    // Actualizar la base de datos en el campo id
                categoria.setNombre(nombre);
               
                // Guardar cambios en el modelo
                modelo.modificarCategoria(categoria);

                modificar.textNombreCategoria.setText("");
                modificar.textCodigoCategoria.setText("");
            }
        }
    }
