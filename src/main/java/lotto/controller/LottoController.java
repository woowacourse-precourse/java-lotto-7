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
        try {
            OutputView.printInsertMoney();
            balance = new Balance(InputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            insertMoney();
        }
    }
}
