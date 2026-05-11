package interfaces;

import classes.characters.Character;

public interface Exchangeable {
    Clothe getClothe();
    void setClothe(Clothe clothe);
    boolean canExchangeWith(Exchangeable other);
    Object getName();
}