package lotto.enums;

public enum ErrorCode {

    WRONG_VALIDATION("[ERROR] 잘못된 접근입니다."),
    PARSING_INTEGER_ERROR("[ERROR] Cannot Change String to Integer");

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    private final String message;
}
