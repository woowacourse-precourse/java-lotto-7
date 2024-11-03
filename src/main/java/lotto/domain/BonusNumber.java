package lotto.domain;

public class BonusNumber {
    private final Number number;

    public BonusNumber(String number) {
        this.number = new Number(number);
    }

    public Number getNumber() {
        return number;
    }
}
