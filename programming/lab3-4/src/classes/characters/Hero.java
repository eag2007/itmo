package classes.characters;

import enums.names.NamesHero;
import interfaces.Clothe;
import interfaces.Exchangeable;

import java.util.Objects;

public class Hero extends Character implements Exchangeable {
    private final NamesHero name;
    private double power;
    private boolean flag;
    private boolean desireExchange;

    public Hero(NamesHero name, Clothe clothe, double power, boolean desireExchange) {
        super(clothe);
        this.name = name;
        this.power = power;

        if (clothe == null) {
            this.flag = false;
        } else {
            this.flag = true;
        }

        this.desireExchange = desireExchange;
    }

    public NamesHero getName() {
        return this.name;
    }

    public double getPower() {
        return this.power;
    }

    public boolean getDesireExchange() {
        return this.desireExchange;
    }

    public void describe() {
        if (this.getClothe() == null) {
            System.out.println(this.getName() + " ничего не нашёл(");
        } else {
            if (this.flag) {
                System.out.println("У " + this.getName() + " были " + this.getClothe());
            } else {
                System.out.println(this.getName() + " нашёл " + this.getClothe());
            }
        }
    }

    public boolean canExchangeWith(Exchangeable other) {
        return ((other instanceof Hero) || (other instanceof Shorty));
    }

    @Override
    public String toString() {
        return "Герой " + this.name + " " + this.power + " " + this.clothe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power, flag, desireExchange, getClothe());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Hero hero = (Hero) obj;
        return Double.compare(power, hero.power) == 0 && flag == hero.flag &&
                desireExchange == hero.desireExchange && name == hero.name &&
                Objects.equals(getClothe(), hero.getClothe());
    }
}