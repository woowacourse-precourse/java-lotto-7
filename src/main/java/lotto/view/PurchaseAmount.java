package lotto.view;

import lotto.io.Input;
import lotto.io.Output;
import lotto.message.IOMessage;
import lotto.validation.PurchaseValidation;

public final class PurchaseAmount {
    public static int purchaseAmount() {
        while (true) {
            try {
                Output.printlnMessage(IOMessage.INPUT_PURCHASE_AMOUNT.getMessage());
                String purchaseAmount = Input.inputMessage();
                return PurchaseValidation.purchaseValidation(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}
