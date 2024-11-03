package lotto.model.exception;

public enum DomainExceptionMessage {
    INVALID_MONEY_FORMAT("[ERROR] 금액은 숫자만 입력 가능합니다."),
    INVALID_MONEY_UNIT("[ERROR] 금액은 1000원 단위여야 합니다."),
    INVALID_MONEY_VALUE("[ERROR] 금액은 0원 이상이어야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 형식이 맞지 않습니다. 숫자를 입력해주세요."),
    INVALID_NUMBER_VALUE("[ERROR] 숫자는 1이상 54이하여야 합니다."),
    INVALID_ANSWER_SIZE("[ERROR] 정답은 6자만 가능합니다."),
    DUPLICATED_ANSWER_NUMBER("[ERROR] 정답 번호는 중복되면 안 됩니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또는 6개의 숫자여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("[ERROR] 로또 번호는 중복되면 안 됩니다.");
    private final String message;

    DomainExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
