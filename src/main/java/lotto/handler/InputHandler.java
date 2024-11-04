package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.OutputMessage;
import lotto.validator.PurchaseAmountValidator;

public class InputHandler {
    public int readPurchaseAmountInput() {
        System.out.println(OutputMessage.PURCHASE_AMOUNT_INPUT_MESSAGE);
        String input = Console.readLine();
        return PurchaseAmountValidator.validatePurchaseAmount(input);
    }
}
