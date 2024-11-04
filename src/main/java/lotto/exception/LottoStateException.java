package lotto.exception;

public class LottoStateException extends IllegalStateException {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String NOT_PURCHASED_ERROR = "로또를 구매하지 않았습니다.";

    public LottoStateException(String message) {
        super(ERROR_PREFIX + message);
    }
}
