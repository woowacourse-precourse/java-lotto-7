package lotto;

import static lotto.Constants.*;

import java.util.List;

public class BonusNumber {
    private static final String BONUS_NUMBER_DUPLICATION_ERROR = ERROR_HEADER + "당첨 번호와 보너스 번호가 같아서는 안 됩니다.";

    private final int number;

    private BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static BonusNumber from(String input) {
        try {
            int value = Integer.parseInt(input);
            return new BonusNumber(value);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public int get() {
        return this.number;
    }

    public void isDuplicated(WinningNumber winningNumber) {
        List<Integer> winningNumbers = winningNumber.getNumbers();
        if (winningNumbers.contains(this.number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR);
        }
    }

    private static void validate(int number) {
        if (number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR);
        }
    }
}
