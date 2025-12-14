package co.edu.itc.programacion.biblioteca.representacion;

import java.time.LocalDateTime;

public class PeriodicoRepresentacion extends RecursoRepresentacion {

    private final String editorial;
    private final Integer anio;

    public PeriodicoRepresentacion(Integer id, String nombre, LocalDateTime fechaRegistro, String editorial, Integer anio) {
        super(id, "PERIODICO", nombre, fechaRegistro);
        this.editorial = editorial;
        this.anio = anio;
    }

    public String getEditorial() {
        return editorial;
    }

    public Integer getAnio() {
        return anio;
    }
}
