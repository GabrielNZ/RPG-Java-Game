package com.gabrielnz.combate;

import com.gabrielnz.magias.classes.MenuMagias;
import com.gabrielnz.mecanicas.NivelXp;
import com.gabrielnz.mecanicas.Recompensa;
import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Turno {
    public void turnoBatalha(Jogador jogador, Monstro monstro) {
        boolean congelado = false;
        boolean armaduraIgnore = false;
        Scanner ler = new Scanner(System.in);
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║          ⚔️ BATALHA COMEÇA! ⚔️         ║");
        System.out.println("╚════════════════════════════════════════╝");
        int dadoIniciativaJogador = Dados.d20() + jogador.getIniciativa();
        int dadoIniciativaMonstro = Dados.d20() + monstro.getIniciativa();
        if (dadoIniciativaJogador >= dadoIniciativaMonstro) {
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║ O jogador começa atacando! 👤  ║");
            System.out.println("║ Razão: Maior Iniciativa!       ║");
            System.out.println("╚════════════════════════════════╝");
        } else {
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║ O montros começa atacando! 🐲  ║");
            System.out.println("║ Razão: Maior Iniciativa!       ║");
            System.out.println("╚════════════════════════════════╝");
        }
        Transicao.transicao();
        Atacar atacar = new Atacar();
        NivelXp nivelXp = new NivelXp();
        for (int i = 1; i > 0; i++) {
            if(monstro.isArmaRoubada() && jogador.isArmaRoubada()){
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║     👹 EFEITO ATIVADO! 💀    ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║ 🗡️ Arma Roubada!             ║");
                System.out.println("╚══════════════════════════════╝");
            }
            if (jogador.isFugiu()) {
                break;
            }
            if (monstro.getVida() <= 0) {
                Recompensa recompensa = new Recompensa();
                jogador.setDanoExtraRound(0);
                System.out.println("╔══════════════════════════════════════╗");
                System.out.println("║      ⚔️ A BATALHA TERMINOU! ⚔️       ║");
                System.out.println("╠══════════════════════════════════════╣");
                System.out.println("║       🎉 O Jogador VENCEU! 🎉        ║");
                System.out.println("╚══════════════════════════════════════╝");
                telaBatalha(jogador, monstro);
                Transicao.transicao();
                nivelXp.ganharXp(monstro, jogador);
                jogador.adicionarOuro(monstro.getOuro(), jogador);
                Transicao.transicao();
                if (Dados.d20() > 6 - jogador.getIniciativa()) {
                    recompensa.recompensaBau(jogador);
                    Transicao.transicao();
                }
                break;
            } else if (jogador.getVida() <= 0) {
                jogador.setDanoExtraRound(0);
                System.out.println("╔══════════════════════════════════════╗");
                System.out.println("║      ⚔️ A BATALHA TERMINOU! ⚔️       ║");
                System.out.println("╠══════════════════════════════════════╣");
                System.out.println("║       💀 O Jogador PERDEU! 💀        ║");
                System.out.println("╚══════════════════════════════════════╝");
                telaBatalha(jogador, monstro);
                Transicao.transicao();
                break;
            }
            if(jogador.isFugiu()){
                jogador.recuperarStatus(jogador);
                Transicao.transicao();
                break;
            }
            telaTurno(jogador, monstro, i);
            telaBatalha(jogador, monstro);
            Transicao.transicao();
            if (dadoIniciativaJogador >= dadoIniciativaMonstro) {
                boolean iniciativa = true;
                do {
                    try {
                        boolean proxturno = false;
                        Transicao.transicaolinha();
                        telaAcao(jogador);
                        int escolha = ler.nextInt();
                        switch (escolha) {
                            case 1:
                                atacar.atacarJogador(jogador, monstro, iniciativa);
                                proxturno = true;
                                break;
                            case 2:
                                if (jogador.getLivroMagia() != null) {
                                    jogador.getLivroMagia().mostrarLivro(jogador, monstro);
                                }else{
                                    MenuMagias menuMagias = new MenuMagias();
                                    menuMagias.telaMagias(jogador, monstro);
                                }
                                if (jogador.isMagiaLancada()) {
                                    proxturno = true;
                                    jogador.setMagiaLancada(false);
                                }
                                break;
                            case 3:
                                jogador.getInventarioJogador().manipularInventario(jogador);
                                break;
                            case 4:
                                fugir(jogador, monstro);
                                proxturno = true;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                Transicao.transicao();
                        }
                        if (proxturno) {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        Transicao.transicaolinha();
                        System.out.println("Digite um valor valido");
                        Transicao.transicao();
                    }
                } while (true);
                if(jogador.isFugiu()){
                    jogador.recuperarStatus(jogador);
                    break;
                }
                if (monstro.getVida() <= 0) {
                    continue;
                }
                Transicao.transicaolinha();
                if (monstro.isCongelado()) {
                    System.out.println("╔══════════════════════════════════════╗");
                    System.out.println("║         ❄️ ALVO CONGELADO! ❄️       ║");
                    System.out.println("╠══════════════════════════════════════╣");
                    System.out.println("║   O inimigo está completamente       ║");
                    System.out.println("║      congelado e incapaz de agir!    ║");
                    System.out.println("║          (Turno pulado)              ║");
                    System.out.println("╚══════════════════════════════════════╝");
                    monstro.setCongelado(false);
                } else {
                    telaMonstro();
                    Transicao.transicao();
                    atacar.atacarMonstro(jogador, monstro, iniciativa);
                }
            }
            if (dadoIniciativaJogador < dadoIniciativaMonstro) {
                boolean iniciativa = false;
                if (monstro.isCongelado()) {
                    System.out.println("╔══════════════════════════════════════╗");
                    System.out.println("║         ❄️ ALVO CONGELADO! ❄️       ║");
                    System.out.println("╠══════════════════════════════════════╣");
                    System.out.println("║   O inimigo está completamente       ║");
                    System.out.println("║      congelado e incapaz de agir!    ║");
                    System.out.println("║          (Turno pulado)              ║");
                    System.out.println("╚══════════════════════════════════════╝");
                    monstro.setCongelado(false);
                } else {
                    telaMonstro();
                    Transicao.transicao();
                    atacar.atacarMonstro(jogador, monstro, iniciativa);
                }
                if (jogador.getVida() <= 0) {
                    continue;
                }
                do {
                    try {
                        boolean proxturno = false;
                        Transicao.transicaolinha();
                        telaAcao(jogador);
                        int escolha = ler.nextInt();
                        switch (escolha) {
                            case 1:
                                atacar.atacarJogador(jogador, monstro, iniciativa);
                                proxturno = true;
                                break;
                            case 2:
                                if (jogador.getLivroMagia() != null) {
                                    jogador.getLivroMagia().mostrarLivro(jogador, monstro);
                                }else{
                                    MenuMagias menuMagias = new MenuMagias();
                                    menuMagias.telaMagias(jogador, monstro);
                                }
                                if (jogador.isMagiaLancada()) {
                                    proxturno = true;
                                    jogador.setMagiaLancada(false);
                                }
                                break;
                            case 3:
                                jogador.getInventarioJogador().manipularInventario(jogador);
                                break;
                            case 4:
                                fugir(jogador, monstro);
                                proxturno = true;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                Transicao.transicao();
                        }
                        if (proxturno) {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        Transicao.transicaolinha();
                        System.out.println("Digite um valor valido");
                        Transicao.transicao();
                    }
                } while (true);
            }
        }
    }

    public void telaAcao(Jogador jogador) {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║        ⚔️ AÇÃO DO JOGADOR          ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ Escolha uma ação:                  ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. 💥 Atacar                       ║");
        System.out.println("║ 2. 🔮 Magia/Livro                  ║");
        System.out.println("║ 3. 💼 Abrir Inventário             ║");
        System.out.println("║ 4. 🏃‍ Fugir                        ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ Escolha uma opção (1-4):           ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("Mana atual: "+jogador.getMana());
    }

    public void telaTurno(Jogador jogador, Monstro monstro, int turno) {
        System.out.println("╔════════════════════════════════════╗");
        System.out.printf("║          🔄 TURNO %-2d               ║\n", turno);
        System.out.println("╠════════════════════════════════════╣");
        System.out.printf("║ 📌 Jogador: %-20s   ║\n", jogador.getNome());
        System.out.printf("║ ⚔️ Monstro: %-20s   ║\n", monstro.getNome());
        System.out.println("╚════════════════════════════════════╝");

    }

    public void telaBatalha(Jogador jogador, Monstro monstro) {
        if (jogador.getArmadura() == null && monstro.getArmadura() != null) {
            System.out.println("╔═════════════════════════════════════╗");
            System.out.println("║            👤 Jogador               ║");
            System.out.printf("║ 🩸 Vida: %-2d   💥 Dano: %-2d          ║\n", jogador.getVida(), jogador.getDano());
            System.out.printf("║ 🔮 Mana: %-2d                          ║\n", jogador.getMana());
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║            👹 Monstro                ║");
            System.out.printf("║ 🩸 Vida: %-2d   💥 Dano: %-2d          ║\n", monstro.getVida(), monstro.getDano());
            System.out.printf("║ 🛡️ Resistência: %-2d                   ║\n", monstro.getArmadura().getValorArmadura());
            System.out.println("╚══════════════════════════════════════╝");
        } else if (jogador.getArmadura() == null && monstro.getArmadura() == null) {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║            👤 Jogador                ║");
            System.out.printf("║ 🩸 Vida: %-2d   💥 Dano: %-2d            ║\n", jogador.getVida(), jogador.getDano());
            System.out.printf("║ 🔮 Mana: %-2d                          ║\n", jogador.getMana());
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║            👹 Monstro                ║");
            System.out.printf("║ 🩸 Vida: %-2d   💥 Dano: %-2d            ║\n", monstro.getVida(), monstro.getDano());
            System.out.println("╚══════════════════════════════════════╝");
        } else if (monstro.getArmadura() == null && jogador.getArmadura() != null) {
            System.out.println("╔═════════════════════════════════════╗");
            System.out.println("║            👤 Jogador               ║");
            System.out.printf("║ 🩸 Vida: %-2d   💥 Dano: %-2d           ║\n", jogador.getVida(), jogador.getDano());
            System.out.printf("║ 🔮 Mana: %-2d   🛡️ Resistência: %-2d    ║\n", jogador.getMana(), jogador.getArmadura().getValorArmadura());
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║            👹 Monstro                ║");
            System.out.printf("║ 🩸 Vida: %-2d   💥 Dano: %-2d            ║\n", monstro.getVida(), monstro.getDano());
            System.out.println("╚══════════════════════════════════════╝");
        } else if (jogador.getArmadura() != null && monstro.getArmadura() != null) {
            System.out.println("╔═════════════════════════════════════╗");
            System.out.println("║            👤 Jogador               ║");
            System.out.printf("║ 🩸 Vida: %-2d   💥 Dano: %-2d          ║\n", jogador.getVida(), jogador.getDano());
            System.out.printf("║ 🔮 Mana: %-2d   🛡️ Resistência: %-2d  ║\n", jogador.getMana(), jogador.getArmadura().getValorArmadura());
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║            👹 Monstro                ║");
            System.out.printf("║ 🩸 Vida: %-2d   💥 Dano: %-2d          ║\n", monstro.getVida(), monstro.getDano());
            System.out.printf("║ 🛡️ Resistência: %-2d                   ║\n", monstro.getArmadura().getValorArmadura());
            System.out.println("╚══════════════════════════════════════╝");
        }

    }


    public void fugir(Jogador jogador, Monstro monstro) {
        Transicao.transicaolinha();
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║          🚪 FUGIR? 🏃‍♂️          ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║        🍀 Boa Sorte! 🍀        ║");
        System.out.println("╚════════════════════════════════╝");
        Transicao.transicao();
        do {
            int monstrodado = Dados.d20() + monstro.getIniciativa();
            int jogadordado = Dados.d20() + jogador.getIniciativa();

            if (jogadordado > monstrodado) {
                System.out.println("╔════════════════════════════════╗");
                System.out.println("║        🚪 VOCÊ FUGIU! 🏃‍♂️       ║");
                System.out.println("╠════════════════════════════════╣");
                System.out.println("║  Você escapou da batalha...    ║");
                System.out.println("╚════════════════════════════════╝");
                jogador.setFugiu(true);
                break;
            } else if (jogadordado < monstrodado) {
                System.out.println("╔════════════════════════════════╗");
                System.out.println("║      ❌ VOCÊ NÃO FUGIU! ❌     ║");
                System.out.println("╠════════════════════════════════╣");
                System.out.println("║  O inimigo foi mais rápido...  ║");
                System.out.println("║  Prepare-se para lutar! ⚔️     ║");
                System.out.println("╚════════════════════════════════╝");
                break;
            } else {
                continue;
            }
        } while (true);
    }

    public void telaMonstro() {
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║    🐲 AÇÃO DO MONSTRO! 🐲      ║");
        System.out.println("╚════════════════════════════════╝");
    }
}
