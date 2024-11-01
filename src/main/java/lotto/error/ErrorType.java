package lotto.error;

public enum ErrorType {
    INVALID_PURCHASE_PRICE("원 단위로 입력해주세요."),
    INVALID_BONUS_NUM("당첨 번호에 없는 보너스 번호를 입력해주세요."),
    INVALID_NUMBER_FORMAT("숫자를 입력해주세요."),
    DUPLICATION_NUM("당첨 숫자는 중복될 수 없습니다. 다시 입력해주세요."),
    INSUFFICIENT_OR_EXCESSIVE_NUMBERS("당첨 숫자는 6개를 입력해주세요."),
    OUT_OF_RANGE_NUMBER("당첨 숫자는 1~45 범위로 입력해주세요");

    private final String message;

    ErrorType(final String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
