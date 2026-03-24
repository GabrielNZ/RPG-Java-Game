package com.gabrielnz.ambientacao;

import com.gabrielnz.combate.Dados;
import com.gabrielnz.itens.Raridade;
import com.gabrielnz.itens.Tamanho;
import com.gabrielnz.itens.arco.Arco;
import com.gabrielnz.itens.espada.Espada;
import com.gabrielnz.itens.pocao.PMana;
import com.gabrielnz.itens.pocao.PVida;

import com.gabrielnz.magias.LivroMagia;
import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.classes.*;

import java.util.InputMismatchException;

import static com.gabrielnz.mecanicas.Transicao.ler;

public class IniciarJogo {
    public void iniciarCampanha() {
        Vila vila = new Vila();
        Jogador jogador = criarPersonagem();
        Transicao.transicao();
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       🌟 UMA NOVA JORNADA SE INICIA 🌟      ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  Após escolher seu destino e trilhar o       ║");
        System.out.println("║  caminho de um verdadeiro aventureiro, você  ║");
        System.out.println("║  desperta em uma pequena vila, um refúgio    ║");
        System.out.println("║  para viajantes e guerreiros em ascensão.    ║");
        System.out.println("║                                              ║");
        System.out.println("║  As casas de madeira e as ruas de pedra são  ║");
        System.out.println("║  banhadas pela luz do sol, e o burburinho de ║");
        System.out.println("║  mercadores e aventureiros ecoa pelo ar.     ║");
        System.out.println("║                                              ║");
        System.out.println("║  Aqui, você pode se preparar antes de partir ║");
        System.out.println("║  para desafios maiores. Mas lembre-se: a     ║");
        System.out.println("║  vila é apenas o começo...                   ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        Transicao.transicao();
        vila.entrarVila(jogador);
        Transicao.transicao();
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║              💀 FIM DA JORNADA 💀             ║");
        System.out.println("╠═══════════════════════════════════════════════╣");
        System.out.println("║  Seus passos cessam... sua visão escurece...  ║");
        System.out.println("║  O destino implacável encontrou seu caminho.  ║");
        System.out.println("║                                               ║");
        System.out.println("║  A aventura termina aqui, mas suas ações      ║");
        System.out.println("║  serão lembradas. Heróis caem, mas lendas     ║");
        System.out.println("║  jamais são esquecidas.                       ║");
        System.out.println("║                                               ║");
        System.out.println("║  ⚔️ Talvez um novo destino aguarde um         ║");
        System.out.println("║  outro aventureiro...                         ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        Transicao.transicao();
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       ⭐    Obrigado por jogar!     ⭐      ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public Jogador criarPersonagem() {
        do {
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.println("║          🌍 BEM-VINDO AO MUNDO DE AVENTURAS 🌍           ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.println("║  Você desperta em um mundo vasto e misterioso,           ║");
            System.out.println("║  onde heróis e lendas se entrelaçam. Sua jornada         ║");
            System.out.println("║  está prestes a começar, e o destino o chama.            ║");
            System.out.println("║                                                          ║");
            System.out.println("║  Aqui, guerreiros, magos, elfos e outras                 ║");
            System.out.println("║  criaturas fantásticas estão em busca de honra,          ║");
            System.out.println("║  poder e um lugar no panteão dos grandes.                ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.println("║                🔥 ESCOLHA SUA CLASSE 🔥                  ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.println("║  1. 🧝‍♂️ Elfo                                              ║");
            System.out.println("║      - Vida: 11  Dano: 5  Mana: 15  Iniciativa: +1       ║");
            System.out.println("║      - Itens Iniciais: Arco Inicial, Poção de Vida       ║");
            System.out.println("║                                                          ║");
            System.out.println("║  2. 💪 Gigante                                           ║");
            System.out.println("║      - Vida: 20  Dano: 1  Mana: 15  Iniciativa: -2       ║");
            System.out.println("║      - Itens Iniciais: Espada de Madeira, Poção de Vida  ║");
            System.out.println("║                                                          ║");
            System.out.println("║  3. 👹 Goblin                                            ║");
            System.out.println("║      - Vida: 11  Dano: 4  Mana: 15  Iniciativa: +3       ║");
            System.out.println("║      - Itens Iniciais: Espada Inicial, Poção de Vida     ║");
            System.out.println("║                                                          ║");
            System.out.println("║  4. ⚔️ Guerreiro                                         ║");
            System.out.println("║      - Vida: 15  Dano: 3  Mana: 15  Iniciativa: 0        ║");
            System.out.println("║      - Itens Iniciais: Espada Inicial, Poção de Vida     ║");
            System.out.println("║                                                          ║");
            System.out.println("║  5. 🧙‍♂️ Mago                                              ║");
            System.out.println("║      - Vida: 12  Dano: 2  Mana: 25  Iniciativa: 0        ║");
            System.out.println("║      - Itens Iniciais: Livro Mágico, Poção de Mana       ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.println("║  Escolha sua classe, aventureiro... O destino            ║");
            System.out.println("║  está em suas mãos!                                      ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            try {
                int escolha = ler.nextInt();
                String nome;
                switch (escolha) {
                    case 1:
                        System.out.print("Digite seu nome jogador: ");
                        nome = ler.next();
                        Transicao.transicaolinha();
                        System.out.println("╔═════════════════════════════╗");
                        System.out.println("║  ✅   Jogador Criado!   ✅  ║");
                        System.out.println("╚═════════════════════════════╝");
                        Elfo elfo = new Elfo(nome);
                        elfo.getInventarioJogador().addArco(new Arco("Arco Inicial", new Dados(1), 20, 5, Raridade.COMUM, 1));
                        return elfo;

                    case 2:
                        System.out.print("Digite seu nome jogador: ");
                        nome = ler.next();
                        Transicao.transicaolinha();
                        System.out.println("╔═════════════════════════════╗");
                        System.out.println("║  ✅   Jogador Criado!   ✅  ║");
                        System.out.println("╚═════════════════════════════╝");
                        Gigante gigante = new Gigante(nome);
                        gigante.getInventarioJogador().addEspada(new Espada("Espada de Madeira", new Dados(2), 20, 5, Raridade.COMUM, 1));
                        gigante.getInventarioJogador().addPocao(new PVida(Tamanho.PEQUENA, Raridade.COMUM, 1, 30));
                        return gigante;
                    case 3:
                        System.out.print("Digite seu nome jogador: ");
                        nome = ler.next();
                        Transicao.transicaolinha();
                        System.out.println("╔═════════════════════════════╗");
                        System.out.println("║  ✅   Jogador Criado!   ✅  ║");
                        System.out.println("╚═════════════════════════════╝");
                        Goblin goblin = new Goblin(nome);
                        goblin.getInventarioJogador().addEspada(new Espada("Espada Inicial", new Dados(1), 20, 5, Raridade.COMUM, 1));
                        goblin.getInventarioJogador().addPocao(new PVida(Tamanho.PEQUENA, Raridade.COMUM, 1, 30));
                        return goblin;
                    case 4:
                        System.out.print("Digite seu nome jogador: ");
                        nome = ler.next();
                        Transicao.transicaolinha();
                        System.out.println("╔═════════════════════════════╗");
                        System.out.println("║  ✅   Jogador Criado!   ✅  ║");
                        System.out.println("╚═════════════════════════════╝");
                        Guerreiro guerreiro = new Guerreiro(nome);
                        guerreiro.getInventarioJogador().addEspada(new Espada("Espada Inicial", new Dados(1), 20, 5, Raridade.COMUM, 1));
                        guerreiro.getInventarioJogador().addPocao(new PVida(Tamanho.PEQUENA, Raridade.COMUM, 1, 30));
                        return guerreiro;
                    case 5:
                        System.out.print("Digite seu nome jogador: ");
                        nome = ler.next();
                        Transicao.transicaolinha();
                        System.out.println("╔═════════════════════════════╗");
                        System.out.println("║  ✅   Jogador Criado!   ✅  ║");
                        System.out.println("╚═════════════════════════════╝");
                        Mago mago = new Mago(nome);
                        mago.getInventarioJogador().addLivro(new LivroMagia("Livro de Magia",Raridade.LENDARIO));
                        mago.getInventarioJogador().addPocao(new PMana(Tamanho.PEQUENA, Raridade.COMUM, 1, 30));
                        return mago;
                    default:
                        System.out.println("Digite um valor valido!");
                        Transicao.transicao();
                }

            } catch (InputMismatchException e) {
                System.out.println("Digite um valor valido!");
                Transicao.transicao();
            }
        } while (true);
    }
}
