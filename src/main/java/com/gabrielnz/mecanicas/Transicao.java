package com.gabrielnz.mecanicas;

import java.util.Scanner;

public class Transicao {
    public static Scanner ler = new Scanner(System.in);

    public static void transicao() {
        System.out.println();
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║       Pressione qualquer botão        ║");
        System.out.println("╚═══════════════════════════════════════╝");
        String linha = ler.next();
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

        public static void transicaolinha () {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }