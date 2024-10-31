package lotto.util.enums;

public enum ValidateMessage {
    NON_NUMERIC_ERROR("숫자만 입력해주세요."),
    NUMBER_SIZE_ERROR("당첨번호의 개수가 6개가 아닙니다.")
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
