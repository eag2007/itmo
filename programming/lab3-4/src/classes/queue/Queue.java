package classes.queue;

import classes.characters.Shorty;
import classes.clothes.Manual;
import enums.colors.ManualColors;
import exceptions.EmptyQueueException;
import interfaces.BehaviorOfCharacter;
import interfaces.Clothe;
import enums.names.NamesShorty;

import java.util.ArrayList;
import java.util.Random;

public class Queue implements BehaviorOfCharacter {
    private final int n;
    private ArrayList<Shorty> listShortys;
    static Random random = new Random();

    public Queue(int n) {
        if (n == 0) {
            throw new EmptyQueueException("Коротышек нет, обмена не будет");
        }
        if (n < 0) {
            throw new EmptyQueueException("Коротышек не может быть отрицательное количество");
        }
        this.n = n;
        this.listShortys = generateQueue(new ArrayList<>());
    }

    private ArrayList<Shorty> generateQueue(ArrayList<Shorty> list) {
        for (int i = 0; i < this.n; i++) {
            // Можно генерировать разную одежду для коротышек
            Clothe clothe;
            if (random.nextBoolean()) {
                clothe = new Manual(ManualColors.getRandomColor());
            } else {
                // Здесь можно добавить другие типы одежды
                clothe = new Manual(ManualColors.getRandomColor());
            }
            list.add(new Shorty(NamesShorty.getRandomName(), clothe));
        }
        return list;
    }

    public Shorty getNextPerson() {
        int index = random.nextInt(this.listShortys.size());
        return this.listShortys.remove(index);
    }

    public int getSizeQueue() {
        return this.n;
    }

    @Override
    public String toString() {
        return "Queue=(" + "n=" + this.n + ", " + "listShortys=" + this.listShortys + ")";
    }
}