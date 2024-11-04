package lotto.validation;

import java.util.List;
import lotto.error.ErrorMessage;

public class Validation {

    public static void validateWinningLottoSize(List<Integer> winningNumbers) {
        if (winningNumbers == null || winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public static void validateWinningLottoDuplicates(List<Integer> winningNumbers) {
        long uniqueCount = winningNumbers.stream().distinct().count();
        if (uniqueCount != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateWinningLottoRange(List<Integer> winningNumbers) {
        boolean isOutOfRange = winningNumbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateBonusNumberDuplicates(List<Integer> winningNumbers, int bonusNumber) {
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
