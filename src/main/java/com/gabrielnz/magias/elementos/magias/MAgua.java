package com.gabrielnz.magias.elementos.magias;

import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

public class MAgua extends MagiaElemento {
    public MAgua() {
        this.nomeMagia1 = "Jato de Agua";
        this.nomeMagia2 = "Bolha Defensiva";
        this.nomeMagia3 = "Toque De Poseidon";
    }

    public void magia1(Jogador jogador, Monstro monstro) {
        int manaGasto = 5;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║           💧 JATO DE ÁGUA 💧           ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  Você canaliza a força das águas e     ║");
            System.out.println("║  dispara um poderoso jato!             ║");
            System.out.println("║  Dano = Mana Maxima/9 🔮               ║");
            System.out.println("║                                        ║");
            System.out.printf("║  Mana gasto: %-3d                      ║\n", manaGasto);
            System.out.println("╚════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int dano = (jogador.getManaMax() / 9) + jogador.getDano();
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
            }
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║   💧 DANO CAUSADO: 💀       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔮 Dano Base: %-2d             ║%n", jogador.getDano());
            if (monstro.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", monstro.getArmadura().getValorArmadura());
            }
            System.out.printf("║ 💧 Dano Total: %-2d            ║%n", dano);
            System.out.println("╚══════════════════════════════╝");
            jogador.setMagiaLancada(true);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }

    public void magia2(Jogador jogador, Monstro monstro) {
        int manaGasto = 12;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║           💧 BOLHA DEFENSIVA 💧            ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  Uma bolha protetora se forma ao seu redor,║");
            System.out.println("║  protegendo você de ataques inimigos!      ║");
            System.out.println("║  Vida restaurada com base na mana          ║");
            System.out.println("║  Cura = Mana Maxima/4 🔮                   ║");
            System.out.println("║                                            ║");
            System.out.printf("║  Mana gasto: %-3d                          ║\n", manaGasto);
            System.out.println("╚════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int cura = jogador.getMana() / 4;
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

    public void magia3(Jogador jogador, Monstro monstro) {
        int manaGasto = 30;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔═══════════════════════════════════════════════╗");
            System.out.println("║           💧 TOQUE DE POSEIDON 💧             ║");
            System.out.println("╠═══════════════════════════════════════════════╣");
            System.out.println("║  Você invoca a benção dos mares, e com        ║");
            System.out.println("║  um toque, restaura vida com a força da água! ║");
            System.out.println("║  Vida restaurada com base na mana             ║");
            System.out.println("║  Cura = Mana Maxima/2 🔮                      ║");
            System.out.println("║                                               ║");
            System.out.printf("║  Mana gasto: %-3d                             ║\n", manaGasto);
            System.out.println("╚═══════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int cura = jogador.getMana() / 2;
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
}
