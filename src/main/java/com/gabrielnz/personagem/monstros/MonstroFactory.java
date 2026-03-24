package com.gabrielnz.personagem.monstros;

import com.gabrielnz.combate.Dados;
import com.gabrielnz.itens.Raridade;
import com.gabrielnz.itens.arco.Arco;
import com.gabrielnz.itens.armadura.Armadura;
import com.gabrielnz.itens.espada.Espada;
import com.gabrielnz.personagem.Jogador;

import java.util.ArrayList;
import java.util.List;

public class MonstroFactory {
    public Monstro criarMonstro(Jogador jogador) {
        List<Monstro> monstros = new ArrayList<Monstro>();
        int sorteio;
        if (jogador.getNivel() >= 20) {
            Monstro guerreiroOrc = new Monstro("Guerreiro Orc", 40, 10, 30, new Espada("Machado de Ouro", new Dados(14), 650, 430, Raridade.EPICO, 13), new Armadura("Armadura de Esmeralda", 12, 550, 400, Raridade.RARO, 12), 0, 160, 3500, 1);
            Monstro trollDasMontanhas = new Monstro("Troll das Montanhas", 50, 12, 30, new Espada("Punho de Aço Carbono", new Dados(12), 520, 340, Raridade.RARO, 11), new Armadura("Armadura de Ouro", 13, 650, 430, Raridade.EPICO, 13), -2, 170, 4000, 2);
            Monstro cavaleiroSombrio = new Monstro("Cavaleiro Sombrio", 60, 15, 45, new Espada("Espada de Dragão", new Dados(15), 715, 490, Raridade.EPICO, 14), new Armadura("Armadura de Dragão", 14, 715, 490, Raridade.EPICO, 14), 2, 200, 4500, 3);
            Monstro giganteDePedra = new Monstro("Gigante de Pedra", 80, 18, 40, new Espada("Machado de Mithril", new Dados(17), 800, 590, Raridade.EPICO, 16), new Armadura("Armadura de Aço Carbono", 11, 520, 340, Raridade.RARO, 11), 2, 255, 6000, 4);
            Monstro demonioChamas = new Monstro("Demônio das Chamas", 70, 20, 50, new Espada("Lança de Infernal", new Dados(18), 900, 650, Raridade.LENDARIO, 17), new Armadura("Armadura de Dragão", 14, 715, 490, Raridade.EPICO, 14), 3, 300, 6500, 5);
            Monstro dragaoSombrioJovem = new Monstro("Dragão Sombrio Jovem", 100, 25, 70, new Espada("Sopro da Morte", new Dados(20), 1180, 720, Raridade.LENDARIO, 19), new Armadura("Armadura de Plutônio", 15, 750, 520, Raridade.EPICO, 15), 4, 500, 7500, 6);
            monstros.add(giganteDePedra);
            monstros.add(demonioChamas);
            monstros.add(dragaoSombrioJovem);
            monstros.add(cavaleiroSombrio);
            monstros.add(trollDasMontanhas);
            monstros.add(guerreiroOrc);

            sorteio = Dados.d6();
            List<Monstro> monstro = monstros.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return monstro.getFirst();

        } else if (jogador.getNivel() >= 15) {
            Monstro orcGuerreiro = new Monstro("Orc Guerreiro", 28, 5, 15, new Espada("Machado de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6), new Armadura("Armadura de Ferro Forjado", 8, 300, 180, Raridade.INCOMUM, 8), 0, 90, 2200, 1);
            Monstro aranhaCaverna = new Monstro("Aranha de Caverna", 25, 7, 25, new Espada("Presa Envenenada", new Dados(8), 245, 130, Raridade.INCOMUM, 7), 2, 95, 2300, 2);
            Monstro elfoAprendiz = new Monstro("Elfo Aprendiz", 24, 7, 50, new Arco("Arco de Cristal", new Dados(10), 450, 250, Raridade.RARO, 9), new Armadura("Armadura de Prata", 10, 490, 300, Raridade.RARO, 10), 2, 105, 2400, 3);
            Monstro guerreiroOrc = new Monstro("Guerreiro Orc", 40, 10, 30, new Espada("Machado de Ouro", new Dados(14), 650, 430, Raridade.EPICO, 13), new Armadura("Armadura de Esmeralda", 12, 550, 400, Raridade.RARO, 12), 0, 160, 3500, 4);
            Monstro trollDasMontanhas = new Monstro("Troll das Montanhas", 50, 12, 30, new Espada("Punho de Aço Carbono", new Dados(12), 520, 340, Raridade.RARO, 11), new Armadura("Armadura de Ouro", 13, 650, 430, Raridade.EPICO, 13), -2, 170, 4000, 5);
            Monstro cavaleiroSombrio = new Monstro("Cavaleiro Sombrio", 60, 15, 45, new Espada("Espada de Dragão", new Dados(15), 715, 490, Raridade.EPICO, 14), new Armadura("Armadura de Dragão", 14, 715, 490, Raridade.EPICO, 14), 2, 200, 4500, 6);
            monstros.add(cavaleiroSombrio);
            monstros.add(trollDasMontanhas);
            monstros.add(guerreiroOrc);
            monstros.add(orcGuerreiro);
            monstros.add(aranhaCaverna);
            monstros.add(elfoAprendiz);

            sorteio = Dados.d6();
            List<Monstro> monstro = monstros.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return monstro.getFirst();

        } else if (jogador.getNivel() > 10) {
            Monstro lobisomem = new Monstro("Lobisomem", 20, 5, 8, new Espada("Garra de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6), new Armadura("Armadura de Bronze", 5, 150, 70, Raridade.INCOMUM, 5), -1, 45, 1400, 1);
            Monstro arqueiroMenor = new Monstro("Arqueiro Menor", 22, 6, 12, new Arco("Arco de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4), new Armadura("Armadura de Cobre", 3, 75, 35, Raridade.COMUM, 3), 2, 55, 1500, 2);
            Monstro elfoSombrio = new Monstro("Elfo Sombrio", 18, 5, 15, new Arco("Arco de Bronze", new Dados(6), 150, 70, Raridade.INCOMUM, 5), new Armadura("Armadura de Ferro", 4, 100, 55, Raridade.COMUM, 4), 3, 60, 1600, 3);
            Monstro orcGuerreiro = new Monstro("Orc Guerreiro", 28, 5, 15, new Espada("Machado de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6), new Armadura("Armadura de Ferro Forjado", 8, 300, 180, Raridade.INCOMUM, 8), 0, 90, 2200, 4);
            Monstro aranhaCaverna = new Monstro("Aranha de Caverna", 25, 7, 25, new Espada("Presa Envenenada", new Dados(8), 245, 130, Raridade.INCOMUM, 7), 2, 95, 2300, 5);
            Monstro elfoAprendiz = new Monstro("Elfo Aprendiz", 24, 7, 50, new Arco("Arco de Cristal", new Dados(10), 450, 250, Raridade.RARO, 9), new Armadura("Armadura de Prata", 10, 490, 300, Raridade.RARO, 10), 2, 105, 2400, 6);
            monstros.add(orcGuerreiro);
            monstros.add(aranhaCaverna);
            monstros.add(elfoAprendiz);
            monstros.add(lobisomem);
            monstros.add(arqueiroMenor);
            monstros.add(elfoSombrio);

            sorteio = Dados.d6();
            List<Monstro> monstro = monstros.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return monstro.getFirst();

        } else if (jogador.getNivel() > 5) {
            Monstro ratoDeEsgoto = new Monstro("Rato de Esgoto", 13, 2, 0, 1, 15, 400, 1);
            Monstro goblinEspreitador = new Monstro("Goblin Espreitador", 15, 4, 15, new Espada("Adaga de Pedra", new Dados(2), 50, 20, Raridade.COMUM, 2), 3, 20, 600, 2);
            Monstro espectroFraco = new Monstro("Espectro Fraco", 12, 5, 20, new Espada("Toque sombrio", new Dados(4), 75, 35, Raridade.COMUM, 3), -1, 25, 700, 3);
            Monstro lobisomem = new Monstro("Lobisomem", 20, 5, 8, new Espada("Garra de Aço", new Dados(7), 200, 105, Raridade.INCOMUM, 6), new Armadura("Armadura de Bronze", 5, 150, 70, Raridade.INCOMUM, 5), -1, 45, 1200, 4);
            Monstro arqueiroMenor = new Monstro("Arqueiro Menor", 22, 6, 12, new Arco("Arco de Ferro", new Dados(5), 100, 55, Raridade.COMUM, 4), new Armadura("Armadura de Cobre", 3, 75, 35, Raridade.COMUM, 3), 2, 55, 1500, 5);
            Monstro elfoSombrio = new Monstro("Elfo Sombrio", 18, 5, 15, new Arco("Arco de Bronze", new Dados(6), 150, 70, Raridade.INCOMUM, 5), new Armadura("Armadura de Ferro", 4, 100, 55, Raridade.COMUM, 4), 3, 60, 1600, 6);
            monstros.add(lobisomem);
            monstros.add(arqueiroMenor);
            monstros.add(elfoSombrio);
            monstros.add(ratoDeEsgoto);
            monstros.add(goblinEspreitador);
            monstros.add(espectroFraco);

            sorteio = Dados.d6();
            List<Monstro> monstro = monstros.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return monstro.getFirst();

        } else if (jogador.getNivel() <= 5) {
            Monstro ratoDeEsgoto = new Monstro("Rato de Esgoto", 13, 2, 0, 1, 15, 400, 1);
            Monstro goblinEspreitador = new Monstro("Goblin Espreitador", 15, 4, 15, new Espada("Adaga de Pedra", new Dados(3), 50, 20, Raridade.COMUM, 2), 3, 20, 600, 2);
            Monstro espectroFraco = new Monstro("Espectro Fraco", 12, 5, 20, new Espada("Toque sombrio", new Dados(4), 75, 35, Raridade.COMUM, 3), -1, 25, 700, 3);
            monstros.add(ratoDeEsgoto);
            monstros.add(goblinEspreitador);
            monstros.add(espectroFraco);

            sorteio = Dados.d3();
            List<Monstro> monstro = monstros.stream().filter(x -> x.getId().equals(sorteio)).toList();
            return monstro.getFirst();

        }
        return null;
    }
}
