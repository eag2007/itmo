package classes.roof;

import classes.characters.Hero;
import classes.clothes.Manual;
import enums.colors.ManualColors;

import java.util.ArrayList;
import java.util.Random;

public class RoofEvent {
    public RoofEvent(ArrayList<Hero> listHeros) {
        System.out.println("Тут сверху что-то посыпалось, " +
                "и целая толпа коротышек бросилась подбирать падавшие c крыши дома вещи.\n" +
                "Незнайку, Кнопочку и Пестренького чуть не сбили с ног.\nС большим трудом они " +
                "выбрались из толпы," +
                " но все-таки тоже успели схватить по паре вещей.\n" +
                "Отбежав подальше, они стали рассматривать свою добычу.");
        System.out.println();
        getClotheWithRoof(listHeros);
        System.out.println("Вдруг к ним подбежали со смехом несколько коротышек и стали меняться вещами.");
    }

    private void getClotheWithRoof(ArrayList<Hero> listHero) {
        Hero hero;
        int countClothes = new Random().nextInt(listHero.size() + 1);
        for (int i = 0; i < countClothes; i++) {
            hero = listHero.get(i);
            if (hero.getClothe() == null) {
                hero.setClothe(new Manual(ManualColors.getRandomColor()));
            }
        }

        for (int i = 0; i < listHero.size(); i++) {
            hero = listHero.get(i);
            hero.describe();
        }
    }
}