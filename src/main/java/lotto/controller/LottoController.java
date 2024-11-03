package lotto.controller;

import lotto.view.InputView;

import static lotto.common.Constants.LOTTO_PRICE_UNIT;
import static lotto.service.Validator.validatePurchaseAmount;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run () {
        Integer lottoCount = lottoPurchase();
    }

    private Integer lottoPurchase () {
        String rawPurchaseAmount = inputView.getPurchaseAmount();

        validatePurchaseAmount(rawPurchaseAmount);
        Integer purchaseAmount = Integer.parseInt(rawPurchaseAmount);

        return changeLottoFromMoney(purchaseAmount);
    }

    private Integer changeLottoFromMoney (Integer money) {
        return money % LOTTO_PRICE_UNIT;
    }
}
