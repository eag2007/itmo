package classes.clothes;

import enums.colors.PantColors;
import interfaces.Clothe;

import java.util.Objects;

public class Pant implements Clothe {
    private final PantColors color;
    private final String style;
    private final String material;
    private final boolean hasPockets;

    public Pant(PantColors color) {
        this(color, "классические", "хлопок", true);
    }

    public Pant(PantColors color, String style) {
        this(color, style, "хлопок", true);
    }

    public Pant(PantColors color, String style, String material) {
        this(color, style, material, true);
    }

    public Pant(PantColors color, String style, String material, boolean hasPockets) {
        this.color = color;
        this.style = style;
        this.material = material;
        this.hasPockets = hasPockets;
    }

    public PantColors getColor() {
        return this.color;
    }

    public String getStyle() {
        return style;
    }

    public String getMaterial() {
        return material;
    }

    public boolean hasPockets() {
        return hasPockets;
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append(color.toString().replace("\"", ""));

        if (style != null && !style.isEmpty()) {
            description.append(" ").append(style);
        }

        if (material != null && !material.isEmpty()) {
            description.append(" из ").append(material);
        }

        if (hasPockets) {
            description.append(" с карманами");
        } else {
            description.append(" без карманов");
        }

        return description.toString();
    }

    @Override
    public String toString() {
        return '"' + getDescription() + '"';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pant pants = (Pant) obj;
        return hasPockets == pants.hasPockets &&
                color == pants.color &&
                Objects.equals(style, pants.style) &&
                Objects.equals(material, pants.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, style, material, hasPockets);
    }
}