package com.methaporec.modelo;  
/**
*
*
*@GutierrezPablo
*/
public class Pelicula {  
    //Atributos de Pelicula
    private int id;  
    private String nombre;  
    private boolean disponible;  

    //Constructor
    public Pelicula(int id, String nombre) {  
        this.id = id;  
        this.nombre = nombre;  
        this.disponible = true;  
    }  

    //Getters y Setters
    public int getId() { return id; }  
    public String getNombre() { return nombre; }  
    public boolean isDisponible() { return disponible; }  
    public void setDisponible(boolean disponible) { this.disponible = disponible; }  
}  
