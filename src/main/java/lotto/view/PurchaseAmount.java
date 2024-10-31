package lotto.view;

import lotto.io.Input;
import lotto.io.Output;
import lotto.message.IOMessage;
import lotto.validation.PurchaseAmountValidation;

public final class PurchaseAmount {
    public static int purchaseAmount() {
        while (true) {
            try {
                Output.printlnMessage(IOMessage.INPUT_PURCHASE_AMOUNT.getMessage());
                String purchaseAmountStr = Input.inputMessage();
                int purchaseQuantity = PurchaseAmountValidation.purchaseAmountValidationAndGetLottoQuantity(
                        purchaseAmountStr);
                Output.printlnFormattedMessage(IOMessage.OUTPUT_PURCHASE_QUANTITY.getMessage(), purchaseQuantity);
                return purchaseQuantity;
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage.getMessage());
            }
        }
    }
}
