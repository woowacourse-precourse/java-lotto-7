package lotto.domain;

public class Bonus {

    private final Integer number;

    public Bonus(Integer number) {
        this.number = number;
    }

    public boolean isContainsBonusBall(Lotto lotto) {
        return lotto.getNumbers().contains(number);
    }
}
