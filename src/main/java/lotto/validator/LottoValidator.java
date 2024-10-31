package lotto.validator;

import lotto.exception.ErrorMessage;

import java.util.List;

public class LottoValidator {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public static void validateLottoPurchaseAmount(int price) {
        if (price % LOTTO_PRICE > 0 || price / LOTTO_PRICE < 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber, winningNumbers);
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateBonusNumberDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        boolean isDuplicate = winningNumbers.stream()
                .anyMatch(winningNumber -> winningNumber == bonusNumber);
        if (isDuplicate) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER_MUST_BE_UNIQUE.getMessage());
        }
    }

}
