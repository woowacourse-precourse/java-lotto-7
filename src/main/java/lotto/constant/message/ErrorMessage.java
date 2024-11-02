package lotto.constant.message;

public enum ErrorMessage {

    INVALID_NULL("입력 값은 null일 수 없습니다."),
    INVALID_NEGATIVE_NUMBER("음수는 입력할 수 없습니다."),
    INVALID_INPUT_TYPE("숫자가 아닌 값을 입력할 수 없습니다."),
    INVALID_MULTIPLE_AMOUNT("로또 구입 금액은 %d의 배수여야 합니다."),
    INVALID_DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다."),
    OUT_OF_RANGE("로또 번호는 %d에서 %d 사이여야 합니다."),
    INVALID_WINNING_NUMBER_COUNT("로또 번호는 %d개여야 합니다.")
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + String.format(message);
    }

    public String getMessage(Integer content) {
        return PREFIX + String.format(message, content);
    }

    public String getMessage(Integer content1, Integer content2) {
        return PREFIX + String.format(message, content1, content2);
    }
}
