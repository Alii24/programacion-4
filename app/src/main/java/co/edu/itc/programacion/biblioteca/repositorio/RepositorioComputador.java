package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Computador;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioComputador extends CrudRepository<Computador, Integer> {
    @Query("SELECT * FROM COMPUTADOR WHERE LOWER(MARCA) LIKE CONCAT('%', LOWER(:criterio), '%') OR LOWER(MODELO) LIKE CONCAT('%', LOWER(:criterio), '%') OR LOWER(NOMBRE) LIKE CONCAT('%', LOWER(:criterio), '%')")
    List<Computador> buscarPorCriterio(@Param("criterio") String criterio);
}
