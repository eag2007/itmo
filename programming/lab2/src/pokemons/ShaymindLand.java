package pokemons;

import attacks.physics.Facade;

import attacks.special.MagicalLeaf;

import attacks.status.Rest;
import attacks.status.SweetScent;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class ShaymindLand extends Pokemon {
    public ShaymindLand(String name, int level) {
        super(name, level);
        setStats(100, 100, 100, 100, 100, 100);
        setType(Type.GRASS);
        setMove(new Facade(), new Rest(), new SweetScent(), new MagicalLeaf());
    }
}
