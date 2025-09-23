package co.edu.itc.programacion.biblioteca.modelo;
import java.time.LocalDateTime;

public abstract class Recurso {
    private Integer id;
    private String nombre;
    private LocalDateTime fechaRegistro;

    public Recurso(Integer id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.fechaRegistro = LocalDateTime.now();
    }

    public Integer getId(){
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
