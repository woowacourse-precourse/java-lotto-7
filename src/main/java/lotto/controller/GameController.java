package lotto.controller;

import lotto.view.InputView;

import java.math.BigInteger;

public class GameController {

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        BigInteger money = getMoney();
    }

    private BigInteger getMoney() {
        String moneyInput = inputView.readMoney();
        try {
            InputValidator.validateMoneyInput(moneyInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
        return new BigInteger(moneyInput);
    }
}
