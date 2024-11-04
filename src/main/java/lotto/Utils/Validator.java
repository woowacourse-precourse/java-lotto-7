package lotto.Utils;

public class Validator {

    private Validator() {
    }

    public static boolean isEmpty(String input) {
        if (input == null) {
            return true;
        }

        return input.isEmpty();
    }

    public static boolean isBlank(String input) {
        return input.isBlank();
    }

    public static boolean isNotNumeric(String input) {
        return !input.matches("\\d+");
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean inRange(int num, int min, int max) {
        return min <= num && num <= max;
    }

}
