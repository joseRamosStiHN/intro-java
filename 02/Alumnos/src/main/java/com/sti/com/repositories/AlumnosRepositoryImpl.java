package com.sti.com.repositories;

import com.sti.com.model.Alumno;

import java.util.ArrayList;
import java.util.List;

public class AlumnosRepositoryImpl implements IAlumnosRepository{

    private static List<Alumno> myData = new ArrayList<>();


    @Override
    public List<Alumno> getAlumnos() {
        return myData;
    }

    @Override
    public List<Alumno> getAlumnosSortBy(String sort) {
        //Stream


        return List.of();
    }

    @Override
    public List<Alumno> getFilterBy(String filter) {
        return List.of();
    }

    @Override
    public void update(String cuentaAlumno, Alumno alumno) {

    }

    @Override
    public void delete(String cuentaAlumno) {

    }

    @Override
    public Alumno createAlumno(Alumno newAlumno) {
        return null;
    }
}
