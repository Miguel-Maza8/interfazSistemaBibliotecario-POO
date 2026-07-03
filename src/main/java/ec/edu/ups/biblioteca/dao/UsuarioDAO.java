/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.biblioteca.dao;

import ec.edu.ups.biblioteca.models.Usuario;
import java.util.List;

/**
 *
 * @author Miguel Maza
 */
public interface UsuarioDAO {
    void crear(Usuario usuario );
    Usuario buscar(String cedula);
    void actualizar( Usuario usuario);
    Usuario Eliminar(String cedula);
    List<Usuario> listar();
}
