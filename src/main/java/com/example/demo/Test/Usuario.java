package com.example.demo.Test;


public class Usuario {
    private final String nombre;
    private final int edad;

    // Constructor para inicializar los valores
    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Solo getters, no setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}


