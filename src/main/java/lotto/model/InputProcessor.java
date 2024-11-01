package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputProcessor {
    private final InputValidator inputValidator;

    public InputProcessor() {
        inputValidator = new InputValidator();
    }

    public int inputPurchaseAmount() {
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

    public Lotto inputWinningLotto() {
        while (true) {
            String input = InputView.readWinningNumbers();
            try {
                List<Integer> winningNumbers = parseWinningNumbers(input);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(Lotto winningLotto) {
        while (true) {
            String input = InputView.readBonusNumber();
            try {
                return inputValidator.validateBonusNumber(input, winningLotto);
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }
}
