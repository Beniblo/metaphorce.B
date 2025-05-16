package com.methaporec.modelo;  
/**
*
*
*@GutierrezPablo
*/
import java.util.ArrayList;  
import java.util.List;  

public class GestorPelicula {  
    //Creacion de Array Para lista de peliculas
    private List<Pelicula> listaPeliculas = new ArrayList<>();  

    //Metodos
    public void agregarPelicula(Pelicula pelicula) {  
        listaPeliculas.add(pelicula);  
    }  

    public void eliminarPelicula(int id) {  
        listaPeliculas.removeIf(p -> p.getId() == id);  
    }  

    public List<Pelicula> obtenerPeliculas() {  
        return new ArrayList<>(listaPeliculas);  
    }  

    public List<Pelicula> obtenerPeliculasDisponibles() {  
        return listaPeliculas.stream().filter(Pelicula::isDisponible).toList();  
    }  

    public void marcarDisponible(int id) {  
        listaPeliculas.stream()  
            .filter(p -> p.getId() == id)  
            .forEach(p -> p.setDisponible(true));  
    }  

    public void marcarNoDisponible(int id) {  
        listaPeliculas.stream()  
            .filter(p -> p.getId() == id)  
            .forEach(p -> p.setDisponible(false));  
    }  
}  