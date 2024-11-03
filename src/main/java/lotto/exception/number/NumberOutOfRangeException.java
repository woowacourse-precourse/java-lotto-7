package lotto.exception.number;

public class NumberOutOfRangeException extends IllegalArgumentException {

    private static final String MESSAGE = "로또 번호는 %d 이상, %d 이하여야 합니다.";

    public NumberOutOfRangeException(int minValue, int maxValue) {
        super(String.format(MESSAGE, minValue, maxValue));
    }
}
