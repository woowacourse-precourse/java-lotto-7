package lotto.controller;

import lotto.validator.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MoneyController {
    private int money;

    public int initMoney() {
        while (true) {
            try {
                String inputMoney = InputView.getMoney();
                validateMoneyInput(inputMoney);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e);
            }
        }
        OutputView.displayCount(money);
        return money;
    }

    public void validateMoneyInput(String inputMoney) {
        MoneyValidator.validateMoneyInputNotNull(inputMoney);
        MoneyValidator.validateMoneyIsNumeric(inputMoney);

        money = Integer.parseInt(inputMoney);
        MoneyValidator.validateMoneyPositive(money);
        MoneyValidator.validateMoneyDivisibleByThousand(money);
    }

    public int getMoney() {
        return money;
    }
}
