package com.gabrielnz.ambientacao;

import com.gabrielnz.combate.Dados;
import com.gabrielnz.combate.Turno;
import com.gabrielnz.itens.Item;
import com.gabrielnz.itens.chave.Chave;
import com.gabrielnz.mecanicas.Recompensa;
import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.MonstroFactory;

import java.util.InputMismatchException;

import static com.gabrielnz.mecanicas.Transicao.ler;

public class Dungeon {
    public void entrarDungeon(Jogador jogador) {
        boolean temChave = jogador.getInventarioJogador().getInventario().stream().anyMatch(item -> item instanceof Chave);
        if (temChave) {
            for (Item item : jogador.getInventarioJogador().getInventario()) {
                if (item instanceof Chave) {
                    jogador.getInventarioJogador().getInventario().remove(item);
                    break;
                }
            }
        }

            System.out.println("Você tem certeza que deseja continuar?");
            System.out.println("[0]-Não");
            System.out.println("[1]-Sim");
            do {
            try {
                int escolha = ler.nextInt();
                if (escolha == 1) {
                    if (temChave) {
                        System.out.println("╔══════════════════════════════════╗");
                        System.out.println("║   🏰 ENTRANDO NA DUNGEON 🔑      ║");
                        System.out.println("╠══════════════════════════════════╣");
                        System.out.println("║ Você se aproxima do colossal     ║");
                        System.out.println("║ portão da masmorra, sentindo     ║");
                        System.out.println("║ um arrepio percorrer sua espinha.║");
                        System.out.println("║ Com um suspiro profundo, você    ║");
                        System.out.println("║ retira a chave do bolso e a      ║");
                        System.out.println("║ insere na fechadura.             ║");
                        System.out.println("╠══════════════════════════════════╣");
                        System.out.println("║ 🔓 *CLACK*... O portão range e   ║");
                        System.out.println("║ lentamente se abre, revelando    ║");
                        System.out.println("║ a escuridão e os mistérios que   ║");
                        System.out.println("║ aguardam lá dentro...            ║");
                        System.out.println("╚══════════════════════════════════╝");
                    } else {
                        System.out.println("╔════════════════════════════════════╗");
                        System.out.println("║      🏰 ENTRADA DA MASMORRA        ║");
                        System.out.println("╠════════════════════════════════════╣");
                        System.out.println("║ Você caminha em direção à temida   ║");
                        System.out.println("║ masmorra do vilarejo... O medo     ║");
                        System.out.println("║ aperta seu peito, mas você segue   ║");
                        System.out.println("║ em frente.                         ║");
                        System.out.println("╠════════════════════════════════════╣");
                        System.out.println("║ Ao alcançar o imenso portão, você  ║");
                        System.out.println("║ tenta empurrá-lo... mas nada       ║");
                        System.out.println("║ acontece. Ele está trancado! 🔒    ║");
                        System.out.println("║ (É necessário uma chave para abrir)║");
                        System.out.println("╚════════════════════════════════════╝");
                        Transicao.transicao();
                        break;
                    }
                } else {
                    temChave = false;
                    break;
                }
            } catch (InputMismatchException e) {
                Transicao.transicaolinha();
                System.out.println("Digite um valor valido");
                Transicao.transicao();
            }
            if (temChave) {
                break;
            }
        } while (true);
        if (temChave) {
            Transicao.transicao();
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║         🕸️ BEM-VINDO À DUNGEON 🕸️          ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  Você adentra um labirinto sombrio,        ║");
            System.out.println("║  repleto de mistérios e perigos ocultos.   ║");
            System.out.println("║  Prepare-se para enfrentar o desconhecido  ║");
            System.out.println("╚════════════════════════════════════════════╝");
            Transicao.transicao();
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║             ⚔️ MECÂNICAS ⚔️            ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║ 🏰 A dungeon é infinita!                ║");
            System.out.println("║                                         ║");
            System.out.println("║ 🚪 Escolha seu caminho e encare o       ║");
            System.out.println("║    destino que aguarda à frente...      ║");
            System.out.println("║                                         ║");
            System.out.println("║ 🎒 A cada sala, você pode:              ║");
            System.out.println("║    📜 Checar seu inventário.            ║");
            System.out.println("║    🔥 Acampar e descançar:              ║");
            System.out.println("║         (Recuperar status)              ║");
            System.out.println("║         (Chance de ser atacado!).       ║");
            System.out.println("║    🏃 Fugir e encerrar sua aventura.    ║");
            System.out.println("║                                         ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║ 💀 Sobreviva, lute e explore! Boa sorte!║");
            System.out.println("╚═════════════════════════════════════════╝");

            Transicao.transicao();
            for (int i = 1; i > 0; i++) {
                if(jogador.getVida()<= 0){
                    break;
                }
                Turno turno = new Turno();
                MonstroFactory mf = new MonstroFactory();
                Recompensa recompensa = new Recompensa();
                Transicao.transicaolinha();
                System.out.println("╔════════════════════════════════════════════╗");
                System.out.printf("║=-=-=-=-=-=-=-=-=-=SALA %d=-=-=-=-=-=-=-=-=-=║\n", i);
                System.out.println("╠════════════════════════════════════════════╣");
                System.out.println("║        🕸️ O QUE DESEJA FAZER? 🕸️           ║");
                System.out.println("╠════════════════════════════════════════════╣");
                System.out.println("║  1. ⬅️ Seguir pelo caminho à esquerda.     ║");
                System.out.println("║  2. ➡️ Seguir pelo caminho à direita.      ║");
                System.out.println("║  3. 🎒 Checar seu inventário.              ║");
                System.out.println("║  4. 🔥 Acampar e descansar.                ║");
                System.out.println("║  5. 🏃 Fugir e encerrar sua aventura.      ║");
                System.out.println("╠════════════════════════════════════════════╣");
                System.out.println("║  Escolha uma opção para prosseguir...      ║");
                System.out.println("╚════════════════════════════════════════════╝");
                int escolha = ler.nextInt();
                boolean fugir = false;
                int sorteJogador;
                int sorteDungeon;
                try {

                    switch (escolha) {
                        case 1:
                            Transicao.transicaolinha();
                            sorteJogador = Dados.d20();
                            sorteDungeon = Dados.d20();
                            rodeDado(sorteJogador);
                            Transicao.transicao();
                            if (sorteJogador >= sorteDungeon) {
                                System.out.println("╔══════════════════════════════════════╗");
                                System.out.println("║         🎁 BAÚ ENCONTRADO! 🎁        ║");
                                System.out.println("╠══════════════════════════════════════╣");
                                System.out.println("║  Você se depara com um baú antigo,   ║");
                                System.out.println("║  coberto de poeira e mistério.       ║");
                                System.out.println("║  Ele está trancado, mas parece       ║");
                                System.out.println("║  conter tesouros escondidos!         ║");
                                System.out.println("║                                      ║");
                                System.out.println("║  O que será que está dentro?         ║");
                                System.out.println("║                                      ║");
                                System.out.println("║  Com certeza essa era a sala certa!⭐║");
                                System.out.println("╚══════════════════════════════════════╝");
                                Transicao.transicao();
                                recompensa.recompensaBau(jogador);
                                Transicao.transicao();
                                continue;
                            } else {
                                System.out.println("╔════════════════════════════════════════╗");
                                System.out.println("║         🏃 MONSTRO APARECE! 😱        ║");
                                System.out.println("╠════════════════════════════════════════╣");
                                System.out.println("║  Um monstro aparece! Infelizmente não  ║");
                                System.out.println("║  era a sala certa... 😨                ║");
                                System.out.println("╚════════════════════════════════════════╝");
                                Transicao.transicao();
                                turno.turnoBatalha(jogador, mf.criarMonstro(jogador));
                                continue;
                            }
                        case 2:
                            Transicao.transicaolinha();
                            sorteJogador = Dados.d20();
                            sorteDungeon = Dados.d20();
                            rodeDado(sorteJogador);
                            Transicao.transicao();
                            if (sorteJogador >= sorteDungeon) {
                                System.out.println("╔══════════════════════════════════════╗");
                                System.out.println("║         🎁 BAÚ ENCONTRADO! 🎁        ║");
                                System.out.println("╠══════════════════════════════════════╣");
                                System.out.println("║  Você se depara com um baú antigo,   ║");
                                System.out.println("║  coberto de poeira e mistério.       ║");
                                System.out.println("║  Ele está trancado, mas parece       ║");
                                System.out.println("║  conter tesouros escondidos!         ║");
                                System.out.println("║                                      ║");
                                System.out.println("║  O que será que está dentro?         ║");
                                System.out.println("║  Com certeza essa era a sala certa!⭐║");
                                System.out.println("╚══════════════════════════════════════╝");
                                Transicao.transicao();
                                recompensa.recompensaBau(jogador);
                                Transicao.transicao();
                                continue;
                            } else {
                                System.out.println("╔════════════════════════════════════════╗");
                                System.out.println("║         🏃 MONSTRO APARECE! 😱        ║");
                                System.out.println("╠════════════════════════════════════════╣");
                                System.out.println("║  Um monstro aparece! Infelizmente não  ║");
                                System.out.println("║  era a sala certa... 😨                ║");
                                System.out.println("╚════════════════════════════════════════╝");
                                Transicao.transicao();
                                turno.turnoBatalha(jogador, mf.criarMonstro(jogador));
                                continue;
                            }
                        case 3:
                            Transicao.transicaolinha();
                            jogador.getInventarioJogador().manipularInventario(jogador);
                            continue;
                        case 4:
                            Transicao.transicaolinha();
                            sorteJogador = Dados.d20();
                            sorteDungeon = Dados.d20();
                            rodeDado(sorteJogador);
                            Transicao.transicao();
                            System.out.println("╔════════════════════════════════════════╗");
                            System.out.println("║           ⛺ ACAMPANDO... 🕯️           ║");
                            System.out.println("╠════════════════════════════════════════╣");
                            System.out.println("║  Ótimo... Você arruma suas coisas,     ║");
                            System.out.println("║  acende uma tocha e decide passar um   ║");
                            System.out.println("║  tempo descansando...                  ║");
                            System.out.println("║                                        ║");
                            System.out.println("║  O tempo passa, e você escuta algo     ║");
                            System.out.println("║  se mexendo em meio à escuridão...     ║");
                            System.out.println("╚════════════════════════════════════════╝");

                            if (sorteJogador >= sorteDungeon) {
                                System.out.println("╔═════════════════════════════════════════╗");
                                System.out.println("║         💤 DESCANSO COMPLETO! 😴        ║");
                                System.out.println("╠═════════════════════════════════════════╣");
                                System.out.println("║  Ufa! Era só um rato... Você consegue   ║");
                                System.out.println("║  descansar tão bem que acaba cochilando!║");
                                System.out.println("║  Vida restaurada!                       ║");
                                System.out.println("╚═════════════════════════════════════════╝");
                                Transicao.transicao();
                                jogador.recuperarStatus(jogador);
                                continue;
                            } else {
                                System.out.println("╔════════════════════════════════════════╗");
                                System.out.println("║           🏃 MONSTRO APARECE! 😱       ║");
                                System.out.println("╠════════════════════════════════════════╣");
                                System.out.println("║  Um monstro aparece! Infelizmente não  ║");
                                System.out.println("║  deu tempo para descansar... 😨        ║");
                                System.out.println("╚════════════════════════════════════════╝");
                                Transicao.transicao();
                                turno.turnoBatalha(jogador, mf.criarMonstro(jogador));
                                continue;
                            }
                        case 5:
                            Transicao.transicaolinha();
                            fugir = true;
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            Transicao.transicao();
                            continue;
                    }
                } catch (InputMismatchException e) {
                    Transicao.transicaolinha();
                    System.out.println("Digite um valor valido");
                    Transicao.transicao();
                    continue;
                }
                if (fugir) {
                    break;
                }
            }
            if (jogador.getVida() > 0) {
                System.out.println("╔══════════════════════════════════════════╗");
                System.out.println("║         🏆 VITÓRIA NA DUNGEON! 🏆       ║");
                System.out.println("╠══════════════════════════════════════════╣");
                System.out.println("║  Você superou os horrores da escuridão,  ║");
                System.out.println("║  derrotou monstros e desvendou segredos! ║");
                System.out.println("╠══════════════════════════════════════════╣");
                System.out.println("║  A dungeon foi vencida com bravura e     ║");
                System.out.println("║  astúcia, provando sua força!            ║");
                System.out.println("╚══════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════╗");
                System.out.println("║   ❤️ Seus status foram totalmente        ║");
                System.out.println("║      recuperados! 💪                     ║");
                System.out.println("╚══════════════════════════════════════════╝");
                jogador.recuperarStatus(jogador);
                Transicao.transicao();
            }else{
                System.out.println("╔═════════════════════════════════════════╗");
                System.out.println("║         💀 DERROTA NA DUNGEON 💀        ║");
                System.out.println("╠═════════════════════════════════════════╣");
                System.out.println("║  Infelizmente, você não conseguiu       ║");
                System.out.println("║  sobreviver à dungeon...                ║");
                System.out.println("║  Seus esforços foram valentes, mas      ║");
                System.out.println("║  o destino não foi favorável desta vez. ║");
                System.out.println("║                                         ║");
                System.out.println("║  Sua jornada termina aqui...            ║");
                System.out.println("╚═════════════════════════════════════════╝");
                Transicao.transicao();
            }
        }
    }

    public void rodeDado(int result) {
        System.out.println("╔════════════════════════════╗");
        System.out.println("║    🎲 ROLANDO O DADO...    ║");
        System.out.println("╚════════════════════════════╝");
        Transicao.transicao();
        System.out.println("╔════════════════════════════╗");
        System.out.printf("║   Resultado: %d            ║\n", result);
        System.out.println("╚════════════════════════════╝");

    }
}