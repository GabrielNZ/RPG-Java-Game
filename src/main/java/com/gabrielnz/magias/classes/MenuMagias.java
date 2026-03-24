package com.gabrielnz.magias.classes;

import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.classes.Classe;
import com.gabrielnz.personagem.monstros.Monstro;

import static com.gabrielnz.mecanicas.Transicao.ler;

public class MenuMagias {
    public void telaMagias(Jogador jogador, Monstro monstro) {
        if (jogador.getClasse() == Classe.Elfo) {
            MagiaElfo magiaElfo = new MagiaElfo();
            boolean escolhido;
            do {
                escolhido = false;
                System.out.println("╔════════════════════════════════════════╗");
                System.out.println("║      🏹📜 MAGIAS DE CLASSE 📜🏹       ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║  Escolha a magia:                      ║");
                System.out.println("║                                        ║");
                System.out.println("║    1. 🌿 Flecha da Natureza      (10)  ║");
                System.out.println("║    2. 🌿 Flecha de Mana          (20)  ║");
                System.out.println("║    3. 🌿 Encantamento da Natureza(30)  ║");
                System.out.println("║    0. Voltar                           ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║  Selecione o número correspondente...  ║");
                System.out.println("╚════════════════════════════════════════╝");
                int escolha = ler.nextInt();
                switch (escolha) {
                    case 1:
                        magiaElfo.magia1(jogador, monstro);
                        break;
                    case 2:
                        magiaElfo.magia2(jogador, monstro);
                        break;
                    case 3:
                        magiaElfo.magia3(jogador, monstro);
                        break;
                    case 0:
                        escolhido = true;
                        break;
                }
            } while (escolhido);
        }
        if (jogador.getClasse() == Classe.Gigante) {
            MagiaGigante magiaGigante = new MagiaGigante();
            boolean escolhido;
            do {
                escolhido = false;
                System.out.println("╔════════════════════════════════════════╗");
                System.out.println("║      🏔️📜 MAGIAS DE CLASSE 📜🏔️       ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║  Escolha a magia:                      ║");
                System.out.println("║                                        ║");
                System.out.println("║    1. 👊 Soco Sísmico            (10)  ║");
                System.out.println("║    2. 👊 Drenagem Vital          (20)  ║");
                System.out.println("║    3. 👊 Resurgir das Montanhas  (30)  ║");
                System.out.println("║    0. Voltar                           ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║  Selecione o número correspondente...  ║");
                System.out.println("╚════════════════════════════════════════╝");
                int escolha = ler.nextInt();
                switch (escolha) {
                    case 1:
                        magiaGigante.magia1(jogador, monstro);
                        break;
                    case 2:
                        magiaGigante.magia2(jogador, monstro);
                        break;
                    case 3:
                        magiaGigante.magia3(jogador, monstro);
                        break;
                    case 0:
                        escolhido = true;
                        break;
                }
            } while (escolhido);
        }
        if (jogador.getClasse() == Classe.Guerreiro) {
            MagiaGuerreiro magiaGuerreiro = new MagiaGuerreiro();
            boolean escolhido;
            do {
                escolhido = false;
                System.out.println("╔════════════════════════════════════════╗");
                System.out.println("║      ⚔️📜 MAGIAS DE CLASSE 📜⚔️       ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║  Escolha a magia:                      ║");
                System.out.println("║                                        ║");
                System.out.println("║    1. 💢 Espada da Furia         (10)  ║");
                System.out.println("║    2. 💢 Mana em Dano            (20)  ║");
                System.out.println("║    3. 💢 Frenesia de Ataque      (30)  ║");
                System.out.println("║    0. Voltar                           ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║  Selecione o número correspondente...  ║");
                System.out.println("╚════════════════════════════════════════╝");
                int escolha = ler.nextInt();
                switch (escolha) {
                    case 1:
                        magiaGuerreiro.magia1(jogador, monstro);
                        break;
                    case 2:
                        magiaGuerreiro.magia2(jogador, monstro);
                        break;
                    case 3:
                        magiaGuerreiro.magia3(jogador, monstro);
                        break;
                    case 0:
                        escolhido = true;
                        break;
                }
            } while (escolhido);
        }
        if (jogador.getClasse() == Classe.Goblin) {
            MagiaGoblin magiaGoblin = new MagiaGoblin();
            boolean escolhido;
            do {
                escolhido = false;
                System.out.println("╔════════════════════════════════════════╗");
                System.out.println("║      👹📜 MAGIAS DE CLASSE 📜👹       ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║  Escolha a magia:                      ║");
                System.out.println("║                                        ║");
                System.out.println("║    1. 🗡️ Corte Sagaz             (10)  ║");
                System.out.println("║    2. 🗡️ Ganancia por Poder      (20)  ║");
                System.out.println("║    3. 🗡️ Roubo de Arma           (30)  ║");
                System.out.println("║    0. Voltar                           ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║  Selecione o número correspondente...  ║");
                System.out.println("╚════════════════════════════════════════╝");
                int escolha = ler.nextInt();
                switch (escolha) {
                    case 1:
                        magiaGoblin.magia1(jogador, monstro);
                        break;
                    case 2:
                        magiaGoblin.magia2(jogador, monstro);
                        break;
                    case 3:
                        magiaGoblin.magia3(jogador, monstro);
                        break;
                    case 0:
                        escolhido = true;
                        break;
                }
            } while (escolhido);
        }
    }
}
