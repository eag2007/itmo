package pokemons;

import attacks.physics.Facade;
import attacks.physics.RazorLeaf;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Sewaddle extends Pokemon {
    public Sewaddle(String name, int level) {
        super(name, level);
        setType(Type.GRASS, Type.BUG);
        setStats(45, 53, 70, 40, 60, 42);
        setMove(new RazorLeaf(), new Facade());
    }
}
