package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;
import lotto.exception.InputException;

public class InputView {
    public static String readInput() {
        return validate(Console.readLine());
    }

    public static String validate(String input) {
        if (input == null) {
            throw InputException.from(ErrorMessage.INPUT_IS_NULL);
        }
        if (input.isEmpty()) {
            throw InputException.from(ErrorMessage.INPUT_IS_EMPTY);
        }
        return input;
    }
}
