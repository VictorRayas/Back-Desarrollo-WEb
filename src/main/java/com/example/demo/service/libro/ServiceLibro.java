package com.example.demo.service.libro;

import com.example.demo.model.libro.Libros;
import com.example.demo.model.libro.RepositoryLibro;
import com.example.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class ServiceLibro {
    @Autowired
    RepositoryLibro repositoryLibro;

   @Transactional(readOnly = true)
    public Response<List<Libros>> getAll(){
       return  new Response<>(
               this.repositoryLibro.findAll(),
               false,
               200,
               "Libros Encontrados"
       );
   }

   @Transactional(readOnly = true)
    public Response<Libros> getOne(long id){
       return new Response<>(
               this.repositoryLibro.findById(id).get(),
               false,
               200,
               "Libro Encontrado"

       );
   }

   @Transactional(rollbackFor = SQLException.class)
    public Response<Libros> insert(Libros libro){
       return new Response<>(
               this.repositoryLibro.saveAndFlush(libro),
               false,
               200,
               "Libro Insertado"
       );
   }

   @Transactional(rollbackFor = SQLException.class)
    public Response<Boolean> delete(Long id){
       this.repositoryLibro.deleteUser(id);
       return new Response<>(
               null,
               false,
               200,
               "Libro Eliminado"
       );
   }


}
