package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Libro;
import org.springframework.data.jdbc.repository.query.Query; 
import org.springframework.data.repository.CrudRepository; 
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioLibro extends CrudRepository<Libro, Integer> {
    @Query("SELECT * FROM LIBRO WHERE LOWER(AUTOR) LIKE CONCAT('%', LOWER(:criterio), '%') OR LOWER(NOMBRE) LIKE CONCAT('%', LOWER(:criterio), '%') OR LOWER(ISBN) LIKE CONCAT('%', LOWER(:criterio), '%')")
    List<Libro> buscarPorCriterio(String criterio);
}