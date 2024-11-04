package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int requestPurchaseAmount() {
        while (true) {
            OutputView.promptPurchaseAmount();
            String input = Console.readLine();
            String validationError = getValidationError(input);
            if (validationError == null) {
                return Integer.parseInt(input);
            } else {
                OutputView.printErrorMessage(validationError);
            }
        }
    }

    protected static String getValidationError(final String input) {
        if (!input.matches("-?\\d+")) {
            return ErrorConstants.INVALID_PURCHASE_AMOUNT_NOT_A_NUMBER;
        }
        int amount = Integer.parseInt(input);
        if (amount <= 0) {
            return ErrorConstants.INVALID_PURCHASE_AMOUNT_NOT_POSITIVE;
        }
        if (amount % 1000 != 0) {
            return ErrorConstants.INVALID_PURCHASE_AMOUNT_NOT_IN_THOUSANDS;
        }
        return null;
    }
}