package lotto.exception;

public enum LottoExceptionMessage implements ExceptionMessage {
    INVALID_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBERS("로또 번호는 중복될 수 없습니다."),
    NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45까지의 숫자여야 합니다."),
    NULL_OR_EMPTY_NUMBERS("로또 번호는 비어있거나 null일 수 없습니다.");

    private final String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
