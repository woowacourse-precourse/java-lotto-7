package lotto.constant;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR]"),
    INTEGER_ERROR("정수가 아닌 값이 입력되었습니다."),
    THOUSANDS_ERROR("1000원 단위로 입력해주세요."),
    NEGATIVE_ERROR("양수를 입력해주세요."),
    NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    RANGE_ERROR("1~45인 숫자를 입력해주세요."),
    REPEAT_ERROR("중복된 숫자가 있습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
