package lotto.model.exception;

public enum DomainExceptionMessage {
    INVALID_MONEY_FORMAT("[ERROR] 금액은 숫자만 입력 가능합니다.");
    private final String message;

    DomainExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
