package lotto.domain;

import java.util.List;
import lotto.common.ErrorMessages;
import lotto.common.LottoConstants;

public class BonusNumber {
    private final int number;

    public BonusNumber(String input, List<Integer> winningNumbers) {
        this.number = parseNumber(input);
        validateRange(this.number);
        validateNoDuplication(this.number, winningNumbers);
    }

    private int parseNumber(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_BONUS_NUMBER);
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_INPUT_ERROR);
        }
    }

    private void validateRange(int number) {
        if (number < LottoConstants.LOTTO_MIN_NUMBER || number > LottoConstants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private void validateNoDuplication(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_BONUS_NUMBER);
        }
    }

    public int getNumber() {
        return number;
    }
}

