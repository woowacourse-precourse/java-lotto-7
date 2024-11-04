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
        if (!cost.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return cost;
    }

}
