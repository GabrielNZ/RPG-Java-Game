package com.gabrielnz.mecanicas;

import com.gabrielnz.combate.Dados;
import com.gabrielnz.itens.Item;
import com.gabrielnz.itens.ouro.Ouro;
import com.gabrielnz.itens.Raridade;
import com.gabrielnz.itens.arco.Arco;
import com.gabrielnz.itens.armadura.Armadura;
import com.gabrielnz.itens.espada.Espada;
import com.gabrielnz.itens.pocao.PMana;
import com.gabrielnz.itens.pocao.PVida;
import com.gabrielnz.itens.pocao.Pocao;
import com.gabrielnz.itens.Tamanho;
import com.gabrielnz.personagem.Jogador;
import java.util.ArrayList;
import java.util.List;

import static com.gabrielnz.combate.Dados.r;

public class Recompensa {

    public void recompensaBau(Jogador jogador) {
        boolean vazio = false;
        Item item = null;
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║ 🗝️ VOCÊ ENCONTROU UM BAÚ! 🗝️ ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║  O que será que há dentro?   ║");
        System.out.println("╚══════════════════════════════╝");
        Transicao.transicao();
        int sorte = Dados.d20();
        if(sorte != 1){
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║   🎉 PARABÉNS, VOCÊ ENCONTROU UMA RECOMPENSA! 🎉   ║");
            System.out.println("╚════════════════════════════════════════════════════╝");
        }
        if (sorte == 1) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║ ❌️    Estava vazio...    ❌  ║");
            System.out.println("╚══════════════════════════════╝");
            vazio = true;
        } else if (sorte <= 9) {
            Ouro ouro = sortearOuro(jogador);
            item = ouro;
            jogador.setOuro(jogador.getOuro() + ouro.getValor());
        }else if (sorte <= 14) {
            Pocao pocao = sortearPocao(jogador);
            item = pocao;
            jogador.getInventarioJogador().addPocao(pocao);
        }else if (sorte <= 16) {
            Espada espada = sortearEspada(jogador);
            item = espada;
            jogador.getInventarioJogador().addEspada(espada);
        }else if (sorte <= 18) {
            Armadura armadura = sortearArmadura(jogador);
            item = armadura;
            jogador.getInventarioJogador().addArmadura(armadura);
        }else if (sorte <= 20) {
            Arco arco = sortearArco(jogador);
            item = arco;
            jogador.getInventarioJogador().addArco(arco);
        }
        if(!vazio) {
            System.out.println("╔═══════════════════════════════════╗");
            System.out.printf("║      📜 STATUS DO ITEM 📜        ║%n");
            System.out.println("╠═══════════════════════════════════╣");
            System.out.printf("║ Nome: %-25s   ║%n", item.getNome());
            System.out.printf("║ Raridade: %-16s        ║%n", item.getRaridade());
            System.out.printf("║ %-26s        ║%n", item.toString());
            System.out.println("╚═══════════════════════════════════╝");
        }
    }

    public Pocao sortearPocao(Jogador jogador) {
        List<Pocao> pocao = new ArrayList<>();
        int sorteio;
        if (jogador.getNivel() > 10) {
            sorteio = Dados.d6();
            PVida pocaoV1 = new PVida(Tamanho.PEQUENA, Raridade.COMUM, 1,20);
            PVida pocaoV2 = new PVida(Tamanho.MEDIA, Raridade.INCOMUM, 2,45);
            PVida pocaoV3 = new PVida(Tamanho.GRANDE, Raridade.RARO, 3,65);

            PMana pocaoM1 = new PMana(Tamanho.PEQUENA, Raridade.COMUM, 4,15);
            PMana pocaoM2 = new PMana(Tamanho.MEDIA, Raridade.INCOMUM, 5,40);
            PMana pocaoM3 = new PMana(Tamanho.GRANDE, Raridade.RARO, 6,60);

            pocao.add(pocaoV1);
            pocao.add(pocaoV2);
            pocao.add(pocaoV3);

            pocao.add(pocaoM1);
            pocao.add(pocaoM2);
            pocao.add(pocaoM3);

            List<Pocao> pocaoSorteada = pocao.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return pocaoSorteada.getFirst();

        } else if (jogador.getNivel() > 5) {
            sorteio = Dados.d4();
            PVida pocaoV1 = new PVida(Tamanho.PEQUENA, Raridade.COMUM, 1,20);
            PVida pocaoV2 = new PVida(Tamanho.MEDIA, Raridade.INCOMUM, 2,45);

            PMana pocaoM1 = new PMana(Tamanho.PEQUENA, Raridade.COMUM, 3,15);
            PMana pocaoM2 = new PMana(Tamanho.MEDIA, Raridade.INCOMUM, 4,40);

            pocao.add(pocaoV1);
            pocao.add(pocaoV2);

            pocao.add(pocaoM1);
            pocao.add(pocaoM2);

            List<Pocao> pocaoSorteada = pocao.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return pocaoSorteada.getFirst();

        } else if (jogador.getNivel() <= 5) {
            sorteio = Dados.d2();
            PVida pocaoV1 = new PVida(Tamanho.PEQUENA, Raridade.COMUM, 1,20);
            PMana pocaoM1 = new PMana(Tamanho.PEQUENA, Raridade.COMUM, 2,15);

            pocao.add(pocaoV1);

            pocao.add(pocaoM1);

            List<Pocao> pocaoSorteada = pocao.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return pocaoSorteada.getFirst();
        }
        return null;
    }

    public Ouro sortearOuro(Jogador jogador) {
        List<Ouro> ouro = new ArrayList<>();
        int sorteio;
        if (jogador.getNivel() > 10) {
            sorteio = Dados.d3();
            Ouro ouro1 = new Ouro("Saco de Ouro Pequeno", r.nextInt(40, 70), Raridade.COMUM, 1);
            Ouro ouro2 = new Ouro("Saco de Ouro Medio", r.nextInt(90, 120), Raridade.INCOMUM, 2);
            Ouro ouro3 = new Ouro("Saco de Ouro Grande", r.nextInt(180, 210), Raridade.RARO, 3);

            ouro.add(ouro1);
            ouro.add(ouro2);
            ouro.add(ouro3);

            List<Ouro> ouroSorteado = ouro.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return ouroSorteado.getFirst();

        } else if (jogador.getNivel() > 5) {
            sorteio = Dados.d2();
            Ouro ouro1 = new Ouro("Saco de Ouro Pequeno", r.nextInt(40, 70), Raridade.COMUM, 1);
            Ouro ouro2 = new Ouro("Saco de Ouro Medio", r.nextInt(90, 120), Raridade.INCOMUM, 2);

            ouro.add(ouro1);
            ouro.add(ouro2);

            List<Ouro> ouroSorteado = ouro.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return ouroSorteado.getFirst();

        } else if (jogador.getNivel() <= 5) {
            return new Ouro("Saco de Ouro Pequeno", r.nextInt(40, 70), Raridade.COMUM, 1);
        }
        return null;
    }

    public Espada sortearEspada(Jogador jogador) {
        List<Espada> espada = new ArrayList<>();
        int sorteio;
        if (jogador.getNivel() >= 20) {
            sorteio = Dados.d20();
            // COMUM
            Espada espadaComum1 = new Espada("Espada de Aluminio", new Dados(2), 20, 5, Raridade.COMUM, 1);
            Espada espadaComum2 = new Espada("Espada de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2);
            Espada espadaComum3 = new Espada("Espada de Cobre", new Dados(4), 75, 35, Raridade.COMUM, 3);
            Espada espadaComum4 = new Espada("Espada de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4);
            // INCOMUM
            Espada espadaIncomum1 = new Espada("Espada de Bronze", new Dados(6), 150, 70, Raridade.INCOMUM, 5);
            Espada espadaIncomum2 = new Espada("Espada de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6);
            Espada espadaIncomum3 = new Espada("Espada de Ferro Envenenada", new Dados(8), 245, 130, Raridade.INCOMUM, 7);
            Espada espadaIncomum4 = new Espada("Espada de Ferro Forjado", new Dados(9), 300, 180, Raridade.INCOMUM, 8);

            // RARO
            Espada espadaRara1 = new Espada("Espada de Cristal", new Dados(10), 450, 250, Raridade.RARO, 9);
            Espada espadaRara2 = new Espada("Espada de Prata", new Dados(11), 490, 300, Raridade.RARO, 10);
            Espada espadaRara3 = new Espada("Espada de Aço Carbono", new Dados(12), 520, 340, Raridade.RARO, 11);
            Espada espadaRara4 = new Espada("Espada de Esmeralda", new Dados(13), 550, 400, Raridade.RARO, 12);

            // EPICO
            Espada espadaEpico1 = new Espada("Espada de Ouro", new Dados(14), 650, 430, Raridade.EPICO, 13);
            Espada espadaEpico2 = new Espada("Espada de Dragão", new Dados(15), 715, 490, Raridade.EPICO, 14);
            Espada espadaEpico3 = new Espada("Espada de Plutônio", new Dados(16), 750, 520, Raridade.EPICO, 15);
            Espada espadaEpico4 = new Espada("Espada de Mithril", new Dados(17), 800, 590, Raridade.EPICO, 16);

            // LENDARIO
            Espada espadaLendario1 = new Espada("Espada de Aço Estelar", new Dados(18), 900, 650, Raridade.LENDARIO, 17);
            Espada espadaLendario2 = new Espada("Espada de Fogo Eterno", new Dados(19), 1000, 680, Raridade.LENDARIO, 18);
            Espada espadaLendario3 = new Espada("Espada do Rei", new Dados(20), 1180, 720, Raridade.LENDARIO, 19);
            Espada espadaLendario4 = new Espada("Espada do Céu", new Dados(21), 1300, 800, Raridade.LENDARIO, 20);

            espada.add(espadaComum1);
            espada.add(espadaComum2);
            espada.add(espadaComum3);
            espada.add(espadaComum4);
            espada.add(espadaIncomum1);
            espada.add(espadaIncomum2);
            espada.add(espadaIncomum3);
            espada.add(espadaIncomum4);
            espada.add(espadaRara1);
            espada.add(espadaRara2);
            espada.add(espadaRara3);
            espada.add(espadaRara4);
            espada.add(espadaEpico1);
            espada.add(espadaEpico2);
            espada.add(espadaEpico3);
            espada.add(espadaEpico4);
            espada.add(espadaLendario1);
            espada.add(espadaLendario2);
            espada.add(espadaLendario3);
            espada.add(espadaLendario4);

            List<Espada> espadaSorteada = espada.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return espadaSorteada.getFirst();

        } else if (jogador.getNivel() >= 15) {
            sorteio = Dados.d16();

            // COMUM
            Espada espadaComum1 = new Espada("Espada de Madeira", new Dados(2), 20, 5, Raridade.COMUM, 1);
            Espada espadaComum2 = new Espada("Espada de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2);
            Espada espadaComum3 = new Espada("Espada de Cobre", new Dados(4), 75, 35, Raridade.COMUM, 3);
            Espada espadaComum4 = new Espada("Espada de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4);
            // INCOMUM
            Espada espadaIncomum1 = new Espada("Espada de Bronze", new Dados(6), 150, 70, Raridade.INCOMUM, 5);
            Espada espadaIncomum2 = new Espada("Espada de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6);
            Espada espadaIncomum3 = new Espada("Espada de Ferro Envenenada", new Dados(8), 245, 130, Raridade.INCOMUM, 7);
            Espada espadaIncomum4 = new Espada("Espada de Ferro Forjado", new Dados(9), 300, 180, Raridade.INCOMUM, 8);

            // RARO
            Espada espadaRara1 = new Espada("Espada de Cristal", new Dados(10), 450, 250, Raridade.RARO, 9);
            Espada espadaRara2 = new Espada("Espada de Prata", new Dados(11), 490, 300, Raridade.RARO, 10);
            Espada espadaRara3 = new Espada("Espada de Aço Carbono", new Dados(12), 520, 340, Raridade.RARO, 11);
            Espada espadaRara4 = new Espada("Espada de Esmeralda", new Dados(13), 550, 400, Raridade.RARO, 12);

            // EPICO
            Espada espadaEpico1 = new Espada("Espada de Ouro", new Dados(14), 650, 430, Raridade.EPICO, 13);
            Espada espadaEpico2 = new Espada("Espada de Dragão", new Dados(15), 715, 490, Raridade.EPICO, 14);
            Espada espadaEpico3 = new Espada("Espada de Plutônio", new Dados(16), 750, 520, Raridade.EPICO, 15);
            Espada espadaEpico4 = new Espada("Espada de Mithril", new Dados(17), 800, 590, Raridade.EPICO, 16);
            espada.add(espadaComum1);
            espada.add(espadaComum2);
            espada.add(espadaComum3);
            espada.add(espadaComum4);
            espada.add(espadaIncomum1);
            espada.add(espadaIncomum2);
            espada.add(espadaIncomum3);
            espada.add(espadaIncomum4);
            espada.add(espadaRara1);
            espada.add(espadaRara2);
            espada.add(espadaRara3);
            espada.add(espadaRara4);
            espada.add(espadaEpico1);
            espada.add(espadaEpico2);
            espada.add(espadaEpico3);
            espada.add(espadaEpico4);

            List<Espada> espadaSorteada = espada.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return espadaSorteada.getFirst();

        } else if (jogador.getNivel() > 10) {
            sorteio = Dados.d12();

            // COMUM
            Espada espadaComum1 = new Espada("Espada de Madeira", new Dados(2), 20, 5, Raridade.COMUM, 1);
            Espada espadaComum2 = new Espada("Espada de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2);
            Espada espadaComum3 = new Espada("Espada de Cobre", new Dados(4), 75, 35, Raridade.COMUM, 3);
            Espada espadaComum4 = new Espada("Espada de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4);
            // INCOMUM
            Espada espadaIncomum1 = new Espada("Espada de Bronze", new Dados(6), 150, 70, Raridade.INCOMUM, 5);
            Espada espadaIncomum2 = new Espada("Espada de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6);
            Espada espadaIncomum3 = new Espada("Espada de Ferro Envenenada", new Dados(8), 245, 130, Raridade.INCOMUM, 7);
            Espada espadaIncomum4 = new Espada("Espada de Ferro Forjado", new Dados(9), 300, 180, Raridade.INCOMUM, 8);

            // RARO
            Espada espadaRara1 = new Espada("Espada de Cristal", new Dados(10), 450, 250, Raridade.RARO, 9);
            Espada espadaRara2 = new Espada("Espada de Prata", new Dados(11), 490, 300, Raridade.RARO, 10);
            Espada espadaRara3 = new Espada("Espada de Aço Carbono", new Dados(12), 520, 340, Raridade.RARO, 11);
            Espada espadaRara4 = new Espada("Espada de Esmeralda", new Dados(13), 550, 400, Raridade.RARO, 12);
            espada.add(espadaComum1);
            espada.add(espadaComum2);
            espada.add(espadaComum3);
            espada.add(espadaComum4);
            espada.add(espadaIncomum1);
            espada.add(espadaIncomum2);
            espada.add(espadaIncomum3);
            espada.add(espadaIncomum4);
            espada.add(espadaRara1);
            espada.add(espadaRara2);
            espada.add(espadaRara3);
            espada.add(espadaRara4);

            List<Espada> espadaSorteada = espada.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return espadaSorteada.getFirst();

        } else if (jogador.getNivel() > 5) {
            sorteio = Dados.d8();
            // COMUM
            Espada espadaComum1 = new Espada("Espada de Madeira", new Dados(2), 20, 5, Raridade.COMUM, 1);
            Espada espadaComum2 = new Espada("Espada de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2);
            Espada espadaComum3 = new Espada("Espada de Cobre", new Dados(4), 75, 35, Raridade.COMUM, 3);
            Espada espadaComum4 = new Espada("Espada de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4);
            // INCOMUM
            Espada espadaIncomum1 = new Espada("Espada de Bronze", new Dados(6), 150, 70, Raridade.INCOMUM, 5);
            Espada espadaIncomum2 = new Espada("Espada de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6);
            Espada espadaIncomum3 = new Espada("Espada de Ferro Envenenada", new Dados(8), 245, 130, Raridade.INCOMUM, 7);
            Espada espadaIncomum4 = new Espada("Espada de Ferro Forjado", new Dados(9), 300, 180, Raridade.INCOMUM, 8);
            espada.add(espadaComum1);
            espada.add(espadaComum2);
            espada.add(espadaComum3);
            espada.add(espadaComum4);
            espada.add(espadaIncomum1);
            espada.add(espadaIncomum2);
            espada.add(espadaIncomum3);
            espada.add(espadaIncomum4);

            List<Espada> espadaSorteada = espada.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return espadaSorteada.getFirst();

        } else if (jogador.getNivel() <= 5) {
            sorteio = Dados.d4();

            // COMUM
            Espada espadaComum1 = new Espada("Espada de Madeira", new Dados(2), 20, 5, Raridade.COMUM, 1);
            Espada espadaComum2 = new Espada("Espada de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2);
            Espada espadaComum3 = new Espada("Espada de Cobre", new Dados(4), 75, 35, Raridade.COMUM, 3);
            Espada espadaComum4 = new Espada("Espada de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4);
            espada.add(espadaComum1);
            espada.add(espadaComum2);
            espada.add(espadaComum3);
            espada.add(espadaComum4);

            List<Espada> espadaSorteada = espada.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return espadaSorteada.getFirst();

        }
        return null;
    }

    public Arco sortearArco(Jogador jogador) {
        List<Arco> arco = new ArrayList<>();
        int sorteio;
        if (jogador.getNivel() >= 20) {
            sorteio = Dados.d20();

            // COMUM
            Arco arcoComum1 = new Arco("Arco de Madeira", new Dados(2), 20, 5, Raridade.COMUM, 1);
            Arco arcoComum2 = new Arco("Arco de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2);
            Arco arcoComum3 = new Arco("Arco de Cobre", new Dados(4), 75, 35, Raridade.COMUM, 3);
            Arco arcoComum4 = new Arco("Arco de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4);
            // INCOMUM
            Arco arcoIncomum1 = new Arco("Arco de Bronze", new Dados(6), 150, 70, Raridade.INCOMUM, 5);
            Arco arcoIncomum2 = new Arco("Arco de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6);
            Arco arcoIncomum3 = new Arco("Arco de Ferro Envenenado", new Dados(8), 245, 130, Raridade.INCOMUM, 7);
            Arco arcoIncomum4 = new Arco("Arco de Ferro Forjado", new Dados(9), 300, 180, Raridade.INCOMUM, 8);

            // RARO
            Arco arcoRaro1 = new Arco("Arco de Cristal", new Dados(10), 450, 250, Raridade.RARO, 9);
            Arco arcoRaro2 = new Arco("Arco de Prata", new Dados(11), 490, 300, Raridade.RARO, 10);
            Arco arcoRaro3 = new Arco("Arco de Aço Carbono", new Dados(12), 520, 340, Raridade.RARO, 11);
            Arco arcoRaro4 = new Arco("Arco de Esmeralda", new Dados(13), 550, 400, Raridade.RARO, 12);

            // EPICO
            Arco arcoEpico1 = new Arco("Arco de Ouro", new Dados(14), 650, 430, Raridade.EPICO, 13);
            Arco arcoEpico2 = new Arco("Arco de Dragão", new Dados(15), 715, 490, Raridade.EPICO, 14);
            Arco arcoEpico3 = new Arco("Arco de Plutônio", new Dados(16), 750, 520, Raridade.EPICO, 15);
            Arco arcoEpico4 = new Arco("Arco de Mithril", new Dados(17), 800, 590, Raridade.EPICO, 16);

            // LENDARIO
            Arco arcoLendario1 = new Arco("Arco de Aço Estelar", new Dados(18), 900, 650, Raridade.LENDARIO, 17);
            Arco arcoLendario2 = new Arco("Arco de Fogo Eterno", new Dados(19), 1000, 680, Raridade.LENDARIO, 18);
            Arco arcoLendario3 = new Arco("Arco do Rei", new Dados(20), 1180, 720, Raridade.LENDARIO, 19);
            Arco arcoLendario4 = new Arco("Arco do Céu", new Dados(21), 1300, 800, Raridade.LENDARIO, 20);

            arco.add(arcoComum1);
            arco.add(arcoComum2);
            arco.add(arcoComum3);
            arco.add(arcoComum4);
            arco.add(arcoIncomum1);
            arco.add(arcoIncomum2);
            arco.add(arcoIncomum3);
            arco.add(arcoIncomum4);
            arco.add(arcoRaro1);
            arco.add(arcoRaro2);
            arco.add(arcoRaro3);
            arco.add(arcoRaro4);
            arco.add(arcoEpico1);
            arco.add(arcoEpico2);
            arco.add(arcoEpico3);
            arco.add(arcoEpico4);
            arco.add(arcoLendario1);
            arco.add(arcoLendario2);
            arco.add(arcoLendario3);
            arco.add(arcoLendario4);

            List<Arco> arcoSorteado = arco.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return arcoSorteado.getFirst();

        } else if (jogador.getNivel() >= 15) {
            sorteio = Dados.d16();
            // COMUM
            Arco arcoComum1 = new Arco("Arco de Madeira", new Dados(2), 20, 5, Raridade.COMUM, 1);
            Arco arcoComum2 = new Arco("Arco de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2);
            Arco arcoComum3 = new Arco("Arco de Cobre", new Dados(4), 75, 35, Raridade.COMUM, 3);
            Arco arcoComum4 = new Arco("Arco de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4);
            // INCOMUM
            Arco arcoIncomum1 = new Arco("Arco de Bronze", new Dados(6), 150, 70, Raridade.INCOMUM, 5);
            Arco arcoIncomum2 = new Arco("Arco de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6);
            Arco arcoIncomum3 = new Arco("Arco de Ferro Envenenado", new Dados(8), 245, 130, Raridade.INCOMUM, 7);
            Arco arcoIncomum4 = new Arco("Arco de Ferro Forjado", new Dados(9), 300, 180, Raridade.INCOMUM, 8);

            // RARO
            Arco arcoRaro1 = new Arco("Arco de Cristal", new Dados(10), 450, 250, Raridade.RARO, 9);
            Arco arcoRaro2 = new Arco("Arco de Prata", new Dados(11), 490, 300, Raridade.RARO, 10);
            Arco arcoRaro3 = new Arco("Arco de Aço Carbono", new Dados(12), 520, 340, Raridade.RARO, 11);
            Arco arcoRaro4 = new Arco("Arco de Esmeralda", new Dados(13), 550, 400, Raridade.RARO, 12);

            // EPICO
            Arco arcoEpico1 = new Arco("Arco de Ouro", new Dados(14), 650, 430, Raridade.EPICO, 13);
            Arco arcoEpico2 = new Arco("Arco de Dragão", new Dados(15), 715, 490, Raridade.EPICO, 14);
            Arco arcoEpico3 = new Arco("Arco de Plutônio", new Dados(16), 750, 520, Raridade.EPICO, 15);
            Arco arcoEpico4 = new Arco("Arco de Mithril", new Dados(17), 800, 590, Raridade.EPICO, 16);

            arco.add(arcoComum1);
            arco.add(arcoComum2);
            arco.add(arcoComum3);
            arco.add(arcoComum4);
            arco.add(arcoIncomum1);
            arco.add(arcoIncomum2);
            arco.add(arcoIncomum3);
            arco.add(arcoIncomum4);
            arco.add(arcoRaro1);
            arco.add(arcoRaro2);
            arco.add(arcoRaro3);
            arco.add(arcoRaro4);
            arco.add(arcoEpico1);
            arco.add(arcoEpico2);
            arco.add(arcoEpico3);
            arco.add(arcoEpico4);

            List<Arco> arcoSorteado = arco.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return arcoSorteado.getFirst();

        } else if (jogador.getNivel() > 10) {
            sorteio = Dados.d12();
            // COMUM
            Arco arcoComum1 = new Arco("Arco de Madeira", new Dados(2), 20, 5, Raridade.COMUM, 1);
            Arco arcoComum2 = new Arco("Arco de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2);
            Arco arcoComum3 = new Arco("Arco de Cobre", new Dados(4), 75, 35, Raridade.COMUM, 3);
            Arco arcoComum4 = new Arco("Arco de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4);
            // INCOMUM
            Arco arcoIncomum1 = new Arco("Arco de Bronze", new Dados(6), 150, 70, Raridade.INCOMUM, 5);
            Arco arcoIncomum2 = new Arco("Arco de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6);
            Arco arcoIncomum3 = new Arco("Arco de Ferro Envenenado", new Dados(8), 245, 130, Raridade.INCOMUM, 7);
            Arco arcoIncomum4 = new Arco("Arco de Ferro Forjado", new Dados(9), 300, 180, Raridade.INCOMUM, 8);

            // RARO
            Arco arcoRaro1 = new Arco("Arco de Cristal", new Dados(10), 450, 250, Raridade.RARO, 9);
            Arco arcoRaro2 = new Arco("Arco de Prata", new Dados(11), 490, 300, Raridade.RARO, 10);
            Arco arcoRaro3 = new Arco("Arco de Aço Carbono", new Dados(12), 520, 340, Raridade.RARO, 11);
            Arco arcoRaro4 = new Arco("Arco de Esmeralda", new Dados(13), 550, 400, Raridade.RARO, 12);

            arco.add(arcoComum1);
            arco.add(arcoComum2);
            arco.add(arcoComum3);
            arco.add(arcoComum4);
            arco.add(arcoIncomum1);
            arco.add(arcoIncomum2);
            arco.add(arcoIncomum3);
            arco.add(arcoIncomum4);
            arco.add(arcoRaro1);
            arco.add(arcoRaro2);
            arco.add(arcoRaro3);
            arco.add(arcoRaro4);

            List<Arco> arcoSorteado = arco.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return arcoSorteado.getFirst();

        } else if (jogador.getNivel() > 5) {
            sorteio = Dados.d8();
            // COMUM
            Arco arcoComum1 = new Arco("Arco de Madeira", new Dados(2), 20, 5, Raridade.COMUM, 1);
            Arco arcoComum2 = new Arco("Arco de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2);
            Arco arcoComum3 = new Arco("Arco de Cobre", new Dados(4), 75, 35, Raridade.COMUM, 3);
            Arco arcoComum4 = new Arco("Arco de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4);
            // INCOMUM
            Arco arcoIncomum1 = new Arco("Arco de Bronze", new Dados(6), 150, 70, Raridade.INCOMUM, 5);
            Arco arcoIncomum2 = new Arco("Arco de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6);
            Arco arcoIncomum3 = new Arco("Arco de Ferro Envenenado", new Dados(8), 245, 130, Raridade.INCOMUM, 7);
            Arco arcoIncomum4 = new Arco("Arco de Ferro Forjado", new Dados(9), 300, 180, Raridade.INCOMUM, 8);

            arco.add(arcoComum1);
            arco.add(arcoComum2);
            arco.add(arcoComum3);
            arco.add(arcoComum4);
            arco.add(arcoIncomum1);
            arco.add(arcoIncomum2);
            arco.add(arcoIncomum3);
            arco.add(arcoIncomum4);

            List<Arco> arcoSorteado = arco.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return arcoSorteado.getFirst();

        } else if (jogador.getNivel() <= 5) {
            sorteio = Dados.d4();

            // COMUM
            Arco arcoComum1 = new Arco("Arco de Madeira", new Dados(2), 20, 5, Raridade.COMUM, 1);
            Arco arcoComum2 = new Arco("Arco de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2);
            Arco arcoComum3 = new Arco("Arco de Cobre", new Dados(4), 75, 35, Raridade.COMUM, 3);
            Arco arcoComum4 = new Arco("Arco de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4);
            arco.add(arcoComum1);
            arco.add(arcoComum2);
            arco.add(arcoComum3);
            arco.add(arcoComum4);

            List<Arco> arcoSorteado = arco.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return arcoSorteado.getFirst();

        }
        return null;
    }

    public Armadura sortearArmadura(Jogador jogador) {
        List<Armadura> armadura = new ArrayList<>();
        int sorteio;
        if (jogador.getNivel() >= 20) {
            sorteio = Dados.d20();
            // COMUM
            Armadura armaduraComum1 = new Armadura("Armadura de Lona", 1, 20, 5, Raridade.COMUM, 1);
            Armadura armaduraComum2 = new Armadura("Armadura de Couro", 2, 50, 20, Raridade.COMUM, 2);
            Armadura armaduraComum3 = new Armadura("Armadura de Cobre", 3, 75, 35, Raridade.COMUM, 3);
            Armadura armaduraComum4 = new Armadura("Armadura de Ferro", 4, 100, 55, Raridade.COMUM, 4);

            // INCOMUM
            Armadura armaduraIncomum1 = new Armadura("Armadura de Bronze", 5, 150, 70, Raridade.INCOMUM, 5);
            Armadura armaduraIncomum2 = new Armadura("Armadura de Aço", 6, 200, 105, Raridade.INCOMUM, 6);
            Armadura armaduraIncomum3 = new Armadura("Armadura de Ferro Envenenada", 7, 245, 130, Raridade.INCOMUM, 7);
            Armadura armaduraIncomum4 = new Armadura("Armadura de Ferro Forjado", 8, 300, 180, Raridade.INCOMUM, 8);

            // RARO
            Armadura armaduraRara1 = new Armadura("Armadura de Cristal", 9, 450, 250, Raridade.RARO, 9);
            Armadura armaduraRara2 = new Armadura("Armadura de Prata", 10, 490, 300, Raridade.RARO, 10);
            Armadura armaduraRara3 = new Armadura("Armadura de Aço Carbono", 11, 520, 340, Raridade.RARO, 11);
            Armadura armaduraRara4 = new Armadura("Armadura de Esmeralda", 12, 550, 400, Raridade.RARO, 12);

            // EPICO
            Armadura armaduraEpico1 = new Armadura("Armadura de Ouro", 13, 650, 430, Raridade.EPICO, 13);
            Armadura armaduraEpico2 = new Armadura("Armadura de Dragão", 14, 715, 490, Raridade.EPICO, 14);
            Armadura armaduraEpico3 = new Armadura("Armadura de Plutônio", 15, 750, 520, Raridade.EPICO, 15);
            Armadura armaduraEpico4 = new Armadura("Armadura de Mithril", 16, 800, 590, Raridade.EPICO, 16);

            // LENDARIO
            Armadura armaduraLendario1 = new Armadura("Armadura de Aço Estelar", 17, 900, 650, Raridade.LENDARIO, 17);
            Armadura armaduraLendario2 = new Armadura("Armadura de Fogo Eterno", 18, 1000, 680, Raridade.LENDARIO, 18);
            Armadura armaduraLendario3 = new Armadura("Armadura do Rei", 19, 1180, 720, Raridade.LENDARIO, 19);
            Armadura armaduraLendario4 = new Armadura("Armadura do Céu", 20, 1300, 800, Raridade.LENDARIO, 20);

            armadura.add(armaduraComum1);
            armadura.add(armaduraComum2);
            armadura.add(armaduraComum3);
            armadura.add(armaduraComum4);
            armadura.add(armaduraIncomum1);
            armadura.add(armaduraIncomum2);
            armadura.add(armaduraIncomum3);
            armadura.add(armaduraIncomum4);
            armadura.add(armaduraRara1);
            armadura.add(armaduraRara2);
            armadura.add(armaduraRara3);
            armadura.add(armaduraRara4);
            armadura.add(armaduraEpico1);
            armadura.add(armaduraEpico2);
            armadura.add(armaduraEpico3);
            armadura.add(armaduraEpico4);
            armadura.add(armaduraLendario1);
            armadura.add(armaduraLendario2);
            armadura.add(armaduraLendario3);
            armadura.add(armaduraLendario4);

            List<Armadura> armaduraSorteada = armadura.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return armaduraSorteada.getFirst();

        } else if (jogador.getNivel() >= 15) {
            sorteio = Dados.d16();

            // COMUM
            Armadura armaduraComum1 = new Armadura("Armadura de Lona", 1, 20, 5, Raridade.COMUM, 1);
            Armadura armaduraComum2 = new Armadura("Armadura de Couro", 2, 50, 20, Raridade.COMUM, 2);
            Armadura armaduraComum3 = new Armadura("Armadura de Cobre", 3, 75, 35, Raridade.COMUM, 3);
            Armadura armaduraComum4 = new Armadura("Armadura de Ferro", 4, 100, 55, Raridade.COMUM, 4);

            // INCOMUM
            Armadura armaduraIncomum1 = new Armadura("Armadura de Bronze", 5, 150, 70, Raridade.INCOMUM, 5);
            Armadura armaduraIncomum2 = new Armadura("Armadura de Aço", 6, 200, 105, Raridade.INCOMUM, 6);
            Armadura armaduraIncomum3 = new Armadura("Armadura de Ferro Envenenada", 7, 245, 130, Raridade.INCOMUM, 7);
            Armadura armaduraIncomum4 = new Armadura("Armadura de Ferro Forjado", 8, 300, 180, Raridade.INCOMUM, 8);

            // RARO
            Armadura armaduraRara1 = new Armadura("Armadura de Cristal", 9, 450, 250, Raridade.RARO, 9);
            Armadura armaduraRara2 = new Armadura("Armadura de Prata", 10, 490, 300, Raridade.RARO, 10);
            Armadura armaduraRara3 = new Armadura("Armadura de Aço Carbono", 11, 520, 340, Raridade.RARO, 11);
            Armadura armaduraRara4 = new Armadura("Armadura de Esmeralda", 12, 550, 400, Raridade.RARO, 12);

            // EPICO
            Armadura armaduraEpico1 = new Armadura("Armadura de Ouro", 13, 650, 430, Raridade.EPICO, 13);
            Armadura armaduraEpico2 = new Armadura("Armadura de Dragão", 14, 715, 490, Raridade.EPICO, 14);
            Armadura armaduraEpico3 = new Armadura("Armadura de Plutônio", 15, 750, 520, Raridade.EPICO, 15);
            Armadura armaduraEpico4 = new Armadura("Armadura de Mithril", 16, 800, 590, Raridade.EPICO, 16);
            armadura.add(armaduraComum1);
            armadura.add(armaduraComum2);
            armadura.add(armaduraComum3);
            armadura.add(armaduraComum4);
            armadura.add(armaduraIncomum1);
            armadura.add(armaduraIncomum2);
            armadura.add(armaduraIncomum3);
            armadura.add(armaduraIncomum4);
            armadura.add(armaduraRara1);
            armadura.add(armaduraRara2);
            armadura.add(armaduraRara3);
            armadura.add(armaduraRara4);
            armadura.add(armaduraEpico1);
            armadura.add(armaduraEpico2);
            armadura.add(armaduraEpico3);
            armadura.add(armaduraEpico4);

            List<Armadura> armaduraSorteada = armadura.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return armaduraSorteada.getFirst();

        } else if (jogador.getNivel() > 10) {
            sorteio = Dados.d12();

            // COMUM
            Armadura armaduraComum1 = new Armadura("Armadura de Lona", 1, 20, 5, Raridade.COMUM, 1);
            Armadura armaduraComum2 = new Armadura("Armadura de Couro", 2, 50, 20, Raridade.COMUM, 2);
            Armadura armaduraComum3 = new Armadura("Armadura de Cobre", 3, 75, 35, Raridade.COMUM, 3);
            Armadura armaduraComum4 = new Armadura("Armadura de Ferro", 4, 100, 55, Raridade.COMUM, 4);

            // INCOMUM
            Armadura armaduraIncomum1 = new Armadura("Armadura de Bronze", 5, 150, 70, Raridade.INCOMUM, 5);
            Armadura armaduraIncomum2 = new Armadura("Armadura de Aço", 6, 200, 105, Raridade.INCOMUM, 6);
            Armadura armaduraIncomum3 = new Armadura("Armadura de Ferro Envenenada", 7, 245, 130, Raridade.INCOMUM, 7);
            Armadura armaduraIncomum4 = new Armadura("Armadura de Ferro Forjado", 8, 300, 180, Raridade.INCOMUM, 8);

            // RARO
            Armadura armaduraRara1 = new Armadura("Armadura de Cristal", 9, 450, 250, Raridade.RARO, 9);
            Armadura armaduraRara2 = new Armadura("Armadura de Prata", 10, 490, 300, Raridade.RARO, 10);
            Armadura armaduraRara3 = new Armadura("Armadura de Aço Carbono", 11, 520, 340, Raridade.RARO, 11);
            Armadura armaduraRara4 = new Armadura("Armadura de Esmeralda", 12, 550, 400, Raridade.RARO, 12);
            armadura.add(armaduraComum1);
            armadura.add(armaduraComum2);
            armadura.add(armaduraComum3);
            armadura.add(armaduraComum4);
            armadura.add(armaduraIncomum1);
            armadura.add(armaduraIncomum2);
            armadura.add(armaduraIncomum3);
            armadura.add(armaduraIncomum4);
            armadura.add(armaduraRara1);
            armadura.add(armaduraRara2);
            armadura.add(armaduraRara3);
            armadura.add(armaduraRara4);

            List<Armadura> armaduraSorteada = armadura.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return armaduraSorteada.getFirst();

        } else if (jogador.getNivel() > 5) {
            sorteio = Dados.d8();
            // COMUM
            Armadura armaduraComum1 = new Armadura("Armadura de Lona", 1, 20, 5, Raridade.COMUM, 1);
            Armadura armaduraComum2 = new Armadura("Armadura de Couro", 2, 50, 20, Raridade.COMUM, 2);
            Armadura armaduraComum3 = new Armadura("Armadura de Cobre", 3, 75, 35, Raridade.COMUM, 3);
            Armadura armaduraComum4 = new Armadura("Armadura de Ferro", 4, 100, 55, Raridade.COMUM, 4);

            // INCOMUM
            Armadura armaduraIncomum1 = new Armadura("Armadura de Bronze", 5, 150, 70, Raridade.INCOMUM, 5);
            Armadura armaduraIncomum2 = new Armadura("Armadura de Aço", 6, 200, 105, Raridade.INCOMUM, 6);
            Armadura armaduraIncomum3 = new Armadura("Armadura de Ferro Envenenada", 7, 245, 130, Raridade.INCOMUM, 7);
            Armadura armaduraIncomum4 = new Armadura("Armadura de Ferro Forjado", 8, 300, 180, Raridade.INCOMUM, 8);
            armadura.add(armaduraComum1);
            armadura.add(armaduraComum2);
            armadura.add(armaduraComum3);
            armadura.add(armaduraComum4);
            armadura.add(armaduraIncomum1);
            armadura.add(armaduraIncomum2);
            armadura.add(armaduraIncomum3);
            armadura.add(armaduraIncomum4);

            List<Armadura> armaduraSorteada = armadura.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return armaduraSorteada.getFirst();

        } else if (jogador.getNivel() <= 5) {
            sorteio = Dados.d4();

            // COMUM
            Armadura armaduraComum1 = new Armadura("Armadura de Lona", 1, 20, 5, Raridade.COMUM, 1);
            Armadura armaduraComum2 = new Armadura("Armadura de Couro", 2, 50, 20, Raridade.COMUM, 2);
            Armadura armaduraComum3 = new Armadura("Armadura de Cobre", 3, 75, 35, Raridade.COMUM, 3);
            Armadura armaduraComum4 = new Armadura("Armadura de Ferro", 4, 100, 55, Raridade.COMUM, 4);
            armadura.add(armaduraComum1);
            armadura.add(armaduraComum2);
            armadura.add(armaduraComum3);
            armadura.add(armaduraComum4);
            List<Armadura> armaduraSorteada = armadura.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return armaduraSorteada.getFirst();

        }
        return null;
    }
}


