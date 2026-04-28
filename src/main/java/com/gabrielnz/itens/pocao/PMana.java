package com.gabrielnz.itens.pocao;

import com.gabrielnz.itens.Raridade;
import com.gabrielnz.itens.Tamanho;

public class PMana extends Pocao {

    public PMana(Tamanho tamanho, Raridade raridade, int id, int valorCompra) {
        nome = "Poção De Mana";
        tipo = Tipo.MANA;
        this.raridade = raridade;
        this.id = id;
        this.tamanho = tamanho;
        this.valorCompra = valorCompra;
        if (this.tamanho == Tamanho.PEQUENA) {
            this.valorRecuperado = 5;
        } else if (this.tamanho == Tamanho.MEDIA) {
            this.valorRecuperado = 10;
        } else if (this.tamanho == Tamanho.GRANDE) {
            this.valorRecuperado = 20;
        }
    }
}
