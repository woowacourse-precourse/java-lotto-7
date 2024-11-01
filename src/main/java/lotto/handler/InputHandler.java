package lotto.handler;

import java.util.Arrays;
import java.util.List;
import lotto.controller.InputValidator;
import lotto.view.InputView;

public class InputHandler {

    private InputHandler() {
    }

    private static final String DELIMITER = ",";

    public static int getPaidAmount() {
        String rawPaidAmount = InputView.getPaidAmount();
        InputValidator.validatePaidAmount(rawPaidAmount);

        return Integer.parseInt(rawPaidAmount);
    }

    public static List<Integer> getWinningNumbers() {
        String rawWinningNumbers = InputView.getWinningNumbers();
        InputValidator.validateWinningNumbers(rawWinningNumbers);

        return Arrays.stream(rawWinningNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public static int getBonusNumber() {
        String rawBonusNumber = InputView.getBonusNumber();
        InputValidator.validateWinningNumbers(rawBonusNumber);

        return Integer.parseInt(rawBonusNumber);
    }
}
