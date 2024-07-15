package com.tapianadia.literatura.repository;

import com.tapianadia.literatura.model.Autor;
import com.tapianadia.literatura.model.Idioma;
import com.tapianadia.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sLibrosRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByIdiomas(Idioma idioma);

    @Query("SELECT a FROM Autor a JOIN a.libro l")
    List<Autor> mostrarAutores();

    @Query("SELECT a FROM Autor a JOIN a.libro l WHERE a.fechaDeNacimiento <= :anio AND (a.fechaDeFallecimiento >= :anio OR a.fechaDeFallecimiento IS NULL)")
    List<Autor> mostrarAutoresVivos(@Param("anio") String anio);


}
