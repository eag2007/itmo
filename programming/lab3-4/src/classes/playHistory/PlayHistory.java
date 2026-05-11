package classes.playHistory;

import classes.characters.*;

import java.util.ArrayList;
import java.util.Random;

import classes.clothes.Jacket;
import enums.colors.JacketColors;
import exceptions.EmptyQueueException;
import classes.exchange.Exchange;
import classes.queue.Queue;

import classes.roof.RoofEvent;

public class PlayHistory {
    private final ArrayList<Hero> listHeros = new ArrayList<>();

    public void addHero(Hero person) {
        listHeros.add(person);
    }

    public void play() {
        try {
            System.out.println("Сюжет начался");

            // играем события на крыше
            System.out.println();
            new RoofEvent(listHeros);

            int n = new Random().nextInt(-5, 20);
            System.out.println("Коротышек было : " + n);
            System.out.println();

            Queue queueShortys = new Queue(n);

            Exchange exchange = new Exchange(listHeros);

            int size = queueShortys.getSizeQueue();
            for (int i = 0; i < size; i++) {
                Shorty person1 = queueShortys.getNextPerson();
                Hero person2 = exchange.getNextPerson();

                exchange.exchange(person1, person2);
                // exchange.exchange(null, new Dog("Пёс погнаый", new Jacket(JacketColors.BlUE)));
                // exchange.exchange(person1, person1);
                // exchange.exchange(person2, new Hero(NamesHero.ALICE, new Clothe(ClotheColors.BLUE),0.9, true));
                // exchange.exchange(person2, new Dog("ПЁС ПОГАНЫЙ", new Jacket(JacketColors.BlUE)));
            }

            System.out.println("Обмен завершен");
            System.out.println();
            Hero hero;
            for (int i = 0; i < listHeros.size(); i++) {
                hero = listHeros.get(i);
                if (hero.getClothe() == null) {
                    System.out.println("С " + hero.getName() + " никто не захотел меняться");
                } else {
                    System.out.println("Теперь у " + listHeros.get(i).getName() + " есть " + listHeros.get(i).getClothe());
                }
            }
        } catch (EmptyQueueException e) {
            System.out.println(e.getMessage());
        }
    }
}
