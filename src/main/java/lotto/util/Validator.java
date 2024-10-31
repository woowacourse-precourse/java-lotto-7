package lotto.util;

public class Validator {

    public static void isEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
