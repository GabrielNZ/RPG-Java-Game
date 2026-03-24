package com.gabrielnz.itens;

import com.gabrielnz.combate.Dados;

public abstract class Equipamentos extends Item {
    protected Dados dado;
    protected Integer valorArmadura;
    protected Integer valorCompra;
    protected Integer valorVenda;
    protected boolean equipado;

    public Equipamentos(String nome, Dados dado, Integer valorCompra, Integer valorVenda, Raridade raridade) {
        super(raridade);
        this.nome = nome;
        this.dado = dado;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.equipado = false;
    }
    public Equipamentos(String nome, Integer ValorArmadura, Integer ValorCompra, Integer valorVenda,Raridade raridade) {
        super(raridade);
        this.nome = nome;
        this.valorArmadura = ValorArmadura;
        this.valorCompra = ValorCompra;
        this.valorVenda = valorVenda;
        this.equipado = false;
    }
    public Equipamentos(String nome,Raridade raridade) {
        super(raridade);
        this.nome = nome;
        this.equipado = false;
    }
    public Dados getDado() {
        return dado;
    }

    public void setDado(Dados dado) {
        this.dado = dado;
    }

    public Integer getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Integer valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Integer getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Integer valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getValorArmadura() {
        return valorArmadura;
    }

    public void setValorArmadura(Integer valorArmadura) {
        this.valorArmadura = valorArmadura;
    }

    @Override
    public boolean isEquipado() {
        return equipado;
    }

    @Override
    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }

}