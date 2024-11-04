package lotto.validator;

public class NumberValidator {
    private static final String PREFIX = "[ERROR]";
    private static final String OUT_OF_RANGE_MESSAGE = PREFIX + " 로또 번호는 1부터 45 사이의 숫자여야 합니다. ";

    private static final Integer MIN = 1;
    private static final Integer MAX = 45;

    public void checkInRange(Integer value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
    }
}
