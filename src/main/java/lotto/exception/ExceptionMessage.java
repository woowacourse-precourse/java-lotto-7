package lotto.exception;

public enum ExceptionMessage {
    NUMBER_RANGE_ERROR("로또 번호는 1에서 45 사이의 숫자여야 합니다."),
    BLANK_INPUT_ERROR("입력값은 공백이 될 수 없습니다."),
    DUPLICATED_NUMBER_ERROR("입력값은 중복될 수 없습니다."),
    MINUS_PRICE_ERROR("입력한 금액은 0 이상이어야 합니다."),
    INVALID_INPUT_ERROR("올바르지 않은 입력값입니다."),
    INVALID_COUNT_ERROR("로또 번호는 6개여야 합니다.");

    private final String message;

    private static final String PREFIX = "[ERROR]";

    ExceptionMessage(String message) {
        this.message = PREFIX + " " + message;
    }

    public String getMessage(){
        return message;
    }
}
