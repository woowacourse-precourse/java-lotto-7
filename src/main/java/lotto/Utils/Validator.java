package lotto.Utils;

public class Validator {

    private Validator() {
    }

    public static boolean isEmptyString(String input) {
        if (input == null) {
            return true;
        }

        return input.isEmpty();
    }

    public static boolean isBlankString(String input) {
        return input.isBlank();
    }

    public static boolean isNumericString(String input) {
        return input.matches("\\d+");
    }

}
