package com.sti.com;

import com.sti.com.repositories.AlumnosRepositoryImpl;
import com.sti.com.service.AlumnosService;

public class Main {
    public static void main(String[] args) {
        AlumnosRepositoryImpl repository = new AlumnosRepositoryImpl();
        AlumnosService service = new AlumnosService(repository);

        //1) lista de alumnos (vació)
        //2) agregar alumnos
        //3) obtener los alumnos filtrados edad y centro de estudio
        //4) obtener alumnos por materia y puntuación más alta
        //5) lista de alumnos (con datos)
        //6) poder eliminar un alumno por numero de cuenta
    }
}