package lotto.controller;

import lotto.model.LottoGame;
import lotto.validator.Validator;
import lotto.view.LottoGameView;

public final class LottoGameController {
    private LottoGame lottoGame;
    private final LottoGameView lottoGameView;

    public LottoGameController(LottoGameView lottoGameView) {
        this.lottoGameView = lottoGameView;
    }

    public void run() {
        setupLottoTickets();
    }

    private void setupLottoTickets() {
        int money = readMoney();
    }

    private int readMoney() {
        String moneyInput = lottoGameView.getMoneyInput();

        Validator.validateMoneyInput(moneyInput);

        return Integer.parseInt(moneyInput);
    }
}
