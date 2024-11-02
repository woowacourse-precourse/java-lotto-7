package lotto.enums;

public enum ErrorMessage {

    ERR_EMPTY_INPUT("빈 문자열은 입력할 수 없습니다."),
    ERR_IS_NOT_DIGIT_STRING("입력은 숫자로만 이루어져야 합니다."),
    ERR_INVALID_NUMBER_RANGE("숫자의 범위가 유효하지 않습니다."),
    ERR_IS_NOT_INTEGER_RANGE("입력이 유효한 정수가 아닙니다."),
    ERR_IS_NOT_DIVISIABLE_INPUT("나누어 떨어지지않는 입력입니다."),
    ERR_IS_NOT_SAME_WITH_LIST_SIZE("유효하지 않은 인자 갯수입니다."),
    ERR_IS_DUPLICATED("중복된 요소가 존재합니다.");


    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
