package com.sti.com.service;

import com.sti.com.model.Alumno;
import com.sti.com.repositories.IAlumnosRepository;

import java.util.List;

public class AlumnosService {

    private final IAlumnosRepository repository;
    public AlumnosService(IAlumnosRepository repository) {
        this.repository = repository;
    }

    // obtener todos los alumnos
    public List<Alumno> getAll() {
        return this.repository.getAlumnos();
    }



    // agregar alumnos
    // eliminar alumnos
    // actualizar la materia de un alumno
    // filtrar alumnos por edad y centro de estudio
    // order alumnos por materia y puntuación más alta
}
