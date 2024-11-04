package lotto.validation;

import java.util.List;
import lotto.error.ErrorMessage;

public class Validation {

    public static void validateWinningLotto(List<Integer> winningNumbers) {
        long uniqueCount = winningNumbers.stream().distinct().count();
        boolean isOutOfRange = winningNumbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
        if (winningNumbers == null || winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_LOTTO_NUMBER_COUNT.getMessage());
        }
        if (uniqueCount != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_LOTTO_NUMBER.getMessage());
        }
        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice <= 0 || purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
        }
    }
}
