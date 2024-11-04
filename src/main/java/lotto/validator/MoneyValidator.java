package lotto.validator;

import lotto.info.LottoInfo;
import lotto.message.ErrorMessage;

public class MoneyValidator {
    private static final String DEFAULT_ERROR_MESSAGE = "[ERROR] ";

    public static int validateMoneyToBuy(String input) {
        int moneyToBuy = parseAndValidateInteger(input);
        validatePositive(moneyToBuy);
        validateDivisibilityByThousand(moneyToBuy);
        return moneyToBuy;
    }

    private static int parseAndValidateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    DEFAULT_ERROR_MESSAGE + ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage(), e);
        }
    }

    private static void validatePositive(int moneyToBuy) {
        if (moneyToBuy <= 0) {
            throw new IllegalArgumentException(
                    DEFAULT_ERROR_MESSAGE + ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateDivisibilityByThousand(int moneyToBuy) {
        if (moneyToBuy % LottoInfo.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(
                    DEFAULT_ERROR_MESSAGE + ErrorMessage.NOT_DIVISIBLE_ERROR_MESSAGE.getMessage());
        }
    }
}
