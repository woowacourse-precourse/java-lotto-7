package lotto.common.config;

import lotto.controller.LottoController;
import lotto.service.LottoGenerator;
import lotto.view.Input;
import lotto.view.Output;
import lotto.view.PurchaseAmountInput;
import lotto.view.WinningNumbersInput;

public class LottoConfig {
    public LottoController getLottoController() {
        LottoGenerator generator = new LottoGenerator();
        Input purchaseAmountInput = new PurchaseAmountInput();
        Input winningNumbersInput = new WinningNumbersInput();
        Output output = new Output();

        return new LottoController(purchaseAmountInput, winningNumbersInput, output, generator);
    }
}
