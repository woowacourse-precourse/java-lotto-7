package lotto.validator;

import lotto.info.LottoInfo;
import lotto.message.ErrorMessage;

public class MoneyValidator {
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
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage(), e);
        }
    }

    private static void validatePositive(int moneyToBuy) {
        if (moneyToBuy <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateDivisibilityByThousand(int moneyToBuy) {
        if (moneyToBuy % LottoInfo.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_ERROR_MESSAGE.getMessage());
        }
    }
}
