package lotto.domain;

import java.util.List;

import static lotto.constants.LottoNumberType.*;
import static lotto.constants.exception.ErrorMessage.*;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(List<Integer> winningNumber, String bonusNumber) {
        this.bonusNumber = Validator.validateBonusNumber(winningNumber, bonusNumber);
    }

    public static BonusNumber of(List<Integer> winningNumber, String bonusNumber) {
        return new BonusNumber(winningNumber, bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static class Validator {

        private static final String BONUS_NUMBER_NUMERIC_REGEX = "-?\\d+";

        private static int validateBonusNumber(List<Integer> winningNumber, String bonusNumber) {
            validateWinningNumbersIsNotEmpty(bonusNumber);
            int numericBonusNumber = validateBonusNumberIsNumeric(bonusNumber);
            validateBonusNumberInRange(numericBonusNumber);
            validateUniqueBonusAndWinningNumbers(winningNumber, numericBonusNumber);
            return numericBonusNumber;
        }

        private static void validateWinningNumbersIsNotEmpty(String bonusNumber) {
            if (bonusNumber == null || bonusNumber.isBlank()) {
                throw new IllegalArgumentException(EMPTY_BONUS_NUMBER.getMessage());
            }
        }

        private static int validateBonusNumberIsNumeric(String bonusNumber) {
            if (!bonusNumber.matches(BONUS_NUMBER_NUMERIC_REGEX)) {
                throw new IllegalArgumentException(NON_NUMERIC_BONUS_NUMBER.getMessage());
            }
            return Integer.parseInt(bonusNumber);
        }

        private static void validateBonusNumberInRange(int bonusNumber) {
            if (bonusNumber < MINIMUM_LOTTO_NUMBER.getNumber()
                    || bonusNumber > MAXIMUM_LOTTO_NUMBER.getNumber()) {
                throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }

        private static void validateUniqueBonusAndWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
            for (int winningNumber : winningNumbers) {
                if (winningNumber == bonusNumber) {
                    throw new IllegalArgumentException(DUPLICATE_BONUS_AND_WINNING_NUMBER.getMessage());
                }
            }
        }

    }

}