package global.errorMessage;

public enum WinningNumberErrorMessage {
    INVALID_WINNING_NUMBER_FORMAT("당첨 번호를 쉼표(,)를 사용하여 올바른 방식으로 6개를 입력하세요."),
    INVALID_WINNING_NUMBER_SIZE("당첨 번호는 6개여야 합니다.")
    ;
    private final String message;
    WinningNumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
