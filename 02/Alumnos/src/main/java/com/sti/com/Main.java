package com.sti.com;

import com.sti.com.model.Alumno;
import com.sti.com.model.Materia;
import com.sti.com.repositories.AlumnosRepositoryImpl;
import com.sti.com.service.AlumnosService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlumnosRepositoryImpl repository = new AlumnosRepositoryImpl();
        AlumnosService service = new AlumnosService(repository);

        //1) lista de alumnos (vació)
        printTable(service.getAll());
        //2) agregar alumnos
        //crear la materia
        /*
        *
        * */
        Materia materia = new Materia("0001", 1L, "Filosofía", 60.5);
        Materia materia1 = new Materia("0001", 2L, "Mat", 75.1);
        Alumno alumno = new Alumno("Informatica", "Ciudad Universitaria", "FM",
                35, List.of(materia, materia1),
                "Jose Ramos", "0001");
        service.save(alumno);
        /*
         * */
        Materia materia2 = new Materia("0002", 1L, "Filosofía", 85);
        Materia materia3 = new Materia("0002", 2L, "Mat", 80);
        Alumno alumno2 = new Alumno("Informatica", "Ciudad Universitaria", "FM",
                25, List.of(materia2, materia3),
                "Luis Martinez", "0002");
        service.save(alumno2);

        //3) obtener los alumnos filtrados edad y centro de estudio
        String ce = "Ciudad Universitaria";
        int edadFilter = 35;
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Alumnos filtrados por edad y Centro de Estudio ");
        List<Alumno> alumnosFiltered = service.filterByAgeAndCE(edadFilter, ce);
        printTable(alumnosFiltered);
        //4) obtener alumnos por materia y puntuación más alta
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Alumnos filtrados por Materia");
        List<Alumno> alumnosByMat = service.filterByMatAndHighestRange("Filosofía");
        printTable(alumnosByMat);
        //5) lista de alumnos (con datos)
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Lista de Alumnos");
        printTable(service.getAll());
        //6) poder eliminar un alumno por número de cuenta
        service.delete("0001");

    }


    public static void printTable(List<Alumno> alumnos) {
        if(alumnos == null || alumnos.isEmpty()) {
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("No hay Alumnos");
            System.out.println("----------------------------------------------------------------------------------------------------");
            return;
        }
        // Header for Alumno table
        System.out.printf("%-15s %-20s %-5s %-20s %-20s %-20s%n",
                "#Cuenta", "Nombre", "Edad", "Carrera", "Departamento", "Centro Estudio");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Alumno alumno : alumnos) {
            // Row for Alumno details
            System.out.printf("%-15s %-20s %-5d %-20s %-20s %-20s%n",
                    alumno.getNumCuenta(),
                    alumno.getNombre(),
                    alumno.getEdad(),
                    alumno.getCarrera(),
                    alumno.getDepartamento(),
                    alumno.getCentroEstudio());

            // Sub-table header for Materias
            System.out.printf("%5s %-20s %-10s%n", "", "Materias", "Puntos");
            System.out.printf("%5s %-20s %-10s%n", "", "--------------", "------");

            for (Materia materia : alumno.getMaterias()) {
                // Row for Materia details
                System.out.printf("%15s %16.2f%n",
                        materia.getNombre(),
                        materia.getPuntos());
            }

            System.out.println();
        }
    }
}