package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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
            outputView.printErrorMessage(e);
            return getMoney();
        }
        return new BigInteger(moneyInput);
    }

    private List<Integer> getWinningNumbers() {
        String numbersInput = inputView.readWinningNumbers();
        try {
            InputValidator.validateWinningNumbers(numbersInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getWinningNumbers();
        }
        return Arrays.stream(numbersInput.split(",")).map(Integer::parseInt).toList();
    }
}
