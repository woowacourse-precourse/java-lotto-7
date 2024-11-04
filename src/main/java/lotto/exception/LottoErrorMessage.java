package lotto.exception;

public enum LottoErrorMessage {
    EMPTY_LOTTO_VALUE("[ERROR] 비어있는 로또가 존재합니다."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6자리여야 합니다."),
    DUPLICATED_LOTTO_NUMBERS("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
