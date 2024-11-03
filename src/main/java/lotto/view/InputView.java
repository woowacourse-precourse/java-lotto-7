package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ExceptionMessage;
import lotto.util.validator.NumberValidator;

public class InputView {

    public static int readNumber() {
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public static String readNumbers() {
        String input = Console.readLine();
        validateEmpty(input);
        return input;
    }

    private static void validateEmpty(String input) {
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY);
        }
    }

    private static void validateNumber(String input) {
        validateEmpty(input);
        NumberValidator.validateInteger(input);
    }
}
