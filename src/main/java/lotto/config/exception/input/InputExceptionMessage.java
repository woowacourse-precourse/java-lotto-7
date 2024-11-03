package lotto.config.exception.input;

public enum InputExceptionMessage {
    EMPTY_INPUT("입력값이 없습니다."),
    POSITIVE_INPUT("금액은 0원 이하가 될 수 없습니다."),
    NOT_NUMBER_INPUT("입력값이 숫자가 아닙니다."),
    NOT_EXIST_DELIMITER("입력값에 쉼표가 없습니다."),
    INVALID_INPUT_PRICE("구입 금액은 1,000원 단위여야 합니다.");

    private final String message;

    InputExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
