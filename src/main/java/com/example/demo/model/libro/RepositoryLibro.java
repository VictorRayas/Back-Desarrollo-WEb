package com.example.demo.model.libro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryLibro extends JpaRepository<Libros,Long> {

    @Modifying
    @Query(value = "DELETE FROM libros WHERE id = :id",nativeQuery = true)
    void deleteUser(@Param("id") Long id);
}
