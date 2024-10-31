package lotto.domain;

public class BonusNumber {

    private final int value;

    public BonusNumber(int value) {
        this.value = value;
    }

    public boolean isSame(int number) {
        return number == value;
    }
}
