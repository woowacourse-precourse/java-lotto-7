package lotto.error;

public enum SystemErrorMessage {

    MAX_RETRY_EXCEEDED("너무 많은 입력으로 기본값 %s을/를 입력합니다.");

    private final String message;
    private final String prefix = ErrorMessage.PREFIX.getMessage();

    SystemErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
