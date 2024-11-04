package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.InputView;

public class InputHandler {

    private static final InputView input = new InputView();
    private static final InputValidator validate = new InputValidator();

    public int getPurchaseAmount() {
        int amount = Integer.parseInt(input.purchaseAmountInput());
        validate.validatePurchaseAmount(amount);
        return amount;
    }

    public Lotto getWinningNumbers() {
        String winningNumbersInput = input.winningNumbersInput();
        List<Integer> numbers = parseNumbers(winningNumbersInput);
        //validate.validateWinningNumbers(numbers);
        return new Lotto(numbers);
    }

    private List<Integer> parseNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }

    public int getBonusNumber(Lotto winningNumbers) {
        int bonus = Integer.parseInt(input.bonusNumberInput());
        validate.validateBonusNumber(bonus, winningNumbers);
        return bonus;
    }

}
