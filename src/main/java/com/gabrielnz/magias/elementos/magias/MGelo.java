package com.gabrielnz.magias.elementos.magias;

import com.gabrielnz.magias.LivroMagia;
import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

public class MGelo extends MagiaElemento {
    public MGelo() {
        this.nomeMagia1 = "Rajada de Gelo";
        this.nomeMagia2 = "Toque Congelante";
        this.nomeMagia3 = "Prisao de Gelo";
    }

    public void magia1(Jogador jogador, Monstro monstro) {
        int manaGasto = 4;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║          ❄️ RAJADA DE GELO ❄️          ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  Uma rajada cortante de gelo é lançada,║");
            System.out.println("║  congelando tudo em seu caminho!       ║");
            System.out.println("║  Dano = Mana Maxima/10 🔮               ║");
            System.out.println("║                                        ║");
            System.out.printf("║  Mana gasto: %-3d                      ║\n", manaGasto);
            System.out.println("╚════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int dano = (jogador.getManaMax() / 10) + jogador.getDano();
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
            System.out.println("║   ❄️ DANO CAUSADO: 💀       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔮 Dano Base: %-2d             ║%n", jogador.getDano());
            if (monstro.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", monstro.getArmadura().getValorArmadura());
            }
            System.out.printf("║ ❄️ Dano Total: %-2d            ║%n", dano);
            System.out.println("╚══════════════════════════════╝");
            jogador.setMagiaLancada(true);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }

    public void magia2(Jogador jogador, Monstro monstro) {
        int manaGasto = 17;
        if (jogador.getMana() >= manaGasto) {
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║         ❄️ TOQUE CONGELANTE ❄️           ║");
            System.out.println("╠══════════════════════════════════════════╣");
            System.out.println("║  Com um toque gélido, você congela seu   ║");
            System.out.println("║  inimigo, retardando seu movimento!      ║");
            System.out.println("║  Proximo round do monstro sera pulado    ║");
            System.out.println("║  Dano = Mana Maxima/7                    ║");
            System.out.println("║                                          ║");
            System.out.printf("║  Mana gasto: %-3d                        ║\n", manaGasto);
            System.out.println("╚══════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int dano = (jogador.getManaMax() / 7) + jogador.getDano();
            monstro.setCongelado(true);
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
            System.out.println("║   ❄️ DANO CAUSADO: 💀       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔮 Dano Base: %-2d             ║%n", jogador.getDano());
            if (monstro.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", monstro.getArmadura().getValorArmadura());
            }
            System.out.printf("║ ❄️ Dano Total: %-2d            ║%n", dano);
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
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("║         ❄️ PRISÃO DE GELO ❄️              ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║  Você invoca correntes de gelo, prendendo ║");
            System.out.println("║  o inimigo em uma armadilha congelante!   ║");
            System.out.println("║  ignorando sua armadura no proximo round! ║");
            System.out.println("║  Dano = Mana Maxima/7 🔮                  ║");
            System.out.println("║                                           ║");
            System.out.printf("║  Mana gasto: %-3d                         ║\n", manaGasto);
            System.out.println("╚═══════════════════════════════════════════╝");
            jogador.setMana(jogador.getMana() - manaGasto);
            int dano = (jogador.getManaMax() / 7) + jogador.getDano();
            if (monstro.isArmaduraIgnore()) {
                if (monstro.getArmadura() != null) {
                    dano -= monstro.getArmadura().getValorArmadura();
                } else {
                    monstro.setVida(monstro.getVida() - dano);
                }
                monstro.setArmaduraIgnore(false);
            } else {
                dano -= monstro.getArmadura().getValorArmadura();
                if (dano < 0) {
                    dano = 0;
                }
            }
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║   ❄️ DANO CAUSADO: 💀       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔮 Dano Base: %-2d             ║%n", jogador.getDano());
            if (monstro.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", monstro.getArmadura().getValorArmadura());
            }
            System.out.printf("║ ❄️ Dano Total: %-2d            ║%n", dano);
            System.out.println("╚══════════════════════════════╝");
            monstro.setArmaduraIgnore(true);
            jogador.setMagiaLancada(true);
            Transicao.transicao();
        } else {
            System.out.println("Mana Insuficiente...");
            Transicao.transicao();
        }
    }
}
