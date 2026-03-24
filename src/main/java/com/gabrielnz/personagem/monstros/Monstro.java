package com.gabrielnz.personagem.monstros;

import com.gabrielnz.itens.Equipamentos;
import com.gabrielnz.itens.arco.Arco;
import com.gabrielnz.itens.armadura.Armadura;
import com.gabrielnz.itens.espada.Espada;

public class Monstro {
    protected String nome;
    protected Integer vida;
    protected Integer dano;
    protected Integer mana;
    protected Equipamentos arma;
    protected Equipamentos armadura;
    protected Integer iniciativa;
    protected Integer ouro = 0;
    protected Integer xp = 0;
    protected Integer id;
    protected boolean congelado;
    protected boolean armaduraIgnore;
    protected boolean armaRoubada;

    public Monstro(String nome, Integer vida, Integer dano, Integer mana, Espada arma, Armadura armadura, Integer iniciativa, Integer ouro, Integer xp, Integer id) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.mana = mana;
        this.arma = arma;
        this.armadura = armadura;
        this.iniciativa = iniciativa;
        this.ouro = ouro;
        this.xp = xp;
        this.id = id;
    }
    public Monstro(String nome, Integer vida, Integer dano, Integer mana, Arco arma, Armadura armadura, Integer iniciativa, Integer ouro, Integer xp, Integer id) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.mana = mana;
        this.arma = arma;
        this.armadura = armadura;
        this.iniciativa = iniciativa;
        this.ouro = ouro;
        this.xp = xp;
        this.id = id;
    }
    public Monstro(String nome, Integer vida, Integer dano, Integer mana, Arco arma, Integer iniciativa, Integer ouro, Integer xp, Integer id) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.mana = mana;
        this.arma = arma;
        this.iniciativa = iniciativa;
        this.ouro = ouro;
        this.xp = xp;
        this.id = id;
    }
    public Monstro(String nome, Integer vida, Integer dano, Integer mana, Espada arma, Integer iniciativa, Integer ouro, Integer xp, Integer id) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.mana = mana;
        this.arma = arma;
        this.iniciativa = iniciativa;
        this.ouro = ouro;
        this.xp = xp;
        this.id = id;
    }
    public Monstro(String nome, Integer vida, Integer dano, Integer mana, Integer iniciativa, Integer ouro, Integer xp, Integer id) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.mana = mana;
        this.iniciativa = iniciativa;
        this.ouro = ouro;
        this.xp = xp;
        this.id = id;
    }
    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getDano() {
        return dano;
    }

    public void setDano(Integer dano) {
        this.dano = dano;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(Integer iniciativa) {
        this.iniciativa = iniciativa;
    }

    public Integer getOuro() {
        return ouro;
    }

    public void setOuro(Integer ouro) {
        this.ouro = ouro;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Equipamentos getArma() {
        return arma;
    }

    public void setArma(Equipamentos arma) {
        this.arma = arma;
    }

    public Equipamentos getArmadura() {
        return armadura;
    }

    public void setArmadura(Equipamentos armadura) {
        this.armadura = armadura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isCongelado() {
        return congelado;
    }

    public void setCongelado(boolean congelado) {
        this.congelado = congelado;
    }

    public boolean isArmaduraIgnore() {
        return armaduraIgnore;
    }

    public void setArmaduraIgnore(boolean armaduraIgnore) {
        this.armaduraIgnore = armaduraIgnore;
    }

    public boolean isArmaRoubada() {
        return armaRoubada;
    }

    public void setArmaRoubada(boolean armaRoubada) {
        this.armaRoubada = armaRoubada;
    }
}
