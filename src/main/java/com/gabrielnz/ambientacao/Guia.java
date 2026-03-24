package com.gabrielnz.ambientacao;

import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;

import static com.gabrielnz.mecanicas.Transicao.ler;

public class Guia {
    public void telaGuia(Jogador jogador) {
        do {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║     ❓📜 GUIA DE HABILIDADES 📜❓     ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  Escolha o tipo de magia que deseja:   ║");
            System.out.println("║                                        ║");
            System.out.println("║    1. 🔮 Magias de Classe              ║");
            System.out.println("║    2. 🌪️ Magias Elementais (Livro)     ║");
            System.out.println("║    3. 🎲 Status Jogador                ║");
            System.out.println("║    0. Sair                             ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  Selecione o número correspondente...  ║");
            System.out.println("╚════════════════════════════════════════╝");
            int escolha = ler.nextInt();
            boolean escolheu = false;
            switch (escolha) {
                case 0:
                    Transicao.transicaolinha();
                    escolheu = true;
                    break;
                case 1:
                    telaGuiaMagiasClasses();
                    break;
                case 2:
                    telaGuiaMagiasLivro();
                    break;
                case 3:
                    if(jogador.getArmadura() != null) {
                        System.out.println("╔═════════════════════════════════════╗");
                        System.out.println("║            👤 Jogador               ║");
                        System.out.printf("║ 🩸 Vida: %-2d   💥 Dano: %-2d          ║\n", jogador.getVidaMax(), jogador.getDano());
                        System.out.printf("║ 🔮 Mana: %-2d   🛡️ Resistência: %-2d  ║\n", jogador.getManaMax(), jogador.getArmadura().getValorArmadura());
                        System.out.println("╚═════════════════════════════════════╝");
                    }else{
                        System.out.println("╔══════════════════════════════════════╗");
                        System.out.println("║            👤 Jogador                ║");
                        System.out.printf("║ 🩸 Vida: %-2d   💥 Dano: %-2d            ║\n", jogador.getVida(), jogador.getDano());
                        System.out.printf("║ 🔮 Mana: %-2d                          ║\n", jogador.getMana());
                        System.out.println("╚══════════════════════════════════════╝");
                    }
                    break;
                default:
                    System.out.println("Valor invalido...");
                    Transicao.transicao();
            }
            if (escolheu) {
                break;
            }
        } while (true);
    }

    public void telaGuiaMagiasLivro() {
        do {
            Transicao.transicaolinha();
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║       ❓📜 GUIA DE MAGIAS 📜❓        ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  Escolha o elemento que deseja ver:    ║");
            System.out.println("║                                        ║");
            System.out.println("║    1. 💧 Água (Suporte)                ║");
            System.out.println("║    2. 🔥 Fogo (Dano)                   ║");
            System.out.println("║    3. ❄️ Gelo (Utilidade)              ║");
            System.out.println("║    0. Sair                             ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  Selecione o número correspondente...  ║");
            System.out.println("╚════════════════════════════════════════╝");
            int escolha = ler.nextInt();
            boolean escolheu = false;
            switch (escolha) {
                case 0:
                    Transicao.transicaolinha();
                    escolheu = true;
                    break;
                case 1:
                    Transicao.transicaolinha();
                    int manaGasto1 = 5;
                    System.out.println("╔════════════════════════════════════════╗");
                    System.out.println("║           💧 JATO DE ÁGUA 💧           ║");
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║  Você canaliza a força das águas e     ║");
                    System.out.println("║  dispara um poderoso jato!             ║");
                    System.out.println("║  Dano = Mana Maxima/9 🔮               ║");
                    System.out.println("║                                        ║");
                    System.out.printf("║  Mana gasto: %-3d                       ║\n", manaGasto1);
                    System.out.println("╚════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto2 = 13;
                    System.out.println("╔════════════════════════════════════════════╗");
                    System.out.println("║           💧 BOLHA DEFENSIVA 💧            ║");
                    System.out.println("╠════════════════════════════════════════════╣");
                    System.out.println("║  Uma bolha protetora se forma ao seu redor,║");
                    System.out.println("║  protegendo você de ataques inimigos!      ║");
                    System.out.println("║  Vida restaurada com base na mana          ║");
                    System.out.println("║  Cura = Mana Maxima/5 🔮                   ║");
                    System.out.println("║                                            ║");
                    System.out.printf("║  Mana gasto: %-3d                           ║\n", manaGasto2);
                    System.out.println("╚════════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto3 = 30;
                    System.out.println("╔═══════════════════════════════════════════════╗");
                    System.out.println("║           💧 TOQUE DE POSEIDON 💧             ║");
                    System.out.println("╠═══════════════════════════════════════════════╣");
                    System.out.println("║  Você invoca a benção dos mares, e com        ║");
                    System.out.println("║  um toque, restaura vida com a força da água! ║");
                    System.out.println("║  Vida restaurada com base na mana             ║");
                    System.out.println("║  Cura = Mana Maxima/2 🔮                      ║");
                    System.out.println("║                                               ║");
                    System.out.printf("║  Mana gasto: %-3d                              ║\n", manaGasto3);
                    System.out.println("╚═══════════════════════════════════════════════╝");
                    Transicao.transicao();
                    break;
                case 2:
                    Transicao.transicaolinha();
                    int manaGasto4 = 7;
                    System.out.println("╔═════════════════════════════════════════╗");
                    System.out.println("║           🔥 BOLA DE FOGO 🔥            ║");
                    System.out.println("╠═════════════════════════════════════════╣");
                    System.out.println("║  Uma esfera flamejante se forma em suas ║");
                    System.out.println("║  mãos e voa em direção ao inimigo!      ║");
                    System.out.println("║  Dano = Mana Maxima/7 🔮                ║");
                    System.out.println("║                                         ║");
                    System.out.printf("║  Mana gasto: %-3d                        ║\n", manaGasto4);
                    System.out.println("╚═════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto5 = 20;
                    System.out.println("╔════════════════════════════════════════════╗");
                    System.out.println("║            🔥 LASER DE FOGO 🔥            ║");
                    System.out.println("╠════════════════════════════════════════════╣");
                    System.out.println("║  Um feixe concentrado de chamas rasga o ar,║");
                    System.out.println("║  atingindo seu inimigo com precisão!       ║");
                    System.out.println("║  Dano = Mana Maxima/4 🔮                   ║");
                    System.out.println("║                                            ║");
                    System.out.printf("║  Mana gasto: %-3d                           ║\n", manaGasto5);
                    System.out.println("╚════════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto6 = 35;
                    System.out.println("╔════════════════════════════════════════════╗");
                    System.out.println("║                🔥 SOL 🔥                   ║");
                    System.out.println("╠════════════════════════════════════════════╣");
                    System.out.println("║  Você convoca o poder do sol, irradiando   ║");
                    System.out.println("║  uma luz intensa que incinera seus inimigos║");
                    System.out.println("║  e aquece os aliados!                      ║");
                    System.out.println("║  Dano = Mana Maxima/2 🔮                   ║");
                    System.out.println("║                                            ║");
                    System.out.printf("║  Mana gasto: %-3d                           ║\n", manaGasto6);
                    System.out.println("╚════════════════════════════════════════════╝");
                    Transicao.transicao();
                    break;
                case 3:
                    Transicao.transicaolinha();
                    int manaGasto7 = 4;
                    System.out.println("╔════════════════════════════════════════╗");
                    System.out.println("║          ❄️ RAJADA DE GELO ❄️          ║");
                    System.out.println("╠════════════════════════════════════════╣");
                    System.out.println("║  Uma rajada cortante de gelo é lançada,║");
                    System.out.println("║  congelando tudo em seu caminho!       ║");
                    System.out.println("║  Dano = Mana Maxima/10 🔮              ║");
                    System.out.println("║                                        ║");
                    System.out.printf("║  Mana gasto: %-3d                       ║\n", manaGasto7);
                    System.out.println("╚════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto8 = 17;
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║         ❄️ TOQUE CONGELANTE ❄️           ║");
                    System.out.println("╠══════════════════════════════════════════╣");
                    System.out.println("║  Com um toque gélido, você congela seus  ║");
                    System.out.println("║  inimigos, retardando seus movimentos!   ║");
                    System.out.println("║  Proximo round do monstro sera pulado    ║");
                    System.out.println("║  Dano = Mana Maxima/7                    ║");
                    System.out.println("║                                          ║");
                    System.out.printf("║  Mana gasto: %-3d                         ║\n", manaGasto8);
                    System.out.println("╚══════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto9 = 30;
                    System.out.println("╔═══════════════════════════════════════════╗");
                    System.out.println("║         ❄️ PRISÃO DE GELO ❄️              ║");
                    System.out.println("╠═══════════════════════════════════════════╣");
                    System.out.println("║  Você invoca correntes de gelo, prendendo ║");
                    System.out.println("║  o inimigo em uma armadilha congelante!   ║");
                    System.out.println("║  ignorando sua armadura no proximo round! ║");
                    System.out.println("║  Dano = Mana Maxima/7 🔮                  ║");
                    System.out.println("║                                           ║");
                    System.out.printf("║  Mana gasto: %-3d                          ║\n", manaGasto9);
                    System.out.println("╚═══════════════════════════════════════════╝");
                    Transicao.transicao();
                    break;
                default:
                    System.out.println("Valor invalido...");
                    Transicao.transicao();
            }
            if (escolheu) {
                break;
            }
        } while (true);
    }

    public void telaGuiaMagiasClasses() {
        do {
            Transicao.transicaolinha();
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║      🔮📜 MAGIAS DE CLASSE 📜🔮       ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  Escolha a classe para ver as magias:  ║");
            System.out.println("║                                        ║");
            System.out.println("║    1. 🏹 Elfo                          ║");
            System.out.println("║    2. ⚔️ Guerreiro                     ║");
            System.out.println("║    3. 🏔️ Gigante                       ║");
            System.out.println("║    4. 👹 Goblin                        ║");
            System.out.println("║    0. Voltar                           ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  Selecione o número correspondente...  ║");
            System.out.println("╚════════════════════════════════════════╝");
            int escolha = ler.nextInt();
            boolean escolheu = false;
            switch (escolha) {
                case 0:
                    Transicao.transicaolinha();
                    escolheu = true;
                    break;
                case 1:
                    Transicao.transicaolinha();
                    int manaGasto1 = 10;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║          🏹 Flecha da Natureza 🌿           ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Você canaliza a força das natureza e       ║");
                    System.out.println("║  dispara uma flecha encantada com energia   ║");
                    System.out.println("║  natural roubando a força vital do alvo     ║");
                    System.out.println("║  Cura = Dano Base 🔮                        ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto1);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto2 = 20;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║            🏹 Flecha de Mana 🌿             ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Você transforma a força da natureza em mana║");
                    System.out.println("║  pura e a coloca em sua flecha. Disparando-a║");
                    System.out.println("║  contra seu alvo.                           ║");
                    System.out.println("║  Dano = Mana Base 🔮                        ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto1);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto3 = 30;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║       🏹 Encantamento da Natureza 🌿        ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Você canaliza a força das natureza e       ║");
                    System.out.println("║  descarrega essa energia toda em sua proxima║");
                    System.out.println("║  flecha, aumento seu dano.                  ║");
                    System.out.println("║  Dano = Critico ⚔️                          ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto1);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    Transicao.transicao();
                    break;
                case 2:
                    Transicao.transicaolinha();
                    int manaGasto4 = 10;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║           ⚔️ Espada da Furia 💢             ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Você transforma toda a sua ira e raiva em  ║");
                    System.out.println("║  sua espada, dobrando seu dano base no      ║");
                    System.out.println("║  proximo round. (Pula esse round)           ║");
                    System.out.println("║  Dano Base = Dano Base X 2 ⚔️               ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto4);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto5 = 20;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║             ⚔️ Mana em Dano 💢              ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Com sangue nos olhos, metade de sua mana   ║");
                    System.out.println("║  se torna furia, ignorando parte da armadura║");
                    System.out.println("║  de seu inimigo                             ║");
                    System.out.println("║  Armadura Ignorada = Mana / 2 🔮            ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto5);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto6 = 30;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║          ⚔️ Frenesia de Ataque 💢           ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Atraves de toda a furia acumulada na       ║");
                    System.out.println("║  batalha, dois ataques serao desferidos     ║");
                    System.out.println("║  Ao ativar a habilidade atacara duas vezes  ║");
                    System.out.println("║  tendo os mesmo efeitos de um ataque normal ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto6);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    Transicao.transicao();
                    break;
                case 3:
                    Transicao.transicaolinha();
                    int manaGasto7 = 10;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║             🏔️ Soco Sísmico 👊              ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Você canaliza a força de sua vitalidade e  ║");
                    System.out.println("║  transforma porcentagem de sua vida maxima  ║");
                    System.out.println("║  em dano no proximo ataque                  ║");
                    System.out.println("║  Dano bonus = Vida maxima /5 ❤️             ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto7);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto8 = 20;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║            🏔️ Drenagem Vital 👊            ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Você sacrifica metade de sua vida atual em ║");
                    System.out.println("║  dano bonus pelo resto da batalha           ║");
                    System.out.println("║  Dano bonus = Vida / 2 ❤️                   ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto8);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto9 = 30;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║         🏔️ Resurgir das Montanhas 👊        ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Ao se fundir com o solo, voce recupera     ║");
                    System.out.println("║  vida baseado em sua armadura.              ║");
                    System.out.println("║  Cura = Armadura 🛡️                         ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto9);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    Transicao.transicao();
                    break;
                case 4:
                    Transicao.transicaolinha();
                    int manaGasto10 = 10;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║             👹 Corte Sagaz 🗡️               ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Atraves de um rapido corte voce acertara em║");
                    System.out.println("║  cheio o inimigo no proximo round, somente  ║");
                    System.out.println("║  caso seja o primeiro a atacar, caso        ║");
                    System.out.println("║  contrario nao mudara nada.                 ║");
                    System.out.println("║  Dano Bonus = +1 Roll da Espada 🎲          ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto10);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto11 = 20;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║          👹 Ganancia por Poder 🗡️           ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  Ao imbuir sua espada com mana, voce        ║");
                    System.out.println("║  acresenta parte de sua mana ao roll de     ║");
                    System.out.println("║  sua espada                                 ║");
                    System.out.println("║  Roll Extra = Mana Maxima / 5 🎲            ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto11);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    System.out.println();
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println();
                    int manaGasto12 = 30;
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║            👹 Roubo de Arma 🗡️              ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║  De forma sorrateira, voce rouba a arma de  ║");
                    System.out.println("║  seu inimigo, fazendo com que ele ataque    ║");
                    System.out.println("║  somente com o dano base e voce com a arma  ║");
                    System.out.println("║  dele como dano extra                       ║");
                    System.out.println("║  Dano Bonus = +1 Roll da Espada inimiga 🎲  ║");
                    System.out.println("║                                             ║");
                    System.out.printf("║  Custo de Mana: %-3d                         ║\n", manaGasto12);
                    System.out.println("╚═════════════════════════════════════════════╝");
                    Transicao.transicao();
                    break;
                default:
                    System.out.println("Valor invalido...");
                    Transicao.transicao();
            }
            if (escolheu) {
                break;
            }
        } while (true);
    }
}
