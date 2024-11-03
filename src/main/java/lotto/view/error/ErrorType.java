package lotto.view.error;

public enum ErrorType {

    ERROR_MESSAGE("[ERROR] "),
    NEED_NOT_EMPTY("입력은 비어있을 수 없습니다."),
    NEED_NUMBER("숫자를 입력해야 합니다."),

    NEED_INTEGER("정수를 입력해야 합니다."),
    NEED_NUMBER_IN_RANGE("1~45 범위 내의 숫자를 입력해야 합니다."),
    NEED_DISTINCT_NUMBER("입력한 당첨 번호와 중복되지 않는 숫자를 입력해야 합니다.");

    final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
