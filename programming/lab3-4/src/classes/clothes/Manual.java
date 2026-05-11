package classes.clothes;

import enums.colors.ManualColors;
import interfaces.Clothe;

import java.util.Objects;

public class Manual implements Clothe {
    private final ManualColors colorClothe;

    public Manual(ManualColors colorClothe) {
        this.colorClothe = colorClothe;
    }

    public ManualColors colorClothe() {
        return this.colorClothe;
    }

    @Override
    public String getDescription() {
        return colorClothe.toString();
    }

    @Override
    public String toString() {
        return colorClothe.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Manual manual = (Manual) obj;
        return colorClothe == manual.colorClothe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorClothe);
    }
}