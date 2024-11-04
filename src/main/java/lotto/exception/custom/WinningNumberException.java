package lotto.exception.custom;

public enum WinningNumberException implements CustomException {

    INVALID_INPUT("당첨 숫자는 6개여야 합니다."),
    ;

    private final String message;

    WinningNumberException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
