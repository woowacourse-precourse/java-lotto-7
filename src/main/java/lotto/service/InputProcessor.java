package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputProcessor {
    private static final String DELIMITER_COMMA = ",";
    private final InputValidator inputValidator;

    public InputProcessor() {
        inputValidator = new InputValidator();
    }

    public int getTotalPurchaseAmount() {
        while (true) {
            String inputTotalPurchaseAmount = InputView.readTotalPurchaseAmount();
            try {
                inputValidator.validateTotalPurchaseAmount(inputTotalPurchaseAmount);
                return Integer.parseInt(inputTotalPurchaseAmount);
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    public Lotto getWinningNumbers() {
        while (true) {
            String inputWinningNumbers = InputView.readWinningNumbers();
            try {
                inputValidator.validateWinningNumbers(inputWinningNumbers);
                List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(DELIMITER_COMMA))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    public int getBonusNumber(Lotto winningNumbers) {
        while (true) {
            String inputBonusNumber = InputView.readBonusNumber();
            try {
                inputValidator.validateBonusNumber(inputBonusNumber, winningNumbers);
                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }
}
