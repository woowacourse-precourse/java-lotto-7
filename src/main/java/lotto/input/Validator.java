package lotto.input;

public class Validator {

    public static void notEmpty(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어 있습니다.");
        }
    }

    private static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    public static void isNumber(String[] strings) {
        try {
            for (String string : strings) {
                isNumber(string);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
