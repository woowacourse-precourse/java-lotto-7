package lotto.domain;

public class BonusNumber {
    private final int value;

    public BonusNumber(String value) {
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }
}
