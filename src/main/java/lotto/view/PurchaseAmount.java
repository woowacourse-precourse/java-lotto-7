package lotto.view;

import lotto.io.Input;
import lotto.io.Output;
import lotto.message.IOMessage;

public final class PurchaseAmount {
    public static void purchaseAmount() {
        Output.printlnMessage(IOMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        String purchaseAmount = Input.inputMessage();
    }
}
