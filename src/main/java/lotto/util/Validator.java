package lotto.util;

import java.util.Arrays;

public class Validator {

    public static void isEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDigitString(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isNumberWithinRange(int number, int minNumber, int maxNumber) {
        if (number < minNumber || number > maxNumber) {
            throw new IllegalArgumentException();
        }
    }
}
