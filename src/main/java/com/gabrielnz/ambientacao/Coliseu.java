package com.gabrielnz.ambientacao;

import com.gabrielnz.combate.Turno;
import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.MonstroFactory;

import java.util.InputMismatchException;

import static com.gabrielnz.mecanicas.Transicao.ler;

public class Coliseu {
    public void entrarColiseu(Jogador jogador) {
        do {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║       🏛️ BEM-VINDO AO COLISEU 🏛️       ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  Prepare-se para enfrentar desafios    ║");
            System.out.println("║  épicos e adversários poderosos!       ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║      Sua coragem será testada...       ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("Ao entrar, um monstro de seu nivel aparecera, derrote-o e ganhe a recompensa!");
            System.out.println("[0]-Sair");
            System.out.println("[1]-Entrar");
            try {
                int escolha = ler.nextInt();
                if (escolha == 0) {
                    break;
                } else if (escolha == 1) {
                    Transicao.transicaolinha();
                    MonstroFactory mf = new MonstroFactory();
                    Turno turno = new Turno();
                    turno.turnoBatalha(jogador, mf.criarMonstro(jogador));
                    if (jogador.getVida() <= 0) {
                        break;
                    } else {
                        System.out.println("╔══════════════════════════════════════════╗");
                        System.out.println("║          🏆 GLÓRIA ETERNA! 🏆            ║");
                        System.out.println("╠══════════════════════════════════════════╣");
                        System.out.println("║  Você derrotou o adversário              ║");
                        System.out.println("║  e conquistou a vitória no Coliseu!      ║");
                        System.out.println("╠══════════════════════════════════════════╣");
                        System.out.println("║  Sua força e determinação foram          ║");
                        System.out.println("║  colocadas à prova e você saiu vitorioso ║");
                        System.out.println("╚══════════════════════════════════════════╝");
                        System.out.println("╔═════════════════════════════════════════╗");
                        System.out.println("║   ❤️ Seus status foram totalmente       ║");
                        System.out.println("║      recuperados! 💪                    ║");
                        System.out.println("╚═════════════════════════════════════════╝");
                        jogador.recuperarStatus(jogador);
                        Transicao.transicao();
                        continue;
                    }
                } else {
                    System.out.println("Digite um valor valido.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor valido.");
                continue;
            }
        } while (true);
    }
}
