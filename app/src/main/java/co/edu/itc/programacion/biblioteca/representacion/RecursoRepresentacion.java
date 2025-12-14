package co.edu.itc.programacion.biblioteca.representacion;

import java.time.LocalDateTime;

public class RecursoRepresentacion {

    private final Integer id;
    private final String tipoRecurso;
    private final String nombre;
    private final LocalDateTime fechaRegistro;

    public RecursoRepresentacion(Integer id, String tipoRecurso, String nombre, LocalDateTime fechaRegistro) {
        this.id = id;
        this.tipoRecurso = tipoRecurso;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
}
