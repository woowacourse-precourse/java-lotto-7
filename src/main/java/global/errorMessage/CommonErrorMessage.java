package global.errorMessage;

public enum CommonErrorMessage {
    INVALID_INDEX("유효한 index 가 아닙니다.")

    ;
    private final String message;

    CommonErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
