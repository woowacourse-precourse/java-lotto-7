package lotto.model;

public class Number {
    private final int number;

    public Number(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        validateNumberRange(number);
    }

    private void validateNumberRange(int number) {
        if (isNotValidRange(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이어야 합니다.");
        }
    }

    private boolean isNotValidRange(int number) {
        return number < 1 || number > 45;
    }

    public int getValue() {
        return number;
    }
}
