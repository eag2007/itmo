package attacks.special;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Psychic extends SpecialMove {
    public Psychic() {
        super(Type.PSYCHIC, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (p.getLevel() == 1) {
            if (Math.random() <= 0.3) {
                p.setMod(Stat.SPECIAL_DEFENSE, -1);
                p.setMod(Stat.SPECIAL_ATTACK, -1);
            }
        } else if (Math.random() <= 0.1) {
            p.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
        p.setMod(Stat.HP, +(int) 90);
    }

    @Override
    protected String describe() {
        return "Экстрасенс наносит урон и с вероятностью 10 % снижает специальную защиту цели на один уровень.";
    }
}
