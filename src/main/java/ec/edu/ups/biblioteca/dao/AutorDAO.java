/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.biblioteca.dao;

import ec.edu.ups.biblioteca.models.Autor;
import java.util.List;

/**
 *
 * @author Miguel Maza
 */
public interface AutorDAO {
    void crear(Autor autor );
    Autor buscar(String cedula);
    void actualizar( Autor autor);
    Autor Eliminar(String cedula);
    List<Autor> listar();
}
