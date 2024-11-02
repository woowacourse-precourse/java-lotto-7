package lotto.commons.numbers;

public class Integers {
    public static Integer parseIntOrThrow(String value, String error) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(error);
        }
    }
}
