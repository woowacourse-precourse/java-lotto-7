package lotto.validation;

import lotto.constants.AppConstants;
import lotto.constants.ErrorMessage;

import java.util.List;

public class InputValidator {

    public void validateNotEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CANNOT_BE_EMPTY.getMessage());
        }
    }

    public void checkDelimiter(String input) {
        if (input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < AppConstants.LOTTO_TICKET_PRICE || purchaseAmount % AppConstants.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void foundDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public void validateBonusNumber(int number) {
        if (number < AppConstants.LOTTO_MIN_NUMBER || number > AppConstants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}