package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.amount.Amount;
import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;

public class InputView {

    public Amount getPurchaseAmount() {
        String input = Console.readLine();
        validateBlankInput(input);
        return new Amount(validateNumber(input));
    }

    private void validateBlankInput(String input) {
        if (input == null || input.isBlank()) {
            throw new CustomException(ExceptionMessage.BLANK_INPUT_EXCEPTION);
        }
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ExceptionMessage.NONE_NUMERIC_INPUT_EXCEPTION);
        }
    }
}
