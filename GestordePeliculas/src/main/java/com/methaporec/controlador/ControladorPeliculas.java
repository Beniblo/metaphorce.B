package com.methaporec.controlador;  
/**
*
*
*@GutierrezPablo
*/

//Importo clases desde otro paquete
import com.methaporec.modelo.GestorPelicula;  
import com.methaporec.modelo.Pelicula;  
import java.util.List;  

public class ControladorPeliculas {  
    private GestorPelicula gestor = new GestorPelicula();  

    //metodos
    public void agregarPelicula(int id, String nombre) {  
        gestor.agregarPelicula(new Pelicula(id, nombre));  
    }  

    public void eliminarPelicula(int id) {  
        gestor.eliminarPelicula(id);  
    }  

    public List<Pelicula> obtenerNoDisponibles() {  
        return gestor.obtenerPeliculas().stream()  
            .filter(p -> !p.isDisponible())  
            .toList();  
    }  

    public void marcarDisponible(int id) {  
        gestor.marcarDisponible(id);  
    }  

    public void marcarNoDisponible(int id) {  
        gestor.marcarNoDisponible(id);  
    }  

    public List<Pelicula> verListaExistencias() {  
        return gestor.obtenerPeliculas();  
    }  
}  