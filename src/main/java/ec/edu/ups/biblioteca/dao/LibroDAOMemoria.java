/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.dao;

import ec.edu.ups.biblioteca.models.Libro;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Miguel Maza
 */
public class LibroDAOMemoria implements LibroDAO {
    
    private List<Libro> lista;

    public LibroDAOMemoria() {
        
        lista= new ArrayList<>();
    }
    
    @Override
    public void crear (Libro libro){
            
        lista.add(libro);
    }
    
    
    @Override
    public void crear(Libro libro) {
      
        
        
    }

    @Override
    public Libro buscar(int codigo) {
       
    }

    @Override
    public void actualizar(Libro libro) {
      
    }

    @Override
    public Libro Eliminar(int codigo) {
      
    }
    
}
