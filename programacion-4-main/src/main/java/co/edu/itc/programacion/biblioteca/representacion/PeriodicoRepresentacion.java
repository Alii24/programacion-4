package co.edu.itc.programacion.biblioteca.representacion;

public class PeriodicoRepresentacion extends RecursoRepresentacion {
    public String editorial;
    public Integer anio;

    public PeriodicoRepresentacion(Integer id, String nombre, String editorial, Integer anio) {
        super(id, nombre, "periodico", null);
        this.editorial = editorial;
        this.anio = anio;
    }
}
