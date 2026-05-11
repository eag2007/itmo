package attacks.physics;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class RazorLeaf extends PhysicalMove {
    public RazorLeaf() {
        super(Type.GRASS, 55, 95);
    }

    @Override
    protected String describe() {
        return "Острый лист наносит урон и имеет повышенный шанс критического удара (1⁄8 вместо 1⁄24).";
    }

    @Override
    protected void applyOppDamage(Pokemon p, double damage) {
        if (Math.random() < (1d/8d)) {
            super.applyOppDamage(p, p.getStat(Stat.HP));
        } else {
            super.applyOppDamage(p, damage);
        }
    }
}
