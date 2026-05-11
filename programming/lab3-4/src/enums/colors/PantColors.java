package enums.colors;

import java.util.Random;

public enum PantColors {
    BLACK("Чёрные"),
    BLUE("Синие"),
    GRAY("Серые"),
    BROWN("Коричневые"),
    BEIGE("Бежевые"),
    WHITE("Белые"),
    GREEN("Зелёные"),
    RED("Красные");

    private String title;
    private static final Random RANDOM = new Random();

    PantColors(String title) {
        this.title = title;
    }

    public static PantColors getRandomColor() {
        PantColors[] colors = values();
        return colors[RANDOM.nextInt(colors.length)];
    }

    @Override
    public String toString() {
        return '"' + this.title + " брюки" + '"';
    }
}