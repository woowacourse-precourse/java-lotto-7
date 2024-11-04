package lotto.controller;

import lotto.service.PurchaseAmountService;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.dto.PurchaseAmountDto;

public class PurchaseAmountController {

    private final PurchaseAmountService purchaseAmountService = new PurchaseAmountService();

    public void getPurchaseAmount() {
        try {
            String input = InputView.inputPurchaseAmount();
            PurchaseAmountDto dto = PurchaseAmountValidator.validate(input);
            OutputView.printPurchaseCount(dto.value);
            purchaseAmountService.generateLotto(dto);
            purchaseAmountService.savePurchaseAmount(dto);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getPurchaseAmount();
        }
    }
}
