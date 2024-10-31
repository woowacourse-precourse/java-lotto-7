package lotto.controller;

import lotto.enums.Constants;
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
        try {
            String inputMoney = inputView.promptMoney();
            LottoValidator.validateInputMoney(inputMoney);
            return Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException error) {
            System.err.println(error.getMessage());
        }
        return getMoney();
    }
}
