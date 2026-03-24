package com.gabrielnz.mecanicas;

import com.gabrielnz.itens.Equipamentos;
import com.gabrielnz.itens.Item;
import com.gabrielnz.itens.arco.Arco;
import com.gabrielnz.itens.armadura.Armadura;
import com.gabrielnz.itens.chave.Chave;
import com.gabrielnz.itens.espada.Espada;
import com.gabrielnz.itens.pocao.Pocao;
import com.gabrielnz.magias.LivroMagia;
import com.gabrielnz.personagem.Jogador;
import exception.RPGexception;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.gabrielnz.mecanicas.Transicao.ler;

public class Inventario {
    private List<Item> inventario = new ArrayList<>();


    public void manipularInventario(Jogador jogador) {
        Scanner ler = new Scanner(System.in);

        do {
            Transicao.transicaolinha();
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║    💼 MANIPULAR INVENTÁRIO     ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Ver inventário              ║");
            System.out.println("║ 2. Equipar item                ║");
            System.out.println("║ 3. Beber poção                 ║");
            System.out.println("║ 4. Voltar                      ║");
            System.out.println("╚════════════════════════════════╝");
            boolean sair = false;
            try {
                switch (ler.nextInt()) {
                    case 1:
                        listarInventario(jogador);
                        Transicao.transicao();
                        throw new RPGexception("");
                    case 2:
                        Transicao.transicaolinha();
                        mostrarEquipamentos(jogador);
                        Transicao.transicaolinha();
                    case 3:
                        mostrarPocao(jogador);
                        Transicao.transicaolinha();
                    case 4:
                        break;
                    default:
                        System.out.println("Valor invalido...");
                        Transicao.transicao();
                }
            } catch (InputMismatchException e) {
                Transicao.transicaolinha();
                System.out.println("Digite um valor valido");
                Transicao.transicao();
            } catch (RPGexception e) {
                continue;
            }
            break;
        } while (true);
    }

    public void listarInventario(Jogador jogador) {
        Transicao.transicaolinha();
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║             💼 INVENTÁRIO 📦               ║");
        System.out.println("╠════════════════════════════════════════════╣");
        if (jogador.getInventarioJogador().getInventario().isEmpty()) {
            System.out.println("║             (Nada para equipar)            ║");
        } else {
            for (int i = 0; i < inventario.size(); i++) {
                System.out.printf("║ %2d. %-25s              ║\n", i + 1, inventario.get(i).getNome());
            }
        }
        System.out.println("╚════════════════════════════════════════════╝");
    }

    public void addArco(Arco arco) {
        inventario.add(arco);
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       ⚔️ ADICIONADO AO INVENTÁRIO ⚔️        ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public void addArmadura(Armadura armadura) {
        inventario.add(armadura);
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       🛡️ ADICIONADO AO INVENTÁRIO 🛡️        ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public void addEspada(Espada espada) {
        inventario.add(espada);
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       ⚔️ ADICIONADO AO INVENTÁRIO ⚔️        ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
    public void addLivro(LivroMagia livroMagia) {
        inventario.add(livroMagia);
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       📖 ADICIONADO AO INVENTÁRIO 📖        ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public void addPocao(Pocao pocao) {
        inventario.add(pocao);
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       ️🔮 ADICIONADO AO INVENTÁRIO ❤️         ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public void addChave(Chave chave) {
        inventario.add(chave);
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       🗝️ ADICIONADO AO INVENTÁRIO 🗝️        ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public void removeArco(Arco arco) {
        inventario.remove(arco);
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       ⚔️ REMOVIDO DO INVENTÁRIO ⚔️          ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public void removeArmadura(Armadura armadura) {
        inventario.remove(armadura);
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║        🛡️ REMOVIDO DO INVENTÁRIO 🛡️          ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public void removeEspada(Espada espada) {
        inventario.remove(espada);
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║        ⚔️ REMOVIDO DO INVENTÁRIO ⚔️          ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public void removePocao(Pocao pocao) {
        inventario.remove(pocao);
    }

    public void mostrarPocao(Jogador jogador) throws RPGexception {
        do {
            Transicao.transicaolinha();
            List<Pocao> inventarioFiltrado = jogador.getInventarioJogador().getInventario().stream().filter(x -> x instanceof Pocao).map(x -> (Pocao)x).toList();
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║             💼 INVENTÁRIO 📦               ║");
            System.out.println("╠════════════════════════════════════════════╣");

            if (inventarioFiltrado.isEmpty()) {
                System.out.println("║             (Nada para equipar)            ║");
            } else {
                for (int i = 0; i < inventarioFiltrado.size(); i++) {
                    System.out.printf("║ %2d. %-25s %-2d+          ║\n", i + 1, inventarioFiltrado.get(i).getNome(),inventarioFiltrado.get(i).getValorRecuperado());
                }
            }
            System.out.println("╚════════════════════════════════════════════╝");
            do {
                System.out.println("Digite o numero da poção para beber [0-> sair]: ");
                int escolha = ler.nextInt();
                if (escolha != 0 && escolha <= inventarioFiltrado.size()) {
                    Pocao pocao = new Pocao();
                    pocao.beberPocao(jogador, (Pocao) inventarioFiltrado.get(escolha - 1));
                    break;
                } else if (escolha == 0) {
                    throw new RPGexception("");
                } else {
                    System.out.println("Opção invalida...");
                    Transicao.transicao();
                    break;
                }
            } while (true);
        } while (true);
    }

    public void mostrarEquipamentos(Jogador jogador) throws RPGexception {
        do {
            Transicao.transicaolinha();
            List<Equipamentos> inventarioFiltrado = jogador.getInventarioJogador().getInventario().stream().filter(x -> x instanceof Armadura || x instanceof Espada || x instanceof Arco || x instanceof LivroMagia).map(x -> (Equipamentos) x).toList();
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║             💼 INVENTÁRIO 📦               ║");
            System.out.println("╠════════════════════════════════════════════╣");
            if (inventarioFiltrado.isEmpty()) {
                System.out.println("║             (Nada para equipar)            ║");
            } else {
                for (int i = 0; i < inventarioFiltrado.size(); i++) {
                    String equipados = "";
                    if (inventarioFiltrado.get(i).isEquipado()) {
                        equipados = "EQUIPADO";
                    }
                    if(inventarioFiltrado.get(i) instanceof Espada || inventarioFiltrado.get(i) instanceof Arco){
                        System.out.printf("║ %2d. %-25s d%-2d %-8s ║\n", i + 1, inventarioFiltrado.get(i).getNome(),inventarioFiltrado.get(i).getDado().getDadoClasse(),equipados);
                    }else if(inventarioFiltrado.get(i) instanceof Armadura){
                        System.out.printf("║ %2d. %-25s %2d  %-8s ║\n", i + 1, inventarioFiltrado.get(i).getNome(), inventarioFiltrado.get(i).getValorArmadura(), equipados);
                    } else {
                        System.out.printf("║ %2d. %-25s %-8s     ║\n", i + 1, inventarioFiltrado.get(i).getNome(), equipados);
                    }
                }
            }

            System.out.println("╚════════════════════════════════════════════╝");
            do {
                System.out.println("Digite o numero do equipamento para o equipar ou desequipar [0-> sair]: ");
                int escolha = ler.nextInt();
                if (escolha != 0 && escolha <= inventarioFiltrado.size()) {
                    if (inventarioFiltrado.get(escolha - 1) instanceof Espada || inventarioFiltrado.get(escolha - 1) instanceof Arco) {
                        equiparArma(jogador, inventarioFiltrado, escolha);
                    } else if (inventarioFiltrado.get(escolha - 1) instanceof Armadura) {
                        equiparArmadura(jogador, inventarioFiltrado, escolha);
                    } else {
                        equiparLivro(jogador, inventarioFiltrado, escolha);
                    }
                    break;
                } else if (escolha == 0) {
                    throw new RPGexception("");
                } else {
                    System.out.println("Opção invalida...");
                    Transicao.transicao();
                    break;
                }
            } while (true);
        } while (true);
    }

    public void equiparArma(Jogador jogador, List<Equipamentos> inventarioFiltrado, int escolha) {
        if (inventarioFiltrado.get(escolha - 1).isEquipado() && jogador.getArma() != null) {
            inventarioFiltrado.get(escolha - 1).setEquipado(false);
            jogador.setArma(null);
        } else if (!inventarioFiltrado.get(escolha - 1).isEquipado() && jogador.getArma() == null) {
            inventarioFiltrado.get(escolha - 1).setEquipado(true);
            jogador.setArma(inventarioFiltrado.get(escolha - 1));
        } else if (!inventarioFiltrado.get(escolha - 1).isEquipado() && jogador.getArma() != null) {
            System.out.println("Desequipe sua arma antes de equipar uma nova...");
            Transicao.transicao();
        }
    }

    public void equiparArmadura(Jogador jogador, List<Equipamentos> inventarioFiltrado, int escolha) {

        if (inventarioFiltrado.get(escolha - 1).isEquipado()) {
            inventarioFiltrado.get(escolha - 1).setEquipado(false);
            jogador.setArmadura(null);
        } else if (!inventarioFiltrado.get(escolha - 1).isEquipado() && jogador.getArmadura() == null) {
            inventarioFiltrado.get(escolha - 1).setEquipado(true);
            jogador.setArmadura(inventarioFiltrado.get(escolha - 1));
        } else {
            System.out.println("Desequipe sua armadura antes de equipar uma nova...");
            Transicao.transicao();
        }
    }
    public void equiparLivro(Jogador jogador, List<Equipamentos> inventarioFiltrado, int escolha) {

        if (inventarioFiltrado.get(escolha - 1).isEquipado()) {
            inventarioFiltrado.get(escolha - 1).setEquipado(false);
            jogador.setLivroMagia(null);
        } else if (!inventarioFiltrado.get(escolha - 1).isEquipado() && jogador.getLivroMagia() == null) {
            inventarioFiltrado.get(escolha - 1).setEquipado(true);
            jogador.setLivroMagia((LivroMagia) inventarioFiltrado.get(escolha - 1));
        } else {
            System.out.println("Desequipe seu livro antes de equipar um novo...");
            Transicao.transicao();
        }
    }

    public List<Item> getInventario() {
        return inventario;
    }
}
