package lotto.model;

import java.util.List;

public class Bonus {
    private static final int START = 1;
    private static final int END = 45;

    private static final String INVALID_RANGE = "[ERROR] 로또 번호는 1-45 사이의 정수여야 합니다.";
    private static final String INVALID_NUMBER = "[ERROR] 로또 번호의 모든 숫자는 서로 다른 숫자여야 합니다.";

    private final int number;

    public Bonus(int number, List<Integer> numbers) {
        validateRange(number);
        validateDuplication(number, numbers);
        this.number = number;
    }

    public static void validateRange(int number) {
        if (number < START || number > END) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    public static void validateDuplication(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    public int getNumber() {
        return number;
    }
}
