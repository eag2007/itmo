package enums.colors;

import java.util.Random;

public enum JacketColors {
    RED("Красная"),
    BlUE("Синяя"),
    GREEN("Зелёная"),
    ORANGE("Ораньжевая"),
    WHITE("Белая"),
    YELLOW("Жёлтая");

    private String title;
    private static final Random RANDOM = new Random();

    JacketColors(String title) {
        this.title = title;
    }

    public static JacketColors getRandomColor() {
        JacketColors[] colors = values();
        return colors[RANDOM.nextInt(colors.length)];
    }

    @Override
    public String toString() {
        return '"' + this.title + " курта" + '"';
    }
}