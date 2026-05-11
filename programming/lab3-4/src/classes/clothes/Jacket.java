package classes.clothes;

import enums.colors.JacketColors;
import interfaces.Clothe;

import java.util.Objects;

public class Jacket implements Clothe {
    private final JacketColors colorClothe;

    public Jacket(JacketColors colorClothe) {
        this.colorClothe = colorClothe;
    }

    public JacketColors colorClothe() {
        return this.colorClothe;
    }

    @Override
    public String getDescription() {
        return colorClothe.toString();
    }

    @Override
    public String toString() {
        return getDescription();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Jacket jacket = (Jacket) obj;
        return colorClothe == jacket.colorClothe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorClothe);
    }
}