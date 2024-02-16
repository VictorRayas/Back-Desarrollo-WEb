package com.example.demo.service.genero;

import com.example.demo.model.genero.Genero;
import com.example.demo.model.genero.RepositoryGenero;
import com.example.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceGenero {
    @Autowired
    RepositoryGenero repositoryGenero;

    @Transactional(readOnly = true)
    public Response<List<Genero>> getAll(){
        return  new Response<>(
                this.repositoryGenero.findAll(),
                false,
                200,
                "Generos Encontrados"
        );
    }

}
