package lotto.domain;

public class Bonus {

    private static final Integer MIN_NUMBER_RANGE = 1;
    private static final Integer MAX_NUMBER_RANGE = 45;

    private final Integer number;

    public Bonus(Integer number) {
        validateRange(number);
        this.number = number;
    }

    private boolean IsNumberRangeIncorrect(Integer number) {
        return number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE;
    }

    private void validateRange(Integer number) {
        if (IsNumberRangeIncorrect(number)) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getNumber() {
        return number;
    }
}
