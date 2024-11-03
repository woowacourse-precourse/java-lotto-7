package lotto.domain;

public class PositiveNumber {

    private final Long number;

    public PositiveNumber(Long number) {
        validate(number);
        this.number = number;
    }

    public PositiveNumber(String number) {
        this(Long.parseLong(number));
    }

    private static void validate(Long number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("숫자는 1 ~ 45 사이여야 합니다");
        }
    }

    public PositiveNumber divide(Long number) {
        return new PositiveNumber(this.number / number);
    }

    public Long get() {
        return number;
    }
}
