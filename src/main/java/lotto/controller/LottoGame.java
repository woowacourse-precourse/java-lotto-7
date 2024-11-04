package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        this.lottoService = new LottoService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int money = purchaseMoney();
    }

    private int purchaseMoney() {
        while (true) {
            try {
                int money = inputView.readPurchaseMoney();
                lottoService.validatePurchaseMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}