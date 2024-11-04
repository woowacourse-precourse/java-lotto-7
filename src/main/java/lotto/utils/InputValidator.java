package lotto.utils;

public class InputValidator {

    private static final String NUMBER_PATTERN = "\\d+";

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
}
