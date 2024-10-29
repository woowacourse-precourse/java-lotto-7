package lotto;

import static lotto.ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static int requestPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
        }
        throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_FORMAT);
    }
}
