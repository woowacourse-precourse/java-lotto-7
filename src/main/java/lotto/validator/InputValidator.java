package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessages;
import lotto.constant.LottoConstants;
import lotto.exception.InputException;

public class InputValidator {
    public static int validatePurchaseAmount(String purchaseAmount) {
        int purchaseAmountInt = parsePurchaseAmount(purchaseAmount);
        checkPurchaseAmountIsMultipleOfUnit(purchaseAmountInt);
        return purchaseAmountInt;
    }

    private static int parsePurchaseAmount(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessages.ERROR_NON_INTEGER_AMOUNT);
        }
    }

    private static void checkPurchaseAmountIsMultipleOfUnit(int purchaseAmountInt) {
        if (purchaseAmountInt <= 0 || purchaseAmountInt % LottoConstants.LOTTO_PRICE_UNIT != 0) {
            throw new InputException(ErrorMessages.ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT);
        }
    }

    public static List<Integer> validateWinningNumbers(List<String> winningNumbersInput) {
        List<Integer> winningNumbers = parseWinningNumbers(winningNumbersInput);
        checkWinningNumbersSize(winningNumbers);
        checkWinningNumbersRange(winningNumbers);
        checkDuplicateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private static List<Integer> parseWinningNumbers(List<String> winningNumbersInput) {
        try {
            return winningNumbersInput.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessages.ERROR_NON_INTEGER_LOTTO_NUMBER);
        }
    }

    private static void checkWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new InputException(ErrorMessages.ERROR_INVALID_WINNING_NUMBER_COUNT);
        }
    }

    private static void checkWinningNumbersRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream()
                .anyMatch(num -> num < LottoConstants.LOTTO_NUMBER_MIN || num > LottoConstants.LOTTO_NUMBER_MAX)) {
            throw new InputException(ErrorMessages.ERROR_WINNING_NUMBER_OUT_OF_RANGE);
        }
    }

    private static void checkDuplicateWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new InputException(ErrorMessages.ERROR_DUPLICATE_WINNING_NUMBER);
        }
    }

    public static int validateBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {
        int bonusNumber = parseBonusNumber(bonusNumberInput);
        checkBonusNumberRange(bonusNumber);
        checkBonusNumberDuplication(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static int parseBonusNumber(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessages.ERROR_NON_INTEGER_BONUS_NUMBER);
        }
    }

    private static void checkBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoConstants.LOTTO_NUMBER_MIN || bonusNumber > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new InputException(ErrorMessages.ERROR_BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    private static void checkBonusNumberDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new InputException(ErrorMessages.ERROR_DUPLICATE_BONUS_NUMBER);
        }
    }
}
