package classes.characters;

import interfaces.Clothe;  // Используем интерфейс
import java.util.Objects;

public abstract class Character {
    protected Clothe clothe;

    public Character(Clothe clothe) {
        this.clothe = clothe;
    }

    public Clothe getClothe() {
        return this.clothe;
    }

    public void setClothe(Clothe clothe) {
        this.clothe = clothe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClothe());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Character character = (Character) obj;
        return Objects.equals(getClothe(), character.getClothe());
    }
}