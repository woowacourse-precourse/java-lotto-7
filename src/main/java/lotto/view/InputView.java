package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;

public class InputView {

    public int getPurchaseAmount() {
        String input = Console.readLine();
        validateBlankInput(input);
        return Integer.parseInt(input);
    }

    private void validateBlankInput(String input) {
        if (input == null || input.isBlank()) {
            throw new CustomException(ExceptionMessage.BLANK_INPUT_EXCEPTION);
        }
    }
}
