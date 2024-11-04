package lotto.validator;

import static lotto.exception.ExceptionMessage.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public class InputValidator {
    public static void validatePurchaseAmount(String purchaseAmount) {
        checkEmpty(purchaseAmount);
        checkValidNumber(purchaseAmount);
        checkMaxPurchaseAmount(purchaseAmount);
        checkMultipleOfThousand(purchaseAmount);
    }

    public static void validateWinningNumbers(String winningNumbers) {
        checkEmpty(winningNumbers);
        List<Integer> parsedWinningNumbers = checkParsedWinningNumbers(winningNumbers);
        new Lotto(parsedWinningNumbers);
    }

    public static void validateBonusNumber(String winningNumbers, String bonusNumber) {
        checkEmpty(bonusNumber);
        checkValidNumber(bonusNumber);

        List<Integer> parsedWinningNumbers = parseWinningNumbers(winningNumbers);
        int parsedBonusNumber = Integer.parseInt(bonusNumber);

        checkBonusNumberDuplicate(parsedWinningNumbers, parsedBonusNumber);
        checkRangeNumber(parsedBonusNumber);
    }

    private static void checkEmpty(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private static void checkValidNumber(String purchaseAmount) {
        try {
            new BigInteger(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static void checkMaxPurchaseAmount(String purchaseAmount) {
        BigInteger parsedAmount = new BigInteger(purchaseAmount);

        if (parsedAmount.compareTo(BigInteger.valueOf(100000)) > 0) {
            throw new IllegalArgumentException(MAX_PURCHASE_AMOUNT_EXCEEDED.getMessage());
        }
    }

    private static void checkMultipleOfThousand(String purchaseAmount) {
        int parsedAmount = Integer.parseInt(purchaseAmount);

        if (parsedAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static List<Integer> checkParsedWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(number -> {
                    try {
                        int parsedNumber = Integer.parseInt(number);
                        checkRangeNumber(parsedNumber);
                        return parsedNumber;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
                    }
                })
                .toList();
    }

    private static void checkRangeNumber(int parsedNumber) {
        if (parsedNumber < 1 || parsedNumber > 45) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private static List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private static void checkBonusNumberDuplicate(List<Integer> parsedWinningNumbers, int parsedBonusNumber) {
        if (parsedWinningNumbers.contains(parsedBonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
