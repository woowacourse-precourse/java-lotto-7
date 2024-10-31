package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.InputError;
import org.junit.platform.commons.util.StringUtils;

public class InputValidator {

    private static final int ZERO = 0;
    private static final int PURCHASE_BASE_AMOUNT = 1_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final String SEPARATOR = ",";
    private static final String ONLY_NUMBERS_AND_SEPARATORS = "^[\\d" + SEPARATOR + "]+$";

    public void validatePurchaseAmount(String rawInput) {
        if (StringUtils.isBlank(rawInput)) {
            throw new IllegalArgumentException(InputError.PURCHASE_AMOUNT_EMPTY.getMessage());
        }
        int purchaseAmount = parsePurchaseAmount(rawInput);
        validateAboveBaseAmount(purchaseAmount);
        validateIsMultipleOfBaseAmount(purchaseAmount);
    }

    private int parsePurchaseAmount(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputError.PURCHASE_AMOUNT_INVALID.getMessage());
        }
    }

    private void validateAboveBaseAmount(int purchaseAmount) {
        if (purchaseAmount < PURCHASE_BASE_AMOUNT) {
            throw new IllegalArgumentException(InputError.PURCHASE_AMOUNT_UNDER_BASE_LIMIT.getMessage());
        }
    }

    private void validateIsMultipleOfBaseAmount(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_BASE_AMOUNT != ZERO) {
            throw new IllegalArgumentException(InputError.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }

    public void validateWinningNumbers(String rawInput) {
        if (StringUtils.isBlank(rawInput)) {
            throw new IllegalArgumentException(InputError.WINNING_NUMBERS_EMPTY.getMessage());
        }
        validateContainsOnlyNumbersAndCommas(rawInput);
        String[] separatedInputs = rawInput.split(SEPARATOR);
        validateCorrectCount(separatedInputs);
        validateNoDuplicates(separatedInputs);
    }

    private void validateContainsOnlyNumbersAndCommas(String rawInput) {
        if (!rawInput.matches(ONLY_NUMBERS_AND_SEPARATORS)) {
            throw new IllegalArgumentException(InputError.WINNING_NUMBERS_INVALID.getMessage());
        }
    }

    private void validateCorrectCount(String[] separatedInputs) {
        if (separatedInputs.length != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(InputError.WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    private void validateNoDuplicates(String[] separatedInputs) {
        Set<Integer> winningNumbers = new HashSet<>();
        for (String input : separatedInputs) {
            int number = parseLottoNumber(input.trim());
            if (!winningNumbers.add(number)) {
                throw new IllegalArgumentException(InputError.WINNING_NUMBERS_DUPLICATE.getMessage());
            }
        }
    }

    private int parseLottoNumber(String rawInput) {
        try {
            int number = Integer.parseInt(rawInput);
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(InputError.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputError.LOTTO_NUMBER_INVALID.getMessage());
        }
    }

    public void validateBonusNumber(String rawInput, List<Integer> winningNumbers) {
        if (StringUtils.isBlank(rawInput)) {
            throw new IllegalArgumentException(InputError.BONUS_NUMBER_EMPTY.getMessage());
        }

        int bonusNumber = parseLottoNumber(rawInput.trim());
        validateBonusNumberNotInWinningNumbers(winningNumbers, bonusNumber);
    }

    private void validateBonusNumberNotInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(InputError.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
