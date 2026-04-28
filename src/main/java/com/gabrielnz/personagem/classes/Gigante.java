package com.gabrielnz.personagem.classes;
import com.gabrielnz.personagem.Jogador;

public class Gigante extends Jogador {

    public Gigante(String nome) {
        super(nome, Classe.Gigante) ;
        this.vida = 20;
        this.vidaMax = vida;
        this.dano = 1;
        this.mana = 30;
        this.manaMax = mana;
        this.iniciativa = -2;
    }
}
