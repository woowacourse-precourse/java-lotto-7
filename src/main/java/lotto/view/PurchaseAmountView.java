package lotto.view;

import lotto.io.Input;
import lotto.io.Output;
import lotto.message.IOMessage;
import lotto.validation.PurchaseAmountValidation;

public final class PurchaseAmountView {
    public static int purchaseAmount() {
        while (true) {
            try {
                Output.printlnMessage(IOMessage.INPUT_PURCHASE_AMOUNT.getMessage());
                String inputAmount = Input.inputMessage();
                int purchaseQuantity = PurchaseAmountValidation.purchaseAmountValidationAndGetLottoQuantity(
                        inputAmount);
                return purchaseQuantity;
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage.getMessage());
            }
        }
    }
}
