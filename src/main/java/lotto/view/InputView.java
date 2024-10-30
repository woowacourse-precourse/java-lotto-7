package lotto.view;

import static lotto.constant.ErrorMessage.EMPTY_INPUT_ERROR;
import static lotto.constant.ErrorMessage.NULL_INPUT_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {
    public static String requestInput(String message) {
        System.out.println(message);
        return getInput();
    }

    private static String getInput() {
        try {
            String input = Console.readLine();
            validateInput(input);

            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(NULL_INPUT_ERROR.getMessage());
        }
    }

    private static void validateInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR.getMessage());
        }
    }
}

