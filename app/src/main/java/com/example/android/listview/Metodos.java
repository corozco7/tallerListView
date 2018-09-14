package com.example.android.listview;

public class Metodos {

    public static int areaCuadrado(int lado) {
        return lado*lado;
    }

    public static int areaRectangulo(int base, int altura) {
        return base * altura;
    }

    public static int areaTriangulo(int base, int altura) {
        return (base * altura) / 2;
    }

    public static double areaCirculo(int radio){
        return radio * radio * Math.PI;
    }

}
