package lotto;

enum ExceptionMessage {
    EMPTY_INPUT("[ERROR] 빈 문자열은 입력할 수 없습니다."),
    NOT_ONLY_NUMBER("[ERROR] 기타 문자나 단위 없이 양의 숫자만 입력하세요."),
    OUT_OF_RANGE_NUMBER(String.format("[ERROR] 입력 가능한 숫자는 0에서 %d 사이 입니다.", Integer.MAX_VALUE)),
    NOT_POSITIVE_NUMBER("[ERROR] 0보다 큰 양수를 입력하세요."),
    NOT_THOUSAND_DIVISIBLE("[ERROR] 1,000원 단위로 입력하세요");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class ExceptionHandler {
    public static void isEmpty(String input) {
        ExceptionMessage exception = ExceptionMessage.EMPTY_INPUT;
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void isOnlyNumber(String input) {
        ExceptionMessage exception = ExceptionMessage.NOT_ONLY_NUMBER;
        if (input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void isBigNumber(String input) {
        ExceptionMessage exception = ExceptionMessage.OUT_OF_RANGE_NUMBER;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void validateNumeric(String input) {
        isEmpty(input);
        isOnlyNumber(input);
        isBigNumber(input);
    }

    public static void isPositiveNumber(int input) {
        ExceptionMessage exception = ExceptionMessage.NOT_POSITIVE_NUMBER;
        if (input <= 0) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public static void isThousandDivisible(int input) {
        ExceptionMessage exception = ExceptionMessage.NOT_THOUSAND_DIVISIBLE;
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }
}
