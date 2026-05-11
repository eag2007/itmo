package attacks.status;

import ru.ifmo.se.pokemon.*;


public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect sleep = new Effect().condition(Status.SLEEP).turns(2);
        p.addEffect(sleep);
        p.setMod(Stat.HP, -(int)(p.getStat(Stat.HP) - p.getHP()));
    }

    @Override
    protected String describe() {
        return "Игрок спит 2 шага, но его HP полностью восстанавливается.";
    }
}