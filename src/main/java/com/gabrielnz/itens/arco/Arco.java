package com.gabrielnz.itens.arco;

import com.gabrielnz.combate.Dados;
import com.gabrielnz.itens.Equipamentos;
import com.gabrielnz.itens.Raridade;

public class Arco extends Equipamentos {

    public Arco(String nome, Dados dado, Integer valorCompra, Integer valorVenda, Raridade raridade, int id) {
        super(nome, dado, valorCompra, valorVenda, raridade);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dano: d"+this.dado.getDadoClasse()+" - Preço: "+valorCompra+"G";
    }
}
