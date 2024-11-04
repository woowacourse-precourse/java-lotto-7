package lotto.input;

public class Validator {

    private static final String ERROR_EMPTY_INPUT = "[ERROR] 입력값이 비어 있습니다.";
    private static final String ERROR_NOT_A_NUMBER = "[ERROR] 숫자가 아닙니다.";
    private static final String ERROR_CONTAINS_NON_NUMBER = "[ERROR] 숫자가 아닌 값이 포함되어 있습니다.";


    public static void notEmpty(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }

    private static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
        }
    }

    public static void isNumber(String[] strings) {
        try {
            for (String string : strings) {
                isNumber(string);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_CONTAINS_NON_NUMBER);
        }
    }
}
