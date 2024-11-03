package lotto.domain;

public class Number {

    private final Integer number;

    public Number(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
