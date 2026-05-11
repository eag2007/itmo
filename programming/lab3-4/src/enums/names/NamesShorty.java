package enums.names;

import java.util.Random;

public enum NamesShorty {
    IVAN("Иван"),
    TARZAN("Тарзан"),
    MASHA("Маша"),
    ANNA("Анна"),
    VLADIMIR("Владимир"),
    NATASHA("Наташа"),
    MAX("Макс"),
    MILKYWAY("Милкивей");


    private String title;
    private static final Random RANDOM = new Random();

    NamesShorty(String title) {
        this.title = title;
    }

    public static NamesShorty getRandomName() {
        NamesShorty[] colors = values();
        return colors[RANDOM.nextInt(colors.length)];
    }

    @Override
    public String toString() {
        return '"' + this.title + '"';
    }
}
