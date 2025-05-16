package com.methaporec.vista;  
/**
*
*
*@GutierrezPablo
*/
import com.methaporec.controlador.ControladorPeliculas;  
import com.methaporec.modelo.Pelicula;  
import java.util.List;  
import java.util.Scanner;  

public class GestordePeliculas {  
    private static ControladorPeliculas _controlador_ = new ControladorPeliculas();  
    private static Scanner _scanner_ = new Scanner(System.in);  

    public static void main(String[] args) {  
        boolean salir = false;  
        
        //Menu
        while (!salir) {  
            System.out.println("\n--- GESTOR DE PELICULAS ---");  
            System.out.println("1. Agregar pelicula");  
            System.out.println("2. Eliminar pelicula");  
            System.out.println("3. Marcar como disponible");  
            System.out.println("4. Marcar como NO disponible");  
            System.out.println("5. Ver peliculas no disponibles");  
            System.out.println("6. Ver peliculas disponibles");   
            
            System.out.println("7. Salir");  
            System.out.print("Seleccione una opcion: ");  

            int opcion = _scanner_.nextInt();  
            _scanner_.nextLine();  

            switch (opcion) {  
                case 1 : agregarPelicula(); break;
                case 2 : eliminarPelicula(); break;
                case 3 : marcarDisponible(); break;
                case 4 : marcarNoDisponible(); break;
                case 5 : mostrarNoDisponibles(); break;  
                case 6 : mostrarDisponibles(); break;
                case 7 : salir = true; 
                default : System.out.println("Opcion no valida. Ingrese un numero del 1 al 7."); 
            }  
        }  
    }  

    private static void agregarPelicula() {  
        System.out.print("ID de la pelicula: ");  
        int id = _scanner_.nextInt();  
        _scanner_.nextLine();  
        System.out.print("Nombre: ");  
        String nombre = _scanner_.nextLine();  
        _controlador_.agregarPelicula(id, nombre);  
        System.out.println("Pelicula agregada exitosamente.");  
    }  

    private static void eliminarPelicula() {  
        System.out.print("ID de la pelicula a eliminar: ");  
        int id = _scanner_.nextInt();  
        _scanner_.nextLine();  
        _controlador_.eliminarPelicula(id);  
        System.out.println("Pelicula eliminada del sistema.");  
    }  

    private static void marcarDisponible() {  
        System.out.print("ID de la pelicula a marcar: ");  
        int id = _scanner_.nextInt();  
        _scanner_.nextLine();  
        _controlador_.marcarDisponible(id);  
        System.out.println("Estado de disponibilidad actualizado.");  
    }  

    private static void marcarNoDisponible() {  
        System.out.print("ID de la pelicula a marcar como NO disponible: ");  
        int id = _scanner_.nextInt();  
        _scanner_.nextLine();  
        _controlador_.marcarNoDisponible(id);  
        System.out.println("Pelicula marcada como NO disponible!");  
    }  

    private static void mostrarNoDisponibles() {  
        List<Pelicula> noDisponibles = _controlador_.obtenerNoDisponibles();  
        System.out.println("\n--- Peliculas NO disponibles ---");  
        noDisponibles.forEach(p -> System.out.println("ID: " + p.getId() + " - " + p.getNombre()));  
    }  

    private static void mostrarDisponibles() {  
        List<Pelicula> disponibles = _controlador_.verListaExistencias().stream().filter(Pelicula::isDisponible).toList();  
        System.out.println("\n--- Peliculas DISPONIBLES ---");  
        disponibles.forEach(p -> System.out.println("ID: " + p.getId() + " - " + p.getNombre()));  
    }  
}  
