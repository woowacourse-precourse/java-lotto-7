package lotto.exception;

import lotto.model.WinningNumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String BLANK = " ";
    private static final Pattern PURCHASE_AMOUNT_PATTERN = Pattern.compile("^[1-9][0-9]?000|100000$");
    private static final Pattern WINNING_NUMBERS_PATTERN = Pattern.compile("^([0-9]{1,2},){5}[0-9]{1,2}$");
    private static final Pattern BONUS_NUMBER_PATTERN = Pattern.compile("^[1-9]|([1-3][0-9])|(4[0-5])$");
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validateContainsBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_BLANK.getErrorMessage());
        }
    }

    public static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getErrorMessage());
        }
    }

    public static void validatePurchaseAmount(String purchaseAmount) {
        if (!PURCHASE_AMOUNT_PATTERN.matcher(purchaseAmount).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getErrorMessage());
        }
    }

    public static void validateWinningNumbers(String winningNumbers) {
        if (!WINNING_NUMBERS_PATTERN.matcher(winningNumbers).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getErrorMessage());
        }
    }

    public static void validateWinningNumber(Integer winningNumber) {
        if (winningNumber < LOTTO_MIN_NUMBER || winningNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE.getErrorMessage());
        }
    }

    public static void validateUniqueWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>(winningNumbers);
        if (uniqueWinningNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING_NUMBERS.getErrorMessage());
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        if (!BONUS_NUMBER_PATTERN.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getErrorMessage());
        }
    }

    public static void validateUniqueBonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }
}
