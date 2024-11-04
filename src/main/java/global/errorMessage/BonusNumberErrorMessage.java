package global.errorMessage;

public enum BonusNumberErrorMessage {
    OUT_OF_RANGE("보너스 번호는 1 이상 45 이하의 숫자여야 합니다."),
    INVALID_FORMAT("보너스 번호는 하나의 숫자여야 합니다.")

    ;

    private final String message;

    BonusNumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
