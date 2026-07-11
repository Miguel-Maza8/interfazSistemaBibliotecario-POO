/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.controllers;

//import ec.edu.ups.biblioteca.views.MenuPrincipalView1;
import ec.edu.ups.biblioteca.dao.AutorDAO;
import ec.edu.ups.biblioteca.dao.LibroDAO;
import ec.edu.ups.biblioteca.models.Autor;
import ec.edu.ups.biblioteca.models.Libro;
import ec.edu.ups.biblioteca.views.ActualizarLibroView;
import ec.edu.ups.biblioteca.views.BuscarLibroView;
import ec.edu.ups.biblioteca.views.EliminarLibroView;
import ec.edu.ups.biblioteca.views.ListarLibroView;
import ec.edu.ups.biblioteca.views.RegistrarLibroView;
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
public class LibroController {
    private LibroDAO libroDAO ;
    private AutorDAO autorDAO;
    private RegistrarLibroView  registrarLibroView;
    private EliminarLibroView eliminarLibroView;
    private BuscarLibroView buscarLibroView;
    private ListarLibroView listarLibroView;
    private ActualizarLibroView actualizarLibroView;
    

    public LibroController(LibroDAO libroDAO, RegistrarLibroView registrarLibroView,AutorDAO autorDAO,BuscarLibroView buscarLibroView,EliminarLibroView eliminarLibroView,ListarLibroView listarLibroView,ActualizarLibroView actualizarLibroView) {
        this.libroDAO = libroDAO;
        this.registrarLibroView = registrarLibroView;
        this.autorDAO = autorDAO;
        this.buscarLibroView = buscarLibroView;
        this.eliminarLibroView= eliminarLibroView;
        this.listarLibroView = listarLibroView;
        this.actualizarLibroView = actualizarLibroView;
        configurarEventosRegistrarLibro();
        configurarEventosBuscarLibro();
        configurarEventosEliminarLibro();
        configurarEventosEliminarLibroBuscar();
        configurarEventosListarLibro();
    }
    
    public void registrarLibro() {
        int codigo = Integer.parseInt(registrarLibroView.getTxtCodigo().getText());
        String titulo = registrarLibroView.getTxtTitulo().getText();
        String editorial = registrarLibroView.getTxtEditorial().getText();
        Autor autor =  (Autor) registrarLibroView.getCbAutor().getSelectedItem();
        String genero = registrarLibroView.getCbGeneros().getSelectedItem().toString();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {

         Date fechaPrestamo = formato.parse(registrarLibroView.getTxtFechaDePublicacion().getText());

         Libro libro = new Libro(codigo,titulo,genero ,editorial,autor,fechaPrestamo);                                 
         
         libroDAO.crear(libro);
         
          
         JOptionPane.showMessageDialog(null, "Libro registrado");
         
       } catch (ParseException e) {
          JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto ingrese: dd/MM/yyyy");
       }
    }    
        
        

        
        
   
    public void cargarAutores() {

        registrarLibroView.getCbAutor().removeAllItems();

        for (Autor autor : autorDAO.listar()) {
            registrarLibroView.getCbAutor().addItem(autor);
        }
    }
    public void cargarAutoresA() {

        actualizarLibroView.getCbAutorA().removeAllItems();
        for (Autor autor : autorDAO.listar()) {
           actualizarLibroView.getCbAutorA().addItem(autor);
        }
    }
    public void configurarEventosRegistrarLibro(){
            registrarLibroView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                registrarLibro();
            }
        });
        }
     public void buscarLibro (){
         int codigo = Integer.parseInt(buscarLibroView.getTxtCodigoLibroB().getText());
         Libro l = libroDAO.buscar(codigo);
         if ( l != null){
            buscarLibroView.mostrarLibro(l);
        }else{
            JOptionPane.showMessageDialog(null, "Libro no encontrado");
        }
     }
      public void configurarEventosBuscarLibro(){
            buscarLibroView.getBtnBuscarL().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                buscarLibro();
            }
        });
        }
    public void eliminarLibro(){
         int codigo = Integer.parseInt(eliminarLibroView.getTxtCodigoEL().getText());
            
            int respuesta = JOptionPane.showConfirmDialog( null,"¿Deseas eliminar?\n" ,"Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            
            if (respuesta == JOptionPane.YES_OPTION){
                 libroDAO.Eliminar(codigo);
                 JOptionPane.showMessageDialog(null, "Libro eliminado");
                 
            }
        else{
                JOptionPane.showMessageDialog(null, "Libro no encontrado");
            }
        }
    
     public void buscarLibroEliminar (){
         int codigo = Integer.parseInt(eliminarLibroView.getTxtCodigoEL().getText());
         Libro l = libroDAO.buscar(codigo);
         if ( l != null){
            eliminarLibroView.mostrarLibro(l);
        }else{
            JOptionPane.showMessageDialog(null, "Libro no encontrado");
        }
     }
       public void configurarEventosEliminarLibroBuscar(){
            eliminarLibroView.getBtnBuscarL().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                buscarLibroEliminar();
            }
        });
        }
       public void configurarEventosEliminarLibro(){
            eliminarLibroView.getBtnEliminarL().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                eliminarLibro();
            }
        });
        }
        public void listarLibro(){
        
        List<Libro> listaActualizada = libroDAO.listar();
        listarLibroView.cargarDatos(listaActualizada);
        
    }
        
        public void configurarEventosListarLibro(){
         listarLibroView.getBtnListarL().addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                listarLibro();
             }
             
         });
         
     } 
        public void actualizarLibro(){
        int codigo = Integer.parseInt(actualizarLibroView.getTxtCodigoAct().getText());
        String titulo = actualizarLibroView.getTxtTituloA().getText();
        String editorial = actualizarLibroView.getTxtEditorialA().getText();
        Autor autor =  (Autor) actualizarLibroView.getCbAutorA().getSelectedItem();
        String genero = actualizarLibroView.getCbGenerosA().getSelectedItem().toString();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {

         Date fechaPrestamo = formato.parse(actualizarLibroView.getTxtFechaAc().getText());

         Libro libro = new Libro(codigo,titulo,genero ,editorial,autor,fechaPrestamo);                                 
         
         libroDAO.actualizar(libro);
         JOptionPane.showMessageDialog(null, "Libro actualizado");
         
       } catch (ParseException e) {
          JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto ingrese: dd/MM/yyyy");
       }
        

        
        
        
      
    }
        public void cargarAutoresActualizar() {

        actualizarLibroView.getCbAutorA().removeAllItems();

        for (Autor autor : autorDAO.listar()) {
            actualizarLibroView.getCbAutorA().addItem(autor);
        }
    }
        
        public void configurarEventosActualizarLibro(){
         actualizarLibroView.getBtnActualizarL().addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 actualizarLibro();
             }
             
         });
         
     }
    }
            
        
    

