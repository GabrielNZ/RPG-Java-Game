package com.gabrielnz.personagem.classes;

import com.gabrielnz.personagem.Jogador;

public class Goblin extends Jogador {

    public Goblin(String nome) {
        super(nome, Classe.Goblin) ;
        this.vida = 11;
        this.vidaMax = vida;
        this.dano = 4;
        this.mana = 30;
        this.manaMax = mana;
        this.iniciativa = 3;
    }
}
