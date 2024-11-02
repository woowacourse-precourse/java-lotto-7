package lotto.constants;

public enum ErrorMessage {
    INPUT_CAN_NOT_BE_BLANK("빈 값은 입력할 수 없습니다."),

    AMOUNT_CAN_NOT_HAVE_CHARACTER("숫자 이외의 문자를 포함할 수 없습니다."),
    AMOUNT_CAN_NOT_BE_ZERO("구입 금액은 0이 될 수 없습니다.");

    private static final String header = "[ERROR] ";
    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String get() {
        return header + errorMessage;
    }
}
