package lotto.exception;

public enum ErrorStatus implements BaseErrorCode {
    //문자열 파싱 관련 예외
    NUMBER_PARSE_ERROR("올바른 형식으로 입력해주세요."),
    NUMBERS_PARSE_ERROR(",로 구분된 숫자들을 입력해주세요.");

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getErrorStatus() {
        return ERROR_PREFIX + message;
    }
}
