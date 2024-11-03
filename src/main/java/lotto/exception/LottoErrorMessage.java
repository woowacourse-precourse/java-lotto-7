package lotto.exception;

public enum LottoErrorMessage {
    EMPTY_LOTTO_VALUE("[ERROR] 비어있는 로또가 존재합니다."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호가 6자리가 아닙니다."),
    INVALID_LOTTO_COUNT("[ERROR] 발행할 로또 수가 유효하지 않습니다."),
    LOTTO_NUMBER_OUT_OF_BOUNDS("[ERROR] 로또 번호는 1~45 범위의 숫자여야 합니다."),
    DUPLICATED_LOTTO_NUMBERS("[ERROR] 로또 번호는 중복될 수 없습니다."),

    INVALID_WINNING_RANK("[ERROR] 잘못된 당첨 등수입니다."),
    INVALID_YIELD("[ERROR] 잘못된 수익률 값입니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
