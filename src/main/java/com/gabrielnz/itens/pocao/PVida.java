package com.gabrielnz.itens.pocao;

import com.gabrielnz.itens.Raridade;
import com.gabrielnz.itens.Tamanho;

public class PVida extends Pocao {

    public PVida(Tamanho tamanho, Raridade raridade, int id, int valorCompra) {
        nome = "Poção De Vida";
        tipo = Tipo.VIDA;
        this.raridade = raridade;
        this.id = id;
        this.tamanho = tamanho;
        this.valorCompra = valorCompra;

        if (this.tamanho == Tamanho.PEQUENA) {
            this.valorRecuperado = 3;
        } else if (this.tamanho == Tamanho.MEDIA) {
            this.valorRecuperado = 5;
        } else if (this.tamanho == Tamanho.GRANDE) {
            this.valorRecuperado = 10;
        }
    }
}
