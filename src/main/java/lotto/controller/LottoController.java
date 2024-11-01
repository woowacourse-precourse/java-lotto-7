package lotto.controller;

import lotto.view.LottoPurchaseInputView;

public class LottoController {
    private LottoPurchaseInputView lottoPurchaseInputView;

    public LottoController(LottoPurchaseInputView lottoPurchaseInputView) {
        this.lottoPurchaseInputView = lottoPurchaseInputView;
    }

    public void run() {
        int lottoAmount = lottoPurchaseInputView.inputPurchaseAmount();
        int numberOfTickets = lottoPurchaseInputView.numberOfLotto(lottoAmount);
        lottoPurchaseInputView.makeRandomLottos(numberOfTickets);
    }
}
