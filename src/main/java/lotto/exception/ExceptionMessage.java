package lotto.exception;

public enum ExceptionMessage {
    TOO_MANY_NUMBERS("로또 번호는 6개여야 합니다."),
    DUPLICATED_NUMBER_LOTTO("로또에 중복된 번호가 있습니다."),
    INVALID_PURCHASE_PRICE("잘못된 단위의 가격입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
