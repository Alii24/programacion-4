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

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString(){
        return "Recurso [ id = " + id + ", nombre = " + nombre +  ", fecha registro = " + fechaRegistro;
    }
}
