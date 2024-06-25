package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import model.UsuarioDAO;
import view.CrearUsuarioView;
import view.InicioTiendaView;
import view.ModificarUsuarioView;
import view.UsuarioView;

public class UsuarioController implements ActionListener {

    private UsuarioView vista;
    private CrearUsuarioView crear;
    private ModificarUsuarioView modificar;
    private UsuarioDAO modelo;
    private Usuario usuario = new Usuario();
    private InicioTiendaView inicio = new InicioTiendaView();

    public UsuarioController(UsuarioView vista, CrearUsuarioView crear, ModificarUsuarioView modificar,UsuarioDAO modelo, InicioTiendaView inicio) {
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
		
		this.vista.btnCrearUsuario.addActionListener(this);
		this.vista.btnEliminarUsuario.addActionListener(this);
		this.vista.btnModificarUsuario.addActionListener(this);
		this.vista.btnMostrarUsuarios.addActionListener(this);
		this.vista.btnVolverUsuarios.addActionListener(this);
		
		this.crear.btnRegistrarUsuario.addActionListener(this);
		this.crear.btnVolver.addActionListener(this);
		
		this.modificar.btnActualizarUsuario.addActionListener(this);
		this.modificar.btnBuscarUsuarioID.addActionListener(this);
		this.modificar.btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica de manejo de eventos
    	
    	//boton volver ventana principal
    	if (e.getSource() == vista.btnVolverUsuarios) {
    		inicio.setVisible(true);
    		vista.setVisible(false);
    	}
    	
    	//Esto lo que hace es mostrar la tabla en el formulario
    	if (e.getSource() == vista.btnMostrarUsuarios) {
    	    modelo.mostrarUsuarios(vista.model); // Lee y actualiza la tabla    
    	}

    	//toma id del campo de texto y elimina segun ese id
    	if (e.getSource() == vista.btnEliminarUsuario) {
    	    int idUsuario = Integer.parseInt(vista.textCodigoEliminarUsuario.getText());
    	    usuario.setIdCliente(idUsuario);
    	    modelo.eliminarUsuario(usuario);
    	    vista.textCodigoEliminarUsuario.setText(""); 	        
    	    } 
    	
        //Esto lo que hace es que al oprimir el boton crear libro se muestre el formulario en cuestion
        if (e.getSource() == vista.btnCrearUsuario) {
            crear.setVisible(true);
            vista.dispose();
        }
        
        if (e.getSource() == crear.btnVolver) {
        	vista.setVisible(true);
        	crear.setVisible(false);
        }

        //Esto permite que al oprimir el boton se guarden los datos suministrados
        if (e.getSource() == crear.btnRegistrarUsuario) {
            // Obtener valores de la ventana de creación
            String nombre = crear.textNombreUsuario.getText();
            String email = crear.textEmailUsuario.getText();
            String telefono = crear.textTelefonoUsuario.getText();           
            // Asignar valores al objeto libro
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setTelefono(telefono);
            // Crear el libro en el modelo
            modelo.crearUsuario(usuario);

            crear.textEmailUsuario.setText("");
            crear.textNombreUsuario.setText("");
            crear.textTelefonoUsuario.setText("");
        }

        //Esto permite que al oprimir el boton se abra el formulario en cuestion
        if (e.getSource() == vista.btnModificarUsuario) {
        	modificar.setVisible(true);
        	vista.dispose();
        }
        
        if (e.getSource() == modificar.btnVolver) {
        	vista.setVisible(true);
        	modificar.setVisible(false);
        }
        
        	//Esto trae el contenido del libro que el usuario propocione en los campos de texto
            if (e.getSource() == modificar.btnBuscarUsuarioID) {
                int id = Integer.parseInt(modificar.textIdUsuario.getText());
                usuario.setIdCliente(id);
                modelo.traerContenidoUsuario(usuario);

                // Asignar valores obtenidos al formulario de modificación
                modificar.textIdUsuario.setText(String.valueOf(usuario.getIdCliente()));
                modificar.textNombreUsuario.setText(usuario.getNombre());
                modificar.textEmailUsuario.setText(usuario.getEmail());
                modificar.textTelefonoUsuario.setText(usuario.getTelefono());
      
            }

            //Esto guarda las modificaciones del usuario
            if (e.getSource() == modificar.btnActualizarUsuario) {
                // Obtener valores modificados del formulario
                String nombre = modificar.textNombreUsuario.getText();
                String email = modificar.textEmailUsuario.getText();
                String telefono = modificar.textTelefonoUsuario.getText();
                // Actualizar la base de datos en el campo id
                usuario.setNombre(nombre);
                usuario.setEmail(email);
                usuario.setTelefono(telefono);
               
                // Guardar cambios en el modelo
                modelo.modificarUsuario(usuario);

                modificar.textIdUsuario.setText("");
                modificar.textNombreUsuario.setText("");
                modificar.textTelefonoUsuario.setText("");
                modificar.textEmailUsuario.setText("");
            }
        }
}
