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
