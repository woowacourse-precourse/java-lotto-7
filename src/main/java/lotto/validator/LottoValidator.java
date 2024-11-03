package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class LottoValidator {
    private static final int NUMBER_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    public static void validatePurchaseAmount(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_OR_ZERO_PURCHASE_AMOUNT.getMessage());
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public static void validatePurchaseAmountFormat(String buyingPrice) {
        try {
            Integer.parseInt(buyingPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());
        }
    }

    public static void validateWinningAndBonusNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_AND_BONUS_NUMBER.getMessage());
        }
    }

    public static void validateNumericInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_INPUT.getMessage());
        }
    }

    public static void validateCommaSeparatedNumericInput(String input) {
        if (!input.matches("^(\\d+,){5}\\d+$")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateProfitCalculation(int totalPurchaseAmount) {
        if (totalPurchaseAmount <= 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_PURCHASE_AMOUNT_FOR_PROFIT_CALCULATION.getMessage());
        }
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }
}
