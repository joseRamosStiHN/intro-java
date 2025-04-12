package com.sti.com.service;

import com.sti.com.model.Alumno;
import com.sti.com.model.Materia;
import com.sti.com.repositories.IAlumnosRepository;

import java.util.List;
import java.util.stream.Stream;

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
    public void save(Alumno alumno) {
        this.repository.createAlumno(alumno);
    }

    // filtrar alumnos por edad y centro de estudio
    public List<Alumno> filterByAgeAndCE(int edad, String centroEstudio) {
        // en este caso vamos a traer todos y filtrar en el service
        List<Alumno> alumnos = this.repository.getAlumnos();
        List<Alumno> studentFiltered = alumnos.stream() // se convierte en stream
                                             .filter(a -> a.getEdad() == edad &&  // aqui tenemos los filtros podemos crear cuantos necesitemos
                                                     a.getCentroEstudio().equalsIgnoreCase(centroEstudio))
                                             .toList(); // convertimos en lista (a partir de java 17 usamos .toList par retornar en lista)
        return studentFiltered;
    }

    // order alumnos por materia y puntuación más alta
    public List<Alumno> filterByMatAndHighestRange(String mat) {
        List<Alumno> alumnos = this.repository.getAlumnos();

         return alumnos.stream()
                .filter(a -> a.getMaterias().stream()
                        .anyMatch(m -> m.getNombre().equalsIgnoreCase(mat)))
                .map(a -> {
                    // Filtramos solo las materias que coincidan
                    List<Materia> materiasFiltradas = a.getMaterias().stream()
                            .filter(m -> m.getNombre().equalsIgnoreCase(mat))
                            .toList();

                    // Creamos una nueva instancia de Alumno con solo esas materias
                    Alumno nuevo = new Alumno();
                    nuevo.setNombre(a.getNombre());
                    nuevo.setCarrera(a.getCarrera());
                    nuevo.setDepartamento(a.getDepartamento());
                    nuevo.setEdad(a.getEdad());
                    nuevo.setCentroEstudio(a.getCentroEstudio());
                    nuevo.setNumCuenta(a.getNumCuenta());
                    nuevo.setMaterias(materiasFiltradas);
                    return nuevo;
                })
                .sorted((a1, a2) -> Double.compare(
                        a2.getMaterias().stream()
                                .mapToDouble(Materia::getPuntos)
                                .max().orElse(0),
                        a1.getMaterias().stream()
                                .mapToDouble(Materia::getPuntos)
                                .max().orElse(0)))
                .toList();
    }

    // eliminar alumnos
    public void delete(String numCuenta) {
        this.repository.delete(numCuenta);
    }

    // actualizar la materia de un alumno

    public void update(String numCuneta, Alumno alumno) {
        this.repository.update(numCuneta, alumno);
    }
    
}
