package lotto.exception;

public enum ExceptionMessage {
    NOT_NUMBER("입력값은 숫자여야 합니다. 혹은 너무 큰 숫자입니다."),
    NOT_POSITIVE_NUMBER("구입 금액은 양수로 입력해야 합니다."),
    NOT_VALID_PURCHASE_AMOUNT("구입 금액은 1000원 단위로 입력 가능합니다."),
    NOT_MATCHED_NUMBERS("당첨 번호는 6개로 나누어진 입력값이 필요합니다."),
    NOT_IN_RANGE("1~45 사이의 숫자 입력이 필요합니다."),
    IS_DUPLICATED("번호가 중복되었습니다.")
    ;


    private final String message;

    ExceptionMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return this.message;
    }
}
