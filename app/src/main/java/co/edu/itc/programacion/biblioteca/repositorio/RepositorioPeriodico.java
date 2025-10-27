package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RepositorioPeriodico extends CrudRepository<Periodico, Integer> {
    @Query("SELECT * FROM PERIODICO WHERE LOWER(EDITORIAL) LIKE CONCAT('%', LOWER(:criterio), '%') OR LOWER(NOMBRE) LIKE CONCAT('%', LOWER(:criterio), '%')")
    List<Periodico> buscarPorCriterio(String criterio);
}