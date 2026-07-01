/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.biblioteca.dao;

import ec.edu.ups.biblioteca.models.Libro;
import java.util.List;

/**
 *
 * @author Miguel Maza
 */
public interface LibroDAO {
    void crear(Libro libro );
    Libro buscar(int codigo);
    void actualizar( Libro libro);
    Libro Eliminar(int codigo);
    List<Libro> listar();
}
