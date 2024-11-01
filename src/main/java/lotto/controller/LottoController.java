package lotto.controller;

import lotto.model.Balance;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Balance balance;

    public void run() {
        insertMoney();
    }

    public void insertMoney() {
        OutputView.printInsertMoney();
        balance = new Balance(InputView.inputMoney());
    }
}
