package lotto.controller;

import static lotto.view.InputView.getConsoleInput;

import lotto.domain.lotto.LottoStore;
import lotto.view.InputView;

public class LottoController {

    private InputView inputView;
    private LottoStore lottoStore;
    private int lottoCount;
    private String purchaseAmount;

    public void run() {
        purchaseAmount = inputView.requestPurchaseAmount(getConsoleInput());
        lottoCount = lottoStore.getLottoCount(purchaseAmount);

    }
}
