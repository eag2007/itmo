package pokemons;

import attacks.physics.Facade;
import attacks.physics.RazorLeaf;
import attacks.status.GrassWhistle;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Swadloon extends Pokemon {
    public Swadloon(String name, int level) {
        super(name, level);
        setType(Type.GRASS, Type.BUG);
        setStats(55, 63, 90, 50, 80, 42);
        setMove(new RazorLeaf(), new Facade(), new GrassWhistle());
    }
}
