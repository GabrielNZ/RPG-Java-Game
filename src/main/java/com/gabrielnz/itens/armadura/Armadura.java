package com.gabrielnz.itens.armadura;

import com.gabrielnz.itens.Equipamentos;
import com.gabrielnz.itens.Raridade;

public class Armadura extends Equipamentos {

    public Armadura(String nome, Integer ValorArmadura, Integer ValorCompra, Integer valorVenda, Raridade raridade,int id) {
        super(nome, ValorArmadura, ValorCompra, valorVenda,raridade);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Proteção: "+valorArmadura+" - Preço: "+valorCompra+"G";
    }
}
