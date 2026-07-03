/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.dao;

import ec.edu.ups.biblioteca.models.Prestamo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Maza
 */
public class PrestamoDAOMemoria implements PrestamoDAO{
    private List<Prestamo> lista;

    public PrestamoDAOMemoria() {
        lista = new ArrayList<>();
    }
    
    
    @Override
    public void crear(Prestamo prestamo) {
       lista.add(prestamo);
    }

    @Override
    public Prestamo buscar(int codigo) {
        for(Prestamo prestamo : lista){
           if(prestamo.getCodigo() == codigo){
               return prestamo;
           }
       }
        return null;
        
        
    }

    @Override
    public List<Prestamo> Listar() {
       return lista;
    }
    
}
