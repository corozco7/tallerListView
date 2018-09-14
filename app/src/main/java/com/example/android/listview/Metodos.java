package com.example.android.listview;

public class Metodos {

    public static double areaCuadrado(double lado) {
        return Math.pow(lado,2);
    }

    public static double areaRectangulo(double base, double altura) {
        return base * altura;
    }

    public static double areaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    public static double areaCirculo(double radio){
        return Math.pow(radio,2) * Math.PI;
    }

    public static double volumenEsfera(double radio){
        return Math.PI * Math.pow(radio,3)* 0.75;
    }

    public static double volumenCilindro (double radio, double altura){
        return Math.PI * Math.pow(radio,2) * altura;
    }

    public static double volumenCono (double radio, double altura){
        return Math.pow(3,-1) * Math.PI * Math.pow(radio,2) * altura;
    }

    public static double volumenCubo(double lado){
        return Math.pow(lado,3);
    }

}
