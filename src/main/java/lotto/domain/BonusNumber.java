package lotto.domain;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber of(int number) {
        return new BonusNumber(number);
    }

    public boolean isMatch(int number) {
        return this.number == number;
    }
}
