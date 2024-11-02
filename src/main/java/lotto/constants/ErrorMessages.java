package lotto.constants;

public enum ErrorMessages {
    MIN_AMOUNT("최소 %s원 이상 구매하셔야합니다."),
    MAX_AMOUNT("최대 %s원 까지만 구매가 가능합니다."),
    UNIT_AMOUNT("%s원 단위로만 구매가 가능합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;


    ErrorMessages(String message) {
        this.message = message;
    }

    public String formatMessage(Object... args) {
        String customMessage = PREFIX + message;
        return String.format(customMessage, args);
    }
}
