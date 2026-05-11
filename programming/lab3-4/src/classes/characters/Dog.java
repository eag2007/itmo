package classes.characters;

import interfaces.Clothe;
import interfaces.Exchangeable;
import java.util.Objects;

public class Dog extends Character implements Exchangeable {
    private final String name;

    public Dog(String name, Clothe clothe) {
        super(clothe);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean canExchangeWith(Exchangeable other) {
        return false;
    }

    @Override
    public String toString() {
        return "Dog=(id=" + this.getName() + ", clothe=" + this.getClothe()  + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getClothe());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dog dog = (Dog) obj;
        return Objects.equals(name, dog.name) &&  // Исправил сравнение для String
                Objects.equals(getClothe(), dog.getClothe());
    }
}