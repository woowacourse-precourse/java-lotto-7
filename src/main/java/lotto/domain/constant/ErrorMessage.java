package lotto.domain.constant;

public enum ErrorMessage {
    PRICE_UNMATCHED("[error] 돈은 1000원 단위로만 입력할 수 있습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
