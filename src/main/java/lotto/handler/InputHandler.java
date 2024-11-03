package lotto.handler;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import lotto.controller.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputHandler {

    private InputHandler() {
    }

    private static final String DELIMITER = ",";

    public static int getPaidAmount() {
        return retryOnInvalidInput(InputHandler::fetchAndValidatePaidAmount);
    }

    public static List<Integer> getWinningNumbers() {
        return retryOnInvalidInput(InputHandler::fetchAndValidateWinningNumbers);
    }

    public static int getBonusNumber() {
        return retryOnInvalidInput(InputHandler::fetchAndValidateBonusNumber);
    }

    private static int fetchAndValidatePaidAmount() {
        String rawPaidAmount = InputView.getPaidAmount();
        InputValidator.validatePaidAmount(rawPaidAmount);

        return Integer.parseInt(rawPaidAmount);
    }

    private static List<Integer> fetchAndValidateWinningNumbers() {
        String rawWinningNumbers = InputView.getWinningNumbers();
        InputValidator.validateWinningNumbers(rawWinningNumbers);

        return Arrays.stream(rawWinningNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    private static int fetchAndValidateBonusNumber() {
        String rawBonusNumber = InputView.getBonusNumber();
        InputValidator.validateBonusNumber(rawBonusNumber);

        return Integer.parseInt(rawBonusNumber);
    }

    private static <T> T retryOnInvalidInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }
}
