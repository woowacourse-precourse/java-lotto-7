package lotto.controller;

import lotto.model.LottoGame;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class LottoGameController {
    private LottoGame lottoGame;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        setupLottoTickets();
    }

    private void setupLottoTickets() {
        int money = readMoney();
    }

    private int readMoney() {
        String moneyInput = inputView.getMoneyInput();

        Validator.validateMoneyInput(moneyInput);

        return Integer.parseInt(moneyInput);
    }
}
