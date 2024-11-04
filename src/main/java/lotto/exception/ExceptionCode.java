package lotto.exception;

public enum ExceptionCode {

    INVALID_NUMBER_SIZE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_MONEY_PRICE("구입 금액은 1,000원 단위여야 합니다");


    private static final String DEFAULT_ERROR_MESSAGE = "[ERROR] ";

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return DEFAULT_ERROR_MESSAGE + this.message;
    }


}
