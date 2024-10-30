package lotto.controller;

import lotto.domain.Cost;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        inputView.requestPurchaseAmount();
        Cost cost = initCost(inputView);
    }

    private Cost initCost(InputView inputView) {
        try {
            return new Cost(inputView.getInput());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return initCost(inputView);
        }
    }
}
