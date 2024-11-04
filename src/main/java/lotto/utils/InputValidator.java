package lotto.utils;

public class InputValidator {

    private static final String NUMBER_PATTERN = "\\d+";
    private static final String SEPARATOR = ",";


    public static String validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
        return input;
    }

    public static String validateCost(String cost) {
        validateNumber(cost);
        validateUnit(cost);
        return cost;
    }

    private static void validateNumber(String cost) {
        if (!cost.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void validateUnit(String cost) {
        if (isNotDivisible(cost)) {
            throw new IllegalArgumentException("%s원 단위의 구입 금액을 입력해주세요.");
        }
    }

    private static boolean isNotDivisible(String cost) {
        return Integer.parseInt(cost) % 1000 != 0;
    }


    public static void validateWinningNumbers(String message) {
        if (hasEdgeSeparator(message) || hasDuplicatedSeparator(message)) {
            throw new IllegalArgumentException("올바르지 않은 구분자 입력입니다.");
        }
    }

    private static boolean hasEdgeSeparator(String message) {
        return startsWithSeparator(message) || endsWithSeparator(message);
    }

    private static boolean startsWithSeparator(String message) {
        return message.startsWith(SEPARATOR);
    }

    private static boolean endsWithSeparator(String message) {
        return message.endsWith(SEPARATOR);
    }

    private static boolean hasDuplicatedSeparator(String message) {
        return message.contains(SEPARATOR.repeat(2));
    }

    public static String validateBonusNumber(String message) {
        validateNumber(message);
        return message;
    }
}
