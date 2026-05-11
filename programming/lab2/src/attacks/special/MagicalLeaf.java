package attacks.special;

import ru.ifmo.se.pokemon.*;

public class MagicalLeaf extends SpecialMove {
    public MagicalLeaf() {
        super(Type.GRASS, 60, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon p, double damage) {
        double evasion = p.getStat(Stat.EVASION);
        double accuracy = p.getStat(Stat.ACCURACY);
        p.setMod(Stat.EVASION, -(int) evasion);
        p.setMod(Stat.ACCURACY, -(int) accuracy);
        super.applyOppDamage(p, damage);
        p.setMod(Stat.EVASION, +(int) evasion);
        p.setMod(Stat.EVASION, +(int) accuracy);
    }

    @Override
    protected String describe() {
        return "Волшебный лист наносит урон и игнорирует изменения в показателях " +
                "точности и уклонения.";
    }
}