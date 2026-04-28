package com.gabrielnz.itens.pocao;

import com.gabrielnz.itens.Item;
import com.gabrielnz.itens.Raridade;
import com.gabrielnz.itens.Tamanho;
import com.gabrielnz.mecanicas.Transicao;
import com.gabrielnz.personagem.Jogador;

public class Pocao extends Item {
    protected Tipo tipo;
    protected Tamanho tamanho;
    protected Integer valorRecuperado;
    protected Integer valorCompra;

    public Pocao() {
        super();

    }
    public Pocao(Raridade raridade) {
        super(raridade);
    }

    public void beberPocao(Jogador jogador, Pocao pocao) {
        jogador.getInventarioJogador().removePocao(pocao);
        if (pocao.getTipo() == Tipo.VIDA) {
            if(jogador.getVida().equals(jogador.getVidaMax())){
                System.out.println("╔═════════════════════════════════╗");
                System.out.printf("║  🍶 %s foi bebida!  ║\n", pocao.getNome());
                System.out.println("╠═════════════════════════════════╣");
                System.out.println("║   Sua vida já está cheia!       ║");
                System.out.println("╚═════════════════════════════════╝");
                Transicao.transicao();
            } else {
                if ((jogador.getVida() + pocao.getValorRecuperado()) > jogador.getVidaMax()) {
                    jogador.setVida(jogador.getVidaMax());
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.printf("║  🍶 %s foi bebida!  ║\n", pocao.getNome());
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.printf("║   Você recuperou +%-2d ❤️        ║\n", pocao.getValorRecuperado());
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.printf("║   Vida atualizada: %-2d 👤️       ║\n", jogador.getVidaMax());
                    System.out.println("╚═════════════════════════════════╝");
                    Transicao.transicao();
                } else {
                    jogador.setVida(jogador.getVida() + pocao.getValorRecuperado());
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.printf("║  🍶 %s foi bebida!  ║\n", pocao.getNome());
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.printf("║   Você recuperou +%-2d ❤️        ║\n", pocao.getValorRecuperado());
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.printf("║   Vida atualizada: %-2d 👤️       ║\n", jogador.getVida());
                    System.out.println("╚═════════════════════════════════╝");
                    Transicao.transicao();
                }
            }
        } else if (pocao.getTipo() == Tipo.MANA) {
            if(jogador.getMana().equals(jogador.getManaMax())){
                System.out.println("╔═════════════════════════════════╗");
                System.out.printf("║  🍶 %s foi bebida!  ║\n", pocao.getNome());
                System.out.println("╠═════════════════════════════════╣");
                System.out.println("║   Sua mana já está cheia!       ║");
                System.out.println("╚═════════════════════════════════╝");
                Transicao.transicao();
            } else {
                if ((jogador.getMana() + pocao.getValorRecuperado()) > jogador.getManaMax()) {
                    jogador.setMana(jogador.getManaMax());
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.printf("║   🍶 %s foi bebida!   ║\n", pocao.getNome());
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.printf("║   Você recuperou +%-2d 🔮        ║\n", pocao.getValorRecuperado());
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.printf("║   Mana atualizada: %-2d 👤️       ║\n", jogador.getManaMax());
                    System.out.println("╚═════════════════════════════════╝");
                    Transicao.transicao();
                } else {
                    jogador.setMana(jogador.getMana() + pocao.getValorRecuperado());
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.printf("║   🍶 %s foi bebida!   ║\n", pocao.getNome());
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.printf("║   Você recuperou +%-2d 🔮        ║\n", pocao.getValorRecuperado());
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.printf("║   Mana atualizada: %-2d 👤       ║\n", jogador.getMana());
                    System.out.println("╚═════════════════════════════════╝");
                    Transicao.transicao();
                }
            }
        }
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getValorRecuperado() {
        return valorRecuperado;
    }

    public void setValorRecuperado(Integer valorRecuperado) {
        this.valorRecuperado = valorRecuperado;
    }

    public Integer getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Integer valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public String toString() {
        return tipo+" - "+tamanho+" - "+valorRecuperado+" de "+tipo;
    }
}

