package lotto.view;

import static lotto.message.MessageConstants.INPUT_PURCHASE_AMOUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchaseAmountValidator;

public class InputView {

    public String inputPurchaseAmount() {
        while (true) {
            System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);

            try {
                String purchaseAmount = Console.readLine();
                PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
