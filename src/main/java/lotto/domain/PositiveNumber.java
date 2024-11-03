package lotto.domain;

public class PositiveNumber {

    private final Long number;

    public PositiveNumber(Long number) {
        this.number = number;
    }

    public PositiveNumber(String number) {
        this(Long.parseLong(number));
    }

    public PositiveNumber divide(Long number) {
        return new PositiveNumber(this.number / number);
    }

    public Long get() {
        return number;
    }
}
