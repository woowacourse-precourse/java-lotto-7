package lotto.controller;

import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {
        int money = inputMoney();
    }

    private int inputMoney() {
        int money;
        while(true) {
            try{
                money = inputView.inputMoney();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return money;
    }
}
