package com.gabrielnz.magias.classes;

import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

public class MagiaGoblin {
    public void magia1(Jogador jogador, Monstro monstro) {
        int manaGasto = 10;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔═══════════════════════════════════════════════╗");
            System.out.println("║               👹 Corte Sagaz 🗡️               ║");
            System.out.println("╠═══════════════════════════════════════════════╣");
            System.out.println("║  Atraves de um rapido corte voce acertara em  ║");
            System.out.println("║  cheio o inimigo no proximo round, somente    ║");
            System.out.println("║  caso seja o primeiro a atacar, contrario a   ║");
            System.out.println("║  isso, nao mudara nada. (Nao pula esse round) ║");
            System.out.println("║  (Caso o jogador nao tenha arma nada acontece)║");
            System.out.println("║  Dano Bonus = +1 Roll da Espada 🎲            ║");
            System.out.println("║                                               ║");
            System.out.printf("║  Custo de Mana: %-3d                           ║\n", manaGasto);
            System.out.println("╚═══════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     👹 EFEITO ATIVADO! 💀    ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 🗡️ Caso comece o turno!      ║");
            System.out.println("╚══════════════════════════════╝");
            jogador.setRollExtra(true);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }

    public void magia2(Jogador jogador, Monstro monstro) {
        int manaGasto = 20;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔═══════════════════════════════════════════════╗");
            System.out.println("║           👹 Ganancia por Poder 🗡️            ║");
            System.out.println("╠═══════════════════════════════════════════════╣");
            System.out.println("║  Ao imbuir sua espada com mana, voce          ║");
            System.out.println("║  acresenta parte de sua mana ao roll de       ║");
            System.out.println("║  sua espada no proximo round                  ║");
            System.out.println("║  (Nao pula esse round)                        ║");
            System.out.println("║  (Caso o jogador nao tenha arma nada acontece)║");
            System.out.println("║  Roll Extra = Mana Maxima / 5 🎲              ║");
            System.out.println("║                                               ║");
            System.out.printf("║  Custo de Mana: %-3d                           ║\n", manaGasto);
            System.out.println("╚═══════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            jogador.setValorDadoExtra(jogador.getManaMax()/5);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }

    public void magia3(Jogador jogador, Monstro monstro) {
        int manaGasto = 30;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔═════════════════════════════════════════════╗");
            System.out.println("║            👹 Roubo de Arma 🗡️              ║");
            System.out.println("╠═════════════════════════════════════════════╣");
            System.out.println("║  De forma sorrateira, voce rouba a arma de  ║");
            System.out.println("║  seu inimigo, fazendo com que ele ataque    ║");
            System.out.println("║  somente com o dano base e voce com a arma  ║");
            System.out.println("║  dele como dano extra                       ║");
            System.out.println("║  Dano Bonus = +1 Roll da Espada inimiga 🎲  ║");
            System.out.println("║                                             ║");
            System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto);
            System.out.println("╚═════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            monstro.setArmaRoubada(true);
            jogador.setArmaRoubada(true);
            jogador.setMagiaLancada(true);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }
}
