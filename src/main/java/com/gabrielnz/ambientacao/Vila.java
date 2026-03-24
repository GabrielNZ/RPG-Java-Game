package com.gabrielnz.ambientacao;
import com.gabrielnz.mecanicas.Loja;
import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import java.util.InputMismatchException;

import static com.gabrielnz.mecanicas.Transicao.ler;

public class Vila {
    public void entrarVila(Jogador jogador) {
        do {
            Transicao.transicaolinha();
            if (jogador.getVida() > 0) {
                System.out.println("╔════════════════════════════════════════════════════╗");
                System.out.println("║      🏰 BEM-VINDO À VILA DO AVENTUREIRO 🏰        ║");
                System.out.println("╠════════════════════════════════════════════════════╣");
                System.out.println("║  Você chega a uma vila pacífica, mas cheia         ║");
                System.out.println("║  de oportunidades para testar sua coragem.         ║");
                System.out.println("║  Aqui você pode se preparar para grandes           ║");
                System.out.println("║  desafios ou descansar um pouco antes de           ║");
                System.out.println("║  continuar sua jornada.                            ║");
                System.out.println("║                                                    ║");
                System.out.println("║  No centro da vila, você encontra:                 ║");
                System.out.println("║                                                    ║");
                System.out.println("║  1. 🏪 Uma loja, para comprar e vender itens.      ║");
                System.out.println("║                                                    ║");
                System.out.println("║  2. ⚔️ O Coliseu, onde você pode lutar e testar    ║");
                System.out.println("║      suas habilidades.                             ║");
                System.out.println("║                                                    ║");
                System.out.println("║  3. 🕸️ A Dungeon, um labirinto perigoso onde       ║");
                System.out.println("║      você pode ganhar grandes recompensas,         ║");
                System.out.println("║      mas para entrar você precisará de uma         ║");
                System.out.println("║      chave...                                      ║");
                System.out.println("║                                                    ║");
                System.out.println("║  4. 🎒 Seu Inventário, para verificar e organizar  ║");
                System.out.println("║      seus itens.                                   ║");
                System.out.println("║                                                    ║");
                System.out.println("║  5. ❓ Guia - Habilidade, Magias e Status.         ║");
                System.out.println("╚════════════════════════════════════════════════════╝");
               try {
                   int escolha = ler.nextInt();
                   switch (escolha) {
                       case 1:
                            Transicao.transicaolinha();
                           Loja loja = new Loja();
                           loja.abrirLoja(jogador);
                           break;
                       case 2:
                           Transicao.transicaolinha();
                           Coliseu coliseu = new Coliseu();
                           coliseu.entrarColiseu(jogador);
                           break;
                       case 3:
                           Transicao.transicaolinha();
                           Dungeon dungeon  = new Dungeon();
                           dungeon.entrarDungeon(jogador);
                           break;
                       case 4:
                           Transicao.transicaolinha();
                           jogador.getInventarioJogador().manipularInventario(jogador);
                           break;
                           case 5:
                               Transicao.transicaolinha();
                               Guia guia = new Guia();
                               guia.telaGuia(jogador);
                               break;
                       default:
                           System.out.println("Opção inválida!");
                           Transicao.transicao();
                   }
               }catch(InputMismatchException e){
                   Transicao.transicaolinha();
                   System.out.println("Valor invalido...");
                   Transicao.transicao();
               }
            } else {
                break;
            }
        } while (true);
    }
}
