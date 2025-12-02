package co.edu.itc.programacion.biblioteca.representacion;

public class RecursoRepresentacion {
    public Integer id;
    public String nombre;
    public String tipo;
    public String fechaRegistro;

    public RecursoRepresentacion(Integer id, String nombre, String tipo, String fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaRegistro = fechaRegistro;
    }
}
