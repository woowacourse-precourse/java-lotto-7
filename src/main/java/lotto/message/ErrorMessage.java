package lotto.message;

public enum ErrorMessage {
    Blank_Message("[ERROR] 빈 문자열을 입력하였습니다."),
    INVALID_NUMBER("[ERROR] 유효한 숫자가 아닙니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public final String getErrorMessage() {
        return errorMessage;
    }

}
