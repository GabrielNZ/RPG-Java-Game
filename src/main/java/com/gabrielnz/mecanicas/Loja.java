package com.gabrielnz.mecanicas;

import com.gabrielnz.itens.Equipamentos;
import com.gabrielnz.itens.arco.Arco;
import com.gabrielnz.itens.armadura.Armadura;
import com.gabrielnz.itens.chave.Chave;
import com.gabrielnz.itens.espada.Espada;
import com.gabrielnz.itens.pocao.Pocao;
import com.gabrielnz.personagem.Jogador;

import java.util.List;

import static com.gabrielnz.mecanicas.Transicao.ler;
import static com.gabrielnz.mecanicas.Transicao.transicaolinha;

public class Loja {
    public void abrirLoja(Jogador jogador) {
        do {
            boolean sair = false;
            Transicao.transicaolinha();
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║    🏰 LOJA DO AVENTUREIRO     ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1 - 🗡️ Comprar Armas          ║");
            System.out.println("║ 2 - 🛡️ Comprar Armaduras      ║");
            System.out.println("║ 3 - 🧪 Comprar Poções         ║");
            System.out.println("║ 4 - 🗝️ Comprar Chaves         ║");
            System.out.println("║ 5 - 💰 Vender Itens           ║");
            System.out.println("║ 6 - 🚪 Sair                   ║");
            System.out.println("╚═══════════════════════════════╝");
            System.out.print("Escolha uma opção, bravo aventureiro: ");
            int escolha = ler.nextInt();
            switch (escolha) {
                case 1:
                    transicaolinha();
                    abaArmas(jogador);
                    break;
                case 2:
                    transicaolinha();
                    abaArmaduras(jogador);
                    break;
                case 3:
                    transicaolinha();
                    abaPocoes(jogador);
                    break;
                case 4:
                    transicaolinha();
                    abaChaves(jogador);
                    break;
                case 5:
                    transicaolinha();
                    abaVenderItens(jogador);
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    Transicao.transicao();
            }
            if (sair) {
                break;
            }
        } while (true);
    }

    public void abaArmas(Jogador jogador) {
        Recompensa r = new Recompensa();
        Espada arma1 = r.sortearEspada(jogador);
        Espada arma2 = r.sortearEspada(jogador);
        Espada arma3 = r.sortearEspada(jogador);
        Arco arma4 = r.sortearArco(jogador);
        Arco arma5 = r.sortearArco(jogador);
        Arco arma6 = r.sortearArco(jogador);

        do {
            System.out.println("╔════════════════════════════════════════════════════════════════════╗");
            System.out.println("║=-=-=-=-=-=-=-=-=-=-=-=-=🔥 LOJA DE ARMAS 🔥=-=-=-=-=-=-=-=-=-=-=-=║");
            System.out.println("╠════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ 1️⃣ %-25s- %-9s - %-25s║\n", arma1.getNome(), arma1.getRaridade(), arma1.toString());
            System.out.printf("║ 2️⃣ %-25s- %-9s - %-25s║\n", arma2.getNome(), arma2.getRaridade(), arma2.toString());
            System.out.printf("║ 3️⃣ %-25s- %-9s - %-25s║\n", arma3.getNome(), arma3.getRaridade(), arma3.toString());
            System.out.printf("║ 4️⃣ %-25s- %-9s - %-25s║\n", arma4.getNome(), arma4.getRaridade(), arma4.toString());
            System.out.printf("║ 5️⃣ %-25s- %-9s - %-25s║\n", arma5.getNome(), arma5.getRaridade(), arma5.toString());
            System.out.printf("║ 6️⃣ %-25s- %-9s - %-25s║\n", arma6.getNome(), arma6.getRaridade(), arma6.toString());
            System.out.println("╠════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ 💰 Seu Ouro: %-4d                                                  ║\n", jogador.getOuro());
            System.out.println("║ 🛒 Escolha uma arma (1-6):                                         ║");
            System.out.println("╚════════════════════════════════════════════════════════════════════╝");
            System.out.println("Digite 0 para retornar.");
            int escolha = ler.nextInt();
            boolean sair = false;
            switch (escolha) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    if (arma1.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - arma1.getValorCompra());
                        jogador.getInventarioJogador().addEspada(arma1);
                        System.out.println("-" + arma1.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }
                    break;
                case 2:
                    if (arma2.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - arma2.getValorCompra());
                        jogador.getInventarioJogador().addEspada(arma2);
                        System.out.println("-" + arma2.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }

                    break;
                case 3:
                    if (arma3.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - arma3.getValorCompra());
                        jogador.getInventarioJogador().addEspada(arma3);
                        System.out.println("-" + arma3.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }
                    break;
                case 4:
                    if (arma4.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - arma4.getValorCompra());
                        jogador.getInventarioJogador().addArco(arma4);
                        System.out.println("-" + arma4.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }
                    break;
                case 5:
                    if (arma5.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - arma5.getValorCompra());
                        jogador.getInventarioJogador().addArco(arma5);
                        System.out.println("-" + arma5.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }
                    break;
                case 6:
                    if (arma6.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - arma6.getValorCompra());
                        jogador.getInventarioJogador().addArco(arma6);
                        System.out.println("-" + arma6.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }
                    break;
                default:
                    System.out.println("Valor invalido...");
                    Transicao.transicao();
                    continue;
            }
            if (sair) {
                break;
            }
            Transicao.transicao();
        } while (true);
    }

    public void abaArmaduras(Jogador jogador) {
        Recompensa r = new Recompensa();
        Armadura armadura1 = r.sortearArmadura(jogador);
        Armadura armadura2 = r.sortearArmadura(jogador);
        Armadura armadura3 = r.sortearArmadura(jogador);


        do {
            System.out.println("╔═════════════════════════════════════════════════════════════════════╗");
            System.out.println("║=-=-=-=-=-=-=-=-=-=-=-=-🛡️ LOJA DE ARMADURA 🛡️=-=-=-=-=-=-=-=-=-=-=-=║");
            System.out.println("╠═════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ 1️⃣ %-25s- %-9s - %-25s ║\n", armadura1.getNome(), armadura1.getRaridade(), armadura1.toString());
            System.out.printf("║ 2️⃣ %-25s- %-9s - %-25s ║\n", armadura2.getNome(), armadura2.getRaridade(), armadura2.toString());
            System.out.printf("║ 3️⃣ %-25s- %-9s - %-25s ║\n", armadura3.getNome(), armadura3.getRaridade(), armadura3.toString());
            System.out.println("╠═════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ 💰 Seu Ouro: %-4d                                                   ║\n", jogador.getOuro());
            System.out.println("║ 🛒 Escolha uma arma (1-3):                                          ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
            System.out.println("Digite 0 para retornar.");
            int escolha = ler.nextInt();
            boolean sair = false;
            switch (escolha) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    if (armadura1.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - armadura1.getValorCompra());
                        jogador.getInventarioJogador().addArmadura(armadura1);
                        System.out.println("-" + armadura1.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }
                    break;
                case 2:
                    if (armadura2.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - armadura2.getValorCompra());
                        jogador.getInventarioJogador().addArmadura(armadura2);
                        System.out.println("-" + armadura2.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }

                    break;
                case 3:
                    if (armadura3.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - armadura3.getValorCompra());
                        jogador.getInventarioJogador().addArmadura(armadura3);
                        System.out.println("-" + armadura3.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }
                    break;
                default:
                    System.out.println("Valor invalido...");
                    Transicao.transicao();
                    continue;
            }
            if (sair) {
                break;
            }
            Transicao.transicao();
        } while (true);
    }

    public void abaPocoes(Jogador jogador) {
        Recompensa r = new Recompensa();
        Pocao pocao1 = r.sortearPocao(jogador);
        Pocao pocao2 = r.sortearPocao(jogador);
        Pocao pocao3 = r.sortearPocao(jogador);
        do {
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║=-=-=-=-=-=-=-=-=-=-=❤️ LOJA DE POÇÃO 🔮=-=-=-=-=-=-=-=-=-=-=-║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.printf("║ 1️⃣ %-15s- %-7s(+%2d) - Preço: %-2d                 ║\n", pocao1.getNome(), pocao1.getTamanho(), pocao1.getValorRecuperado(), pocao1.getValorCompra());
            System.out.printf("║ 2️⃣ %-15s- %-7s(+%2d) - Preço: %-2d                 ║\n", pocao2.getNome(), pocao2.getTamanho(), pocao2.getValorRecuperado(), pocao2.getValorCompra());
            System.out.printf("║ 3️⃣ %-15s- %-7s(+%2d) - Preço: %-2d                 ║\n", pocao3.getNome(), pocao3.getTamanho(), pocao3.getValorRecuperado(), pocao3.getValorCompra());
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.printf("║ 💰 Seu Ouro: %-4d                                            ║\n", jogador.getOuro());
            System.out.println("║ 🛒 Escolha uma poção (1-3):                                  ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            System.out.println("Digite 0 para retornar.");
            int escolha = ler.nextInt();
            boolean sair = false;
            switch (escolha) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    if (pocao1.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - pocao1.getValorCompra());
                        jogador.getInventarioJogador().addPocao(pocao1);
                        System.out.println("-" + pocao1.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }
                    break;
                case 2:
                    if (pocao2.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - pocao2.getValorCompra());
                        jogador.getInventarioJogador().addPocao(pocao2);
                        System.out.println("-" + pocao2.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }

                    break;
                case 3:
                    if (pocao3.getValorCompra() <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - pocao3.getValorCompra());
                        jogador.getInventarioJogador().addPocao(pocao3);
                        System.out.println("-" + pocao3.getValorCompra() + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }
                    break;
                default:
                    System.out.println("Valor invalido...");
                    Transicao.transicao();
                    continue;
            }
            if (sair) {
                break;
            }
            Transicao.transicao();
        } while (true);
    }

    public void abaChaves(Jogador jogador) {
        do {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║=-=-=-=-=-=-=🗝️️ LOJA DE CHAVES 🗝️=-=-=-=-=-=-=║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.printf("║ 1️⃣ Chave - Dungeon - Preço: 30G              ║\n");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.printf("║ 💰 Seu Ouro: %-4d                            ║\n", jogador.getOuro());
            System.out.println("║ 🛒 Escolha uma chave (1):                    ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.println("Digite 0 para retornar.");
            int escolha = ler.nextInt();
            boolean sair = false;
            switch (escolha) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    if (30 <= jogador.getOuro()) {
                        jogador.setOuro(jogador.getOuro() - 30);
                        jogador.getInventarioJogador().addChave(new Chave());
                        System.out.println("-" + 30 + " de ouro, nova quantia: " + jogador.getOuro() + "G");
                    } else {
                        System.out.println("Ouro insuficiente...");
                    }
                    break;
                default:
                    System.out.println("Valor invalido...");
                    Transicao.transicao();
                    continue;
            }
            if (sair) {
                break;
            }
            Transicao.transicao();
        } while (true);
    }

    public void abaVenderItens(Jogador jogador) {
        do {
            Transicao.transicaolinha();
            List<Equipamentos> inventarioFiltrado = jogador.getInventarioJogador().getInventario().stream().filter(x -> x instanceof Armadura || x instanceof Espada || x instanceof Arco).map(x -> (Equipamentos) x).toList();
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║             💼 INVENTÁRIO 📦               ║");
            System.out.println("╠════════════════════════════════════════════╣");
            if (inventarioFiltrado.isEmpty()) {
                System.out.println("║             (Nada para vender)            ║");
            } else {
                for (int i = 0; i < inventarioFiltrado.size(); i++) {
                    boolean equipado = false;
                    String equipados = "";
                    if (inventarioFiltrado.get(i).isEquipado()) {
                        equipado = true;
                        equipados = "EQUIPADO";
                    }
                    System.out.printf("║ %2d. %-25s %dG %-8s  ║\n", i + 1, inventarioFiltrado.get(i).getNome(), inventarioFiltrado.get(i).getValorVenda(), equipados);
                }
            }
            System.out.println("╚════════════════════════════════════════════╝");
            boolean sair = false;
            do {
                System.out.println("Digite o numero do equipamento para vende-lo [0-> sair]: ");
                int escolha = ler.nextInt();
                if (escolha != 0 && escolha <= inventarioFiltrado.size()) {
                    if (inventarioFiltrado.get(escolha - 1).isEquipado() && inventarioFiltrado.get(escolha - 1) instanceof Arco || inventarioFiltrado.get(escolha - 1) instanceof Espada) {
                        inventarioFiltrado.get(escolha - 1).setEquipado(false);
                        jogador.setArma(null);
                    } else if (inventarioFiltrado.get(escolha - 1).isEquipado() && inventarioFiltrado.get(escolha - 1) instanceof Armadura) {
                        inventarioFiltrado.get(escolha - 1).setEquipado(false);
                        jogador.setArmadura(null);
                    }
                    jogador.setOuro(jogador.getOuro() + inventarioFiltrado.get(escolha - 1).getValorVenda());
                    jogador.getInventarioJogador().getInventario().remove(inventarioFiltrado.get(escolha - 1));
                    System.out.println("╔═══════════════════════════════════╗");
                    System.out.println("║      💰  ITEM VENDIDO!  💰       ║");
                    System.out.println("╠═══════════════════════════════════╣");
                    System.out.printf("║ Ouro Atual: %dG                  ║%n", jogador.getOuro());
                    System.out.println("╚═══════════════════════════════════╝");
                    Transicao.transicao();
                    break;
                } else if (escolha == 0) {
                    sair = true;
                    break;
                } else {
                    System.out.println("Opção invalida...");
                    Transicao.transicao();
                }
            } while (true);
            if (sair) {
                break;
            }
        } while (true);
    }
}
