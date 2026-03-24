package com.gabrielnz.personagem.classes;

import com.gabrielnz.personagem.Jogador;

public class Mago extends Jogador {

    public Mago(String nome) {
        super(nome, Classe.Mago) ;
        this.vida = 12;
        this.vidaMax = vida;
        this.dano = 2;
        this.mana = 25;
        this.manaMax = mana;
        this.iniciativa = 0;
    }
}
