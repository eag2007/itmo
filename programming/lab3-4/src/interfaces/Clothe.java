package interfaces;

import java.util.Objects;

public interface Clothe {
    String getDescription();

    @Override
    String toString();

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();
}