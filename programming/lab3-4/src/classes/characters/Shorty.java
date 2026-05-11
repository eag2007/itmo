package classes.characters;

import classes.clothes.Manual;
import enums.names.NamesShorty;
import interfaces.Clothe;
import interfaces.Exchangeable;
import java.util.Objects;

public class Shorty extends Character implements Exchangeable {
    private final NamesShorty name;

    public Shorty(NamesShorty name, Clothe clothe) {
        super(clothe);
        this.name = name;
    }

    public NamesShorty getName() {
        return this.name;
    }

    public boolean canExchangeWith(Exchangeable other) {
        return (other instanceof Hero);
    }

    @Override
    public String toString() {
        return "Shorty=(id=" + this.getName() + ", clothe=" + this.getClothe()  + ")";
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
        Shorty shorty = (Shorty) obj;
        return name == shorty.name &&
                Objects.equals(getClothe(), shorty.getClothe());
    }
}