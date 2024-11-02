package lotto.view;

import static lotto.exception.ExceptionMessage.EXCEEDS_MAX_ATTEMPTS;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchaseAmountValidator;

public class InputView {
    public static final int MAX_ATTEMPTS = 3;

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
            System.out.println(e.getMessage());
            return false;
        }
    }

    private long parsePurchaseAmount(String input) {
        return Long.parseLong(input);
    }

    private String readInput() {
        return Console.readLine();
    }
}
