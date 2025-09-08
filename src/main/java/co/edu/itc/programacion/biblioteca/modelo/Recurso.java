package co.edu.itc.programacion.biblioteca.modelo;
import java.time.LocalDateTime;

public abstract class Recurso {
    private int id;
    private String nombre;
    private LocalDateTime fechaRegistro;

    public Recurso(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.fechaRegistro = LocalDateTime.now();
    }

    public int getId(){
        return id;
    }

    public String nombre(){
        return nombre;
    }

    public String toString(){
        return "el ID es: " + id + " el Nombre es: " + nombre + "La Fecha de Registro es:" + fechaRegistro;
    }
}
