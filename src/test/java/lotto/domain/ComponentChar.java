package lotto.domain;

import java.util.Objects;

public class ComponentChar implements Component {

    private final char word;

    public ComponentChar(char word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ComponentChar that = (ComponentChar) object;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }

    @Override
    public String toString() {
        return Character.toString(word);
    }
}
