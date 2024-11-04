package lotto.validator;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.domain.vo.Number;

import java.util.List;

public class BonusNumberValidator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private BonusNumberValidator() {
    }

    public static void validate(String bonusNumber, List<Number> winningNumbers) {
        validateNotNull(bonusNumber);
        validateNotEmpty(bonusNumber);
        validateIsNumeric(bonusNumber);
        validateInRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber, winningNumbers);
    }

    private static void validateNotNull(String input) {
        if (input == null) {
            throw LottoException.from(ErrorMessage.NULL_INPUT_ERROR);
        }
    }

    private static void validateNotEmpty(String input) {
        if (input.isBlank()) {
            throw LottoException.from(ErrorMessage.EMPTY_INPUT_ERROR);
        }
    }

    private static void validateIsNumeric(String bonusNumber) {
        if (isNotNumeric(bonusNumber)) {
            throw LottoException.from(ErrorMessage.INVALID_NUMBER_RANGE_ERROR);
        }
    }

    private static void validateInRange(String bonusNumber) {
        if (isBonusNumberOutOfRange(bonusNumber)) {
            throw LottoException.from(ErrorMessage.INVALID_NUMBER_RANGE_ERROR);
        }
    }

    private static void validateBonusNumberDuplication(String bonusNumber, List<Number> winningNumbers) {
        if (isBonusNumberDuplicateWithWinningNumbers(bonusNumber, winningNumbers)) {
            throw LottoException.from(ErrorMessage.DUPLICATE_WINNING_NUMBER_ERROR);
        }
    }

    private static boolean isNotNumeric(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static boolean isBonusNumberOutOfRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    private static boolean isBonusNumberDuplicateWithWinningNumbers(String bonusNumber, List<Number> winningNumbers) {
        return winningNumbers.stream()
                .anyMatch(number -> number.lottoNumber() == Integer.parseInt(bonusNumber));
    }
}
