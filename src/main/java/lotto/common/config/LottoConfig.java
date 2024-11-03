package lotto.common.config;

import lotto.controller.LottoController;
import lotto.service.LottoChecker;
import lotto.service.LottoGenerator;
import lotto.view.Input;
import lotto.view.Output;
import lotto.view.PurchaseAmountInput;
import lotto.view.WinningNumbersInput;

public class LottoConfig {
    public LottoController getLottoController() {
        Input purchaseAmountInput = new PurchaseAmountInput();
        Input winningNumbersInput = new WinningNumbersInput();
        Output output = new Output();
        LottoGenerator generator = new LottoGenerator();
        LottoChecker checker = new LottoChecker();

        return new LottoController(purchaseAmountInput, winningNumbersInput, output, generator, checker);
    }
}
