package lotto.view.input;

import static lotto.constant.ExceptionMessage.INVALID_INPUT;

import java.util.List;
import java.util.stream.Stream;

public class InputHandler {
    private static final String DELIMITER = ",";

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    public static List<Integer> toNumbers(String input) {
        try {
            return Stream.of(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
