package lotto.domain.prize;

public class BonusNumber {
    private final int value;

    public BonusNumber(int value) {
        this.value = value;
    }

    public static BonusNumber of(int value) {
        return new BonusNumber(value);
    }

    public int getValue() {
        return 0;
    }
}
