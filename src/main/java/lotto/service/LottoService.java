package lotto.service;

import lotto.view.InputView;

public class LottoService {

    private final InputView inputView;

    public LottoService() {
        this.inputView = new InputView();
    }

    public void run() {
        int amount = purchaseLotto();
    }

    private int purchaseLotto() {
        int amount = inputView.readPurchaseAmount();
        return amount;
    }
}
