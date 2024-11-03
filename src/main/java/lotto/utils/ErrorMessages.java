package lotto.utils;

public final class ErrorMessages {
    public static final String ERROR_LENGTH_MESSAGE = "로또 번호는 6개여야 합니다.";
    public static final String ERROR_RANGE_MESSAGE = "로또 번호는 1이상 45이하여야 합니다.";
    public static final String ERROR_DUPLICATE_MESSAGE = "로또 번호는 중복되면 안됩니다.";
    public static final String ERROR_INVALID_AMOUNT = "금액은 로또 티켓 가격의 배수여야 합니다.";
    public static final String ERROR_NON_POSITIVE_TICKET_COUNT = "금액이 충분하지 않아 티켓을 구매할 수 없습니다.";

    private ErrorMessages() {
    }
}
