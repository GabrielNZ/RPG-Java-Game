package com.gabrielnz.magias.classes;

import com.gabrielnz.combate.Atacar;
import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

public class MagiaGuerreiro {
    public void magia1(Jogador jogador, Monstro monstro) {
        int manaGasto = 10;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔═════════════════════════════════════════════╗");
            System.out.println("║           ⚔️ Espada da Furia 💢             ║");
            System.out.println("╠═════════════════════════════════════════════╣");
            System.out.println("║  Você transforma toda a sua ira e raiva em  ║");
            System.out.println("║  sua espada, dobrando seu dano base no      ║");
            System.out.println("║  proximo round. (Pula esse round)           ║");
            System.out.println("║  Dano Base = Dano Base X 2 ⚔️               ║");
            System.out.println("║                                             ║");
            System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto);
            System.out.println("╚═════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            jogador.setDanoBaseExtra(jogador.getDano());
            jogador.setMagiaLancada(true);
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     ⚔️ EFEITO ATIVADO! 💀    ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 💢 Dano Base Critico +       ║");
            System.out.println("╚══════════════════════════════╝");
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
            System.out.println("║             ⚔️ Mana em Dano 💢              ║");
            System.out.println("╠═════════════════════════════════════════════╣");
            System.out.println("║  Com sangue nos olhos, metade de sua mana   ║");
            System.out.println("║  se torna furia, ignorando parte da armadura║");
            System.out.println("║  de seu inimigo                             ║");
            System.out.println("║  Armadura Ignorada = Mana / 2 🔮            ║");
            System.out.println("║                                             ║");
            System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto);
            System.out.println("╚═════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            jogador.setArmaduraIgnoaradaValor(jogador.getManaMax() / 2);
            jogador.setMagiaLancada(true);
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     ⚔️ EFEITO ATIVADO! 💀    ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 💢 Armadura Ignorada = %2d   ║",jogador.getArmaduraIgnoaradaValor());
            System.out.println("╚══════════════════════════════╝");
            Transicao.transicao();
        }else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }

    public void magia3(Jogador jogador, Monstro monstro) {
        int manaGasto = 30;
        if (jogador.getMana() >= manaGasto) {
            boolean iniciativa = false;
            System.out.println("╔═════════════════════════════════════════════╗");
            System.out.println("║          ⚔️ Frenesia de Ataque 💢           ║");
            System.out.println("╠═════════════════════════════════════════════╣");
            System.out.println("║  Atraves de toda a furia acumulada na       ║");
            System.out.println("║  batalha, dois ataques serao desferidos     ║");
            System.out.println("║  Ao ativar a habilidade atacara duas vezes  ║");
            System.out.println("║  tendo os mesmo efeitos de um ataque normal ║");
            System.out.println("║                                             ║");
            System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto);
            System.out.println("╚═════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            Transicao.transicao();
            Atacar atacar = new Atacar();
            atacar.atacarJogador(jogador, monstro, iniciativa);
            atacar.atacarJogador(jogador, monstro, iniciativa);
            jogador.setMagiaLancada(true);
        }else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }
}
