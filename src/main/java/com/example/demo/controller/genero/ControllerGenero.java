package com.example.demo.controller.genero;

import com.example.demo.model.genero.Genero;
import com.example.demo.service.genero.ServiceGenero;
import com.example.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libreria/genero")
@CrossOrigin(origins = {"*"})
public class ControllerGenero {
    @Autowired
    ServiceGenero serviceGenero;

    @GetMapping("/")
    public ResponseEntity<Response<List<Genero>>> getAll(){
        return  new ResponseEntity<>(
                this.serviceGenero.getAll(),
                HttpStatus.OK
        );
    }

}
