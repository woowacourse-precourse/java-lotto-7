package lotto.exception;

public enum WinnerNumberExceptionMessage implements ExceptionMessage {
    BONUS_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45까지의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    WinnerNumberExceptionMessage(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
