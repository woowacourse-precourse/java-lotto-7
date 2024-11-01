package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static lotto.controller.InputValidator.SPLITTER;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        BigInteger budget = getBudget();
        List<Integer> winningNumbers = getWinningNumbers();
    }

    private BigInteger getBudget() {
        String budgetInput = inputView.readBudget();
        try {
            InputValidator.validateBudgetInput(budgetInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getBudget();
        }
        return new BigInteger(budgetInput);
    }

    private List<Integer> getWinningNumbers() {
        String numbersInput = inputView.readWinningNumbers();
        try {
            InputValidator.validateWinningNumbers(numbersInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getWinningNumbers();
        }
        return Arrays.stream(numbersInput.split(SPLITTER)).map(Integer::parseInt).toList();
    }
}
