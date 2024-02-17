package com.example.demo.model.libro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryLibro extends JpaRepository<Libros,Long> {

    @Modifying
    @Query(value = "DELETE FROM libros WHERE id = :id",nativeQuery = true)
    void deleteUser(@Param("id") Long id);
    List<Libros> findByNombreContaining(String nombre);
    List<Libros> findByAutorContaining(String autor);
    List<Libros> findAByGenero_Id(Long id);

    List<Libros> findByNombreContainingAndAutorContaining(String nombre,String autor);
    List<Libros> findByAnioBetween(Long inicio, Long fin);

    List<Libros> findByOrderByAnioDesc();

}
