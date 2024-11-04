package lotto.validator;

import java.util.List;
import lotto.constant.Constants;
import lotto.exception.InputNumberException;

public class LottoBonusNumberValidator {
    public static int validateAndParse(String input, List<Integer> winningNumbers) {
        int bonusNumber = parseBonusNumber(input);
        validateRange(bonusNumber);
        checkDuplicateWithWinningNumbers(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static int parseBonusNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(InputNumberException.EMPTY_INPUT.getMessage());
        }
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputNumberException.INVALID_FORMAT.getMessage());
        }
    }

    private static void validateRange(int number) {
        if (number < Constants.LOTTO_NUMBER_RANGE_START || number > Constants.LOTTO_NUMBER_RANGE_END) {
            throw new IllegalArgumentException(InputNumberException.INVALID_RANGE.getMessage());
        }
    }

    private static void checkDuplicateWithWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(InputNumberException.DUPLICATE_NUMBER_WITH_WINNING_NUMBERS.getMessage());
        }
    }
}
