package lotto.constant;

public enum ErrorMessage {
    INPUT_BLANK("입력이 공백입니다."),
    INPUT_NOT_NUMBER("문자열이 숫자가 아닙니다."),
    AMOUNT_NEGATIVE("구매 금액은 음수가 될 수 없습니다."),
    AMOUNT_NOT_MULTIPLE_OF_THOUSAND("구매 금액이 1,000원 단위가 아닙니다."),
    AMOUNT_OVER_LIMIT("구매 금액이 너무 큽니다."),
    NUMBERS_COUNT_NOT_SIX("번호를 6개 입력해 주세요."),
    NUMBER_OUT_OF_RANGE("번호는 1부터 45 사이의 숫자여야 합니다."),
    NUMBER_DUPLICATED("번호가 중복되었습니다.");

    private final String errorMessage;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String get() {
        return ERROR_MESSAGE_PREFIX + errorMessage;
    }
}
