package com.sti.com;

public class Persona {




    // Variable estática para contar personas
    private static int contadorPersonas = 0;

    // Constructor
    public Persona() {

        contadorPersonas++;
    }





    public static void contarPersonas() {
        System.out.println("Se han creado " + contadorPersonas + " personas.");
    }


}
