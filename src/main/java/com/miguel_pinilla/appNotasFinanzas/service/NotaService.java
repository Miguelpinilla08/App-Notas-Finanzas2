package com.miguel_pinilla.appNotasFinanzas.service;

import com.miguel_pinilla.appNotasFinanzas.model.Nota;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotaService {
    private List<Nota> notas = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Nota> obtenerTodasLasNotas(){
        return notas;
    }

    public Nota crearNota(String titulo, String contenido) {
        Nota nuevaNota = new Nota();
        nuevaNota.setId(contadorId++);
        nuevaNota.setTitulo(titulo);
        nuevaNota.setContenido(contenido);
        notas.add(nuevaNota);
        return nuevaNota;
    }
}
