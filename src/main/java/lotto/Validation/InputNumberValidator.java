package lotto.Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Util.Error.ErrorMessage;
import lotto.Util.Splitter.InputSplitter;

public class InputNumberValidator {
    private static final int REQUIRED_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String REGEX = "\\d+";

    public static boolean isNotInteger(String winNumbers) {
        try {
            InputSplitter.splitByDelimiter(winNumbers);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isOutOfIntegerRange(String winNumbers) {
        try {
            InputSplitter.splitByDelimiter(winNumbers);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isOutOfLottoRange(String winNumbers) {
        List<Integer> winningNumbers = InputSplitter.splitByDelimiter(winNumbers);

        for (int number : winningNumbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMatchedLottoSize(String winNumbers) {
        List<Integer> winningNumbers = InputSplitter.splitByDelimiter(winNumbers);

        if (winningNumbers.size() != REQUIRED_SIZE) {
            return true;
        }
        return false;
    }

    public static boolean isDuplicated(String winNumbers) {
        List<Integer> winningNumbers = InputSplitter.splitByDelimiter(winNumbers);
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        if (uniqueNumbers.size() != winningNumbers.size()) {
            return true;
        }
        return false;
    }

    private static boolean isSingleInteger(String input) {
        return input.trim().matches(REGEX);
    }

    public static void validatePaymentPriceType(String paymentPriceInput) {
        if (PriceValidator.isNotInteger(paymentPriceInput)) {
            throw new NumberFormatException(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    public static void validatePaymentPriceValue(String paymentPriceInput) {
        if (PriceValidator.isOutOfIntegerRange(paymentPriceInput)) {
            throw new NumberFormatException(ErrorMessage.PURCHASE_LIMIT_REACHED.getMessage());
        }
        if (PriceValidator.isZero(paymentPriceInput) || PriceValidator.isNegative(paymentPriceInput)) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (PriceValidator.isNotThousandUnit(paymentPriceInput)) {
            throw new ArithmeticException(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    public static void validateWinnigNumberType(String winningNumberInput) {
        if (isNotInteger(winningNumberInput)) {
            throw new NumberFormatException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
        if (isOutOfIntegerRange(winningNumberInput)) {
            throw new NumberFormatException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateWinnigNumberValue(String winningNumberInput) {
        if (isOutOfLottoRange(winningNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
        if (isMatchedLottoSize(winningNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
        if (isDuplicated(winningNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateBonusNumberType(String bonusNumberInput) {
        if (isNotInteger(bonusNumberInput)) {
            throw new NumberFormatException(ErrorMessage.INVALID_BONUS_NUMBER_COUNT.getMessage());
        }
        if (!isSingleInteger(bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_COUNT.getMessage());
        }
        if (isOutOfIntegerRange(bonusNumberInput)) {
            throw new NumberFormatException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateBonusNumberValue(String bonusNumberInput, List<Integer> winningNumber) {
        if (isOutOfLottoRange(bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
        if (winningNumber.contains(Integer.parseInt(bonusNumberInput))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

}
