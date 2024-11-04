package lotto.common;

public enum ErrorMessage {
    NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_PRICE("1000원 단위의 금액을 입력해 주세요."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되어선 안됩니다."),
    NON_NUMERIC_INPUT("숫자만 입력해 주세요."),
    DUPLICATE_LOTTO_NUMBER("중복된 숫자를 입력하지 마시오.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ErrorMessage(final String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String format() {
        return String.format(message);
    }

}
