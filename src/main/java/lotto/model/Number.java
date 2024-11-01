package lotto.model;

import static lotto.util.inputParser.parseInt;

public class Number {
    private final int value;

    public Number(final int value) {
        validate(value);
        this.value = value;
    }

    public Number(final String input){
        validate(parseInt(input));
        this.value = parseInt(input);
    }

    private void validate(int value) {
        validateNumberRange(value);
    }

    private void validateNumberRange(int value) {
        if (isNotValidRange(value)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이어야 합니다.");
        }
    }

    private boolean isNotValidRange(int value) {
        return value < 1 || value > 45;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Number number = (Number) obj;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    public int getValue() {
        return value;
    }
}
