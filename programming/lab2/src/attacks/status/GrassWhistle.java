package attacks.status;

import ru.ifmo.se.pokemon.*;

public class GrassWhistle extends StatusMove {
    public GrassWhistle() {
        super(Type.GRASS, 0, 55);
    }

    @Override
    protected String describe() {
        return "Травяной свист усыпляет цель, если попадает в неё. Спящий покемон не может двигаться. Сон длится 1–3 хода.";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        double random_number = Math.random();
        Effect sleep = new Effect().condition(Status.SLEEP);

        if (random_number < 0.33) {
            p.addEffect(sleep.turns(1));
        } else if (random_number < 0.66) {
            p.addEffect(sleep.turns(2));
        } else {
            p.addEffect(sleep.turns(3));
        }
    }
}
