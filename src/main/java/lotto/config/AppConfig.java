package lotto.config;

import lotto.utils.parser.BonusNumberParser;
import lotto.utils.parser.PurchaseAmountParser;
import lotto.utils.parser.WinningNumberParser;
import lotto.utils.validator.BonusNumberValidator;
import lotto.utils.validator.PurchaseAmountValidator;
import lotto.utils.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    private final PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
    private final WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
    private final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    public InputView getInputView() {
        return new InputView(
                new PurchaseAmountParser(purchaseAmountValidator),
                new WinningNumberParser(winningNumberValidator),
                new BonusNumberParser(bonusNumberValidator)
        );
    }

    public OutputView getOutputView() {
        return new OutputView();
    }
}
