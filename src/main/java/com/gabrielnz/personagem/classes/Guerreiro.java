package com.gabrielnz.personagem.classes;

import com.gabrielnz.personagem.Jogador;

public class Guerreiro extends Jogador {

    public Guerreiro(String nome) {
        super(nome, Classe.Guerreiro) ;
        this.vida = 15;
        this.vidaMax = vida;
        this.dano = 3;
        this.mana = 50;
        this.manaMax = mana;
        this.iniciativa = 0;
    }
}
