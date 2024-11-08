package com.miguel_pinilla.appNotasFinanzas.controller;

import com.miguel_pinilla.appNotasFinanzas.service.NotaService;
import com.miguel_pinilla.appNotasFinanzas.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notas")

public class NotaController {

    private List<Nota> notas = new ArrayList<>(); // Lista para almacenar notas

    // Método para obtener todas las notas
    @GetMapping
    public List<Nota> obtenerNotas() {
        return notas; // Devuelve la lista de notas
    }

    // Método para crear una nueva nota
    @PostMapping
    public ResponseEntity<Nota> crearNota(@RequestBody Nota nuevaNota) {
        if (nuevaNota.getTitulo() == null || nuevaNota.getContenido() == null) {
            return ResponseEntity.badRequest().build(); // Devuelve un error 400 si los datos son nulos
        }
        notas.add(nuevaNota); // Agrega la nota a la lista
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNota); // Devuelve la nueva nota con estado 201
    }
}
