package com.example.demo.controller.libro.dto;

import com.example.demo.model.genero.Genero;
import com.example.demo.model.libro.Libros;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DtoLibro {
    private Long id;
    private String nombre;
    private String autor;
    private int anio;
    private Genero genero;

    public Libros castToLibro(){
        return  new Libros(
            getId(),
                getNombre(),
                getAutor(),
                getAnio(),
                genero
        );
    }


}
