package lotto.util.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.InputException;
import lotto.util.enums.ExceptionMessages;

public class InputValidator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAXIMUM_PURCHASE_AMOUNT = 100000;
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final String DELIMITER = ",";

    public void validatePurchaseAmount(String purchaseAmountInput) {
        validateNotEmpty(purchaseAmountInput, ExceptionMessages.EMPTY_INPUT.getMessage());
        validateNumberFormat(purchaseAmountInput, ExceptionMessages.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());

        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        validatePurchaseAmountRange(purchaseAmount);
    }

    public void validateWinningNumbers(String winningNumbers) {
        List<Integer> winningNumberList = parseAndValidateWinningNumbers(winningNumbers);
        validateWinningNumberCountAndRange(winningNumberList);
    }

    public void validateBonusNumber(String winningNumbers, String bonusNumber) {
        List<Integer> winningNumberList = parseWinningNumbers(winningNumbers);
        int bonusNum = parseBonusNumber(bonusNumber);
        validateBonusNumberRange(bonusNum);
        validateBonusNumberDuplication(winningNumberList, bonusNum);
    }

    private void validateNotEmpty(String input, String errorMessage) {
        if (input == null || input.trim().isEmpty()) {
            throw new InputException(errorMessage);
        }
    }

    private void validateNumberFormat(String input, String errorMessage) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new InputException(errorMessage);
        }
    }

    private void validatePurchaseAmountRange(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new InputException(ExceptionMessages.NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
        }

        if (purchaseAmount > MAXIMUM_PURCHASE_AMOUNT) {
            throw new InputException(ExceptionMessages.EXCEEDS_PURCHASE_LIMIT.getMessage());
        }
    }

    private List<Integer> parseAndValidateWinningNumbers(String winningNumbers) {
        List<Integer> winningNumberList = parseWinningNumbers(winningNumbers);
        validateWinningNumberCountAndRange(winningNumberList);
        return winningNumberList;
    }

    private List<Integer> parseWinningNumbers(String winningNumbers) {
        try {
            return Arrays.stream(winningNumbers.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InputException(ExceptionMessages.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateWinningNumberCountAndRange(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new InputException(ExceptionMessages.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new InputException(ExceptionMessages.DUPLICATE_WINNING_NUMBER.getMessage());
        }

        for (int number : winningNumbers) {
            if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
                throw new InputException(ExceptionMessages.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private int parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber.trim());
        } catch (NumberFormatException e) {
            throw new InputException(ExceptionMessages.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new InputException(ExceptionMessages.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateBonusNumberDuplication(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new InputException(ExceptionMessages.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
