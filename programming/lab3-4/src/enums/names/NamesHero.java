package enums.names;

import java.util.Random;

public enum NamesHero {
    DUNNO("НЕЗНАЙКА"),
    BUTTON("КНОПОЧКА"),
    MOTTLED("ПЕСТРЕНЬКИЙ"),
    ALLKNOW("ВСЕЗНАЙКА"),
    BALAKSHIN("БАЛАКШИН"),
    POLYKOV("ПОЛЯКОВ"),
    LENA("ЛЕНА"),
    ANNA("АНЯ"),
    ALICE("АЛИСА"),
    NIKITA("НИКИТА"),
    EVGENIY("ЕВГЕНИЙ");

    private String title;
    private static final Random RANDOM = new Random();

    NamesHero(String title) {
        this.title = title;
    }

    public static NamesHero getRandomName() {
        NamesHero[] colors = values();
        return colors[RANDOM.nextInt(colors.length)];
    }

    @Override
    public String toString() {
        return this.title;
    }
}
