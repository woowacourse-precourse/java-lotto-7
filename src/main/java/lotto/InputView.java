package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int requestPurchaseAmount() {
        while (true) {
            OutputView.promptPurchaseAmount();
            String input = Console.readLine();
            if (isValidPurchaseAmount(input)) {
                return Integer.parseInt(input);
            } else {
                OutputView.printErrorMessage(ErrorConstants.INVALID_PURCHASE_AMOUNT_ERROR);
            }
        }
    }

    private static boolean isValidPurchaseAmount(final String input) {
        if (!input.matches("\\d+")) {
            return false;
        }
        int amount = Integer.parseInt(input);
        return amount > 0 && amount % 1000 == 0;
    }
}