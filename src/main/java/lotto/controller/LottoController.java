package lotto.controller;

import lotto.domain.Lotto;
import lotto.validator.BonusValidator;
import lotto.validator.NumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private int bonus;

    public List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                String winningInput = InputView.getWinningNumbers();
                return validateWinningNumbers(winningInput);
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e);
            }
        }
    }

    public List<Integer> validateWinningNumbers(String winningInput) {
        String[] parsedWinningNumbers= winningInput.split(",");
        NumberValidator.validateWinningNumbersAreNumeric(parsedWinningNumbers);

        List<Integer> numbers = convertToIntegerList(parsedWinningNumbers);
        new Lotto(numbers);
        return numbers;
    }

    private List<Integer> convertToIntegerList(String[] parsedWinningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : parsedWinningNumbers) {
            numbers.add(Integer.parseInt(s.trim()));
        }
        return numbers;
    }

    public int getValidatedBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusInput = InputView.getBonusNumber();
                bonus = validateBonusNumber(winningNumbers, bonusInput);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e);
            }
        }
        return bonus;
    }

    public int validateBonusNumber(List<Integer> winningNumbers, String bonusInput) {
        BonusValidator.validateBonusIsNumeric(bonusInput);

        bonus = Integer.parseInt(bonusInput.trim());
        BonusValidator.validateBonusNumberRange(bonus);
        BonusValidator.validateBonusNotDuplicated(winningNumbers, bonus);

        return bonus;
    }
}
