package lotto.handler;

import lotto.validator.WinningNumbersValidator;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersHandler {
    public static boolean handle(String winningNumbers) {
        List<String> winningNumbersList = Arrays.asList(winningNumbers.split(","));

        if (!WinningNumbersValidator.validateBlank(winningNumbersList)) {
            return false;
        }
        if (!WinningNumbersValidator.validateWinningNumbersLength(winningNumbersList)) {
            return false;
        }
        for (String token : winningNumbersList) {
            if (!WinningNumbersValidator.validateElementIsInteger(token)) {
                return false;
            }
            if (!WinningNumbersValidator.validateElementRange(token)) {
                return false;
            }
            if (!WinningNumbersValidator.validateDuplicate(winningNumbersList, token)) {
                return false;
            }
        }
        return true;
    }
}
