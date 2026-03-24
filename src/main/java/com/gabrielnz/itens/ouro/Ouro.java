package com.gabrielnz.itens.ouro;
import com.gabrielnz.itens.Item;
import com.gabrielnz.itens.Raridade;

public class Ouro extends Item {
    protected String nome;
    protected int valor;
    public Ouro(String nome, int valor, Raridade raridade, int id ) {
        this.nome = nome;
        this.raridade = raridade;
        this.valor = valor;
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return ""+valor;
    }
}
