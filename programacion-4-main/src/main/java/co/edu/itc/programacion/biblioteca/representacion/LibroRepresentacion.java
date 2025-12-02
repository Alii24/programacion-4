package co.edu.itc.programacion.biblioteca.representacion;

public class LibroRepresentacion extends RecursoRepresentacion {
    public String autor;
    public Integer anio;
    public String isbn;

    public LibroRepresentacion(Integer id, String nombre, String autor, Integer anio, String isbn) {
        super(id, nombre, "libro", null);
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }
}
