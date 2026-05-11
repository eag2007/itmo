import classes.characters.Hero;
import classes.clothes.Jacket;
import classes.clothes.Manual;
import classes.clothes.Pant;
import classes.playHistory.PlayHistory;
import enums.colors.JacketColors;
import enums.colors.ManualColors;
import enums.colors.PantColors;
import enums.names.NamesHero;

public class Main {
    public static void main(String[] args) {
        PlayHistory history = new PlayHistory();

        Hero dunno = new Hero(NamesHero.DUNNO, null, 0.5, true);
        Hero button = new Hero(NamesHero.BUTTON, null, 0.6, true);
        Hero mottled = new Hero(NamesHero.MOTTLED, null, 0.7, true);
        Hero allknow = new Hero(NamesHero.ALLKNOW, null, 0.8, true);
        Hero polykov = new Hero(NamesHero.POLYKOV, null, 1, false);
        Hero balaksin = new Hero(NamesHero.BALAKSHIN, null, 0, false);
        Hero lena = new Hero(NamesHero.LENA, null, 0, true);
        Hero anna = new Hero(NamesHero.ANNA, null, 1, true);
        Hero alice = new Hero(NamesHero.ALICE, null, 0, false);
        Hero nikita = new Hero(NamesHero.NIKITA, null, 1, true);
        Hero evgeniy = new Hero(NamesHero.EVGENIY, new Manual(ManualColors.BLACK), 1, true);

        Hero testJacket = new Hero(NamesHero.DUNNO,
                new Jacket(JacketColors.GREEN),
                0.5, true);

        Hero testPant = new Hero(NamesHero.DUNNO, new Pant(PantColors.BEIGE), 0, true);

        //history.addHero(dunno);
        //history.addHero(button);
        //history.addHero(mottled);
        //history.addHero(allknow);
        //history.addHero(polykov);
        //history.addHero(balaksin);
        //history.addHero(lena);
        //history.addHero(anna);
        //history.addHero(alice);
        //history.addHero(nikita);
        history.addHero(evgeniy);
        history.addHero(testJacket);
        history.addHero(testPant);

        history.play();
    }
}