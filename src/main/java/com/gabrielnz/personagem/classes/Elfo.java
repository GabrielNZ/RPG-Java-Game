package com.gabrielnz.personagem.classes;

import com.gabrielnz.personagem.Jogador;

public class Elfo extends Jogador {

    public Elfo(String nome) {
        super(nome, Classe.Elfo) ;
        this.vida = 11;
        this.vidaMax = vida;
        this.dano = 5;
        this.mana = 30;
        this.manaMax = mana;
        this.iniciativa = 1;
    }
}
