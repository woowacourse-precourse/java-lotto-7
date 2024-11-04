package lotto.constant;

public enum ErrorMessage {
    INTEGER_ERROR("[ERROR] 정수가 아닌 값이 입력되었습니다."),
    THOUSANDS_ERROR("[ERROR] 1000원 단위로 입력해주세요."),
    NEGATIVE_ERROR("[ERROR] 양수를 입력해주세요."),
    NUMBER_COUNT_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    RANGE_ERROR("[ERROR] 1~45인 숫자를 입력해주세요."),
    REPEAT_ERROR("[ERROR] 중복된 숫자가 있습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
