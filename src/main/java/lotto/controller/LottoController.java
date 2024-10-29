package lotto.controller;

import lotto.model.UserLottoInfo;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        UserLottoInfo userLottoInfo = new UserLottoInfo(readPurchaseAmount());

    }

    private long readPurchaseAmount() {
        return inputView.readPurchaseAmount();
    }
}
