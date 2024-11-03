package lotto.view;

public enum ErrorMessages {
    ERROR_MESSAGE("[ERROR]"),
    NOT_NUMBER_FORMAT(ERROR_MESSAGE.message + " 숫자 형식이 아닙니다."),
    NOT_DIVISIBLE_BY_THOUSAND(ERROR_MESSAGE.message + " 1000단위로 나누어 떨어지지 않습니다."),
    INVALID_LOTTO_NUMBER_COUNT(ERROR_MESSAGE.message + " 보너스 번호를 제외한 로또 번호는 6개여야 합니다."),
    DUPLICATION_LOTTO_NUMBER(ERROR_MESSAGE.message + " 로또 번호가 중복됩니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}