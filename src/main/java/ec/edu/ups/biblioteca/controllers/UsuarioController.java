/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.controllers;

import ec.edu.ups.biblioteca.dao.UsuarioDAO;
import ec.edu.ups.biblioteca.models.Direccion;
import ec.edu.ups.biblioteca.models.Usuario;
import ec.edu.ups.biblioteca.views.ActualizarUsuarioView;
import ec.edu.ups.biblioteca.views.BuscarUsuarioView;
import ec.edu.ups.biblioteca.views.EliminarUsuarioView;
import ec.edu.ups.biblioteca.views.ListarUsuarioView;
import ec.edu.ups.biblioteca.views.RegistrarUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Maza
 */
public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    private RegistrarUsuarioView registrarUsuarioView;
    private BuscarUsuarioView buscarUsuarioView;
    private EliminarUsuarioView eliminarUsuarioView;
    private ActualizarUsuarioView actualizarUsuarioView;
    private ListarUsuarioView listarUsuarioView;

    public UsuarioController(UsuarioDAO usuarioDAO, RegistrarUsuarioView registrarUsuarioView,BuscarUsuarioView buscarUsuarioView,EliminarUsuarioView eliminarUsuarioView,ActualizarUsuarioView actualizarUsuarioView,ListarUsuarioView listarUsuarioView) {
        this.usuarioDAO = usuarioDAO;
        this.registrarUsuarioView = registrarUsuarioView;
        this.buscarUsuarioView = buscarUsuarioView;
        this.eliminarUsuarioView = eliminarUsuarioView;
        this.actualizarUsuarioView =actualizarUsuarioView;
        this.listarUsuarioView = listarUsuarioView;
        configurarEventosRegistrarUsuario();
        configurarEventosBuscarUsuario();
        configurarEventosEliminarUsuario();
        configurarEventosEliminarUsuarioBuscar();
        configurarEventosActualizarUsuario();
        configurarEventosListarUsuario();
    }
    
    public void registrarUsuario(){
        
        String cedula = registrarUsuarioView.getTxtCedulaU().getText();
        String nombre = registrarUsuarioView.getTxtNombreU().getText();
        String apellido =  registrarUsuarioView.getTxtApellidoU().getText();
        String correo =  registrarUsuarioView.getTxtCorreoElU().getText();
        String ciudad = registrarUsuarioView.getTxtCiudadU().getText();
        String parroquia = registrarUsuarioView.getTxtParroquiaU().getText();
        int codigoP = Integer.parseInt(registrarUsuarioView.getTxtCodigoPostalU().getText());
        
        Direccion direccion = new Direccion(ciudad,parroquia,codigoP);
        Usuario usuario = new Usuario(cedula,nombre,apellido,correo,direccion);
        usuarioDAO.crear(usuario);
        
        JOptionPane.showMessageDialog(null, "Usuario correctamente registrado");
        
        
    }
    public void configurarEventosRegistrarUsuario(){
            registrarUsuarioView.getBtnRegistarU().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola");
                registrarUsuario();
            }
        });
        }
    
    public void buscarUsuario(){
         String cedula = buscarUsuarioView.getTxtCedulaB().getText();
        
        Usuario l = usuarioDAO.buscar(cedula);
         if ( l != null){
            buscarUsuarioView.mostrarUsuario(l);
        }else{
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }
    }
     public void configurarEventosBuscarUsuario(){
            buscarUsuarioView.getBtnBuscarU().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola");
                buscarUsuario();
            }
        });
        }   
    
     public void eliminarUsuario(){
         String cedula = eliminarUsuarioView.getTxtCedulaBE().getText();
        // Libro p = libroDAO.buscar(codigo);
        
        //if (p != null){
            
           // eliminarLibroView.mostrarLibro(p);
            
            int respuesta = JOptionPane.showConfirmDialog( null,"¿Deseas eliminar?\n" ,"Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            
            if (respuesta == JOptionPane.YES_OPTION){
                 usuarioDAO.Eliminar(cedula);
                 JOptionPane.showMessageDialog(null, "Usuario eliminado");
                 
            }
        else{
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
        }
     public void configurarEventosEliminarUsuario(){
            eliminarUsuarioView.getBtnEliminarU().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola");
                eliminarUsuario();
            }
        });
        }
     public void buscarUsuarioEliminar (){
         String cedula = eliminarUsuarioView.getTxtCedulaBE().getText();
         Usuario l = usuarioDAO.buscar(cedula);
         if ( l != null){
            eliminarUsuarioView.mostrarUsuario(l);
        }else{
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }
     }
    public void configurarEventosEliminarUsuarioBuscar(){
            eliminarUsuarioView.getBtnBuscarUE().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola");
                buscarUsuarioEliminar();
            }
        });
        }
    
    public void actualizarUsuario (){
        String cedula = actualizarUsuarioView.getTxtCedulaA().getText();
        String nombre = actualizarUsuarioView.getTxtNombreA().getText();
        String apellido =  actualizarUsuarioView.getTxtApellidoA().getText();
        String correo =  actualizarUsuarioView.getTxtCorreoA().getText();
        String ciudad = actualizarUsuarioView.getTxtCiudadA().getText();
        String parroquia = actualizarUsuarioView.getTxtParroquiaA().getText();
        int codigoP = Integer.parseInt(actualizarUsuarioView.getTxtCodigoA().getText());
        
        Direccion direccion = new Direccion(ciudad,parroquia,codigoP);
        Usuario usuario = new Usuario(cedula,nombre,apellido,correo,direccion);
        usuarioDAO.actualizar(usuario);
        
        JOptionPane.showMessageDialog(null, "Usuario correctamente actualizadp");
    }
    public void configurarEventosActualizarUsuario(){
            actualizarUsuarioView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola");
                actualizarUsuario();
            }
        });
        }
    
    public void listarUsuario(){
        
        List<Usuario> listaActualizada = usuarioDAO.listar();
        listarUsuarioView.cargarDatos(listaActualizada);
        
    }
        
        public void configurarEventosListarUsuario(){
         listarUsuarioView.getBtnListar().addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                listarUsuario();
             }
             
         });
         
     }
}
