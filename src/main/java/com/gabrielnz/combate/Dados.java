package com.gabrielnz.combate;

import java.util.Random;

public class Dados {
    private int dadoClasse;
    private static final Integer d20 = 20;
    private static final Integer d16 = 16;
    private static final Integer d12 = 12;
    private static final Integer d8 = 8;
    private static final Integer d6 = 6;
    private static final Integer d4 = 4;
    private static final Integer d3 = 3;
    private static final Integer d2 = 2;

    public static Random r = new Random();

    public Dados(int dado) {
        dadoClasse = dado;
    }

    public int dadoClasse() {
        return r.nextInt(dadoClasse) + 1;
    }
    public int dadoPersonalizado(int dado) {
        return r.nextInt(dado) + 1;
    }

    public static Integer d20() {
        return r.nextInt(d20) + 1;
    }

    public static Integer d16() {
        return r.nextInt(d16) + 1;
    }

    public static Integer d12() {
        return r.nextInt(d12) + 1;
    }

    public static Integer d8() {
        return r.nextInt(d8) + 1;
    }

    public static Integer d6() {
        return r.nextInt(d6) + 1;
    }

    public static Integer d4() {
        return r.nextInt(d4) + 1;
    }
    public static Integer d3() {
        return r.nextInt(d3) + 1;
    }
    public static Integer d2() {
        return r.nextInt(d2) + 1;
    }

    public int getDadoClasse() {
        return dadoClasse;
    }

    public void setDadoClasse(int dadoClasse) {
        this.dadoClasse = dadoClasse;
    }
}
