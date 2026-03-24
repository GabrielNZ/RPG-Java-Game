package com.gabrielnz.magias;

import com.gabrielnz.itens.Equipamentos;
import com.gabrielnz.itens.Raridade;
import com.gabrielnz.magias.elementos.Agua;
import com.gabrielnz.magias.elementos.Elemento;
import com.gabrielnz.magias.elementos.Fogo;
import com.gabrielnz.magias.elementos.Gelo;
import com.gabrielnz.magias.elementos.magias.MAgua;
import com.gabrielnz.magias.elementos.magias.MFogo;
import com.gabrielnz.magias.elementos.magias.MGelo;
import com.gabrielnz.magias.elementos.magias.MagiaElemento;
import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;
import com.gabrielnz.personagem.monstros.Monstro;

import java.util.HashMap;

import static com.gabrielnz.mecanicas.Transicao.ler;

public class LivroMagia extends Equipamentos {
    private HashMap<Elemento, MagiaElemento> magias = new HashMap<>();
    private boolean sair;

    public LivroMagia(String nome, Raridade raridade) {
        super(nome, raridade);
        magias.put(new Agua(), new MAgua());
        magias.put(new Fogo(), new MFogo());
        magias.put(new Gelo(), new MGelo());
        this.nome = "Livro de Magias";
    }

    public void mostrarLivro(Jogador jogador, Monstro monstro) {
        do {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║         📜 LIVRO DE MAGIAS 📜          ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  Escolha o elemento que deseja usar:   ║");
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
                    MagiaElemento magiaa = magias.get(Agua.class);
                    selecionarMagica(new Agua(), jogador, monstro);
                    if (!this.sair) {
                    escolheu = true;
                    }else{
                        this.sair = false;
                    }
                    break;
                case 2:
                    Transicao.transicaolinha();
                    MagiaElemento magiaf = magias.get(Fogo.class);
                    selecionarMagica(new Fogo(), jogador, monstro);
                    if (!this.sair) {
                        escolheu = true;
                    }else{
                        this.sair = false;
                    }
                    break;
                case 3:
                    Transicao.transicaolinha();
                    MagiaElemento magiag = magias.get(Gelo.class);
                    selecionarMagica(new Gelo(), jogador, monstro);
                    if (!this.sair) {
                        escolheu = true;
                    }else{
                        this.sair = false;
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

    public void selecionarMagica(Elemento elemento, Jogador jogador, Monstro monstro) {
        if (elemento instanceof Agua) {
            MAgua magua = new MAgua();
            do {
                System.out.println("╔════════════════════════════════════════╗");
                System.out.println("║          💧 MAGIAS - ÁGUA 💧           ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║ 1. Jato de Água              (5 Mana)  ║");
                System.out.println("║ 2. Bolha Defensiva           (12 Mana) ║");
                System.out.println("║ 3. Toque de Poseidon         (30 Mana) ║");
                System.out.println("║ 0. Voltar                              ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║ Escolha sua magia [1-3]:               ║");
                System.out.println("╚════════════════════════════════════════╝");
                boolean repetir = false;
                switch (ler.nextInt()) {
                    case 0:
                        this.sair = true;
                        Transicao.transicaolinha();
                        break;
                    case 1:
                        Transicao.transicaolinha();
                        magua.magia1(jogador, monstro);
                        break;
                    case 2:
                        Transicao.transicaolinha();
                        magua.magia2(jogador, monstro);
                        break;
                    case 3:
                        Transicao.transicaolinha();
                        magua.magia3(jogador, monstro);
                        break;
                    default:
                        System.out.println("Valor invalido...");
                        repetir = true;
                        break;
                }
                if (repetir) {
                    Transicao.transicao();
                } else {
                    break;
                }
            } while (true);
        } else if (elemento instanceof Gelo) {
            MGelo mgelo = new MGelo();
            do {
                System.out.println("╔════════════════════════════════════════╗");
                System.out.println("║         ❄️ MAGIAS - GELO ❄️            ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║ 1. Rajada de Gelo            (4 Mana)  ║");
                System.out.println("║ 2. Toque Congelante          (17 Mana) ║");
                System.out.println("║ 3. Prisão de Gelo            (30 Mana) ║");
                System.out.println("║ 0. Voltar                              ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║ Escolha sua magia [1-3]:               ║");
                System.out.println("╚════════════════════════════════════════╝");
                boolean repetir = false;
                switch (ler.nextInt()) {
                    case 0:
                        this.sair = true;
                        Transicao.transicaolinha();
                        break;
                    case 1:
                        Transicao.transicaolinha();
                        mgelo.magia1(jogador, monstro);
                        break;
                    case 2:
                        Transicao.transicaolinha();
                        mgelo.magia2(jogador, monstro);
                        break;
                    case 3:
                        Transicao.transicaolinha();
                        mgelo.magia3(jogador, monstro);
                        break;
                    default:
                        System.out.println("Valor invalido...");
                        repetir = true;
                        break;
                }
                if (repetir) {
                    Transicao.transicao();
                } else {
                    break;
                }
            } while (true);
        } else if (elemento instanceof Fogo) {
            MFogo mfogo = new MFogo();
            do {
                System.out.println("╔════════════════════════════════════════╗");
                System.out.println("║          🔥 MAGIAS - FOGO 🔥           ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║ 1. Bola de Fogo              (7 Mana)  ║");
                System.out.println("║ 2. Laser de Fogo             (20 Mana) ║");
                System.out.println("║ 3. Sol                       (35 Mana) ║");
                System.out.println("║ 0. Voltar                              ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.println("║ Escolha sua magia [1-3]:               ║");
                System.out.println("╚════════════════════════════════════════╝");
                boolean repetir = false;
                switch (ler.nextInt()) {
                    case 0:
                        this.sair = true;
                        Transicao.transicaolinha();
                        break;
                    case 1:
                        Transicao.transicaolinha();
                        mfogo.magia1(jogador, monstro);
                        break;
                    case 2:
                        Transicao.transicaolinha();
                        mfogo.magia2(jogador, monstro);
                        break;
                    case 3:
                        Transicao.transicaolinha();
                        mfogo.magia3(jogador, monstro);
                        break;
                    default:
                        System.out.println("Valor invalido...");
                        repetir = true;
                        break;
                }
                if (repetir) {
                    Transicao.transicao();
                } else {
                    break;
                }
            } while (true);
        }
    }

    @Override
    public String toString() {
        return "Livro de Magia";
    }

    public boolean isSair() {
        return sair;
    }

    public void setSair(boolean sair) {
        this.sair = sair;
    }
}
