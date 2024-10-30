package lotto.controller;

import lotto.view.LottoInputView;

public class LottoController {

    private final LottoInputView lottoInputView;

    public LottoController(LottoInputView lottoInputView) {
        this.lottoInputView = lottoInputView;
    }

    public void run() {
        String PurchaseMoney = lottoInputView.getLottoPurchaseMoney();
    }
}
