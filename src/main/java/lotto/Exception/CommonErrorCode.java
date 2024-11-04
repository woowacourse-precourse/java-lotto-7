package lotto.Exception;

public enum CommonErrorCode implements ExceptionCode {
    NOT_NULL("입력 값이 null이거나 빈 문자열입니다."),
    NOT_NUMBER("%s은 숫자만 입력할 수 있습니다."),
    OUT_OF_RANGE("%s는 %d에서 %d 사이의 숫자여야 합니다.");

    private final String message;

    CommonErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
