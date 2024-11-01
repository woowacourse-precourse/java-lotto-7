package lotto.util;

public enum ExceptionMessage {
    INVALID_INPUT("잘못된 입력입니다."),
    INVALID_AMOUNT_UNIT("입력 금액은 1000원 단위의 양의 정수로 입력해야 합니다."),
    INVALID_RANGE("로또 번호는 1에서 45 사이의 숫자여야 합니다."),
    INVALID_WINNING_NUMBERS("로또 번호는 6개의 서로 다른 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("로또 번호와 보너스 번호는 중복될 수 없습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s 다시 입력해주세요.";
    private final String message;

    ExceptionMessage(final String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String format() {
        return String.format(message);
    }
}