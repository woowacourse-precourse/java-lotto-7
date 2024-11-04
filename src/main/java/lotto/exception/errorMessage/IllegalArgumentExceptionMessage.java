package lotto.exception.errorMessage;

public enum IllegalArgumentExceptionMessage {
    NUMBER_FORMAT("숫자 형식의 값을 입력해주세요"),
    PURCHASE_AMOUNT_UNIT("구입 금액은 1000원 단위여야 합니다."),
    PURCHASE_AMOUNT_NOT_NATURE("구입 금액은 자연수값이어야 합니다."),
    NOT_NUMBER_ATTEMPT("숫자가 아닌 값이 들어왔습니다.");

    private final String message;

    IllegalArgumentExceptionMessage(String message) {
        String ERROR = "[ERROR] ";
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
