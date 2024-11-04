package lotto.validator;

import lotto.message.ErrorMessage;

public class LottoAmountValidator {
    public static int validatePurchaseAmout(String lottoAmount) {
        inputNullOrEmpty(lottoAmount);
        int lottoRound = convertPurchaseAmountToInt(lottoAmount);
        if (lottoRound % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
        if (lottoRound < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE_OR_ZERO.getMessage());
        }
        return lottoRound / 1000;
    }

    private static int convertPurchaseAmountToInt(String lottoAmount) {
        try {
            return Integer.parseInt(lottoAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER.getMessage());
        }
    }

    public static void inputNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL_OR_EMPTY.getMessage());
        }
    }
}
