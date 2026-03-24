package com.gabrielnz.magias.classes;

import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

public class MagiaGigante {
    public void magia1(Jogador jogador, Monstro monstro) {
        int manaGasto = 10;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔═════════════════════════════════════════════╗");
            System.out.println("║             🏔️ Soco Sísmico 👊              ║");
            System.out.println("╠═════════════════════════════════════════════╣");
            System.out.println("║  Você canaliza a força de sua vitalidade e  ║");
            System.out.println("║  transforma porcentagem de sua vida maxima  ║");
            System.out.println("║  em dano base extra no proximo ataque       ║");
            System.out.println("║  Dano bonus = Vida maxima /5 ❤️             ║");
            System.out.println("║                                             ║");
            System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto);
            System.out.println("╚═════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            jogador.setDanoBaseExtra(jogador.getVidaMax()/5);
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     🏔️ EFEITO ATIVADO! 💀    ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 👊  Dano bonus = %2d         ║",jogador.getVidaMax()/5);
            System.out.println("╚══════════════════════════════╝");
            jogador.setMagiaLancada(true);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }

    public void magia2(Jogador jogador, Monstro monstro) {
        int manaGasto = 20;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔═════════════════════════════════════════════╗");
            System.out.println("║            🏔️ Drenagem Vital 👊            ║");
            System.out.println("╠═════════════════════════════════════════════╣");
            System.out.println("║  Você sacrifica metade de sua vida atual em ║");
            System.out.println("║  dano bonus pelo resto da batalha           ║");
            System.out.println("║  Dano bonus = Vida / 2 ❤️                   ║");
            System.out.println("║                                             ║");
            System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto);
            System.out.println("╚═════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            Transicao.transicao();
            jogador.setDanoExtraRound(jogador.getVida()/2);
            jogador.setVida(jogador.getVida()/2);
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     🏔️ EFEITO ATIVADO! 💀    ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 👊  Dano bonus = %2d         ║",jogador.getDanoExtraRound());
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ ❤️  Vida atual = %2d         ║",jogador.getVida());
            System.out.println("╚══════════════════════════════╝");
            jogador.setDanoExtraRound(jogador.getVida()/2);
            jogador.setMagiaLancada(true);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }

    public void magia3(Jogador jogador, Monstro monstro) {
        int manaGasto = 30;
        if(jogador.getArmadura() != null) {
            if (jogador.getMana() >= manaGasto) {
                System.out.println("╔═════════════════════════════════════════════╗");
                System.out.println("║         🏔️ Resurgir das Montanhas 👊        ║");
                System.out.println("╠═════════════════════════════════════════════╣");
                System.out.println("║  Ao se fundir com o solo, voce recupera     ║");
                System.out.println("║  vida baseado em sua armadura.              ║");
                System.out.println("║  Cura = Armadura 🛡️                         ║");
                System.out.println("║                                             ║");
                System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto);
                System.out.println("╚═════════════════════════════════════════════╝");
                jogador.setMana(jogador.getMana() - manaGasto);
                int cura = jogador.getArmadura().getValorArmadura();
                jogador.setVida(jogador.getVida() + cura);
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║   🏔️ VIDA RECUPERADA: 💀     ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.printf("║ 🛡️ Armadura Base: %-2d       ║%n", jogador.getArmadura().getValorArmadura());
                System.out.printf("║ ❤️ Cura Total: %-2d          ║%n", cura);
                System.out.println("╚══════════════════════════════╝");
                jogador.setMagiaLancada(true);
                Transicao.transicao();
            } else {
                System.out.println("Mana Insuficiente...");
                Transicao.transicao();
            }
        }else{
            System.out.println("Jogador nao apresenta armadura");
            Transicao.transicao();
        }
    }
}
