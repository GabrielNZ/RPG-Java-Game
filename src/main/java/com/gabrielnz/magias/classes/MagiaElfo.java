package com.gabrielnz.magias.classes;

import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

public class MagiaElfo {
    public void magia1(Jogador jogador, Monstro monstro) {
        int manaGasto = 10;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔═════════════════════════════════════════════╗");
            System.out.println("║          🏹 Flecha da Natureza 🌿           ║");
            System.out.println("╠═════════════════════════════════════════════╣");
            System.out.println("║  Você canaliza a força das natureza e       ║");
            System.out.println("║  dispara uma flecha encantada com energia   ║");
            System.out.println("║  natural roubando a força vital do alvo     ║");
            System.out.println("║  Cura = Dano Base 🔮                        ║");
            System.out.println("║                                             ║");
            System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto);
            System.out.println("╚═════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int cura = jogador.getDano();
            jogador.setVida(jogador.getVida() + cura);
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║   💧 VIDA RECUPERADA: 💀     ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔮 Mana Base: %-2d           ║%n", jogador.getManaMax());
            System.out.printf("║ 💧 Cura Total: %-2d          ║%n", cura);
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
            int manaGasto2 = 20;
            System.out.println("╔═════════════════════════════════════════════╗");
            System.out.println("║            🏹 Flecha de Mana 🌿             ║");
            System.out.println("╠═════════════════════════════════════════════╣");
            System.out.println("║  Você transforma a força da natureza em mana║");
            System.out.println("║  pura e a coloca em sua flecha. Disparando-a║");
            System.out.println("║  contra seu alvo.                           ║");
            System.out.println("║  Dano = Mana Base 🔮                        ║");
            System.out.println("║                                             ║");
            System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto);
            System.out.println("╚═════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int dano = jogador.getManaMax();
            if (monstro.isArmaduraIgnore()) {
                monstro.setVida(monstro.getVida() - dano);
                monstro.setArmaduraIgnore(false);
            } else {
                if (monstro.getArmadura() != null) {
                    dano -= monstro.getArmadura().getValorArmadura();
                } else {
                    monstro.setVida(monstro.getVida() - dano);
                }
                if (dano < 0) {
                    dano = 0;
                }
                monstro.setVida(monstro.getVida() - dano);
            }
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║   🏹 DANO CAUSADO: 💀       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔮 Dano Base: %-2d             ║%n", jogador.getDano());
            if (monstro.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", monstro.getArmadura().getValorArmadura());
            }
            System.out.printf("║ 🌿 Dano Total: %-2d            ║%n", dano);
            System.out.println("╚══════════════════════════════╝");
            jogador.setMagiaLancada(true);
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
            System.out.println("║       🏹 Encantamento da Natureza 🌿        ║");
            System.out.println("╠═════════════════════════════════════════════╣");
            System.out.println("║  Você canaliza a força das natureza e       ║");
            System.out.println("║  descarrega essa energia toda em sua proxima║");
            System.out.println("║  flecha, aumentando seu dano.               ║");
            System.out.println("║  Dano = Critico ⚔️                          ║");
            System.out.println("║                                             ║");
            System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto);
            System.out.println("╚═════════════════════════════════════════════╝");
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     🏹 EFEITO ATIVADO! 💀    ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 🌿 Critico sera GARANTIDO!   ║");
            System.out.println("╚══════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            jogador.setMagiaLancada(true);
            jogador.setCriticoGarantido(true);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }
}
