package lotto.util;

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
import lotto.enums.ExceptionMessage;

public class Validator {

    public static int validatePurchaseAmount(String input) {
        try {
            long purchaseAmount = Long.parseLong(input);

            if (purchaseAmount > Integer.MAX_VALUE) {
                throw new IllegalArgumentException(PURCHASE_AMOUNT_TOO_LARGE.getMessage());
            } else if (purchaseAmount < 1000) {
                throw new IllegalArgumentException(PURCHASE_AMOUNT_TOO_SMALL.getMessage());
            } else if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_EXCEPTION.getMessage());
            }

            return (int) purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_FORMAT_EXCEPTION.getMessage());
        }
    }

    public static List<Integer> validateWinningNumbers(String input) {
        String[] winningNumbers = input.split(",");

        Set<String> unique = new HashSet<>(Arrays.asList(winningNumbers));
        if (unique.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBER_COUNT_EXCEPTION.getMessage());
        }

        boolean anyMatch = Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> number < 1 || number > 45);
        if (anyMatch) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_EXCEPTION.getMessage());
        }

        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    public static int validateBonusNumber(List<Integer> winningNumbers, String input) {
        try {
            int bonusNumber = Integer.parseInt(input);

            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException(BONUS_NUMBER_RANGE_EXCEPTION.getMessage());
            }

            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_EXCEPTION.getMessage());
            }

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }
}
