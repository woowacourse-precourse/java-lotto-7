package lotto.model.exception;

public enum DomainExceptionMessage {
    INVALID_MONEY_FORMAT("[ERROR] 금액은 숫자만 입력 가능합니다."),
    INVALID_MONEY_UNIT("[ERROR] 금액은 1000원 단위여야 합니다."),
    INVALID_MONEY_VALUE("[ERROR] 금액은 0원 이상이어야 합니다."),
    INVALID_BONUS_NUMBER_FORMAT("[ERROR] 보너스 숫자는 숫자만 입력 가능합니다."),
    INVALID_BONUS_NUMBER_VALUE("[ERROR] 보너스 숫자는 1이상 54이하여야 합니다.");
    private final String message;

    DomainExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
