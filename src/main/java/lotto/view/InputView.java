package lotto.view;

import static lotto.exception.ExceptionMessage.EXCEEDS_MAX_ATTEMPTS;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.WinningNumbersParser;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;

public class InputView {
    public static final int MAX_ATTEMPTS = 3;

    public int readBonusNumber() {
        return Integer.parseInt(readInput());
    }

    public List<Integer> readWinningNumbers() {
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            String input = readInput();
            if (isValidWinningNumbers(input)) {
                return parseWinningNumbers(input);
            }
            attempts++;
        }

        throw new IllegalStateException(EXCEEDS_MAX_ATTEMPTS.getMessage());
    }

    private List<Integer> parseWinningNumbers(String input) {
        return WinningNumbersParser.parse(input);
    }

    private boolean isValidWinningNumbers(String input) {
        try {
            WinningNumbersValidator.validate(input);
            return true;
        } catch (IllegalArgumentException e) {
            alert(e.getMessage());
            return false;
        }
    }

    public long readPurchaseAmount() {
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            String input = readInput();
            if (isValidPurchaseAmount(input)) {
                return parsePurchaseAmount(input);
            }
            attempts++;
        }

        throw new IllegalStateException(EXCEEDS_MAX_ATTEMPTS.getMessage());
    }

    private boolean isValidPurchaseAmount(String input) {
        try {
            PurchaseAmountValidator.validate(input);
            return true;
        } catch (IllegalArgumentException e) {
            alert(e.getMessage());
            return false;
        }
    }

    private long parsePurchaseAmount(String input) {
        return Long.parseLong(input);
    }

    private String readInput() {
        return Console.readLine();
    }

    private void alert(String errorMessage) {
        System.out.println(errorMessage);
    }
}
