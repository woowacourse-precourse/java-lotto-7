package lotto.service;

import lotto.util.InputParser;
import lotto.util.ValidationUtils;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class InputService {
    private final InputView inputView;
    private final InputParser inputParser = new InputParser();

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public int getValidBuyInput() {
        while (true) {
            try {
                String money = inputView.getBuy();
                return inputParser.parseBuy(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Set<Integer> getValidWinningNumInput() {
        while (true) {
            try {
                String winningNum = inputView.getWinningNum();

                validateWinningNumInput(winningNum);

                Set<Integer> winningNumbers = inputParser.parseWinningNumbers(winningNum);
                ValidationUtils.validateWinningNumbersCount(winningNumbers);

                return winningNumbers;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateWinningNumInput(String winningNum) {
        List<String> numbers = Arrays.asList(winningNum.split(","));
        for (String num : numbers) {
            ValidationUtils.validateNumberFormat(num.trim());
        }
    }

    public int getValidBonusNumberInput(Set<Integer> winningNum) {
        while (true) {
            try {
                String bonusNum = inputView.getBonusNum();
                ValidationUtils.vaildateBonusNumberNotNumber(bonusNum);
                int bounusNumber = inputParser.parseBonusNumber(bonusNum);
                ValidationUtils.validateBonusNumberRange(bounusNumber);
                ValidationUtils.validateBonusNumberDuplication(bounusNumber, winningNum);
                return bounusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
