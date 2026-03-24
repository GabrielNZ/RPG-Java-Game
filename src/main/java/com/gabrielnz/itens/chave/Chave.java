package com.gabrielnz.itens.chave;

import com.gabrielnz.itens.Item;

public class Chave extends Item {
    protected String nome;
    public Chave() {
        this.equipado = true;
        this.nome = "Chave Dungeon";
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}
