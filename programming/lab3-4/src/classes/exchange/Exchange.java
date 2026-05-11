package classes.exchange;

import classes.characters.Hero;
import classes.characters.Shorty;
import interfaces.BehaviorOfCharacter;
import interfaces.Clothe;
import interfaces.Exchangeable;

import java.util.ArrayList;
import java.util.Random;

public class Exchange implements BehaviorOfCharacter {
    private ArrayList<Hero> listHeros;
    static Random random = new Random();

    public Exchange(ArrayList<Hero> listHeros) {
        this.listHeros = listHeros;
    }

    private void exchangeShortyHero(Shorty person1, Hero person2) {
        Clothe first = person1.getClothe();
        Clothe second = person2.getClothe();

        if (!person2.getDesireExchange()) {
            System.out.println(person2.getName() + " не желает меняться с " + person1.getName());
        } else if (first == null) {
            System.out.println("У " + person1.getName() + " больше ничего нет для обмена с " + person2.getName());
        } else if (first.equals(second)) {
            System.out.println("Обмен не произошел, так как у " + person1.getName() +
                    " и " + person2.getName() + " одинаковые вещи");
        } else if (second == null) {
            if (person2.getPower() > Math.random()) {
                System.out.println(person2.getName() + " ударил коротышку " + person1.getName() + " и отобрал у него " + first);

                person1.setClothe(second);
                person2.setClothe(first);
            } else {
                System.out.println("Коротышка " + person1.getName() + " не захотел " +
                        " отдавать свою вещь " + person2.getName() + " и не получить ничего взамен");
            }
        } else {
            System.out.println("Коротышка - " + person1.getName() + " выхватил "
                    + second + " у " + person2.getName() + " и сунул " + first);

            person1.setClothe(second);
            person2.setClothe(first);
        }
    }

    public void exchangeExchangeable(Exchangeable person1, Exchangeable person2) {
        Clothe first = person1.getClothe();
        Clothe second = person2.getClothe();

        if (first == null && second == null) {
            System.out.println("У обоих персонажей " + person1.getName() + ", " + person2.getName() + " ничего нет");
            return;
        }

        if (first == null) {
            System.out.println("У " + person1.getName() + " нет ничего для обмена с " + person2.getName());
            return;
        }

        if (second == null) {
            System.out.println("У " + person2.getName() + " нет ничего для обмена с " + person1.getName());
            return;
        }

        if (first.equals(second)) {
            System.out.println("Персонажи " + person1.getName() + ", " + person2.getName() + " с одинаковыми вещами");
        } else {
            person1.setClothe(second);
            person2.setClothe(first);

            System.out.println("Персонажи " + person1.getName() + ", " + person2.getName() +
                    " обменялись вещами " + first + ", " + second);
        }
    }

    public void exchange(Exchangeable person1, Exchangeable person2) {
        if (person1 == null && person2 == null) {
            System.out.println("Объектов не существует");
        } else if (person1 == null) {
            System.out.println("Объекта 1 не существует");
        } else if (person2 == null) {
            System.out.println("Объекта 2 не существует");
        } else if (person2 instanceof Hero && person1 instanceof Shorty) {
            exchangeShortyHero((Shorty) person1, (Hero) person2);
        } else if (person1 instanceof Hero && person2 instanceof Shorty) {
            exchangeShortyHero((Shorty) person2, (Hero) person1);
        } else if (person1.canExchangeWith(person2) || person2.canExchangeWith(person1)){
            exchangeExchangeable(person1, person2);
        } else {
            System.out.println(person1.getName() + " " + person1.getClass() + ", " + person2.getName() + " "
                    + person2.getClass() + " не умеют обмениваться они разные по природе");
        }
    }

    @Override
    public Hero getNextPerson() {
        int index = random.nextInt(listHeros.size());
        return listHeros.get(index);
    }
}