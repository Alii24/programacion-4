package co.edu.itc.programacion.biblioteca.infraestructura;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class InicializadorBaseDatos implements InitializingBean, DisposableBean {

    private final JdbcTemplate jdbcTemplate;

    public InicializadorBaseDatos(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("--- Inicializando Base de Datos H2 ---");

        jdbcTemplate.execute(
            "CREATE TABLE LIBRO (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "NOMBRE VARCHAR(255), " +
            "FECHA_REGISTRO TIMESTAMP, " +
            "AUTOR VARCHAR(255), " +
            "ANIO INT, " +
            "ISBN VARCHAR(255))"
        );

        jdbcTemplate.execute(
            "CREATE TABLE PERIODICO (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "NOMBRE VARCHAR(255), " +
            "FECHA_REGISTRO TIMESTAMP, " +
            "EDITORIAL VARCHAR(255), " +
            "ANIO INT)"
        );

        jdbcTemplate.execute(
            "CREATE TABLE COMPUTADOR (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "NOMBRE VARCHAR(255), " +
            "FECHA_REGISTRO TIMESTAMP, " +
            "MARCA VARCHAR(255), " +
            "MODELO VARCHAR(255), " +
            "TIPO VARCHAR(255))" 
        );
        
        System.out.println("--- Tablas creadas exitosamente ---");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("--- Cerrando conexion y apagando H2 (SHUTDOWN) ---");
        jdbcTemplate.execute("SHUTDOWN");
    }
}