package com.gabrielnz.combate;

import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

public class Atacar {

    public void atacarJogador(Jogador jogador, Monstro monstros, boolean iniciativa) {
        do {
            int monstrodado = Dados.d20();
            int jogadordado = Dados.d20();

            System.out.println("╔══════════════════════════════╗");
            System.out.println("║  ⚔️  ATAQUE REALIZADO!  ⚔️  ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🎲 D20 rolado: %-2d            ║%n", jogadordado);
            System.out.println("╚══════════════════════════════╝");
            defesaMonstro(monstrodado);
            if (monstrodado == jogadordado) {
                System.out.println("Valores iguais! Recalculando...");
                Transicao.transicao();
                continue;
            }
            Transicao.transicao();
            if (jogadordado == 20 || jogador.isCriticoGarantido()) {
                jogador.setCriticoGarantido(false);
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║ 💥 Acerto Crítico!           ║");
                System.out.println("╚══════════════════════════════╝");
                danoJogador(jogador, monstros, true, iniciativa);
                break;
            }
            if (jogadordado == 1) {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║ ❌ Falha Crítica!            ║");
                System.out.println("╚══════════════════════════════╝");
                System.out.println("Ataque extra do monstro!");
                danoMonstro(jogador, monstros, false);
                break;
            }
            if (monstrodado == 20) {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║ 🛡️ Contra Ataque!            ║");
                System.out.println("╚══════════════════════════════╝");
                System.out.println("Ataque extra do monstro!");
                danoMonstro(jogador, monstros, false);
                break;
            }
            if (jogadordado > monstrodado) {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║ ✅ Ataque Acertado!          ║");
                System.out.println("╚══════════════════════════════╝");
                danoJogador(jogador, monstros, false, iniciativa);
                break;
            } else {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║ ❗ Ataque Desviado...        ║");
                System.out.println("╚══════════════════════════════╝");
                Transicao.transicao();
                break;
            }
        } while (true);
    }

    public void atacarMonstro(Jogador jogador, Monstro monstros, boolean iniciativa) {
        do {
            int monstrodado = Dados.d20();
            int jogadordado = Dados.d20();
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║  🐲 ATAQUE DO MONSTRO!  ⚔️  ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🎲 D20 rolado: %-2d            ║%n", monstrodado);
            System.out.println("╚══════════════════════════════╝");
            defesaJogador(jogadordado);

            if (monstrodado == jogadordado) {
                System.out.println("Valores iguais! Recalculando...");
                Transicao.transicao();
                continue;
            }
            Transicao.transicao();
            if (monstrodado == 20) {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║ 💥 Acerto Crítico!           ║");
                System.out.println("╚══════════════════════════════╝");
                danoMonstro(jogador, monstros, true);
                break;
            }
            if (monstrodado == 1) {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║ ❌ Falha Crítica!            ║");
                System.out.println("╚══════════════════════════════╝");
                System.out.println("Ataque extra do jogador!");
                Transicao.transicao();
                danoJogador(jogador, monstros, false, iniciativa);
                break;
            }
            if (jogadordado == 20) {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║ 🛡️ Contra Ataque!            ║");
                System.out.println("╚══════════════════════════════╝");
                System.out.println("Ataque extra do jogador!");
                danoJogador(jogador, monstros, false, iniciativa);
                break;
            }
            if (monstrodado > jogadordado) {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║ ✅ Ataque Acertado!          ║");
                System.out.println("╚══════════════════════════════╝");
                danoMonstro(jogador, monstros, false);
                break;
            } else {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║ ❗ Ataque Desviado...        ║");
                System.out.println("╚══════════════════════════════╝");
                Transicao.transicao();
                break;
            }
        } while (true);
    }

    public void defesaJogador(int defesaJogador) {

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║   🛡️ DEFESA DO JOGADOR!  ⚔️  ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.printf("║ 🎲 D20 rolado: %-2d            ║%n", defesaJogador);
        System.out.println("╚══════════════════════════════╝\n");
    }

    public void defesaMonstro(int defesaMonstro) {

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║   🦴 DEFESA DO MONSTRO!  🛡️  ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.printf("║ 🎲 D20 rolado: %-2d            ║%n", defesaMonstro);
        System.out.println("╚══════════════════════════════╝");
    }

    public void danoJogador(Jogador jogador, Monstro monstro, boolean crit, boolean iniciativa) {
        int dano = 0;
        int dado;
        int dadoExtra = 0;
        int dadoExtraMonstro = 0;
        if (jogador.getArma() != null) {
            if(jogador.getValorDadoExtra() > 0){
                dado = jogador.getArma().getDado().dadoPersonalizado(jogador.getArma().getDado().dadoClasse()+jogador.getValorDadoExtra());
            }
            dado = jogador.getArma().getDado().dadoClasse();
            if(jogador.isArmaRoubada()){
                dadoExtraMonstro += monstro.getArma().getDado().dadoClasse();
                dado += dadoExtraMonstro;
            }
            if (jogador.isRollExtra()) {
                dadoExtra = jogador.getArma().getDado().dadoClasse();
                dado += dadoExtra;
            }
            dano = dado + jogador.getDano() + jogador.getDanoBaseExtra() + jogador.getDanoExtraRound();

            if (crit) {
                dano *= 2;
            }
            if (monstro.isArmaduraIgnore()) {
                monstro.setArmaduraIgnore(false);
            } else if (monstro.getArmadura() != null) {
                dano -= monstro.getArmadura().getValorArmadura() - jogador.getArmaduraIgnoaradaValor();
            }
            if (dano < 0) {
                dano = 0;
            }
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     💥 DANO CAUSADO: 💀      ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🎲 D%-2d rolado: %-2d            ║%n", jogador.getArma().getDado().getDadoClasse()+jogador.getValorDadoExtra(), dado);
            if (jogador.isRollExtra()) {
                System.out.printf("║ 🎲 D%-2d extra: %-2d             ║%n", jogador.getArma().getDado().getDadoClasse(), dadoExtra);
            }
            if(jogador.isArmaRoubada()){
                System.out.printf("║ 🎲 D%-2d extra: %-2d             ║%n", monstro.getArma().getDado().getDadoClasse(), dadoExtraMonstro);
            }
            System.out.printf("║ 🔥 Dano Base: %-2d             ║%n", jogador.getDano() + jogador.getDanoBaseExtra() + jogador.getDanoExtraRound());
            if (monstro.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", monstro.getArmadura().getValorArmadura());
            }
            if (jogador.getArmaduraIgnoaradaValor() > 0) {
                System.out.printf("║ 🛡️️ Resistencia ignorada: %-2d    ║%n", jogador.getArmaduraIgnoaradaValor());
            }
            System.out.printf("║ ⚔️ Dano Total: %-2d            ║%n", dano);
            System.out.println("╚══════════════════════════════╝");
            jogador.setRollExtra(false);
            jogador.setArmaRoubada(false);
            jogador.setDanoBaseExtra(0);
            jogador.setValorDadoExtra(0);
            monstro.setVida(monstro.getVida() - dano);
        } else {
            dano = jogador.getDano() + jogador.getDanoBaseExtra() + jogador.getDanoExtraRound();
            if (crit) {
                dano *= 2;
            }
            if (monstro.isArmaduraIgnore()) {
                monstro.setArmaduraIgnore(false);
            } else if (monstro.getArmadura() != null) {
                dano -= monstro.getArmadura().getValorArmadura() - jogador.getArmaduraIgnoaradaValor();
            }
            if (dano < 0) {
                dano = 0;
            }

            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     💥 DANO CAUSADO: 💀      ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔥 Dano Base: %-2d             ║%n", jogador.getDano() + jogador.getDanoBaseExtra() + jogador.getDanoExtraRound());
            if(jogador.isArmaRoubada()){
                dadoExtraMonstro = monstro.getArma().getDado().dadoClasse();
                System.out.printf("║ 🎲 D%-2d extra: %-2d             ║%n", monstro.getArma().getDado().getDadoClasse(), dadoExtraMonstro);
            }
            if (monstro.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", monstro.getArmadura().getValorArmadura());
            }
            if (jogador.getArmaduraIgnoaradaValor() > 0) {
                System.out.printf("║ 🛡️️ Resistencia ignorada: %-2d    ║%n", jogador.getArmaduraIgnoaradaValor());
            }
            System.out.printf("║ ⚔️ Dano Total: %-2d            ║%n", dano);
            System.out.println("╚══════════════════════════════╝");
            jogador.setDanoBaseExtra(0);
            monstro.setVida(monstro.getVida() - (dano + dadoExtraMonstro));
        }
        Transicao.transicao();
    }

    public void danoMonstro(Jogador jogador, Monstro monstro, boolean crit) {
        int dano = 0;
        int dado;
        if (monstro.isArmaRoubada()) {
            dano = monstro.getDano();
            if (crit) {
                dano *= 2;
            }
            if (jogador.getArmadura() != null) {
                dano -= jogador.getArmadura().getValorArmadura();
            }
            if (dano < 0) {
                dano = 0;
            }
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     💥 DANO CAUSADO: 💀      ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.printf("║ 🔥 Dano Base: %-2d             ║%n", monstro.getDano());
            if (jogador.getArmadura() != null) {
                System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d   ║%n", jogador.getArmadura().getValorArmadura());
            }
            System.out.printf("║ ⚔️ Dano Total: %-2d            ║%n", dano);
            System.out.println("╚══════════════════════════════╝");
            jogador.setVida(jogador.getVida() - dano);
            monstro.setArmaRoubada(false);
            Transicao.transicao();
        } else {
            if (monstro.getArma() != null) {
                dado = monstro.getArma().getDado().dadoClasse();
                dano = dado + monstro.getDano();
                if (crit) {
                    dano *= 2;
                }
                if (jogador.getArmadura() != null) {
                    dano -= jogador.getArmadura().getValorArmadura();
                }
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║     💥 DANO CAUSADO: 💀      ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.printf("║ 🎲 D%-2d rolado: %-2d            ║%n", monstro.getArma().getDado().getDadoClasse(), dado);
                System.out.printf("║ 🔥 Dano Base: %-2d             ║%n", monstro.getDano());
                if (jogador.getArmadura() != null) {
                    System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d    ║%n", jogador.getArmadura().getValorArmadura());
                }
                System.out.printf("║ ⚔️ Dano Total: %-2d            ║%n", dano);
                System.out.println("╚══════════════════════════════╝");
                jogador.setVida(jogador.getVida() - dano);
            } else {
                dano = monstro.getDano();
                if (crit) {
                    dano *= 2;
                }
                if (jogador.getArmadura() != null) {
                    dano -= jogador.getArmadura().getValorArmadura();
                }
                if (dano < 0) {
                    dano = 0;
                }
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║     💥 DANO CAUSADO: 💀      ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.printf("║ 🔥 Dano Base: %-2d             ║%n", monstro.getDano());
                if (jogador.getArmadura() != null) {
                    System.out.printf("║ 🛡️️ Resistencia do Alvo: %-2d   ║%n", jogador.getArmadura().getValorArmadura());
                }
                System.out.printf("║ ⚔️ Dano Total: %-2d            ║%n", dano);
                System.out.println("╚══════════════════════════════╝");
                jogador.setVida(jogador.getVida() - dano);
            }
            Transicao.transicao();
        }
    }
}

