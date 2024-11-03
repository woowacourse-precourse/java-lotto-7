package lotto.domain.service;

import lotto.domain.model.ErrorMessages;
import java.util.List;

public class ValidationService {

    private static final int TICKET_PRICE = 1000;

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_FORMAT.getMessage());
        }

        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.ZERO_PURCHASE_AMOUNT.getMessage());
        }
        if (purchaseAmount < TICKET_PRICE) {
            throw new IllegalArgumentException(ErrorMessages.MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT.getMessage());
        }

        return purchaseAmount;
    }

    public static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER_ERROR.getMessage());
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_FORMAT.getMessage());
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
        }

        return bonusNumber;
    }
}
