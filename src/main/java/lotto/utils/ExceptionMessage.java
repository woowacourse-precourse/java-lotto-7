package lotto.utils;

public enum ExceptionMessage {
    INVALID_INPUT_BUDGET("예산은 1000원 단위로 입력 가능합니다.");

    private static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return this.message;
    }

}
