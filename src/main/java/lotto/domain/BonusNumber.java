package lotto.domain;

import java.util.List;

public class BonusNumber {
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 45;
    private static final String ERROR_NUMBER_OUT_OF_RANGE = String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            START_VALUE, END_VALUE);
    private static final String ERROR_DUPLICATE_WINNING_NUMBERS = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";

    private final int value;

    public BonusNumber(Lotto winningNumbers, int value) {
        validateRange(value);
        validateDuplicate(winningNumbers, value);
        this.value = value;
    }

    private void validateRange(int number) {
        if (number < START_VALUE || number > END_VALUE) {
            throw new IllegalArgumentException(ERROR_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateDuplicate(Lotto winningNumbers, int value) {
        List<Integer> numbers = winningNumbers.getNumbers();
        if (numbers.contains(value)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBERS);
        }
    }

    public int getValue() {
        return value;
    }
}
