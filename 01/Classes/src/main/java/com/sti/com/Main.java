package com.sti.com;

import com.sti.com.fibo.Fibo;

public class Main {


    public static void main(String[] args) {
//        Persona.contarPersonas();
//
//        Persona p1 = new Persona();
//        Persona p2 = new Persona();
//        Persona p3 = new Persona();
//
//        Persona.contarPersonas();


        Fibo f = new Fibo();
        System.out.println( f.fibonacciMemo(10));


    }


}