/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.controllers;

import ec.edu.ups.biblioteca.dao.AutorDAO;
import ec.edu.ups.biblioteca.models.Autor;
import ec.edu.ups.biblioteca.views.ActualizarAutorView;
import ec.edu.ups.biblioteca.views.BuscarAutorView;
import ec.edu.ups.biblioteca.views.EliminarAutorView;
import ec.edu.ups.biblioteca.views.ListarAutorView;
import ec.edu.ups.biblioteca.views.RegistrarAutorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Maza
 */
public class AutorController {
    private AutorDAO autorDAO;
    private RegistrarAutorView registrarAutorView;
    private BuscarAutorView buscarAutorView;
    private EliminarAutorView eliminarAutorView;
    private ActualizarAutorView actualizarAutorView;
    private ListarAutorView listarAutorView;

    public AutorController(AutorDAO autorDAO, RegistrarAutorView registrarAutorView,BuscarAutorView buscarAutorView,EliminarAutorView eliminarAutorView,ActualizarAutorView actualizarAutorView,ListarAutorView listarAutorView) {
        this.autorDAO = autorDAO;
        this.registrarAutorView = registrarAutorView;
        this.buscarAutorView = buscarAutorView;
        this.eliminarAutorView = eliminarAutorView;
        this.actualizarAutorView = actualizarAutorView;
        this.listarAutorView = listarAutorView;
        configurarEventosRegistrarLibro();
        configurarEventosBuscarAutor();
        configurarEventosEliminarAutor();
        configurarEventosEliminarAutorBuscar();
        configurarEventosActualizarAutor();
        configurarEventosListarLibro();
        
    }
    
    public void registrarAutor(){
        String cedula = registrarAutorView.getTxtCedulaA().getText();
        String nombre = registrarAutorView.getTxtNombreA().getText();
        String nacionalidad=  registrarAutorView.getTxtNacionalidadA().getText();
        String apellido = registrarAutorView.getTxtApellidoA().getText();
        
        Autor autor = new Autor(cedula,nombre,apellido,nacionalidad);
        autorDAO.crear(autor);
        
    }
    
    
    public void configurarEventosRegistrarLibro(){
            registrarAutorView.getBtnRegistrarA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                registrarAutor();
            }
        });
        }
    
    public void buscarAutor(){
        String cedula = buscarAutorView.getTxtCedulaBA().getText();
        
        Autor l = autorDAO.buscar(cedula);
         if ( l != null){
            buscarAutorView.mostrarAutor(l);
        }else{
            JOptionPane.showMessageDialog(null, "Autor no encontrado");
        }
    }
    public void configurarEventosBuscarAutor(){
            buscarAutorView.getBtnBuscarA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                buscarAutor();
            }
        });
        }
    public void eliminarAutor(){
         String cedula = eliminarAutorView.getTxtCodigoEliminarA().getText();
        // Libro p = libroDAO.buscar(codigo);
        
        //if (p != null){
            
           // eliminarLibroView.mostrarLibro(p);
            
            int respuesta = JOptionPane.showConfirmDialog( null,"¿Deseas eliminar?\n" ,"Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            
            if (respuesta == JOptionPane.YES_OPTION){
                 autorDAO.Eliminar(cedula);
                 JOptionPane.showMessageDialog(null, "Autor eliminado");
                 
            }
        else{
                JOptionPane.showMessageDialog(null, "Autor no encontrado");
            }
        }
    public void configurarEventosEliminarAutor(){
            eliminarAutorView.getBtnEliminarA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                eliminarAutor();
            }
        });
        }
     public void buscarAutorEliminar (){
         String cedula = eliminarAutorView.getTxtCodigoEliminarA().getText();
         Autor l = autorDAO.buscar(cedula);
         if ( l != null){
            eliminarAutorView.mostrarAutor(l);
        }else{
            JOptionPane.showMessageDialog(null, "Autor no encontrado");
        }
     }
       public void configurarEventosEliminarAutorBuscar(){
            eliminarAutorView.getBtnBuscarA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                buscarAutorEliminar();
            }
        });
        }
       
    public void actualizarAutor (){
        String cedula = actualizarAutorView.getTxtCedulaActA().getText();
         Autor l = autorDAO.buscar(cedula);
         if ( l != null){
        
        String nombre = actualizarAutorView.getTxtNombreAct().getText();
        String nacionalidad=  actualizarAutorView.getTxtNacionalidadAct().getText();
        String apellido = actualizarAutorView.getTxtApellidoAc().getText();
        
        Autor autor = new Autor(cedula,nombre,apellido,nacionalidad);
        autorDAO.actualizar(autor);
        JOptionPane.showMessageDialog(null, "Autor actualizado correctamente ");
         }else{
            JOptionPane.showMessageDialog(null, "Autor no encontrado");
         }
    }
    public void configurarEventosActualizarAutor(){
            actualizarAutorView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                actualizarAutor();
            }
        });
        }
    public void listarLibro(){
        
        List<Autor> listaActualizada = autorDAO.listar();
        listarAutorView.cargarDatos(listaActualizada);
        
    }
        
        public void configurarEventosListarLibro(){
         listarAutorView.getBtnListarAu().addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                listarLibro();
             }
             
         });
         
     } 
    
        
}

