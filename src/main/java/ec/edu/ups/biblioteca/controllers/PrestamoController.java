/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.controllers;

import ec.edu.ups.biblioteca.dao.LibroDAO;
import ec.edu.ups.biblioteca.dao.PrestamoDAO;
import ec.edu.ups.biblioteca.dao.UsuarioDAO;
import ec.edu.ups.biblioteca.models.Libro;
import ec.edu.ups.biblioteca.models.Prestamo;
import ec.edu.ups.biblioteca.models.Usuario;
import ec.edu.ups.biblioteca.views.BuscarPrestamoView;
import ec.edu.ups.biblioteca.views.CrearDevolucionView;
import ec.edu.ups.biblioteca.views.CrearPrestamoView;
import ec.edu.ups.biblioteca.views.ListarPrestamoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Maza
 */
public class PrestamoController {
    private PrestamoDAO prestamoDAO;
    private UsuarioDAO usuarioDAO;
    private LibroDAO libroDAO;
    private CrearPrestamoView crearPrestamoView;
    private BuscarPrestamoView buscarPrestamoView;
    private ListarPrestamoView listarPrestamoView;
    private CrearDevolucionView crearDevolucionView;

    public PrestamoController(PrestamoDAO prestamoDAO, UsuarioDAO usuarioDAO, LibroDAO libroDAO, CrearPrestamoView crearPrestamoView,BuscarPrestamoView buscarPrestamoView,ListarPrestamoView listarPrestamoView,CrearDevolucionView crearDevolucionView) {
        this.prestamoDAO = prestamoDAO;
        this.usuarioDAO = usuarioDAO;
        this.libroDAO = libroDAO;
        this.crearPrestamoView = crearPrestamoView;
        this.buscarPrestamoView = buscarPrestamoView;
        this.listarPrestamoView = listarPrestamoView;
        this.crearDevolucionView = crearDevolucionView;
        configurarEventosCrearPrestamo();
        configurarEventosBuscarPrestamo();
        configurarEventosListarLibro();
        configurarEventosEliminarLibro();
        configurarEventosEliminarPrestamoBuscar();
    }
    
    public void crearPrestamo(){
        int codigo = Integer.parseInt(crearPrestamoView.getTxtCodigoP().getText());
        Usuario usuario = (Usuario)crearPrestamoView.getCbUsuarioP().getSelectedItem();
        Libro libro = (Libro) crearPrestamoView.getCbLibroP().getSelectedItem();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {

         Date fechaPrestamo = formato.parse(crearPrestamoView.getTxtFechaPrestamo().getText());

         Date fechaDevolucion = formato.parse(crearPrestamoView.getTxtFechaDevolucion().getText());

         Prestamo prestamo = new Prestamo(codigo,usuario,libro,fechaPrestamo,fechaDevolucion);
                                           
          prestamoDAO.crear(prestamo);

          JOptionPane.showMessageDialog(null, "Prestamo registrado");

       } catch (ParseException e) {
          JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto ingrese: dd/MM/yyyy");
    }    
    }
    
    public void cargarUsuarios(){
       crearPrestamoView.getCbUsuarioP().removeAllItems();
       for(Usuario usuario : usuarioDAO.listar()){
           crearPrestamoView.getCbUsuarioP().addItem(usuario);
       }
    }
    public void cargarLibros(){
        crearPrestamoView.getCbLibroP().removeAllItems();
        for(Libro libro : libroDAO.listar()){
            crearPrestamoView.getCbLibroP().addItem(libro);
         }
    }
    
    public void configurarEventosCrearPrestamo(){
            crearPrestamoView.getBtnRegistrarP().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola");
                crearPrestamo();
            }
        });
        }
      public void buscarPrestamo(){
         int codigo = Integer.parseInt(buscarPrestamoView.getTxtCodigoP().getText());
        
        Prestamo l = prestamoDAO.buscar(codigo);
         if ( l != null){
            buscarPrestamoView.mostrarPrestamo(l);
        }else{
            JOptionPane.showMessageDialog(null, "Prestamo no encontrado");
        }
      }
        public void configurarEventosBuscarPrestamo(){
            buscarPrestamoView.getBtnBuscarP().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola");
                buscarPrestamo();
            }
        });
        }  
        public void listarPrestamo(){
        
        List<Prestamo> listaActualizada = prestamoDAO.Listar();
        listarPrestamoView.cargarDatos(listaActualizada);
        
    }
        
        public void configurarEventosListarLibro(){
         listarPrestamoView.getBtnListarP().addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                listarPrestamo();
             }
             
         });
         
     } 
        public void eliminarPrestamo(){
         int codigo = Integer.parseInt(crearDevolucionView.getTxtCodigoP().getText());
            
            int respuesta = JOptionPane.showConfirmDialog( null,"¿Deseas devolver?\n" ,"Confirmar devolucion", JOptionPane.YES_NO_OPTION);
            
            if (respuesta == JOptionPane.YES_OPTION){
                 prestamoDAO.Eliminar(codigo);
                 JOptionPane.showMessageDialog(null, " Prestamo devuelto");
                 
            }
        else{
                JOptionPane.showMessageDialog(null, "Prestamo no encontrado");
            }
        }
     public void configurarEventosEliminarLibro(){
            crearDevolucionView.getBtnDevuelto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola");
                eliminarPrestamo();
            }
        });
        }
    public void buscarPrestamoEliminar (){
         int codigo = Integer.parseInt(crearDevolucionView.getTxtCodigoP().getText());
         Prestamo l = prestamoDAO.buscar(codigo);
         if ( l != null){
            crearDevolucionView.mostrarPrestamo(l);
        }else{
            JOptionPane.showMessageDialog(null, "Prestamo no encontrado");
        }
     }
    public void configurarEventosEliminarPrestamoBuscar(){
            crearDevolucionView.getBtnEliminarP().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola");
                buscarPrestamoEliminar();
            }
        });
        }
}
