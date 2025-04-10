package com.sti.com.repositories;

import com.sti.com.model.Alumno;

import java.util.List;

public interface IAlumnosRepository {

    List<Alumno> getAlumnos(); // todos los alumnos

    List<Alumno> getAlumnosSortBy(String sort); // ordenados por un criterio
    List<Alumno> getFilterBy(String filter); // filtrados por un criterio

    void update(String cuentaAlumno, Alumno alumno); // actualiza informacion de un alumno

    void delete(String cuentaAlumno); // elimina alumno de la lista

    Alumno createAlumno(Alumno newAlumno); // crea un nuevo alumno


}
