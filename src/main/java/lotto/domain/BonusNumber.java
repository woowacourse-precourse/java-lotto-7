package lotto.domain;

import java.util.List;
import lotto.common.ErrorMessages;
import lotto.common.LottoConstants;

public class BonusNumber {
    private final int number;

    public BonusNumber(String input, List<Integer> winningNumbers) {
        this.number = parseAndValidate(input, winningNumbers);
    }

    private int parseAndValidate(String input, List<Integer> winningNumbers) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_BONUS_NUMBER);
        }
        try {
            int number = Integer.parseInt(input);
            if (number < LottoConstants.LOTTO_MIN_NUMBER || number > LottoConstants.LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_RANGE);
            }
            if (winningNumbers.contains(number)) {
                throw new IllegalArgumentException(ErrorMessages.DUPLICATE_BONUS_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_INPUT_ERROR);
        }
    }

    public int getNumber() {
        return number;
    }
}
