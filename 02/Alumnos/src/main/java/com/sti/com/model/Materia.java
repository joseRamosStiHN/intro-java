package com.sti.com.model;

import java.util.Objects;

public class Materia {
    private Long id;
    private String nombre;
    private double puntos;
    private String alumnoCuenta;

    public Materia(){}

    public Materia(String alumnoCuenta, Long id, String nombre, double puntos) {
        this.alumnoCuenta = alumnoCuenta;
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getAlumnoCuenta() {
        return alumnoCuenta;
    }

    public void setAlumnoCuenta(String alumnoCuenta) {
        this.alumnoCuenta = alumnoCuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Double.compare(getPuntos(), materia.getPuntos()) == 0 && Objects.equals(getId(), materia.getId()) && Objects.equals(getNombre(), materia.getNombre()) && Objects.equals(getAlumnoCuenta(), materia.getAlumnoCuenta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getPuntos(), getAlumnoCuenta());
    }

    @Override
    public String toString() {
        return "Materia{" +
                "alumnoCuenta='" + alumnoCuenta + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puntos=" + puntos +
                '}';
    }
}
