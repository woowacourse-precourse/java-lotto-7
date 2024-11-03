package lotto.handler;

import lotto.validator.WinningNumbersValidator;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersHandler {
    public static void handle(String winningNumbers) {
        List<String> winningNumbersList = Arrays.asList(winningNumbers.split(","));
        WinningNumbersValidator.validateBlank(winningNumbersList);
        WinningNumbersValidator.validateWinningNumbersLength(winningNumbersList);
        for (String token : winningNumbersList) {
            WinningNumbersValidator.validateElementIsInteger(token);
            WinningNumbersValidator.validateElementRange(token);
        }
    }
}
