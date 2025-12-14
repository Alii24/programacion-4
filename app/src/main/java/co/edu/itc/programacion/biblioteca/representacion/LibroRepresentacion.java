package co.edu.itc.programacion.biblioteca.representacion;

import java.time.LocalDateTime;

public class LibroRepresentacion extends RecursoRepresentacion {

    private final String autor;
    private final Integer anio;
    private final String isbn;

    public LibroRepresentacion(Integer id, String nombre, LocalDateTime fechaRegistro, String autor, Integer anio, String isbn) {
        super(id, "LIBRO", nombre, fechaRegistro);
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAnio() {
        return anio;
    }

    public String getIsbn() {
        return isbn;
    }
}
