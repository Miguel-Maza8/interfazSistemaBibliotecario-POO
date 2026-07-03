/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.dao;

import ec.edu.ups.biblioteca.models.Autor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Maza
 */
public class AutorDAOMemoria implements AutorDAO{
    private List<Autor> lista;

    public AutorDAOMemoria() {
         lista= new ArrayList<>();
    }

    @Override
    public void crear(Autor autor) {
      lista.add(autor);
    }

    @Override
    public List<Autor> listar() {
      return lista;
    }

    @Override
    public Autor buscar(String cedula) {
      for(Autor autor : lista){
           if( autor.getCedula().equalsIgnoreCase(cedula)){
               return autor;
           }
       }
        return null;
       
    }
    

    @Override
    public void actualizar(Autor autor) {
        for( int i = 0 ; i< lista.size();i++){
         Autor autorEncontrado = lista.get(i);
         if( autorEncontrado.getCedula().equalsIgnoreCase(autor.getCedula())){
             lista.set(i, autor);
             break;
         }
     }
        
        
        
    }

    @Override
    public Autor Eliminar(String cedula) {
         Autor autorEncontrado = buscar(cedula);

     if ( autorEncontrado != null){
         
         lista.remove(autorEncontrado);
         return autorEncontrado;
     }
     return null;
    }
    
    
    
    
    
}

