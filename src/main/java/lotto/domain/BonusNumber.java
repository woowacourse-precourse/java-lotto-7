package lotto.domain;

import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoRules;

public class BonusNumber {
    private final int number;

    public BonusNumber(List<Integer> numbers, WinningNumbers winningNumbers) {
        validateNumbersCount(numbers);
        this.number = validateNumberInRange(numbers.getFirst());
        validateNumbersDuplication(this.number, winningNumbers);
    }

    private static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LottoRules.BONUS_NUMBER_REQUIRED) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumbersDuplication(int number, WinningNumbers winningNumbers) {
        if (winningNumbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public static int validateNumberInRange(int number) {
        if (number < LottoRules.MIN_NUMBER || number > LottoRules.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.OUT_OF_BOUNDS.getMessage(), LottoRules.MIN_NUMBER,
                            LottoRules.MAX_NUMBER));
        }
        return number;
    }

    public int getNumber() {
        return number;
    }
}
