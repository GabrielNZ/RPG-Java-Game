package com.gabrielnz.magias.elementos.magias;

import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

public class MFogo extends MagiaElemento {
    public MFogo() {
        this.nomeMagia1 = "Bola de Fogo";
        this.nomeMagia2 = "Laser De Fogo";
        this.nomeMagia3 = "Sol";
    }

    public void magia1(Jogador jogador, Monstro monstro) {
        int manaGasto = 7;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║           🔥 BOLA DE FOGO 🔥            ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║  Uma esfera flamejante se forma em suas ║");
            System.out.println("║  mãos e voa em direção ao inimigo!      ║");
            System.out.println("║  Dano = Mana Maxima/7 🔮                ║");
            System.out.println("║                                         ║");
            System.out.printf("║  Mana gasto: %-3d                        ║\n", manaGasto);
            System.out.println("╚═════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int dano = (jogador.getManaMax() / 7) + jogador.getDano();
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
            System.out.println("║   🔥 DANO CAUSADO: 💀       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔮 Dano Base: %-2d             ║%n", jogador.getDano());
            if (monstro.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", monstro.getArmadura().getValorArmadura());
            }
            System.out.printf("║ 🔥 Dano Total: %-2d            ║%n", dano);
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
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║            🔥 LASER DE FOGO 🔥            ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  Um feixe concentrado de chamas rasga o ar,║");
            System.out.println("║  atingindo seu inimigo com precisão!       ║");
            System.out.println("║  Dano = Mana Maxima/3 🔮                   ║");
            System.out.println("║                                            ║");
            System.out.printf("║  Mana gasto: %-3d                           ║\n", manaGasto);
            System.out.println("╚════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int dano = (jogador.getManaMax() / 3) + jogador.getDano();
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
            System.out.println("║   🔥 DANO CAUSADO: 💀       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔮 Dano Base: %-2d             ║%n", jogador.getDano());
            if (monstro.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", monstro.getArmadura().getValorArmadura());
            }
            System.out.printf("║ 🔥 Dano Total: %-2d            ║%n", dano);
            System.out.println("╚══════════════════════════════╝");
            jogador.setMagiaLancada(true);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }

    public void magia3(Jogador jogador, Monstro monstro) {
        int manaGasto = 35;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║                🔥 SOL 🔥                   ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  Você convoca o poder do sol, irradiando   ║");
            System.out.println("║  uma luz intensa que incinera seus inimigos║");
            System.out.println("║  e aquece os aliados!                      ║");
            System.out.println("║  Dano = Mana Maxima 🔮                     ║");
            System.out.println("║                                            ║");
            System.out.printf("║  Mana gasto: %-3d                           ║\n", manaGasto);
            System.out.println("╚════════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int dano = (jogador.getManaMax()) + jogador.getDano();
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
            System.out.println("║   🔥 DANO CAUSADO: 💀       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔮 Dano Base: %-2d             ║%n", jogador.getDano());
            if (monstro.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", monstro.getArmadura().getValorArmadura());
            }
            System.out.printf("║ 🔥 Dano Total: %-2d            ║%n", dano);
            System.out.println("╚══════════════════════════════╝");
            jogador.setMagiaLancada(true);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }
}
