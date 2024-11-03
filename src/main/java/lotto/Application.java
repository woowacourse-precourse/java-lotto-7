package lotto;

import lotto.controller.LottoController;
import lotto.controller.PurchaseAmountController;
import lotto.controller.WinningNumbersController;
import lotto.dto.PurchaseAmountRequestDto;
import lotto.dto.WinningNumbersRequestDto;

public class Application {
    public static void main(String[] args) {
        PurchaseAmountRequestDto purchaseAmountRequestDto = PurchaseAmountController.run();
        LottoController.run(purchaseAmountRequestDto);
        WinningNumbersRequestDto winningNumbersRequestDto = WinningNumbersController.run();
    }
}
