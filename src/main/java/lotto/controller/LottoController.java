package lotto.controller;

import lotto.domain.LottoPurchase;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoPurchase lottoPurchase = inputAmount();

        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        OutputView.printPurchaseAmount(purchaseAmount);
    }

    private LottoPurchase inputAmount() {
        try {
            int amount = Validator.validateAmount(InputView.inputAmount());
            return new LottoPurchase(amount);
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(e);
            return inputAmount();
        }
    }


}
