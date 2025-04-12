package com.sti.com.repositories;

import com.sti.com.model.Alumno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Alumno> existingAlumno = myData.stream()
                .filter(a -> a.getNumCuenta().equalsIgnoreCase(cuentaAlumno))
                .findFirst();

        if (existingAlumno.isPresent()) {
            Alumno currentAlumno = existingAlumno.get();
            currentAlumno.setNombre(alumno.getNombre());
            currentAlumno.setEdad(alumno.getEdad());
            currentAlumno.setCarrera(alumno.getCarrera());
            currentAlumno.setDepartamento(alumno.getDepartamento());
            currentAlumno.setCentroEstudio(alumno.getCentroEstudio());
            //currentAlumno.setMaterias(alumno.getMaterias());
        } else {
            throw new RuntimeException(String.format("No se encontró un Alumno con el número de cuenta %s", cuentaAlumno));
        }
    }

    @Override
    public void delete(String cuentaAlumno) {
        // forma imperativa: se usa un for explícito para recorrer y eliminar manualmente
        for(Alumno a : myData){
            if(a.getNumCuenta().equalsIgnoreCase(cuentaAlumno)){
                myData.remove(a);
                return;
            }
        }
        // forma declarativa: se usa programación funcional con removeIf
        // myData.removeIf(a -> a.getNumCuenta().equalsIgnoreCase(cuentaAlumno));
    }

    @Override
    public Alumno createAlumno(Alumno newAlumno) {

        Optional<Alumno> alumno = myData.stream() // convertimos a steam para manipular los datos
                                       .filter(a -> a.getNumCuenta().equalsIgnoreCase(newAlumno.getNumCuenta())) // filtramos para buscar y ver si existe
                                       .findFirst(); // obtenemos solo un resultado
        if (alumno.isEmpty()){ // si no retona valor es porque el alumno no existe en la lista y ya lo podemos agregar
            myData.add(newAlumno);
            return newAlumno;
        }

        throw new RuntimeException(String.format("Ya existe un Alumno con el numero de cuenta %s", newAlumno.getNumCuenta()));

    }
}
