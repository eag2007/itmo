package main;

import pokemons.*;

import ru.ifmo.se.pokemon.*;


public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Umbreon umbreon = new Umbreon("Umbreon", 1);
        Swadloon swadloon = new Swadloon("Swadloon", 1);
        ShaymindLand shaymindLand = new ShaymindLand("ShaymindLand", 1);
        Sewaddle sewaddle = new Sewaddle("Sewaddle", 1);
        Leavanny leavanny = new Leavanny("Leavanny", 1);
        Eevee eevee = new Eevee("Eevee", 1);

        battle.addAlly(umbreon);
        battle.addAlly(swadloon);
        battle.addAlly(shaymindLand);

        battle.addFoe(sewaddle);
        battle.addFoe(leavanny);
        battle.addFoe(eevee);

        battle.go();
    }
}