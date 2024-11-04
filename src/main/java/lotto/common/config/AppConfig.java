package lotto.common.config;

import lotto.controller.LottoController;
import lotto.service.LottoChecker;
import lotto.service.LottoGenerator;
import lotto.service.WinningResult;
import lotto.view.BonusNumberInput;
import lotto.view.Output;
import lotto.view.PurchaseAmountInput;
import lotto.view.WinningNumbersInput;

public class AppConfig {
    public LottoController getLottoController() {
        PurchaseAmountInput purchaseAmountInput = new PurchaseAmountInput();
        WinningNumbersInput winningNumbersInput = new WinningNumbersInput();
        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        Output output = new Output();
        LottoGenerator generator = new LottoGenerator();
        LottoChecker checker = new LottoChecker();
        WinningResult winningResult = new WinningResult();

        return new LottoController(
                purchaseAmountInput, winningNumbersInput, bonusNumberInput, output, generator, checker, winningResult
        );
    }
}
