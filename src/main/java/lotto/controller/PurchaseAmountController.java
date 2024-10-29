package lotto.controller;

import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.dto.PurchaseAmountDto;

public class PurchaseAmountController {

    public void getPurchaseAmount() {
        try {
            String input = InputView.inputPurchaseAmount();
            PurchaseAmountDto dto = PurchaseAmountValidator.validate(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
