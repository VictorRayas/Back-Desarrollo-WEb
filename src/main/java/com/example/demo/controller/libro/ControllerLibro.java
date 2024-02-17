package com.example.demo.controller.libro;

import com.example.demo.controller.libro.dto.DtoLibro;
import com.example.demo.model.libro.Libros;
import com.example.demo.service.libro.ServiceLibro;
import com.example.demo.utils.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libreria/libro")
@CrossOrigin(origins = {"*"})
public class ControllerLibro {
    @Autowired
    ServiceLibro serviceLibro;

    @GetMapping("/")
    ResponseEntity<Response<List<Libros>>> getall(){
        return  new ResponseEntity<>(
                this.serviceLibro.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/name/{name}")
    ResponseEntity<Response<List<Libros>>> getByName(@PathVariable String name){
        return new ResponseEntity<>(
                this.serviceLibro.getName(name),
                HttpStatus.OK
        );
    }
    @GetMapping("/autor/{autor}")
    ResponseEntity<Response<List<Libros>>> getByAutor(@PathVariable String autor){
        return new ResponseEntity<>(
                this.serviceLibro.getAutor(autor),
                HttpStatus.OK
        );
    }
    @GetMapping("/genero/{id}")
    ResponseEntity<Response<List<Libros>>> getbyGenero(@PathVariable Long id){
        return new ResponseEntity<>(
                this.serviceLibro.getGenero(id),
                HttpStatus.OK
        );
    }
    @GetMapping("/pack/{nombre}/{autor}")
    ResponseEntity<Response<List<Libros>>> getbyGenero(@PathVariable String nombre,@PathVariable String autor){
        return new ResponseEntity<>(
                this.serviceLibro.getNombreAutor(nombre,autor),
                HttpStatus.OK
        );
    }
    @GetMapping("/anio/{inicio}/{fin}")
    ResponseEntity<Response<List<Libros>>> getbyAnio(@PathVariable Long inicio, @PathVariable Long fin){
        return new ResponseEntity<>(
                this.serviceLibro.getAnio(inicio,fin),
                HttpStatus.OK
        );
    }
    @GetMapping("/anio/desc/")
    ResponseEntity<Response<List<Libros>>> getbyAnio(){
        return new ResponseEntity<>(
                this.serviceLibro.getFechaDesc(),
                HttpStatus.OK
        );
    }


    @PostMapping("/")
    public  ResponseEntity<Response<Libros>> insert(@Valid @RequestBody DtoLibro libros,
                                                    @Valid BindingResult result){
        return  new ResponseEntity<>(
                this.serviceLibro.insert(libros.castToLibro()),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable  Long id){
        return new ResponseEntity<>(
                this.serviceLibro.delete(id),
                HttpStatus.OK
        );
    }
}
