package pokemons;

import attacks.special.Psychic;
import attacks.status.BabyDollEyes;
import attacks.status.Swagger;
import attacks.status.TailWhip;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Umbreon extends Pokemon {
    public Umbreon(String name, int level) {
        super(name, level);
        setType(Type.DARK);
        setStats(95, 65, 110, 60, 130, 65);
        setMove(new BabyDollEyes(), new TailWhip(), new Swagger(), new Psychic());
    }
}