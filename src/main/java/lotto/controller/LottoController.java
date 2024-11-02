package lotto.controller;

import lotto.exception.ValidationValues;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    public void startLotto() {
        String purchaseAmount = InputView.getLottoPurchaseAmount();
        ValidationValues.purchaseAmount(purchaseAmount);
    }

}
