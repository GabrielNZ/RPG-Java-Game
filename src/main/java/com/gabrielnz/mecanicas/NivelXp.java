package com.gabrielnz.mecanicas;

import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

public class NivelXp {

    public void ganharXp(Monstro monstro, Jogador jogador) {
        System.out.println("╔════════════════╗");
        System.out.printf("║  XP GANHO: %-4d║%n", monstro.getXp());
        System.out.println("╚════════════════╝");
        jogador.setXp(jogador.getXp() + monstro.getXp());
        Transicao.transicao();
        atualizarNivel(jogador);
    }

    public void atualizarNivel(Jogador jogador) {

        if (jogador.getXp() > jogador.getXpNecessario()) {
            jogador.setXp(jogador.getXp() - jogador.getXpNecessario());
            jogador.setXpNecessario(jogador.getXpNecessario() + jogador.getXpNecessario() * 2);
            System.out.println("╔══════════════════════╗");
            System.out.println("║   🌟 LEVEL UP! 🌟    ║");
            System.out.println("╠══════════════════════╣");
            System.out.printf("║   Lv. %d  →  Lv. %d    ║%n", jogador.getNivel(), jogador.getNivel() + 1);
            System.out.println("╚══════════════════════╝");
            jogador.uparDeNivel(jogador);
        }
    }

    public static void grafic(Jogador jogador, int pontosDisponiveis) {
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║  📊 DISTRIBUIÇÃO DE ATRIBUTOS   ║");
        System.out.println("╠═════════════════════════════════╣");
        System.out.printf("║  ❤️  Vida: %-2d                   ║\n", jogador.getVidaMax());
        System.out.printf("║  ⚔️  Dano: %-2d                   ║\n", jogador.getDano());
        System.out.printf("║  🔮  Mana: %-2d                   ║\n", jogador.getManaMax());
        System.out.println("╠═════════════════════════════════╣");
        System.out.printf("║  🔹 Pontos disponíveis: %-2d      ║\n", pontosDisponiveis);
        System.out.println("╚═════════════════════════════════╝");
    }

}
