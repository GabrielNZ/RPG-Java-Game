package com.gabrielnz.itens.espada;

import com.gabrielnz.combate.Dados;
import com.gabrielnz.itens.Equipamentos;
import com.gabrielnz.itens.Raridade;

public class Espada extends Equipamentos {


    public Espada(String nome, Dados dado, Integer valorCompra, Integer valorVenda, Raridade raridade,int id) {
        super(nome, dado, valorCompra, valorVenda, raridade);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dano: d"+this.dado.getDadoClasse()+" - Preço: "+valorCompra+"G";
    }
}
