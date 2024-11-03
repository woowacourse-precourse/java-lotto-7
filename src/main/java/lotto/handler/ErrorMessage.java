package lotto.handler;

public enum ErrorMessage {
    CASTING_ERROR("클래스 타입이 맞지 않거나 컨텐츠가 없습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
