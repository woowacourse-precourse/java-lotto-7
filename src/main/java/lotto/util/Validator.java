package lotto.util;

import static lotto.enums.Constants.LOTTO_NUMBER_COUNT;
import static lotto.enums.Constants.LOTTO_NUMBER_MAXIMUM;
import static lotto.enums.Constants.LOTTO_NUMBER_MINIMUM;
import static lotto.enums.Constants.PURCHASE_AMOUNT_MINIMUM;
import static lotto.enums.Constants.PURCHASE_AMOUNT_UNIT;
import static lotto.enums.Constants.ZERO_VALUE;
import static lotto.enums.ExceptionMessage.BONUS_NUMBER_DUPLICATE_EXCEPTION;
import static lotto.enums.ExceptionMessage.BONUS_NUMBER_FORMAT_EXCEPTION;
import static lotto.enums.ExceptionMessage.BONUS_NUMBER_RANGE_EXCEPTION;
import static lotto.enums.ExceptionMessage.PURCHASE_AMOUNT_FORMAT_EXCEPTION;
import static lotto.enums.ExceptionMessage.PURCHASE_AMOUNT_TOO_LARGE;
import static lotto.enums.ExceptionMessage.PURCHASE_AMOUNT_TOO_SMALL;
import static lotto.enums.ExceptionMessage.PURCHASE_AMOUNT_UNIT_EXCEPTION;
import static lotto.enums.ExceptionMessage.WINNING_NUMBER_COUNT_EXCEPTION;
import static lotto.enums.ExceptionMessage.WINNING_NUMBER_RANGE_EXCEPTION;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final String DELIMITER = ",";

    public static int validatePurchaseAmount(String input) {
        try {
            long purchaseAmount = Long.parseLong(input);
            validateMaximum(purchaseAmount);
            validateMinimum(purchaseAmount);
            validateUnit(purchaseAmount);
            return (int) purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_FORMAT_EXCEPTION.getMessage());
        }
    }

    private static void validateMaximum(long purchaseAmount) {
        if (purchaseAmount > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_TOO_LARGE.getMessage());
        }
    }

    private static void validateMinimum(long purchaseAmount) {
        if (purchaseAmount < PURCHASE_AMOUNT_MINIMUM.getValue()) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_TOO_SMALL.getMessage());
        }
    }

    private static void validateUnit(long purchaseAmount) {
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT.getValue() != ZERO_VALUE.getValue()) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_EXCEPTION.getMessage());
        }
    }

    public static List<Integer> validateWinningNumbers(String input) {
        String[] winningNumbers = input.split(DELIMITER);
        validateSize(winningNumbers);
        validateRange(winningNumbers);
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateSize(String[] winningNumbers) {
        Set<String> unique = new HashSet<>(Arrays.asList(winningNumbers));
        if (unique.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(WINNING_NUMBER_COUNT_EXCEPTION.getMessage());
        }
    }

    private static void validateRange(String[] winningNumbers) {
        boolean anyMatch = Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .anyMatch(number ->
                        number < LOTTO_NUMBER_MINIMUM.getValue() ||
                                number > LOTTO_NUMBER_MAXIMUM.getValue()
                );
        if (anyMatch) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    public static int validateBonusNumber(List<Integer> winningNumbers, String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            validateRange(bonusNumber);
            validateDuplicate(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MINIMUM.getValue() ||
                bonusNumber > LOTTO_NUMBER_MAXIMUM.getValue()) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }
    }
}
