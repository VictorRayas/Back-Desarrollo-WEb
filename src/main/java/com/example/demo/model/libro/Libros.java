package com.example.demo.model.libro;


import com.example.demo.model.genero.Genero;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "libros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String autor;
    private int anio;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;


}
