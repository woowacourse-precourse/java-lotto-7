package io;

import camp.nextstep.edu.missionutils.Console;
import domain.error.ErrorMessage;
import domain.error.InputErrorMessage;

public class Input {
    public static int purchaseLottoAndGetLottoCount() {
        System.out.println(OutputMessage.ENTER_PURCHASE_AMOUNT.getOutputMessage());
        while (true) {
            try {
                return parseAndValidatePurchaseAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseAndValidatePurchaseAmount(String input) {
        validateInputStringIsEmpty(input);
        int amount = parseStringToInt(input);
        validateAmountForPurchaseConditions(amount);
        return amount;
    }

    private static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.ONLY_NUMBERS_ALLOWED.getErrorMessage());
        }
    }

    private static void validateAmountForPurchaseConditions(int amount) {
        if (amount > 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException(InputErrorMessage.PURCHASE_LOTTO_CONDITION.getErrorMessage());
        }
    }

    private static void validateInputStringIsEmpty(String input) {
        if (input.isEmpty() || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_MESSAGE.getErrorMessage());
        }
    }
}
