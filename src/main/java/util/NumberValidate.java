package util;

public class NumberValidate {

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isPositiveNumber(String input) {
        if (isNumber(input)) {
            int number = Integer.parseInt(input);
            return number > 0;
        }
        return false;
    }

    public static boolean nothingLeftAfterDivideBy(int number, int divideNumber) {
        return (number % divideNumber) == 0;
    }
}
