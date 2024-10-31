package lotto.validator;

import java.util.List;
import lotto.constants.LottoConstants;
import lotto.view.ErrorMessage;

public class InputValidator {

    public static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_INVALID.getMessage());
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INVALID.getMessage());
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoConstants.MIN_NUMBER || bonusNumber > LottoConstants.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateBonusNumberNotDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_INVALID.getMessage());
        }
    }

    public static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

}
