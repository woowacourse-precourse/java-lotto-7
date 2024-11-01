package lotto.validation;

import java.util.List;
import lotto.exception.ExceptionMessage;

public class LottoNumberValidator {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static void validateLottoNumbers(List<Integer> winningNumbers) {
        validateSizeOfWinningNumbers(winningNumbers);
        validateDuplicateOfWinningNumbers(winningNumbers);
        validateRangeOfLottoWinningNumbers(winningNumbers);
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateRangeOfBonusNumber(bonusNumber);
        validateDuplicateOfBonusNumber(winningNumbers, bonusNumber);
    }

    private static void validateSizeOfWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
    }

    private static void validateDuplicateOfWinningNumbers(List<Integer> winningNumbers) {
        List<Integer> validateDuplicate = winningNumbers.stream().distinct().toList();
        if (validateDuplicate.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private static void validateRangeOfLottoWinningNumbers(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
            }
        }
    }

    private static void validateRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber < MINIMUM_NUMBER || bonusNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateDuplicateOfBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
