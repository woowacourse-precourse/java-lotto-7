package lotto.util.enums;

public enum ValidateMessage {
    NON_NUMERIC_ERROR("숫자만 입력해주세요."),
    NUMBER_SIZE_ERROR("당첨번호의 개수가 6개가 아닙니다."),
    NUMBER_RANGE_ERROR("1 ~ 45 사이의 숫자만 입력해주세요."),
    POSITIVE_NUMBER_ERROR("양수만 입력해주세요."),
    DOUBLE_ERROR("자연수만 입력해주세요."),
    DUPLICATE_ERROR("서로 다른 숫자를 입력해주세요.")
    ;

    private final String message;

    ValidateMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        String prefix = "[ERROR] ";
        return prefix + message;
    }
}
