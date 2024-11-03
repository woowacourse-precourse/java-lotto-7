package lotto;

import lotto.controller.LottoController;
import lotto.controller.PurchaseAmountController;
import lotto.dto.PurchaseAmountRequestDto;

public class Application {
    public static void main(String[] args) {
        PurchaseAmountRequestDto purchaseAmountRequestDto =  PurchaseAmountController.run();
        LottoController.run(purchaseAmountRequestDto);
    }
}
