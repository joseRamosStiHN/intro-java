package com.sti.com.model;

import java.util.List;
import java.util.Objects;

public class Alumno {

    private String numCuenta;
    private String nombre;
    private int edad;
    private String carrera;
    private String departamento;
    private String centroEstudio;

    private List<Materia> materias;

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCentroEstudio() {
        return centroEstudio;
    }

    public void setCentroEstudio(String centroEstudio) {
        this.centroEstudio = centroEstudio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return getEdad() == alumno.getEdad() && Objects.equals(getNumCuenta(), alumno.getNumCuenta()) && Objects.equals(getNombre(), alumno.getNombre()) && Objects.equals(getCarrera(), alumno.getCarrera()) && Objects.equals(getDepartamento(), alumno.getDepartamento()) && Objects.equals(getCentroEstudio(), alumno.getCentroEstudio()) && Objects.equals(getMaterias(), alumno.getMaterias());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumCuenta(), getNombre(), getEdad(), getCarrera(), getDepartamento(), getCentroEstudio(), getMaterias());
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "carrera='" + carrera + '\'' +
                ", numCuenta='" + numCuenta + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", departamento='" + departamento + '\'' +
                ", centroEstudio='" + centroEstudio + '\'' +
                ", materias=" + materias +
                '}';
    }
}
