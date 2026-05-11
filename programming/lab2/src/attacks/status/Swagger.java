package attacks.status;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.confuse();
        p.setMod(Stat.ATTACK, +(int) p.getStat(Stat.ATTACK));
    }

    @Override
    protected String describe() {
        return "Swagger сбивает цель с толку и повышает её атаку на два уровня.";
    }
}