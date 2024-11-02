package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.exception.Exception.*;

public class InputView {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static int inputPurchaseAmount() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_INPUT_FOR_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static String removeAllSpaces(String input) {
        return input.replace(" ", "");
    }

    private static String[] splitWinningNumbers(String input) {
        return input.split(WINNING_NUMBER_DELIMITER);
    }
}
