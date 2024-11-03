package lotto.commons.numbers;

public class Integers {

    private Integers() {}

    public static Integer parseIntOrThrow(String value, String error) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(error);
        }
    }
}
