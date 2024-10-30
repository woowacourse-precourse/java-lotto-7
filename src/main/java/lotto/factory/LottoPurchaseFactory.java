package lotto.factory;

import lotto.domain.LottoPurchase;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoPurchaseFactory {
    public static LottoPurchase createLottoPurchase() {
        try {
            int amount = Validator.validateAmount(InputView.inputAmount());
            return new LottoPurchase(amount);
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(e);
            return createLottoPurchase();
        }
    }
}