package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.RequestMessage;
import lotto.exception.PurchaseException;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println(RequestMessage.REQUEST_LOTTO_PURCHASE_AMOUNT.getMessage());
        String input = Console.readLine().trim();

        if (input.isEmpty()) {
            throw new IllegalArgumentException(PurchaseException.EMPTY_INPUT.getMessage());
        }

        return parseAmount(input);
    }

    private static int parseAmount(String input) {
        try {
            long longAmount = Long.parseLong(input);
            if (longAmount > Integer.MAX_VALUE || longAmount < Integer.MIN_VALUE) {
                throw new IllegalArgumentException(PurchaseException.OUT_OF_INT_RANGE.getMessage());
            }
            return (int) longAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PurchaseException.INVALID_FORMAT.getMessage());
        }
    }
}
