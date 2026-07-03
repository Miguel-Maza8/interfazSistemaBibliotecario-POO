/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.dao;

import ec.edu.ups.biblioteca.models.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Maza
 */
public class UsuarioDAOMemoria implements UsuarioDAO {
      
    private List<Usuario> lista;

    public UsuarioDAOMemoria() {
        lista = new ArrayList<>();
    }
    
    
    @Override
    public void crear(Usuario usuario) {
        
      lista.add(usuario);
    }

    @Override
    public Usuario buscar(String cedula) {
       for(Usuario usuario : lista){
           if( usuario.getCedula().equalsIgnoreCase(cedula)){
               return usuario;
           }
       }
        return null;
    }

    @Override
    public void actualizar(Usuario usuario) {
       for( int i = 0 ; i< lista.size();i++){
         Usuario usuarioEncontrado = lista.get(i);
         if( usuarioEncontrado.getCedula().equalsIgnoreCase(usuario.getCedula())){
             lista.set(i, usuario);
             break;
         }
     }
    }

    @Override
    public Usuario Eliminar(String cedula) {
       Usuario usuarioEncontrado = buscar(cedula);

     if ( usuarioEncontrado != null){
         
         lista.remove(usuarioEncontrado);
         return usuarioEncontrado;
     }
     return null;
    }
    

    @Override
    public List<Usuario> listar() {
       return lista;
    }
    
}
