package lotto.exception;

public enum ExceptionMessage {

    INPUT_BLANK("값을 입력하지 않으셨습니다."),
    INVALID_NUMBER_FORMAT("유효하지 않은 숫자입니다."),
    INVALID_DELIMITER_FORMAT("숫자만 입력할 수 있으며, 구분자는 %s만 사용할 수 있습니다."),
    INVALID_WINNING_NUMBER_FORMAT("잘못된 입력 형식입니다: %s다음 숫자를 입력해 주세요."),
    INVALID_PURCHASING_UNIT("%d원 단위로 구매해주세요."),
    INVALID_PURCHASING_PRICE("최대 %d원까지 구매 가능합니다."),
    NO_MORE_LOTTO("더이상 존재하는 로또가 없습니다.");


    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ExceptionMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage(Object... args) {
        return  String.format(message, args);
    }
}
