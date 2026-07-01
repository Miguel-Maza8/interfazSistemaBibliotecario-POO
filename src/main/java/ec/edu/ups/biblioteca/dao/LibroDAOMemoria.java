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
    public void crear(Libro libro) {
      
         lista.add(libro);
        
    }

    @Override
    public Libro buscar(int codigo) {
        
         for(Libro libro : lista){
           if(libro.getCodigo() == codigo){
               return libro;
           }
       }
        return null;
       
    }

    @Override
    public void actualizar(Libro libro) {
      for( int i = 0 ; i< lista.size();i++){
         Libro libroEncontrado = lista.get(i);
         if( libroEncontrado.getCodigo() == libro.getCodigo()){
             lista.set(i, libro);
             break;
         }
     }
    }

    @Override
    public Libro Eliminar(int codigo) {
      Libro libroEncontrado = buscar(codigo);

     if ( libroEncontrado != null){
         
         lista.remove(libroEncontrado);
         return libroEncontrado;
     }
     return null;
    }

    @Override
    public List<Libro> listar() {
      return lista;
    }
    
}
