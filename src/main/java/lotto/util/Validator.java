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

    public static int isInteger(String input) {
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static void isDivisibleBy(int number, int divisor) {
        if ((number % divisor) != 0) {
            throw new IllegalArgumentException();
        }
    }
}
