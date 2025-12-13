package co.edu.itc.programacion.biblioteca.api.mapper;

import co.edu.itc.programacion.biblioteca.modelo.*;
import co.edu.itc.programacion.biblioteca.representacion.*;

public class RecursoMapper {

    public static RecursoRepresentacion aRepresentacion(Recurso r) {
        if (r instanceof Libro l) {
            return new LibroRepresentacion(
                l.getId(), l.getNombre(), l.getFechaRegistro(),
                l.getAutor(), l.getAnio(), l.getIsbn()
            );
        }

        if (r instanceof Periodico p) {
            return new PeriodicoRepresentacion(
                p.getId(), p.getNombre(), p.getFechaRegistro(),
                p.getEditorial(), p.getAnio()
            );
        }

        if (r instanceof Computador c) {
            return new ComputadorRepresentacion(
                c.getId(), c.getNombre(), c.getFechaRegistro(),
                c.getMarca(), c.getModelo(), c.getTipo().name()
            );
        }

        return null;
    }

    public static Recurso aEntidad(RecursoRepresentacion r) {
        if (r instanceof LibroRepresentacion l) {
            return new Libro(null, l.getNombre(), l.getAutor(), l.getAnio(), l.getIsbn());
        }

        if (r instanceof PeriodicoRepresentacion p) {
            return new Periodico(null, p.getNombre(), p.getEditorial(), p.getAnio());
        }

        if (r instanceof ComputadorRepresentacion c) {
            return new Computador(
                null, c.getNombre(), c.getMarca(), c.getModelo(),
                TipoComputador.valueOf(c.getTipo())
            );
        }

        return null;
    }
}
