package lotto.validate;

import static lotto.constants.LottoConstants.DELIMITER;
import static lotto.constants.LottoConstants.PURCHASE_UNIT_WON;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

public class Validator {

    public static void validatePurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        isEmpty(purchaseAmount);
        validateUnit(parseToInt(purchaseAmount));
    }

    public static void validateWinningNumbers(String winningNumbers) throws IllegalArgumentException {
        isEmpty(winningNumbers);
        validateIntegerAndDelimiter(winningNumbers);
    }

    public static void validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        isEmpty(bonusNumber);
        validateNumberRange(parseToInt(bonusNumber));
    }

    private static void isEmpty(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateUnit(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount % PURCHASE_UNIT_WON != 0 || purchaseAmount < PURCHASE_UNIT_WON) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_UNIT.getMessage());
        }
    }

    private static void validateIntegerAndDelimiter(String winningNumbers) throws IllegalArgumentException {
        if (!winningNumbers.chars().allMatch(ch -> Character.isDigit(ch) || ch == DELIMITER.charAt(0))) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_PATTERN.getMessage());
        }
    }

    private static void validateNumberRange(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < LottoConstants.LOTTO_START_INCLUSIVE
                || bonusNumber > LottoConstants.LOTTO_END_INCLUSIVE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }

    private static int parseToInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_TYPE.getMessage());
        }
    }
}
