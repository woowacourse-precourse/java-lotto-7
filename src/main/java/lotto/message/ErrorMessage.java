package lotto.message;

public enum ErrorMessage {

    INVALID_NUMBER_FORMAT("숫자 형식으로 입력해야 합니다."),
    INVALID_PRICE_MULTIPLE("금액은 1000원 단위로 입력해야 합니다."),
    NEGATIVE_PRICE_VALUE("금액은 양의 정수로 입력해야 합니다."),
    INVALID_INPUT_FORMAT("숫자는 공백 없이 쉼표(,)로 구분해 입력해야 합니다."),
    INVALID_NUMBER_RANGE("숫자는 1 이상 45 이하의 범위여야 합니다."),
    INVALID_NUMBER_COUNT("총 %d개의 숫자를 입력해야 합니다."),
    DUPLICATE_NUMBER_PRESENT("중복된 숫자는 입력할 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public void printError() {
        System.out.println(ERROR_PREFIX + message);
    }

    public void printError(String prefix) {
        System.out.printf(ERROR_PREFIX + message, prefix);
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + message;
    }

    public String getErrorMessage(int value) {
        return String.format(ERROR_PREFIX + message, value);
    }
}
