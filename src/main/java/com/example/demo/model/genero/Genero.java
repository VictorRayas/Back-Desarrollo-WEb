package com.example.demo.model.genero;

import com.example.demo.model.libro.Libros;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "genero")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String nombre;
    @OneToMany(mappedBy = "genero")
    @JsonIgnore
    private List<Libros> libros;

}
