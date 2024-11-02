package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputProcessor {
    private final InputValidator inputValidator;

    public InputProcessor() {
        inputValidator = new InputValidator();
    }

    public int getTotalPurchaseAmount() {
        while (true) {
            String input = InputView.readPurchaseAmount();
            try {
                inputValidator.validatePurchaseAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    public Lotto getWinningLotto() {
        while (true) {
            String input = InputView.readWinningNumbers();
            try {
                inputValidator.validateWinningNumber(input);
                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    public int getBonusNumber(Lotto winningLotto) {
        while (true) {
            String input = InputView.readBonusNumber();
            try {
                inputValidator.validateBonusNumber(input, winningLotto);
                return Integer.parseInt(input.trim());
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }
}
