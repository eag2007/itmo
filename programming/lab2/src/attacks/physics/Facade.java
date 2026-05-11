package attacks.physics;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.Type;


public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70., 100.);
    }

    @Override
    protected String describe() {
        return "Фасад наносит урон и поражает с удвоенной силой (140), если пользователь обожжён, отравлен или парализован.";
    }

    @Override
    protected void applyOppDamage(Pokemon p, double damage) {
        if (((p.getCondition() == Status.PARALYZE) || (p.getCondition() ==  Status.BURN) || (p.getCondition() == Status.POISON))) {
            super.applyOppDamage(p, damage * 2);
        } else {
            super.applyOppDamage(p, damage);
        }
    }
}