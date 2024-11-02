package lotto.util;

public class ValidateNumber {

    public static Integer change(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
