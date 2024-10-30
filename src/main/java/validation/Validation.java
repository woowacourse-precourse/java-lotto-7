package validation;

public class Validation {

    private static final String BLANK_INPUT_ERROR = "[ERROR] 비어있는 문자열입니다.";
    private static final String INVALID_INPUT_ERROR = "[ERROR] 정상적인 입력이 아닙니다.";
    private static final String OVER_INPUT_ERROR = "[ERROR] 회차당 10만원을 초과할 수 없습니다.";
    private static final int MAX_MONEY = 100000;

    public static void blankInput(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_ERROR);
        }
    }

    public static void numberInput(String str) {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        if (num <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }

    }

    public static void overInput(int inputMoney) {
        if (inputMoney > MAX_MONEY) {
            throw new IllegalArgumentException(OVER_INPUT_ERROR);
        }
    }
}

