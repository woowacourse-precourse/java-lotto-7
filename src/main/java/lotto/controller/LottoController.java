package lotto.controller;

import lotto.validator.LottoValidator;
import lotto.view.InputView;

public class LottoController {

    InputView inputView;

    public LottoController() {
        this.inputView = new InputView();
    }

    public void run() {
        int money = getMoney();
    }

    private int getMoney() {
        String inputMoney = inputView.promptMoney();
        LottoValidator.validateInputMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }
}
