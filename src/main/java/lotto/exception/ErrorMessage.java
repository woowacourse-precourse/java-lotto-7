package lotto.exception;

public enum ErrorMessage {

    NOT_MULTIPLE_OF_THOUSAND("구매 금액은 1,000원 단위로 입력해야 합니다."),
    NOT_GREATER_THAN_A_THOUSAND("구매 금액은 최소 1,000원 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
