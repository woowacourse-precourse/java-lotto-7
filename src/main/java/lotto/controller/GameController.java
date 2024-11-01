package lotto.controller;

import lotto.view.InputView;

import java.math.BigInteger;
import java.util.List;

public class GameController {

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        BigInteger money = getMoney();
        List<Integer> winningNumbers = getWinningNumbers();
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

    private List<Integer> getWinningNumbers() {
        String numbersInput = inputView.readWinningNumbers();
        try {
            InputValidator.validateWinningNumbers(numbersInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }
}
