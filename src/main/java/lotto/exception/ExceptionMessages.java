package lotto.exception;

public enum ExceptionMessages {
    INPUT_WHITESPACE("[ERROR] 입력은 비어있을 수 없습니다! 다시 입력해주세요."),
    NOT_DIGIT("[ERROR] 숫자가 아닌 문자가 입력되었습니다! 다시 입력해주세요."),
    AMOUNT_OUT_OF_RANGE("[ERROR] 2,147,483,647을 초과하는 수는 금액으로 입력하실 수 없습니다! 다시 입력해주세요."),
    AMOUNT_CANNOT_BE_NEGATIVE_DIGIT("[ERROR] 음수는 금액으로 입력하실 수 없습니다! 다시 입력해주세요."),
    AMOUNT_CANNOT_DIVISIBLE("[ERROR] 금액이 1,000원 단위로 나누어 떨어지지 않습니다! 다시 입력해주세요.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
