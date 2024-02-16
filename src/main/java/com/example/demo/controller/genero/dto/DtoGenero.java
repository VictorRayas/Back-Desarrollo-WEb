package com.example.demo.controller.genero.dto;

import com.example.demo.model.genero.Genero;
import com.example.demo.model.libro.Libros;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DtoGenero {
    private Long id;
    private String nombre;
    private Libros libros;

    public Genero castToGenero(){
        return  new Genero(
           getId(),
           getNombre(),
           null
        );
    }

}
