package pokemons;

import attacks.physics.Facade;
import attacks.physics.RazorLeaf;

import attacks.status.GrassWhistle;
import attacks.status.Rest;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Leavanny extends Pokemon {
    public Leavanny(String name, int level) {
        super(name, level);
        setType(Type.NORMAL, Type.BUG);
        setStats(75, 103, 80, 70, 80, 92);
        setMove(new RazorLeaf(), new Facade(), new GrassWhistle(), new Rest());
    }
}
