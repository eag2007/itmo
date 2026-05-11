package enums.colors;

import java.util.Random;

public enum ManualColors {
    RED("Красные"),
    BLUE("Синие"),
    GREEN("Зелёные"),
    ORANGE("Оранъжевые"),
    WHITE("Белые"),
    BLACK("Чёрные"),
    PINK("Розовые"),
    YELLOW("Жёлтые"),
    PUPLE("Фиолетовые");

    private String title;
    private static final Random RANDOM = new Random();

    ManualColors(String title) {
        this.title = title;
    }

    public static ManualColors getRandomColor() {
        ManualColors[] colors = values();
        return colors[RANDOM.nextInt(colors.length)];
    }

    @Override
    public String toString() {
        return '"' + this.title + " Руковички" + '"';
    }
}