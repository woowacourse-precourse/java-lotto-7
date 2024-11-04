package lotto;

public enum MoneyInputErrorMessage {
    INVALID_NUMBER_FORMAT("양의 정수만 입력 가능합니다."),
    INVALID_AMOUNT("너무 큰 값을 입력할 수 없습니다."),
    NON_THOUSAND_MULTIPLE("1,000원 단위여야 합니다.");

    public static final String ERROR = "[ERROR]";
    private static final String PREFIX = "로또 구입 금액은";
    private static final String SUFFIX = "다시 입력해주세요.";

    private final String message;

    MoneyInputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("%s %s %s %s", ERROR, PREFIX, message, SUFFIX);
    }
}